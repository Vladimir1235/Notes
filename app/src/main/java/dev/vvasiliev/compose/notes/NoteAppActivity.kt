package dev.vvasiliev.compose.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.android.AndroidInjection
import dev.vvasiliev.compose.notes.navigation.GlobalNavigator
import dev.vvasiliev.compose.notes.navigation.NotesNavigationHost
import dev.vvasiliev.compose.notes.ui.theme.NotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteAppActivity : ComponentActivity() {

    @Inject
    lateinit var globalNavigator: GlobalNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContent {
            NotesTheme {
                val navController = rememberNavController()
                ConnectGlobalNavigation(navController)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NotesNavigationHost(navHostController = navController, globalNavigator = globalNavigator)
                }
            }
        }
    }
}

@Composable
private fun NoteAppActivity.ConnectGlobalNavigation(navController: NavHostController){
    LaunchedEffect(key1 = true){
        CoroutineScope(Dispatchers.Main).launch{
            globalNavigator.navigationChannel.collect{
                navController.navigate(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesTheme {}
}