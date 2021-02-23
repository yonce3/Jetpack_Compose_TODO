package com.example.jetpack_compose_todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    var items: ArrayList<ToDo> = arrayListOf()
    val viewModel: MainViewModel by lazy { MainViewModel.Factory(application).create(MainViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // for Kotlin
        fun Int.times(func: (Int) -> Unit) : Int{
            for (i in 0..this) {
                func(i)
            }
            return this
        }
        viewModel.getItems()

//        viewModel.items.observe(this, Observer {
//            setContent {
//
//            }
//        })

        // for JetPack Compose
        setContent {
            10.times { i -> items.add(ToDo(i, "$i", "${i}ですよ")) }
            ListViewLayout(viewModel, items, { it -> this}, Modifier)
        }
    }

    @Composable
    fun ListViewLayout(viewModel: MainViewModel, items: List<ToDo>, onClicked: (item: ToDo) -> Unit, modifier: Modifier) {
        //val items: List<ToDo> by viewModel.items.observeAsState(listOf<ToDo>())
        Scaffold(
                topBar = {
                    TopAppBar(
                            title = { Text(text = "Jetpack Compose ToDo") },
                            actions = {
//                                IconButton(onClick = { /* doSomething() */ }) {
//                                    Icon(Icons.Filled.Favorite, contentDescription = null)
//                                }
                                })
                },
                floatingActionButtonPosition = FabPosition.End,
                floatingActionButton = { FloatingActionButton(onClick = {
                    val intent = Intent(this@MainActivity, AddToDoActivity::class.java)
                    startActivity(intent)
                }){
                    Text("+", color = Color.White, fontSize = 24.sp, style = MaterialTheme.typography.h3)
                } },
        ) { innerPadding -> LazyColumn(modifier = modifier) {
                items(items = items) { item ->
                    ToDoItem(item) { onClicked(item) }
                }
            }
        }
    }

    @Composable
    fun ToDoItem(todo: ToDo, onClick: () -> Unit) {
        val padding = 16.dp
        val typography = MaterialTheme.typography
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clip(RoundedCornerShape(4.dp))
                .clickable(onClick = onClick)
                .padding(16.dp, 0.dp)
                .fillMaxWidth()) {
            Checkbox(checked = false, onCheckedChange = {})
            Column(modifier = Modifier.padding(16.dp, 10.dp, 0.dp, 10.dp)) {
                Text(todo.title,
                        style = typography.h6,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Bold)
                Text(todo.todo,
                        style = typography.body2)
            }
        }
        Divider(color = Color.Black)
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        //NewStory()
    }

//    private fun convertDrawableBitmap(imageId: Int): ImageBitmap {
//        val drawable = getDrawable(imageId) as BitmapDrawable
//        //return drawable.ima
//    }
}