package com.dsuzuki.todoappbackend.presentation.model

data class ToDoResponse(
    val id: String,
    val title: String,
    val isDone: Boolean
)
