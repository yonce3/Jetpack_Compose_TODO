package com.example.jetpack_compose_todo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_todo.viewmodel.AddToDoViewModel

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{ AddToDoLayout() }
    }

    @Composable
    fun AddToDoLayout(toDoViewModel: AddToDoViewModel = AddToDoViewModel.Factory(application).create(AddToDoViewModel::class.java)) {
        val title: String by toDoViewModel.title.observeAsState("")
        val todo: String by toDoViewModel.todo.observeAsState("")
        Surface(color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(value = title,
                        onValueChange = { },
                        label = {Text("タイトル")},
                        maxLines = 2)
                OutlinedTextField(value = todo,
                        onValueChange = {},
                        label = { Text("ToDo")},
                        maxLines = 3)
            }
        }
    }

    @Preview
    @Composable
    fun PreviewLayout() {
        AddToDoLayout()
    }
}