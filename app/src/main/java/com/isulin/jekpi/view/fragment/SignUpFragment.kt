package com.isulin.jekpi.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.btnLanjutkanRegister.setOnClickListener {
            navigateToFragmentBiometrik()
        }
        binding.tvLoginRegister.setOnClickListener {
            navigateToLoginBiometrikFragment()
        }

        return binding.root
    }
    private fun navigateToFragmentBiometrik(){
        val fragment = BiometricFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun navigateToLoginBiometrikFragment(){
        val fragment = LoginBiometrikFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}