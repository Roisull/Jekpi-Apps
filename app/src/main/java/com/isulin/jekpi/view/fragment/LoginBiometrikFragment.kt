package com.isulin.jekpi.view.fragment

import android.content.Intent
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
import com.isulin.jekpi.view.activity.MainActivity

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

            if (currentProgress == 100){
                navigateToMainActivity()
            }
        }

        binding.tvMasukDenganPIN.setOnClickListener {
            navigateToLoginPinFragment()
        }

        return binding.root
    }
    private fun navigateToLoginPinFragment() {
        val fragment = LoginWithPinFragment() // Ganti OtherFragment dengan fragment tujuan Anda
//    val fragmentManager = requireActivity().supportFragmentManager
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerLoginRegis, fragment) // R.id.fragment_container adalah ID dari container fragment Anda
        transaction.addToBackStack(null) // Jika Anda ingin menambahkan ke back stack, biarkan ini seperti ini
        transaction.commit()
    }
    private fun navigateToMainActivity() {
        val intent = Intent(requireContext(),MainActivity::class.java)
        startActivity(intent)
    }
}

private fun ContentLoadingProgressBar.max(i: Int) {
    this.max = i
}
