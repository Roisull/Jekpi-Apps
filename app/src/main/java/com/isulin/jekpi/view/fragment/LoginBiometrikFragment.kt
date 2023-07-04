package com.isulin.jekpi.view.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.widget.ContentLoadingProgressBar
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentLoginBiometrikBinding

class LoginBiometrikFragment : Fragment() {

    private var _binding: FragmentLoginBiometrikBinding? = null
    private val binding get() = _binding!!

    private var currentProgress: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBiometrikBinding.inflate(inflater, container, false)

        binding.btnTesProgressBar.setOnClickListener {
            binding.tvMemindaiSidikJariLogin.visibility = View.VISIBLE
            currentProgress = currentProgress + 10
            binding.clpLogin.setProgress(currentProgress)
            binding.clpLogin.max(100)
        }

        return binding.root
    }
}

private fun ContentLoadingProgressBar.max(i: Int) {
    this.max = i
}
