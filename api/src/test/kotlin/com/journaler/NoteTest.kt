package com.journaler

import com.journaler.service.NoteService
import org.junit.After
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [ApiApplication::class])
class NoteTest {

    @Autowired
    lateinit var service: NoteService

    @Before
    fun prepare() {

    }

    @Test
    fun testOrder() {
        insertNote()
        selectNote()
        updateNote()
        deleteNote()
    }

    @After
    fun cleanup() {

    }

    @Test
    fun insertNote() {

    }

    @Test
    fun selectNote() {

    }

    @Test
    fun updateNote() {

    }

    @Test
    fun deleteNote() {

    }
}