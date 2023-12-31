package com.isulin.jekpi.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.isulin.jekpi.R
import com.isulin.jekpi.databinding.ActivityMainBinding
import com.isulin.jekpi.view.activity.crudNote.AddNoteActivity
import com.isulin.jekpi.view.fragment.AccountFragment
import com.isulin.jekpi.view.fragment.FavoriteFragment
import com.isulin.jekpi.view.fragment.HomeFragment
import com.isulin.jekpi.view.fragment.LoginBiometrikFragment
import com.isulin.jekpi.view.fragment.TrashFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var dialog: BottomSheetDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    //  FOR BOTTOM NAVIGATION
        binding.btmNavigationView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.bottom_nav_selector)
        binding.btmNavigationView.background = null
        binding.btmNavigationView.menu.getItem(2).isEnabled = false
        loadFragment(HomeFragment())
        binding.btmNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                R.id.iconHome ->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.iconFavorite ->{
                    loadFragment(FavoriteFragment())
                    true
                }
                R.id.iconTrash ->{
                    loadFragment(TrashFragment())
                    true
                }
                R.id.iconProfile ->{
                    loadFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    //  END FOR BOTTOM NAVIGATION

    // FOR NAVIGATE TO ADD NOTE ACTIVITY
        binding.fabAddNotedFromMain.setOnClickListener {
            startActivity(Intent(this, AddNotedActivity::class.java))
        }
    // FOR NAVIGATE TO ADD NOTE ACTIVITY
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContainerMain, fragment)
        transaction.commit()
    }
//    private fun showDialogFilter(){
//        val dialogView = layoutInflater.inflate(R.layout.filter_dialog, null)
//        dialog = BottomSheetDialog(this,R.style.FilterBottomSheetDialog)
//        dialog.setContentView(dialogView)
//        dialog.show()
//    }
}