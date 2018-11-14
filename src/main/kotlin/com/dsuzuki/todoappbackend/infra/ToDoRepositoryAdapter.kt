package com.dsuzuki.todoappbackend.infra

import com.dsuzuki.todoappbackend.domain.ToDoRepository
import com.dsuzuki.todoappbackend.domain.entity.ToDoForCreate
import com.dsuzuki.todoappbackend.domain.entity.ToDo
import com.dsuzuki.todoappbackend.domain.entity.ToDoForUpdate
import com.dsuzuki.todoappbackend.infra.translator.ToDoEntityTranslator
import org.springframework.stereotype.Repository

@Repository
class ToDoRepositoryAdapter(val repository: ToDoJpaRepository) : ToDoRepository {

    override fun getAll(): List<ToDo> {
        return repository.findAll().filterNotNull().map { ToDoEntityTranslator.translateFrom(it) }
    }

    override fun get(id: Long): ToDo {
        return ToDoEntityTranslator.translateFrom(repository.findById(id).get())
    }

    override fun create(toDoForCreate: ToDoForCreate) {
        val entity = ToDoEntityTranslator.translateFrom(toDoForCreate)
        repository.save(entity)
    }

    override fun change(toDoForUpdate: ToDoForUpdate) {
        repository.findById(toDoForUpdate.id).get().also {
            it.title = toDoForUpdate.title
            it.isDone = toDoForUpdate.isDone
        }
    }

    override fun delete(id: Long) {
        repository.deleteById(id)
    }
}
