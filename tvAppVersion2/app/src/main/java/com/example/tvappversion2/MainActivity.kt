package com.example.tvappversion2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var engtv = findViewById<Button>(R.id.engtv);
        var chintv = findViewById<Button>(R.id.chintv);
        var japtv = findViewById<Button>(R.id.japtv);
        var kortv = findViewById<Button>(R.id.kortv);

        engtv.setOnClickListener {
            val intent = Intent(this, Webview::class.java)
            intent.putExtra("links", "https://www.youtube.com/watch?v=XWq5kBlakcQ")
            startActivity(intent)
        }

        chintv.setOnClickListener {
            val intent = Intent(this, Webview::class.java)
            intent.putExtra("links", "https://www.youtube.com/watch?v=9sE12tg3CmA")
            startActivity(intent)
        }

        japtv.setOnClickListener {
            val intent = Intent(this, Webview::class.java)
            intent.putExtra("links", "https://www.youtube.com/watch?v=coYw-eVU0Ks")
            startActivity(intent)
        }

        kortv.setOnClickListener {
            val intent = Intent(this, Webview::class.java)
            intent.putExtra("links", "https://www.youtube.com/watch?v=CJVBX7KI5nU")
            startActivity(intent)
        }
    }
}