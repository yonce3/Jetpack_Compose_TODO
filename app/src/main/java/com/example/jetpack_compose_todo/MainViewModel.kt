package com.example.jetpack_compose_todo

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val items: MutableLiveData<List<ToDo>> = MutableLiveData()
    private val repository:ToDoRepository = ToDoRepository(
        Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build())

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
                val list = repository.getItems()
                items.postValue(list)
            } catch(error: Throwable) {

            } finally {
                this.cancel()
            }
        }
    }
}