package dev.vvasiliev.compose.notes.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class GlobalNavigator @Inject constructor() {
    private val _navigationChannel: Channel<String> = Channel()
    val navigationChannel = _navigationChannel.receiveAsFlow()

    suspend fun navigate(destination: NavigationDestination){
        _navigationChannel.send(destination.getRoute())
    }

}