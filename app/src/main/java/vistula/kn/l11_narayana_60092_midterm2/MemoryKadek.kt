package vistula.kn.l11_narayana_60092_midterm2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.io.FileOutputStream

class MemoryKadek : AppCompatActivity() {
    val Nara : String = "nara.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory_kadek)

        val etNameEditKn : TextView = findViewById(R.id.etNameEditKn)
        val etSurnameEditKn : TextView = findViewById(R.id.etSurnameEditKn)
        val etTownEditKn : EditText = findViewById(R.id.etTownEditKn)
        val btnSaveNewkn : Button = findViewById(R.id.btnSaveNewkn)
        val tvWelcomeNara : TextView = findViewById(R.id.tvWelcomeNara)
        val btnBackHomeKn : Button = findViewById(R.id.btnBackHomeKn)
        val fileContent = intent.getStringExtra("fileContent")
        if (fileContent != null) {
            tvWelcomeNara.text = fileContent
        }
        btnSaveNewkn.setOnClickListener {
            val etnameEditKn = etNameEditKn.text.toString()
            val etsurnameEditKn = etSurnameEditKn.text.toString()
            val etTownEditKn = etTownEditKn.text.toString()
            val finallyallKn = "$etnameEditKn\n$etsurnameEditKn\n$etTownEditKn"
            tvWelcomeNara.text = finallyallKn

            val fileOutputStream: FileOutputStream

            try {
                fileOutputStream = openFileOutput(Nara, Context.MODE_PRIVATE)
                fileOutputStream.write(finallyallKn.toByteArray())
                fileOutputStream.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        btnBackHomeKn.setOnClickListener {
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

    }
}