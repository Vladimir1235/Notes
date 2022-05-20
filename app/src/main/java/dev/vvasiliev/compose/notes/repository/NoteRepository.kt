package dev.vvasiliev.compose.notes.repository

import dev.vvasiliev.compose.notes.data.Note

/**
 * Note repository, db accessor
 */
interface NoteRepository {
    /**
     * Select whole bunch of notes stored in db
     */
    suspend fun getNotes(): List<Note>

    /**
     * Select specific note by it's [id]
     */
    suspend fun getNote(id: Long): Note
}