package ro.pub.cs.systems.eim.practicaltest01var07

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.random.nextInt

class PracticalTest01Var07MainActivity : AppCompatActivity() {


    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText

    private var sumResult: Int = 0
    private var productResult: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_main)

        val btnSet = findViewById<Button>(R.id.btnSet)
        val btnRandom = findViewById<Button>(R.id.btnRandom)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)




        btnSet.setOnClickListener {

            val intent = Intent(this, PracticalTest01Var07SecondaryActivity::class.java).apply {
                putExtra("INPUT1", editText1.text.toString().toInt())
                putExtra("INPUT2", editText2.text.toString().toInt())
                putExtra("INPUT3", editText3.text.toString().toInt())
                putExtra("INPUT4", editText4.text.toString().toInt())
            }
            startActivityForResult(intent, 1)

        }


            btnRandom.setOnClickListener {
                val num1 = Random.nextInt(0, 10)
                val num2 = Random.nextInt(0, 10)
                val num3 = Random.nextInt(0, 10)
                val num4 = Random.nextInt(0, 10)
                val string1 = editText1.text.toString()
                val string2 = editText2.text.toString()
                val string3 = editText3.text.toString()
                val string4 = editText4.text.toString()
                val float1: Float? = string1.toFloatOrNull()
                val float2: Float? = string2.toFloatOrNull()
                val float3: Float? = string3.toFloatOrNull()
                val float4: Float? = string4.toFloatOrNull()
                if (float1 == null) {
                    editText1.setText(num1.toString())
                } else {
                    editText1.setText(string1)
                }
                if (float2 == null) {
                    editText2.setText(num2.toString())
                } else {
                    editText1.setText(string1)
                }
                if (float3 == null) {
                    editText3.setText(num3.toString())
                } else {
                    editText1.setText(string1)
                }
                if (float4 == null) {
                    editText4.setText(num4.toString())
                } else {
                    editText1.setText(string1)
                }


            }


        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val result = data?.getIntExtra("EXTRA_RESULT", 0) ?: 0

            if (result > 0) {
                sumResult = result
            } else {
                productResult = result
            }

            Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
            Log.d("MainActivity", "Result: $result")

        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SUM_RESULT", sumResult)
        outState.putInt("PRODUCT_RESULT", productResult)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        sumResult = savedInstanceState.getInt("SUM_RESULT", 0)
        productResult = savedInstanceState.getInt("PRODUCT_RESULT", 1)

        Toast.makeText(this, "Restored Sum: $sumResult, Product: $productResult", Toast.LENGTH_LONG).show()
    }
}