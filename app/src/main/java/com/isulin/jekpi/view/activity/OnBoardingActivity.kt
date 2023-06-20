package com.isulin.jekpi.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.isulin.jekpi.R
import com.isulin.jekpi.adapter.OnBoardingAdapter
import com.isulin.jekpi.data.OnBoardingItem
import com.isulin.jekpi.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val data = listOf(
            OnBoardingItem(R.drawable.ic_easy_write_ills, "Kemudahan Menulis", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            OnBoardingItem(R.drawable.ic_list_catatan_ills, "List Catatan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."),
            OnBoardingItem(R.drawable.ic_security_ills, "Keamanan", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        )
        init(data)

        binding.tvSkipOnBoarding.setOnClickListener {
            startMainActivity()
        }
    }
    private fun init(data: List<OnBoardingItem>) {
        val adapter = OnBoardingAdapter(this, data)
        binding.vpOnBoarding.adapter = adapter

        TabLayoutMediator(binding.tabDotsOnBoarding, binding.vpOnBoarding, TabLayoutMediator.TabConfigurationStrategy { tab, position ->

        }).attach()
//        binding.vpOnBoarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                Snackbar.make(binding.parentView,"You are selected "+(position+1), Snackbar.LENGTH_SHORT).show()
//            }
//        })
    }
    private fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}