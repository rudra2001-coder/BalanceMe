package com.rudra.balanceme.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun HomeScreen() {
    var mood by remember { mutableStateOf(5f) }
    var energy by remember { mutableStateOf(5f) }
    var suggestion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("How do you feel today?", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        Text("Mood: ${mood.toInt()}")
        Slider(value = mood, onValueChange = { mood = it }, valueRange = 1f..10f)

        Text("Energy: ${energy.toInt()}")
        Slider(value = energy, onValueChange = { energy = it }, valueRange = 1f..10f)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            suggestion = analyzeState(mood.toInt(), energy.toInt())
        }) {
            Text("Get Suggestion")
        }

        if (suggestion.isNotEmpty()) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(suggestion, style = MaterialTheme.typography.bodyLarge)
        }
    }
}


