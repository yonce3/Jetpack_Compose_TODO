package com.example.jetpack_compose_todo.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val application : Application) : ViewModelProvider.NewInstanceFactory() {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return ViewModel(application) as T
//    }
}
