package com.example.jetpack_compose_todo.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.jetpack_compose_todo.ToDoRepository
import com.example.jetpack_compose_todo.data.AppDatabase
import com.example.jetpack_compose_todo.data.ToDo
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val items: MutableLiveData<List<ToDo>> = MutableLiveData()
    private val repository: ToDoRepository = ToDoRepository(AppDatabase.getDatabase(application))

    class Factory(private val application : Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }

    fun getItems() {
        viewModelScope.launch {
            // repository get Items
            try {
                println("taroro")
                val list = repository.getItems()
                items.postValue(list)
            } catch(error: Throwable) {

            } finally {
                this.cancel()
            }
        }
    }
}