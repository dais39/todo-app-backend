package com.dsuzuki.todoappbackend.application

import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.domain.entity.ToDoForUpdate

interface ToDoService {

    fun getToDoList():List<ToDo>

    fun getToDo(id: Long): ToDo

    fun registerToDo(toDoForCreate: ToDoForCreate)

    fun updateToDo(toDoForUpdate: ToDoForUpdate)

    fun deleteToDo(id: Long)

}
