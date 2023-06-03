package vistula.kn.l11_narayana_60092_midterm2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConverterKadek : AppCompatActivity() {
    val Nara : String = "nara.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_kadek)

        val tvDataConverterKn : TextView = findViewById(R.id.tvDataConverterKn)
        val fileContent = intent.getStringExtra("fileContent")
        if (fileContent != null) {
            tvDataConverterKn.text = fileContent
        }
        val etTempKn : EditText = findViewById(R.id.etTempKn)
        val btnConvertKn : Button = findViewById(R.id.btnConvertKn)
        val spinnerTempKn : Spinner = findViewById(R.id.spinnerTempKn)
        val tvCelciusKn : TextView = findViewById(R.id.tvCelciusKn)
        val tvFahrenheitKn : TextView = findViewById(R.id.tvFahrenheitKn)
        val tvKelvinKn : TextView = findViewById(R.id.tvKelvinKn)
        val btnbackMainKn : Button = findViewById(R.id.btnBackMainKn)

        //button Convert
        btnConvertKn.setOnClickListener {

        }
        //button to backk to Main
        btnbackMainKn.setOnClickListener {
            try {
                val fileInputStream = openFileInput(Nara)
                val fileContent = fileInputStream.bufferedReader().use { it.readText() }
                fileInputStream.close()


                Intent(this, MainActivity::class.java).also {
                    it.putExtra("fileContent", fileContent)
                    startActivity(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        btnConvertKn.setOnClickListener {
            val TempKn = spinnerTempKn.selectedItem.toString()
            if (TempKn=="Celcius") {
                val value: String = etTempKn.getText().toString()
                val finalValueKn = value.toDouble()

                val totalCelciusKn = value
                val totalFahrenheitKn = (finalValueKn * 9/5) + 32
                val totalKelvinKn = finalValueKn + 273.15

                tvCelciusKn.text = totalCelciusKn
                tvFahrenheitKn.text = totalFahrenheitKn.toString()
                tvKelvinKn.text = totalKelvinKn.toString()
            }
            else if (TempKn=="Kelvin"){
                val value: String = etTempKn.getText().toString()
                val finalValueKn = value.toDouble()

                val totalCelciusKn = finalValueKn - 273.15
                val totalFahrenheitKn = (finalValueKn-273.15)*9/5+32
                val totalKelvinKn = value

                tvCelciusKn.text = totalCelciusKn.toString()
                tvFahrenheitKn.text = totalFahrenheitKn.toString()
                tvKelvinKn.text = totalKelvinKn
            }
            else{
                val value: String = etTempKn.getText().toString()
                val finalValueKn = value.toDouble()

                val totalCelciusKn = (finalValueKn - 32)*5/9
                val totalFahrenheitKn = value
                val totalKelvinKn = (finalValueKn -32)*5/9+273.15

                tvCelciusKn.text = totalCelciusKn.toString()
                tvFahrenheitKn.text = totalFahrenheitKn
                tvKelvinKn.text = totalKelvinKn.toString()
            }
        }
    }
}