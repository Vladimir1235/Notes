package dev.vvasiliev.compose.notes.screen.note.event

import dev.vvasiliev.compose.notes.data.Event

open class NoteScreenEvent(override val tag: String, override val parameters: Map<String, String>): Event