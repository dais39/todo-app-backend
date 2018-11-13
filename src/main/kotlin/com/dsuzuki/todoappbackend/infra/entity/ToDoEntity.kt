package com.dsuzuki.todoappbackend.infra.entity

import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class ToDoEntity(

    @Column
    var id: String = "",

    @Column
    var title: String = "",

    @Column
    var isDone: Boolean = false
)
