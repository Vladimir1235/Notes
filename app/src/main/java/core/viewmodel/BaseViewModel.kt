package core.viewmodel

import androidx.lifecycle.ViewModel
import dev.vvasiliev.compose.notes.data.Event

abstract class BaseViewModel<EventType : Event> : ViewModel() {

  abstract fun onEvent(event: EventType)

}