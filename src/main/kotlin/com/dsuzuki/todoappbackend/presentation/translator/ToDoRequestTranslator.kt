package com.dsuzuki.todoappbackend.presentation.translator

import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDoForUpdate
import com.dsuzuki.todoappbackend.presentation.model.ToDoRequestForCreate
import com.dsuzuki.todoappbackend.presentation.model.ToDoRequestForUpdate

class ToDoRequestTranslator {

    companion object {

        fun translateFrom(requestForCreate: ToDoRequestForCreate) = ToDoForCreate(requestForCreate.title)

        fun translateFrom(id: String, requestForUpdate: ToDoRequestForUpdate) = ToDoForUpdate(
            id,
            requestForUpdate.title,
            requestForUpdate.isDone
        )
    }
}
