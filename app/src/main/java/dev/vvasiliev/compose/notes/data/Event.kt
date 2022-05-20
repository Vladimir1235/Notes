package dev.vvasiliev.compose.notes.data

interface Event {
    val tag: String
    val parameters: Map<String, String>
}