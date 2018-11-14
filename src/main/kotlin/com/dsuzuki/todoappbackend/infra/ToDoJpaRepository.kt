package com.dsuzuki.todoappbackend.infra

import com.dsuzuki.todoappbackend.infra.entity.ToDoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ToDoJpaRepository : JpaRepository<ToDoEntity, Long>
