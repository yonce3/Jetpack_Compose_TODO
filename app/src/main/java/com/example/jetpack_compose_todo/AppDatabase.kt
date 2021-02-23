package com.example.jetpack_compose_todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}