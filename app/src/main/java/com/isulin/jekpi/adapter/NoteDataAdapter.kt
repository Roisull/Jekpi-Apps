package com.isulin.jekpi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.isulin.jekpi.databinding.CardContentBinding
import com.isulin.jekpi.model.NoteModel

class NoteDataAdapter: RecyclerView.Adapter<ViewHolder>() {
    var listData = mutableListOf<NoteModel>()
    var viewType = 0
    class Holder(val binding: CardContentBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(data : NoteModel){
            binding.tvTitleCardContent.text = data.title
            binding.tvContentCardContent.text = data.content
            binding.tvDateTimeCardContent.text = data.date
        }
    }
    class HeaderHolder(val binding: CardContentBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(data: NoteModel){
            binding.tvTitleCardContent.text = data.title
            binding.tvContentCardContent.text = data.content
            binding.tvDateTimeCardContent.text = data.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when(viewType){
            0 -> {
                val binding = CardContentBinding.inflate(layoutInflater,parent,false)
                return HeaderHolder(binding)
            }
            1 -> {
                val binding = CardContentBinding.inflate(layoutInflater,parent,false)
                return Holder(binding)
            }
            else ->{
                return null!!
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(viewType){
            0 -> {
                val headerNoteHolder = holder as HeaderHolder
                headerNoteHolder.bindView(listData[position])
            }
            1 -> {
                val holderNote = holder as Holder
                holderNote.bindView(listData[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0){
            viewType = 0
            return  0
        }
        else{
            viewType = 1
            return 1
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun addList(listNote :List<NoteModel>){
        listData.clear()
        listData.addAll(listNote)
        notifyDataSetChanged()
    }
}