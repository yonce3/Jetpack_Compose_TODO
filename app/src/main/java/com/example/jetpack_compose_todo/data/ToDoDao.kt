package com.example.jetpack_compose_todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<ToDo>

    @Query("SELECT * FROM todo WHERE id IN (:id)")
    fun loadAllByIds(id: IntArray): List<ToDo>

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): ToDo

    @Insert
    fun insertAll(vararg items: ToDo)

    @Delete
    fun delete(item: ToDo)
}