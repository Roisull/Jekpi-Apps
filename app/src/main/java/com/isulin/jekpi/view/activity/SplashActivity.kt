package com.isulin.jekpi.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val splashTimeOut = 3000L // waktu dalam milidetik 3 detik
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
    override fun onDestroy() {
        super.onDestroy()
        // Menghapus pending runnable jika activity dihancurkan sebelum timeout tercapai
        Handler().removeCallbacksAndMessages(null)
    }
}