package dev.vvasiliev.compose.notes.navigation

/**
 * Navigation destination available to use internally
 *
 * @param destination is destination key to obtain root of this [DestinationType] root
 */
sealed class NavigationDestination(protected val destination: DestinationType) {

    /**
     * Screen with notes list destination
     */
    object NotesScreen: NavigationDestination(destination = DestinationType.NOTE_LIST_SCREEN) {
        override fun getRoot(): String = destination.getRoot()

        override val fullScheme: String = destination.getRoot()
    }

    /**
     * Screen with note details destination
     */
    class NoteScreen(private val id: Long): NavigationDestination(destination = DestinationType.NOTE_SCREEN){

        /**
         * Route field 'id'
         */
        private val _id_field = "id"

        override fun getRoot(): String = "${ this.destination.getRoot() }/{$id}"

        override val fullScheme: String = "${ this.destination.getRoot() }/{$_id_field}"
    }

    /**
     * Greeting screen destination
     */
    object GreetingScreen : NavigationDestination(destination = DestinationType.GREETING_SCREEN){

        override val fullScheme: String = destination.getRoot()

        override fun getRoot(): String = destination.getRoot()

    }

    abstract fun getRoot(): String
    abstract val fullScheme: String
}

class NavigationNotFoundException(destination: DestinationType) :
    Exception("Destination $destination not found")

/**
 * Is root of destination hierarchy
 */
enum class DestinationType(private val destination: String) {
    NOTE_SCREEN("note"), NOTE_LIST_SCREEN("notes"), GREETING_SCREEN("greeting");
    fun getRoot() = this@DestinationType.destination
}