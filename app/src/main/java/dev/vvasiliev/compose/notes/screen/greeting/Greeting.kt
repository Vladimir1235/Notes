package dev.vvasiliev.compose.notes.screen.greeting

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.vvasiliev.compose.notes.screen.greeting.viewmodel.GreetingViewModel
import kotlinx.coroutines.delay

@Composable
fun GreetingScreen() {

    var buttonVisibility by remember{ mutableStateOf(false) }
    var greetingVisibility by remember { mutableStateOf(false)}

    LaunchedEffect(true){
        delay(500L)
        greetingVisibility = true
        delay(500L)
        buttonVisibility = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = greetingVisibility) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Greeting!", style = MaterialTheme.typography.h2)
            }
        }
        AnimatedVisibility(visible = buttonVisibility) {
            Button(onClick = { }) {
                Text(text = "Let's go!")
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    GreetingScreen()
}