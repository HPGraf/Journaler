package com.journaler.api.service

import com.journaler.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService {

    fun getTodos(): List<Todo> = listOf(
            Todo(UUID.randomUUID().toString(),
                    "my first todo",
                    "this is the first message",
                    System.currentTimeMillis()
            ),
            Todo(UUID.randomUUID().toString(),
                    "my second tofdo",
                    "this is the second message",
                    System.currentTimeMillis())
    )

    fun insertTodo(todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(note: Todo): Boolean = true
}