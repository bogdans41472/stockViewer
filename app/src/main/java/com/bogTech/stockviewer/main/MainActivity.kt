package com.bogTech.stockviewer.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bogTech.stockviewer.R
import com.bogTech.stockviewer.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, MainFragment(), MainFragment.FRAGMENT_TAG)
            .commit()
    }
}