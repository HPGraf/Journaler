package com.journaler.service

import com.journaler.api.data.Note
import com.journaler.api.data.NoteDTO
import com.journaler.api.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteService {

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<NoteDTO> = repository.findAll().map { it -> NoteDTO(it) }

    fun insertNote(noteDTO: NoteDTO): NoteDTO {
        var myNote: Note

        myNote = repository.save(Note(
                title = noteDTO.title,
                message = noteDTO.message,
                location = noteDTO.location))

        return NoteDTO(myNote)
    }

    fun deleteNote(id: String) = repository.deleteById(id)

    fun updateNote(noteDTO: NoteDTO): NoteDTO {
        var note: Note = repository.findById(noteDTO.id).get()

        note.title = noteDTO.title
        note.message = noteDTO.message
        note.location = noteDTO.location
        note.modified = Date()

        repository.save(note)
        return NoteDTO(note)
    }
}