package com.example.superheroapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.superheroapp.R
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.presentation.Main.MainFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}