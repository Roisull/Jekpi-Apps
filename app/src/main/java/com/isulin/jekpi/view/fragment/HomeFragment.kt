package com.isulin.jekpi.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.GridLayout
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import com.isulin.jekpi.R
import com.isulin.jekpi.adapter.NoteDataAdapter
import com.isulin.jekpi.data.dummy.NoteContentDummy
import com.isulin.jekpi.databinding.FragmentHomeBinding
import com.isulin.jekpi.view.activity.note.AllNoteActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: NoteDataAdapter

//    private lateinit var ivIconFavorite: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        adapter = NoteDataAdapter()
        adapter.addList(NoteContentDummy.listNote)
        val lyManager = GridLayoutManager(requireContext(), 2)
        binding.rvForContentFragmentHome.layoutManager = lyManager
        binding.rvForContentFragmentHome.adapter = adapter

//        ivIconFavorite = view.findViewById(R.id.ivIconFavoriteFragmentHome)
//        ivIconFavorite.setOnClickListener {
//            // Ubah gambar di sini setelah ImageView diklik
//            ivIconFavorite.setImageResource(R.drawable.ic_false_love)
//        }
        binding.ivMoreFragmentHome.setOnClickListener {
            val intent = Intent(requireContext(), AllNoteActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}