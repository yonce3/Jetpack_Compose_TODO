package com.example.jetpack_compose_todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name ="title") val title: String,
    @ColumnInfo(name ="lastname")val todo: String
    )