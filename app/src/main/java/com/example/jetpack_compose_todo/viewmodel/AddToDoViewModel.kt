package com.example.jetpack_compose_todo.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.jetpack_compose_todo.ToDoRepository
import com.example.jetpack_compose_todo.data.AppDatabase
import kotlinx.coroutines.launch

class AddToDoViewModel(application: Application): AndroidViewModel(application) {
    var title: MutableLiveData<String> = MutableLiveData("")
    var todo: MutableLiveData<String> = MutableLiveData("")
    private val repository: ToDoRepository = ToDoRepository(
            Room.databaseBuilder(
                    application,
                    AppDatabase::class.java, "database-name"
            ).build())

    class Factory(private val application : Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AddToDoViewModel(application) as T
        }
    }

    fun addToDo(title: String, todo: String) {
        // DBにToDoを保存する処理
        viewModelScope.launch {
            //repository.insertItem()
        }
    }
}