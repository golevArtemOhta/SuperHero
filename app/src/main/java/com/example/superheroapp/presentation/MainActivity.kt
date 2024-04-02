package com.example.superheroapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.superheroapp.R
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.presentation.Main.MainFragment
import com.example.superheroapp.presentation.navigation.Navigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }

    }


}