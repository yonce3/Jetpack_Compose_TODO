package com.example.jetpack_compose_todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
            ListViewLayout(listOf(ToDo("a", "a"), ToDo("", "")), Modifier)
        }
    }

    @Composable
    fun ListViewLayout(items: List<ToDo>, modifier: Modifier) {
        //val image = imageResource(R.drawable.header)
//        MaterialTheme {
//            Scaffold(
//                    topBar = {
//                        Text(text = "Jetpack ToDo",
//                                style = MaterialTheme.typography.h3)
//                    }
//            ) {
//            }
//            ToDoList(listOf(ToDo("titleaaaaaaaaaaaaaaaaaaaaaaaaaaa", "text"), ToDo("a", "b")), {})
//        }
        Scaffold {
            LazyColumn(modifier = modifier) {
                items(items = items) { item ->
                    ToDoItem(item, { Toast.makeText(this@MainActivity, "タップ", Toast.LENGTH_SHORT).show() })
                }
            }
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
            Divider(color = Color.Black)
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        //NewStory()
    }
}