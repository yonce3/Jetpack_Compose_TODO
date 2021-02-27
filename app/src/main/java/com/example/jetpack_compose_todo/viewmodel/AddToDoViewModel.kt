package com.example.jetpack_compose_todo.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddToDoViewModel: ViewModel() {
    var title: MutableLiveData<String> = MutableLiveData("")
    var todo: MutableLiveData<String> = MutableLiveData("")

    class Factory(private val application : Application) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }
}