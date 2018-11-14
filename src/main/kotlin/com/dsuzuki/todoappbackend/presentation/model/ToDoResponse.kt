package com.dsuzuki.todoappbackend.presentation.model

data class ToDoResponse(
    val id: Long,
    val title: String,
    val isDone: Boolean
)
