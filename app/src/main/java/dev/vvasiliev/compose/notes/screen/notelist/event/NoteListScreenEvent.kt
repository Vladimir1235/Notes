package dev.vvasiliev.compose.notes.screen.notelist.event

import dev.vvasiliev.compose.notes.data.Event

open class NoteListScreenEvent(
    override val tag: String,
    override val parameters: Map<String, String>
) : Event