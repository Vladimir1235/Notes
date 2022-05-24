package dev.vvasiliev.compose.notes.screen.greeting.event

import dev.vvasiliev.compose.notes.data.Event

open class GreetingEvent(override val tag: String = "greeting_screen", override val parameters: Map<String, String>) : Event

data class ShowAllNotesEvent constructor(
    override val parameters: Map<String, String> = mapOf()
): GreetingEvent(parameters = parameters) 