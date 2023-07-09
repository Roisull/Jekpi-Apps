package com.isulin.jekpi.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.isulin.jekpi.R
import com.isulin.jekpi.adapter.NoteDataAdapter
import com.isulin.jekpi.data.dummy.NoteContentDummy
import com.isulin.jekpi.databinding.ActivityMainBinding
import com.isulin.jekpi.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    lateinit var adapter: NoteDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ivBackFromSearch.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        adapter = NoteDataAdapter()

//        hanya mengambil satu item saja
        val getSingleItem = NoteContentDummy.listNote.firstOrNull()
        if (getSingleItem != null){
            adapter.addList(listOf(getSingleItem))
        }

        val lyManager = GridLayoutManager(this,2)
        binding.rvAllNoteActivitySearch.layoutManager = lyManager
        binding.rvAllNoteActivitySearch.adapter = adapter
    }
}