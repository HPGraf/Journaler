package com.journaler.api.data

import java.util.*

data class TodoDTO(
        var title: String,
        var message: String,
        var schedule: Long,
        var location: String
) {
    lateinit var id: String
    lateinit var created: Date
    lateinit var modified: Date

    constructor(todo: Todo) : this(
            todo.title,
            todo.message,
            todo.schedule,
            todo.location
    ) {
        id = todo.id
        created = todo.created
        modified = todo.modified
    }
}