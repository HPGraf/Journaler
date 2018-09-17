package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.journaler.api.data.Note
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
            value = ["/obtain"],
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
}