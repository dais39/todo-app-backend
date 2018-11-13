package com.dsuzuki.todoappbackend.presentation.translator

import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.presentation.model.ToDoResponse

class ToDoResponseTranslator {

    companion object {
        fun translateFrom(todo: ToDo) = ToDoResponse(
            todo.id,
            todo.title,
            todo.isDone
        )
    }
}
