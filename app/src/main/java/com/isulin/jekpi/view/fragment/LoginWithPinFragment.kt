package com.isulin.jekpi.view.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.FragmentLoginWithPinBinding
import com.isulin.jekpi.view.activity.MainActivity

class LoginWithPinFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentLoginWithPinBinding? = null
    private val binding get() = _binding!!

    private var passCode: String = ""
    var num1: String = ""
    var num2: String = ""
    var num3: String = ""
    var num4: String = ""
    var num5: String = ""
    var num6: String = ""

    val numbersList: ArrayList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginWithPinBinding.inflate(inflater, container, false)
        val view = binding.root

        initializeComponent()

        binding.btnLanjutkanRegister.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        return view
    }
    private fun initializeComponent(){


        binding.btn01.setOnClickListener(this)
        binding.btn02.setOnClickListener(this)
        binding.btn03.setOnClickListener(this)
        binding.btn04.setOnClickListener(this)
        binding.btn05.setOnClickListener(this)
        binding.btn06.setOnClickListener(this)
        binding.btn07.setOnClickListener(this)
        binding.btn08.setOnClickListener(this)
        binding.btn09.setOnClickListener(this)
        binding.btn00.setOnClickListener(this)
        binding.ivBackspace.setOnClickListener(this)
        binding.ivHideKeyboard.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_01 ->{
                numbersList.add("1")
                passNumber(numbersList)
            }
            R.id.btn_02 ->{
                numbersList.add("2")
                passNumber(numbersList)
            }
            R.id.btn_03 ->{
                numbersList.add("3")
                passNumber(numbersList)
            }
            R.id.btn_04 ->{
                numbersList.add("4")
                passNumber(numbersList)
            }
            R.id.btn_05 ->{
                numbersList.add("5")
                passNumber(numbersList)
            }
            R.id.btn_06 ->{
                numbersList.add("6")
                passNumber(numbersList)
            }
            R.id.btn_07 ->{
                numbersList.add("7")
                passNumber(numbersList)
            }
            R.id.btn_08 ->{
                numbersList.add("8")
                passNumber(numbersList)
            }
            R.id.btn_09 ->{
                numbersList.add("9")
                passNumber(numbersList)
            }
            R.id.btn_00 ->{
                numbersList.add("0")
                passNumber(numbersList)
            }
            R.id.iv_backspace ->{
                numbersList.clear()
                passNumber(numbersList)
            }
//            R.id.iv_hide_keyboard ->{
//                numbersList.add("1")
//                passNumber(numbersList)
//            }
        }
    }
    private fun passNumber(numberList: ArrayList<String>){
        if (numberList.size == 0){
            binding.vPin1.setBackgroundResource(R.drawable.pin_place)
            binding.vPin2.setBackgroundResource(R.drawable.pin_place)
            binding.vPin3.setBackgroundResource(R.drawable.pin_place)
            binding.vPin4.setBackgroundResource(R.drawable.pin_place)
            binding.vPin5.setBackgroundResource(R.drawable.pin_place)
            binding.vPin6.setBackgroundResource(R.drawable.pin_place)
        }else{
            when(numberList.size){
                1 -> {
                    num1 = numberList.get(0)
                    binding.vPin1.setBackgroundResource(R.drawable.pin_place_value)
                }
                2 -> {
                    num2 = numberList.get(1)
                    binding.vPin2.setBackgroundResource(R.drawable.pin_place_value)
                }
                3 -> {
                    num3 = numberList.get(2)
                    binding.vPin3.setBackgroundResource(R.drawable.pin_place_value)
                }
                4 -> {
                    num4 = numberList.get(3)
                    binding.vPin4.setBackgroundResource(R.drawable.pin_place_value)
                }
                5 -> {
                    num5 = numberList.get(4)
                    binding.vPin5.setBackgroundResource(R.drawable.pin_place_value)
                }
                6 -> {
                    num6 = numberList.get(5)
                    binding.vPin6.setBackgroundResource(R.drawable.pin_place_value)
                    passCode = num1 + num2 + num3 + num4 + num5 + num6
                    if (getPassCode().length == 0){
                        savePassCode(passCode)
                    }else{
                        matchPassCode()
                    }
                }
            }
        }
    }
    private fun matchPassCode(){
        if(getPassCode().equals(passCode)){
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }else{
            Toast.makeText(requireContext(), "Your Pin Doesn't match", Toast.LENGTH_SHORT).show()
        }
    }
    private fun savePassCode(passCode: String): SharedPreferences.Editor {
        val preferences: SharedPreferences = requireContext().getSharedPreferences("passcode_pref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("passcode", passCode)
        editor.apply()

        return editor
    }

    private fun getPassCode(): String {
        val preferences: SharedPreferences = requireContext().getSharedPreferences("passcode_pref", Context.MODE_PRIVATE)
        return preferences.getString("passcode", "") ?: ""
    }

}