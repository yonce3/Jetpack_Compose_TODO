package com.example.jetpack_compose_todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context) = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-name"
            ).build()
        }
    }
}