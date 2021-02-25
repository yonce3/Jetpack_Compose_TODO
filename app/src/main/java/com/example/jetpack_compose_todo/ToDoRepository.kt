package com.example.jetpack_compose_todo

import com.example.jetpack_compose_todo.data.AppDatabase
import com.example.jetpack_compose_todo.data.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoRepository(val db: AppDatabase) {

    suspend fun getItems(): List<ToDo>? {
        var items = try {
            withContext(Dispatchers.IO) {
                db.toDoDao().getAll()
            }
        } catch (e: Throwable) {
            return null
        } finally {
            
        }
        return items
    }
}