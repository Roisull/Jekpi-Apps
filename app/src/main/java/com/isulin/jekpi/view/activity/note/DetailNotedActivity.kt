package com.isulin.jekpi.view.activity.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivityDetailNotedBinding

class DetailNotedActivity : AppCompatActivity() {

    private var _binding: ActivityDetailNotedBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailNotedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ivBackFromDetailNotedActivity.setOnClickListener {
            onBackPressed()
        }
    }
}