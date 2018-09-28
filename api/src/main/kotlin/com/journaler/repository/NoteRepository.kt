package com.journaler.repository

import com.journaler.api.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, String> {

}