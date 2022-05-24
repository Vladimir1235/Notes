package dev.vvasiliev.compose.notes.screen.greeting

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.vvasiliev.compose.notes.screen.greeting.event.ShowAllNotesEvent
import dev.vvasiliev.compose.notes.screen.greeting.viewmodel.GreetingViewModel

@Composable
fun GreetingScreen(viewModel: GreetingViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(text = "Greeting!", style = MaterialTheme.typography.h2)
        }
            Button(onClick = {
                viewModel.onEvent(ShowAllNotesEvent())
            }) {
                Text(text = "Let's go!")
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
}