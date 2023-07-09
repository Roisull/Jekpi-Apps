package com.isulin.jekpi.view.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentSuccessSignUpBinding

class SuccessSignUpFragment : Fragment() {
    private var _binding: FragmentSuccessSignUpBinding? = null
    private val binding get() = _binding!!

    private val handler = Handler()
    private val delayDuration = 2000L
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSuccessSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToLoginFragmentDelayed()
    }
    private fun navigateToLoginFragmentDelayed() {
        handler.postDelayed({
            navigateToLoginBiometrikFragment()
        }, delayDuration)
    }

    private fun navigateToLoginBiometrikFragment() {
        val fragment = LoginBiometrikFragment()
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}