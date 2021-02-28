package com.example.jetpack_compose_todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class ToDo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name ="title") val title: String,
    @ColumnInfo(name ="lastname")val todo: String
    )