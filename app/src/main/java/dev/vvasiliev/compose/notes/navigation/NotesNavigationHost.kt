package dev.vvasiliev.compose.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.vvasiliev.compose.notes.screen.greeting.GreetingScreen
import dev.vvasiliev.compose.notes.screen.greeting.viewmodel.GreetingViewModel
import dev.vvasiliev.compose.notes.screen.note.NoteScreen
import dev.vvasiliev.compose.notes.screen.notelist.NoteListScreen
import dev.vvasiliev.compose.notes.screen.notelist.viewmodel.NoteListViewModel

@Composable
fun NotesNavigationHost(
    globalNavigator: GlobalNavigator,
    navHostController: NavHostController,
    startDestination: String = DestinationType.GREETING_SCREEN.getRoot()
) = NavHost(navController = navHostController, startDestination = startDestination) {
        composable(NavigationDestination.GreetingScreen.fullScheme) {
            GreetingScreen(GreetingViewModel(globalNavigator))
        }

        composable(NavigationDestination.NotesScreen.fullScheme) {
            NoteListScreen(NoteListViewModel(globalNavigator))
        }

        composable(
            NavigationDestination.NoteScreen().fullScheme, arguments = listOf(
                navArgument("id") { type = NavType.LongType }
            )
        ) { entry ->
            entry.arguments?.getLong("id")?.let { id ->
                NoteScreen(noteId = id)
            }
        }
    }