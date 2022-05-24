package dev.vvasiliev.compose.notes.screen.greeting.viewmodel

import androidx.lifecycle.viewModelScope
import core.viewmodel.BaseViewModel
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import dev.vvasiliev.compose.notes.navigation.NavigationDestination
import dev.vvasiliev.compose.notes.screen.greeting.event.GreetingEvent
import dev.vvasiliev.compose.notes.screen.greeting.event.ShowAllNotesEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class GreetingViewModel @Inject constructor(private val globalNavigator: GlobalNavigator) :
    BaseViewModel<GreetingEvent>(globalNavigator) {
    override fun onEvent(event: GreetingEvent) {
        when (event) {
            is ShowAllNotesEvent -> {
                viewModelScope.launch {
                    globalNavigator.navigate(NavigationDestination.NotesScreen)
                }
            }
        }
    }
}