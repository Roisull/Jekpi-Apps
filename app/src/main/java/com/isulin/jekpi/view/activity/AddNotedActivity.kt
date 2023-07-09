package com.isulin.jekpi.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivityAddNotedBinding

class AddNotedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ivBackFromActivityAddNoted.setOnClickListener {
            onBackPressed()
        }
    }
}