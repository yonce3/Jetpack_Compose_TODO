package com.example.jetpack_compose_todo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_todo.viewmodel.AddToDoViewModel

class AddToDoActivity : AppCompatActivity() {
    private val todoViewModel : AddToDoViewModel by lazy { AddToDoViewModel.Factory(application).create(AddToDoViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{ AddToDoLayout(todoViewModel) }
    }

    @Composable
    fun AddToDoLayout(toDoViewModel: AddToDoViewModel) {
        val title: String by toDoViewModel.title.observeAsState("")
        val todo: String by toDoViewModel.todo.observeAsState("")
        Surface(color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(value = title,
                        onValueChange = { toDoViewModel.title.value = it },
                        label = { Text("タイトル") },
                        maxLines = 2)
                OutlinedTextField(value = todo,
                        onValueChange = { toDoViewModel.todo.value = it },
                        label = { Text("ToDo") },
                        maxLines = 3)
                FloatingActionBUtton(title, todo)
            }
        }
    }

    @Composable
    fun FloatingActionBUtton(title: String, todo: String) {
        FloatingActionButton(
                onClick = { onDoneButtonClick(title, todo) },
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
        ){ Icon(Icons.Filled.Done) }
    }

    @Preview
    @Composable
    fun PreviewLayout() {
        AddToDoLayout(todoViewModel)
    }

    private fun onDoneButtonClick(title: String, todo: String) {
        todoViewModel.addToDo(title, todo)
    }
}