package com.example.jetpack_compose_todo

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val items: MutableLiveData<ToDo> = MutableLiveData()

    class Factory(private val application : Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }

    init {
        // repository
    }

    fun getItems() {
        viewModelScope.launch {
            // repository get Items
//            val list = repository.getItems()
//            items.postValue()
        }
    }
}