package com.example.jetpack_compose_todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name ="title") val title: String,
    @ColumnInfo(name ="lastname")val todo: String
    )