package dev.vvasiliev.compose.notes.screen.greeting.viewmodel

import core.viewmodel.BaseViewModel
import dev.vvasiliev.compose.notes.screen.greeting.event.GreetingEvent
import dev.vvasiliev.compose.notes.screen.greeting.event.ShowAllNotesEvent

class GreetingViewModel: BaseViewModel<GreetingEvent>() {
    override fun onEvent(event: GreetingEvent) {
        when(event){
            is ShowAllNotesEvent -> {

            }
        }
    }
}