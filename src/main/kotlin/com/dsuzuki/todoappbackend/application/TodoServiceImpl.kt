package com.dsuzuki.todoappbackend.application

import com.dsuzuki.todoappbackend.domain.ToDoRepository
import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.domain.entity.ToDoForUpdate
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(val repository: ToDoRepository) : ToDoService {

    override fun getToDoList(): List<ToDo> = repository.getAll()

    override fun getToDo(id: String): ToDo = repository.get(id)

    override fun registerToDo(toDoForCreate: ToDoForCreate) = repository.create(toDoForCreate)

    override fun updateToDo(toDoForUpdate: ToDoForUpdate) = repository.change(toDoForUpdate)

    override fun deleteToDo(id: String) = repository.delete(id)
}
