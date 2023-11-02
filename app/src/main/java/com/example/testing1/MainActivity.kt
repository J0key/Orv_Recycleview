package com.example.testing1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var chapterList: ArrayList<chapter>
    private lateinit var chapterAdapter: ChapterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setCustomView(R.layout.actionbar_layout);
        supportActionBar?.setBackgroundDrawable(ColorDrawable(Color.parseColor("#181A25")));


        recyclerView = findViewById(R.id.viewryc)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val ch1 = resources.getString(R.string.ch1)
        val ch2 = resources.getString(R.string.ch2)
        val ch3 = resources.getString(R.string.ch3)
        val ch4 = resources.getString(R.string.ch4)
        val ch5 = resources.getString(R.string.ch5)
        val ch6 = resources.getString(R.string.ch6)
        val ch7 = resources.getString(R.string.ch7)
        val ch8 = resources.getString(R.string.ch8)


        chapterList = ArrayList()

        chapterList.add(chapter(R.drawable.img1, "Chapter 01.", ch1))
        chapterList.add(chapter(R.drawable.img2, "Chapter 02.", ch2))
        chapterList.add(chapter(R.drawable.img3, "Chapter 03.", ch3))
        chapterList.add(chapter(R.drawable.img4, "Chapter 04.", ch4))
        chapterList.add(chapter(R.drawable.img5, "Chapter 05.", ch5))
        chapterList.add(chapter(R.drawable.img6, "Chapter 06.", ch6))
        chapterList.add(chapter(R.drawable.img7, "Chapter 07.", ch7))
        chapterList.add(chapter(R.drawable.img8, "Chapter 08.", ch8))


        chapterAdapter = ChapterAdapter(chapterList)
        recyclerView.adapter = chapterAdapter

        chapterAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("chapter" , it)
            startActivity(intent)
        }

    }
}