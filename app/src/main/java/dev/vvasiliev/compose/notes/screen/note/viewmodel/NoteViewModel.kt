package dev.vvasiliev.compose.notes.screen.note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vvasiliev.compose.notes.usecase.LoadNotes
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val load: LoadNotes): ViewModel() {

    fun loadNotes(id: Long) = viewModelScope.launch { load.getSpecific(id = id) }

    fun onEvent(){

    }
}