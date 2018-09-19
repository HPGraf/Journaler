package com.journaler.api.service

import com.journaler.api.data.Todo
import com.journaler.api.data.TodoDTO
import com.journaler.api.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService {

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<TodoDTO> = repository.findAll().map { it -> TodoDTO(it) }

    fun insertTodo(todoDTO: TodoDTO): TodoDTO {
        var myTodo: Todo

        myTodo = repository.save(Todo(
                title = todoDTO.title,
                message = todoDTO.message,
                location = todoDTO.location,
                schedule = todoDTO.schedule))

        return TodoDTO(myTodo)
    }

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(todoDTO: TodoDTO): TodoDTO {
        var todo: Todo = repository.findById(todoDTO.id).get()

        todo.title = todoDTO.title
        todo.message = todoDTO.message
        todo.location = todoDTO.location
        todo.schedule = todoDTO.schedule
        todo.modified = Date()

        repository.save(todo)
        return TodoDTO(todo)
    }

    fun getScheduledLaterThan(date: Date): Iterable<TodoDTO> {
        return repository.findScheduledLaterThan(date.time).map { it -> TodoDTO(it) }
    }
}