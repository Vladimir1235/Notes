package dev.vvasiliev.compose.notes.screen.notelist.viewmodel

import core.viewmodel.BaseViewModel
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import dev.vvasiliev.compose.notes.screen.notelist.event.NoteListScreenEvent
import javax.inject.Inject

class NoteListViewModel @Inject constructor(
    globalNavigator: GlobalNavigator
) : BaseViewModel<NoteListScreenEvent>(globalNavigator) {
    override fun onEvent(event: NoteListScreenEvent) {

    }
}