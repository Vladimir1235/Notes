package dev.vvasiliev.compose.notes.screen.note.viewmodel

import core.viewmodel.BaseViewModel
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import dev.vvasiliev.compose.notes.screen.note.event.NoteScreenEvent
import dev.vvasiliev.compose.notes.usecase.LoadNotes
import javax.inject.Inject

class NoteViewModel @Inject constructor(
    globalNavigator: GlobalNavigator,
    private val load: LoadNotes
) : BaseViewModel<NoteScreenEvent>(globalNavigator) {
    override fun onEvent(event: NoteScreenEvent) {}
}