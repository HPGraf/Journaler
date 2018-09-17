package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import com.journaler.api.data.Todo
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration
class TodoController {

    @GetMapping(
            produces = [(MediaType.APPLICATION_JSON_VALUE)]
    )
    fun getTodos(): List<Todo> {
        return listOf(
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
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(@RequestBody todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        todo.schedule = System.currentTimeMillis()
        return todo
    }

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean {
        println("Removing: $id")
        return true
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(@RequestBody todo: Todo): Todo {
        todo.title += " [updated] "
        todo.message += " [updated] "
        return todo
    }
}