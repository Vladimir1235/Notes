package dev.vvasiliev.compose.notes.repository

import androidx.compose.ui.graphics.Color
import dev.vvasiliev.compose.notes.data.Background
import dev.vvasiliev.compose.notes.data.Note
import java.util.*

class NotesRepositoryShould: NoteRepository {

    private val noteList: List<Note> = mutableListOf<Note>().also { list ->
        for(i in 0..10){
            list.add(TestNote(id = i.toLong(), text = "Note $i"))
        }
    }

    class TestNote(
        override val id: Long,
        override val lastModify: Date = Date(),
        override val title: String = "test",
        override val text: String,
        override val background: Background = Background.ColorBg(Color.Yellow)
    ) : Note

    override suspend fun getNotes(): List<Note> = noteList

    override suspend fun getNote(id: Long): Note = noteList.find { it.id == id }?: throw Exception("Not such note")
}