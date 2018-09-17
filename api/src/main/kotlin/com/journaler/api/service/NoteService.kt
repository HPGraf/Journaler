package com.journaler.api.service

import com.journaler.api.data.Note
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteService {

    fun getNotes(): List<Note> = listOf(
            Note(UUID.randomUUID().toString(),
                    "my first note",
                    "this is the first message"),
            Note(UUID.randomUUID().toString(),
                    "my second note",
                    "this is the second message")
    )

    fun insertNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun deleteNote (id: String): Boolean = false

    fun updateNote (note: Note): Boolean = true
}