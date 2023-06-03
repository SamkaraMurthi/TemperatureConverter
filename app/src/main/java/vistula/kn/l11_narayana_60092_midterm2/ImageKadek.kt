package vistula.kn.l11_narayana_60092_midterm2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class ImageKadek : AppCompatActivity() {
    val Nara : String = "nara.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_kadek)
        val tvDataKn : TextView = findViewById(R.id.tvDataKn)
        val fileContent = intent.getStringExtra("fileContent")
        if (fileContent != null) {
            tvDataKn.text = fileContent
        }
        val ibMainKn : ImageButton = findViewById(R.id.ibMainKn)
        val ibConverterKn : ImageButton = findViewById(R.id.ibConverterKn)
        val ibMemoryKn : ImageButton = findViewById(R.id.ibMemoryKn)
        val btnBackKn : Button = findViewById(R.id.btnBackKn)

        btnBackKn.setOnClickListener {
            finish()
        }

        ibMainKn.setOnClickListener {
            finish()
        }

        ibConverterKn.setOnClickListener {
            try {
                val fileInputStream = openFileInput(Nara)
                val fileContent = fileInputStream.bufferedReader().use { it.readText() }
                fileInputStream.close()


                Intent(this, ConverterKadek::class.java).also {
                    it.putExtra("fileContent", fileContent)
                    startActivity(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        ibMemoryKn.setOnClickListener {
            try {
                val fileInputStream = openFileInput(Nara)
                val fileContent = fileInputStream.bufferedReader().use { it.readText() }
                fileInputStream.close()


                Intent(this, MemoryKadek::class.java).also {
                    it.putExtra("fileContent", fileContent)
                    startActivity(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}