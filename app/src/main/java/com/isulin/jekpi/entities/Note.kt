package com.isulin.jekpi.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "Title")
    val title: String,

    @ColumnInfo(name = "note_text")
    val noteText: String?,

    @ColumnInfo(name = "date_time")
    val dateTime: String,

    @ColumnInfo(name = "web_link")
    val webLink: String?,

    @ColumnInfo(name = "image_path")
    val imagePath: String?,

    @ColumnInfo(name = "bookmark")
    val bookmark: Int = 0
)