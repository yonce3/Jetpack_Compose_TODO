package com.example.jetpack_compose_todo

import com.example.jetpack_compose_todo.data.AppDatabase
import com.example.jetpack_compose_todo.data.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoRepository(val db: AppDatabase) {

    suspend fun getItems(): List<ToDo>? {
        var items = null
        withContext(Dispatchers.IO) {
            val items = db.toDoDao().getAll()
        }
        return items
    }
}