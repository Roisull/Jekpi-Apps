package com.isulin.jekpi.view.activity.note

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.isulin.jekpi.R
import com.isulin.jekpi.adapter.NoteDataAdapter
import com.isulin.jekpi.data.dummy.NoteContentDummy
import com.isulin.jekpi.databinding.ActivityAllNoteBinding

class AllNoteActivity : AppCompatActivity() {
    private var _binding: ActivityAllNoteBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: NoteDataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAllNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = NoteDataAdapter()
        adapter.addList(NoteContentDummy.listNote)
        val lyManager = GridLayoutManager(this,2)
        binding.rvAllNoteActivityAllNote.layoutManager = lyManager
        binding.rvAllNoteActivityAllNote.adapter = adapter
    }
}