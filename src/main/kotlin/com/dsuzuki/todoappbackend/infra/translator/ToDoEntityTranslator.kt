package com.dsuzuki.todoappbackend.infra.translator

import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.infra.entity.ToDoEntity

class ToDoEntityTranslator {

    companion object {

        fun translateFrom(toDoForCreate: ToDoForCreate) = ToDoEntity(toDoForCreate.title)

        fun translateFrom(entity: ToDoEntity) = ToDo(
            entity.id,
            entity.title,
            entity.isDone
        )
    }
}
