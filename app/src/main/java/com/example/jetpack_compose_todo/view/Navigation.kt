package com.example.jetpack_compose_todo.view

enum class ScreenName { HOME, DETAIL, ADD}

sealed class Screen(val id: ScreenName) {
    object Home: Screen(ScreenName.HOME)
    data class DETAIL(val todoId: Int): Screen(ScreenName.DETAIL)
}