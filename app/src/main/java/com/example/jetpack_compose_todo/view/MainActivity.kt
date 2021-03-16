package com.example.jetpack_compose_todo.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_todo.viewmodel.MainViewModel
import com.example.jetpack_compose_todo.data.ToDo

class MainActivity : AppCompatActivity() {
    val detailFragment: DetailFragment = DetailFragment.newInstance()
    val viewModel: MainViewModel by lazy {
        MainViewModel.Factory(application).create(MainViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        //viewModel.getItems()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // for Kotlin
        // 拡張関数: 記念に残す
        fun Int.times(func: (Int) -> Unit) : Int{
            for (i in 0..this) {
                func(i)
            }
            return this
        }
        viewModel.getItems()
        setContent {
            viewModel.items.let {
                ListViewLayout(viewModel, Modifier, this)
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        //NewStory()
    }

    fun startAddToDoActivity() {
        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                if (result?.resultCode == Activity.RESULT_OK) {
                    viewModel.getItems()
                }
            }
        val intent = Intent(this@MainActivity, AddToDoActivity::class.java)
        startForResult.launch(intent)
    }
}