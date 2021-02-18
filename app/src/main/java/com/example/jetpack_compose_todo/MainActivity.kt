package com.example.jetpack_compose_todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // for JetPack Compose
        setContent {
            //Text("Hello World")
            //TopAppBar()
            NewStory()
        }
    }

    @Composable
    fun NewStory() {
        //val image = imageResource(R.drawable.header)
        MaterialTheme {
            Scaffold(
                    topBar = {
                        Text(text = "Jetpack ToDo",
                                style = MaterialTheme.typography.h3)
                    }
            ) {
            }
            ToDoList(listOf(ToDo("titleaaaaaaaaaaaaaaaaaaaaaaaaaaa", "text"), ToDo("a", "b")), {})
        }
    }

    @Composable
    fun TopAppBar() {
        Scaffold(
                topBar = {
                    Text(text = "Jetpack ToDo",
                        style = MaterialTheme.typography.h3)
                }
        ) {
        }
    }

    @Composable
    fun ToDoItem(todo: ToDo, onClick: () -> Unit) {
        val padding = 16.dp
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable (onClick = onClick)
                    .padding(padding)
                    .fillMaxWidth()
        ) {
            Text(todo.title,
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold)
            Text(todo.todo,
                style = typography.body2)
        }
    }

    @Composable
    fun ToDoList(
        todoItems: List<ToDo>,
        onSelected: () -> Unit
    ) {
        Surface(Modifier.fillMaxSize()) {
            LazyColumnFor(todoItems) { item ->
                ToDoItem(item, onSelected)
            }
        }
//        ScrollableColumn(Modifier.fillMaxSize()) {
//            todoItems.forEach {
//                ToDoItem(it) {  }
//            }
//        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        NewStory()
    }
}