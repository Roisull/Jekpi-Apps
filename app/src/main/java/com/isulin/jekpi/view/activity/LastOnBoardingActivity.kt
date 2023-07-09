package com.isulin.jekpi.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivityLastOnBoardingBinding

class LastOnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLastOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnMulaiInLastOnBoarding.setOnClickListener {
            startActivity(Intent(this, LoginRegisActivity::class.java))
        }
    }
}