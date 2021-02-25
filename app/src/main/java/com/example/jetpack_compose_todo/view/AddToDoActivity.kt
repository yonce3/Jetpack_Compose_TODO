package com.example.jetpack_compose_todo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlin.coroutines.EmptyCoroutineContext

class AddToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{ AddToDoLayout() }
    }

    @Composable
    fun AddToDoLayout() {
        val modifier = Modifier
        Column {
            Spacer(modifier)
            TextField(value = "", onValueChange = {})
        }
    }

    @Preview
    @Composable
    fun PreviewLayout() {
        AddToDoLayout()
    }
}