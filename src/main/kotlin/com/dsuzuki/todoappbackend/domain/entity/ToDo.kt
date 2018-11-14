package com.dsuzuki.todoappbackend.domain.entity

data class ToDo(
    val id: Long,
    val title: String,
    val isDone: Boolean
)
