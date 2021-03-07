package com.example.jetpack_compose_todo.view

import android.view.Gravity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpack_compose_todo.data.ToDo
import com.example.jetpack_compose_todo.viewmodel.MainViewModel

@Composable
fun ListViewLayout(viewModel: MainViewModel, items: List<ToDo>, onClicked: (item: ToDo) -> Unit, modifier: Modifier, activity: MainActivity) {
    //val items: List<ToDo> by viewModel.items.observeAsState(listOf<ToDo>())
    Scaffold(
            topBar = { TopAppBar(
                        title = { Text(text = "Jetpack Compose ToDo") },
                        actions = {
                                IconButton(onClick = { /* doSomething() */ }) {
                                    Icon(Icons.Filled.List)
                                }
                        })
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                        onClick = { activity.startAddToDoActivity() },
                        elevation = FloatingActionButtonDefaults.elevation(8.dp),
                        contentColor = Color.White)
                    { Icon(Icons.Filled.Add) } },
            bodyContent = {
                innerPadding -> LazyColumn(modifier = modifier) {
                                    items(items = items) { item ->
                                        ToDoItem(item) { onClicked(item) }
                                    }
                                }
            }
    )
}

@Composable
fun ToDoItem(todo: ToDo, onClick: () -> Unit) {
    val padding = 16.dp
    val typography = MaterialTheme.typography
    Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp, 8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable(onClick = onClick)
                    .fillMaxWidth()) {
        Checkbox(checked = false, onCheckedChange = {}, modifier = Modifier.weight(0.5f))
        Column(modifier = Modifier.weight(3f).padding(0.dp, 10.dp, 4.dp, 10.dp)) {
            Text(todo.title,
                    style = typography.h6,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold)
            Text(todo.todo,
                    style = typography.body2,
                    maxLines = 2)
        }
        Text(convertTodoStateToText(todo.state),
                style = typography.body1,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.weight(0.6f)
        )
    }
}

@Composable
fun NoItemLayout(activity: MainActivity) {
    Scaffold(
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(
                        onClick = { activity.startAddToDoActivity() },
                        elevation = FloatingActionButtonDefaults.elevation(8.dp))
                { Icon(Icons.Filled.Add) } },
            bodyContent = {
                Text("Please Add Items")
            }
    )
}

// TODO: getStringとかの方が良い？
private fun convertTodoStateToText(state: Int): String =
    when(state) {
        0 -> "未対応"
        1 -> "対応中"
        2 -> "対応済み"
        else -> "未対応"
    }


