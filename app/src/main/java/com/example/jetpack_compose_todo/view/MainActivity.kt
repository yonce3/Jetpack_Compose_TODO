package com.example.jetpack_compose_todo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_compose_todo.viewmodel.MainViewModel
import com.example.jetpack_compose_todo.data.ToDo

class MainActivity : AppCompatActivity() {
    var items: ArrayList<ToDo> = arrayListOf()
    val viewModel: MainViewModel by lazy { MainViewModel.Factory(application).create(MainViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // for Kotlin
        fun Int.times(func: (Int) -> Unit) : Int{
            for (i in 0..this) {
                func(i)
            }
            return this
        }
        viewModel.getItems()

        // for JetPack Compose
        setContent {
            10.times { i -> items.add(ToDo(i, "$i", "${i}ですよ")) }
            /* ToDo: DBから取得した値を表示したい。
                nullableなリストはどうやるの？
             */

            viewModel.items.let {
                ListViewLayout(viewModel, items, { it -> this }, Modifier, this)
            } ?: run {
                NoItemLayout(this)
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        //NewStory()
    }

    fun startAddToDoActivity() {
        val intent = Intent(this@MainActivity, AddToDoActivity::class.java)
        startActivity(intent)
    }
}