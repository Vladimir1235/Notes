package dev.vvasiliev.compose.notes.usecase

import dev.vvasiliev.compose.notes.repository.NoteRepository
import javax.inject.Inject

class LoadNotes @Inject constructor(private val repository: NoteRepository) {
    suspend operator fun invoke() = repository.getNotes()
    suspend fun getSpecific(id: Long) = repository.getNote(id = id)
}