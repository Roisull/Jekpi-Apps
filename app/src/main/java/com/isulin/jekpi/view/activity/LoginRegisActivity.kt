package com.isulin.jekpi.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivityLoginRegisBinding
import com.isulin.jekpi.databinding.FragmentLoginBiometrikBinding
import com.isulin.jekpi.view.fragment.LoginBiometrikFragment
import com.isulin.jekpi.view.fragment.SignUpFragment

class LoginRegisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadFragment(SignUpFragment())

    }
    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment)
        transaction.commit()
    }
}