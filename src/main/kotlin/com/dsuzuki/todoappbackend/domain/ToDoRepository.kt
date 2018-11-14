package com.dsuzuki.todoappbackend.domain

import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.domain.entity.ToDoForUpdate

interface ToDoRepository {

    fun getAll(): List<ToDo>

    fun get(id: Long): ToDo

    fun create(toDoForCreate: ToDoForCreate)

    fun change(toDoForUpdate: ToDoForUpdate)

    fun delete(id: Long)
}
