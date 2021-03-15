package com.example.jetpack_compose_todo.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_todo.data.ToDo
import com.example.jetpack_compose_todo.viewmodel.MainViewModel

@Composable
fun ListViewLayout(viewModel: MainViewModel, modifier: Modifier, activity: MainActivity) {
    val items = viewModel.items.observeAsState(listOf()).value
    val navController = rememberNavController()
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
                                        ToDoItem(item) { onClicked(item, navController) }
                                    }
                                }
            },
            bottomBar = {
                BottomAppBar {
                    BottomBar()
                }
            }
    )
}

@Composable
fun ToDoItem(todo: ToDo, onClick: () -> Unit) {
    val padding = 16.dp
    val typography = MaterialTheme.typography
    val navController = rememberNavController()
    Card(modifier = Modifier.fillMaxWidth()
            .padding(8.dp, 8.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick),
            elevation = 10.dp) {
        Row(verticalAlignment = Alignment.CenterVertically) {
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
}

@Composable
fun BottomBar() {
    BottomAppBar {
        Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.weight(1f)) {
                Box(modifier = Modifier.width(8.dp))
                BottomMenuItem(
                        //iconAsset = Icons.Filled.Favorite,
                        text = "未対応",
                        click = {})
                BottomMenuItem(
                        //iconAsset = Icons.Filled.Favorite,
                        text = "対応中",
                        click = {})
                BottomMenuItem(
                        //iconAsset = Icons.Filled.Favorite,
                        text = "対応済",
                        click = {})
            }
        }
    }
}

@Composable
fun BottomMenuItem(text: String, click: () -> Unit) {
    Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.absolutePadding(left = 8.dp, right = 8.dp)
    ) {
        Text(text = text)
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

private fun onClicked(todo: ToDo, navController: NavHostController) {
    navController.navigate(ScreenName.DETAIL)
}


