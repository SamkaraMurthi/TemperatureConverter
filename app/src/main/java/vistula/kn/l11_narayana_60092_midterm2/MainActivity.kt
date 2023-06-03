package vistula.kn.l11_narayana_60092_midterm2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val Nara : String = "nara.txt"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvWelcomeKn : TextView = findViewById(R.id.tvWelcomeMemoryKn)
        val etNameKn : TextView = findViewById(R.id.etNameKn)
        val etSurnameKn : TextView = findViewById(R.id.etSurnameKn)
        val spinnerKn : Spinner = findViewById(R.id.spinnerKn)
        val btnSaveMemoryKn : Button = findViewById(R.id.btnSaveMemoryKn)
        val btnImageKn : Button = findViewById(R.id.btnImageKn)
        val fileContent = intent.getStringExtra("fileContent")
        if (fileContent != null) {
            tvWelcomeKn.text = fileContent
        }


        btnSaveMemoryKn.setOnClickListener {
            val etnameKn = etNameKn.text.toString()
            val etsurnameKn = etSurnameKn.text.toString()
            val calcum = spinnerKn.selectedItem.toString()
            val finallyallKn = "$etnameKn\n$etsurnameKn\n$calcum"
            tvWelcomeKn.text = finallyallKn

            val fileOutputStream: FileOutputStream

            try {
                fileOutputStream = openFileOutput(Nara, Context.MODE_PRIVATE)
                fileOutputStream.write(finallyallKn.toByteArray())
                fileOutputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        btnImageKn.setOnClickListener {
            try {
                val fileInputStream = openFileInput(Nara)
                val fileContent = fileInputStream.bufferedReader().use { it.readText() }
                fileInputStream.close()


                Intent(this, ImageKadek::class.java).also {
                    it.putExtra("fileContent", fileContent)
                    startActivity(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



    }
}