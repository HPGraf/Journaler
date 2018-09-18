package com.journaler.api.controller

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import com.journaler.api.data.NoteDTO
import com.journaler.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    @GetMapping(
            produces = [(MediaType.APPLICATION_JSON_VALUE)]
    )
    fun getNotes(): Iterable<NoteDTO> {
        return service.getNotes()
    }

    @PutMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody noteDTO: NoteDTO): NoteDTO {
        return service.insertNote(noteDTO)
    }

    @DeleteMapping(
            value = ["/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String) {
        return service.deleteNote(id)
    }

    @PostMapping(
            produces = [MediaType.APPLICATION_JSON_VALUE],
            consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody noteDTO: NoteDTO): NoteDTO {
        return service.updateNote(noteDTO)
    }
}