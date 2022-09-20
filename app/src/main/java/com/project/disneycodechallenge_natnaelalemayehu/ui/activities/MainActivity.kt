package com.project.disneycodechallenge_natnaelalemayehu.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.disneycodechallenge_natnaelalemayehu.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}