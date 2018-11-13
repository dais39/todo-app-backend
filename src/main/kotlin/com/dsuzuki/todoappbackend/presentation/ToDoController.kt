package com.dsuzuki.todoappbackend.presentation

import com.dsuzuki.todoappbackend.application.ToDoService
import com.dsuzuki.todoappbackend.presentation.model.ToDoRequestForCreate
import com.dsuzuki.todoappbackend.presentation.model.ToDoResponse
import com.dsuzuki.todoappbackend.presentation.model.ToDoRequestForUpdate
import com.dsuzuki.todoappbackend.presentation.translator.ToDoRequestTranslator
import com.dsuzuki.todoappbackend.presentation.translator.ToDoResponseTranslator
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/todo")
class ToDoController(val service: ToDoService) {

    @GetMapping
    fun getToDoList(): List<ToDoResponse> =
        service.getToDoList().map { ToDoResponseTranslator.translateFrom(it) }

    @GetMapping("/{id}")
    fun getToDo(@PathVariable id: String): ToDoResponse =
        ToDoResponseTranslator.translateFrom(service.getToDo(id))

    @PostMapping
    fun registerToDo(@RequestBody requestForCreate: ToDoRequestForCreate){
        // TODO requestBodyのvalidation
        service.registerToDo(ToDoRequestTranslator.translateFrom(requestForCreate))
    }

    @PutMapping("/{id}")
    fun updateToDo(@PathVariable id: String, @RequestBody requestForUpdate: ToDoRequestForUpdate) {
        // TODO requestBodyのvalidation
        service.updateToDo(ToDoRequestTranslator.translateFrom(id, requestForUpdate))
    }

    @DeleteMapping("/{id}")
    fun deleteToDo(@PathVariable id: String) = service.deleteToDo(id)
}
