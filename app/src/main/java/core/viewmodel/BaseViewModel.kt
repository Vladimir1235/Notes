package core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.vvasiliev.compose.notes.data.Event
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import dev.vvasiliev.compose.notes.navigation.NavigationDestination
import kotlinx.coroutines.launch

abstract class BaseViewModel<EventType : Event> (private val globalNavigator: GlobalNavigator) : ViewModel() {

  protected fun navigate(destination: NavigationDestination){
    viewModelScope.launch {
      globalNavigator.navigate(destination = destination)
    }
  }

  abstract fun onEvent(event: EventType)

}