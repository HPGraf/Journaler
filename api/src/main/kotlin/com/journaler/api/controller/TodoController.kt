package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import com.journaler.api.data.Todo
import com.journaler.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
@EnableAutoConfiguration
class TodoController {

    @Autowired
    private lateinit var service: TodoService

    @GetMapping(
            produces = [(MediaType.APPLICATION_JSON_VALUE)]
    )
    fun getTodos(): List<Todo> {
        return service.getTodos()
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(@RequestBody todo: Todo): Todo {
        return service.insertTodo(todo)
    }

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean {
        println("Removing: $id")
        return service.deleteTodo(id)
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(@RequestBody todo: Todo): Boolean {
        return service.updateTodo(todo)
    }
}