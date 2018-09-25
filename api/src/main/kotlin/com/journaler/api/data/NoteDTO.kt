package com.journaler.api.data

import java.util.*

data class NoteDTO(
        var title: String,
        var message: String,
        var location: String) {

    lateinit var id: String
    lateinit var created: Date
    lateinit var modified: Date

    constructor(note: Note) : this(
            note.title,
            note.message,
            note.location) {

        id = note.id
        created = note.created
        modified = note.modified
    }

    constructor() : this("", "", "")
}
