package com.nailah.movieapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nailah.movieapp.R


class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
    }
}