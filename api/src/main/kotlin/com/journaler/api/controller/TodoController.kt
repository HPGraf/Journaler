package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import com.journaler.api.data.TodoDTO
import com.journaler.api.data.TodoLaterThanRequest
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
    fun getTodos(): Iterable<TodoDTO> {
        return service.getTodos()
    }
    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTodosLaterThan (@RequestBody payload: TodoLaterThanRequest): Iterable<TodoDTO> {
        return service.getScheduledLaterThan(payload.date)
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(@RequestBody todoDTO: TodoDTO): TodoDTO {
        return service.insertTodo(todoDTO)
    }

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(@PathVariable(name = "id") id: String) {
        println("Removing: $id")
        return service.deleteTodo(id)
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(@RequestBody todoDTO: TodoDTO): TodoDTO {
        return service.updateTodo(todoDTO)
    }
}