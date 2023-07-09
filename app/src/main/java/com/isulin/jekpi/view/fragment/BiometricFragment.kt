package com.isulin.jekpi.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentBiometricBinding

class BiometricFragment : Fragment() {
    private var _binding: FragmentBiometricBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBiometricBinding.inflate(inflater, container, false)

        binding.btnDaftarSidikJari.setOnClickListener {
            navigateToFragmentSuccesDaftar()
        }

        return binding.root
    }
    private fun navigateToFragmentSuccesDaftar(){
        val fragment = SuccessSignUpFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}