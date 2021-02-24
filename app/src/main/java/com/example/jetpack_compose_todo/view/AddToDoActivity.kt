package com.example.jetpack_compose_todo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import kotlinx.coroutines.Job
import kotlin.coroutines.EmptyCoroutineContext

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{ AddToDoLayout() }
    }

    @Composable
    fun AddToDoLayout() {

    }
}