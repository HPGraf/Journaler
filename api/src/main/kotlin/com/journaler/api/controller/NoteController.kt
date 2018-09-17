package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import com.journaler.api.data.Note
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
            produces = [(MediaType.APPLICATION_JSON_VALUE)]
    )
    fun getNotes(): List<Note> {
        return listOf(
                Note(UUID.randomUUID().toString(),
                        "my first note",
                        "this is the first message"),
                Note(UUID.randomUUID().toString(),
                        "my second note",
                        "this is the second message")
        )
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean {
        println("Removing: $id")
        return true
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody note: Note): Note {
        note.title += " [updated] "
        note.message += " [updated] "
        return note
    }
}