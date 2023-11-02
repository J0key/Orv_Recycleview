package com.example.testing1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        supportActionBar?.setCustomView(R.layout.actionbar_layout);
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#181A25")));

        val chap = intent.getParcelableExtra<chapter>("chapter")
        if(chap!= null){
            val imageView : ImageView = findViewById(R.id.detail_image)
            val textView : TextView = findViewById(R.id.detail_title)
            val textViewds : TextView = findViewById(R.id.detail_description)

            imageView.setImageResource(chap.image)
            textView.text = chap.name
            textViewds.text = chap.desc
        }

        val backImageView: ImageView = findViewById(R.id.back)
        backImageView.setOnClickListener {
            // Kembali ke MainActivity tanpa mengaktifkan new task atau stacking aktivitas
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }




    }
}