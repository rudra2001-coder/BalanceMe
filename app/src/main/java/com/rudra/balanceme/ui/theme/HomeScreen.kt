package com.rudra.balanceme.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    var mood by remember { mutableStateOf(5f) }
    var energy by remember { mutableStateOf(5f) }
    var suggestion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "👋 Hello, how are you feeling today?",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 22.sp
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEDF6FF)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Mood: ${mood.toInt()} 🥲😊😀😎", fontSize = 18.sp)
                Text("🙂", fontSize = 32.sp)
                Slider(
                    value = mood,
                    onValueChange = { mood = it },
                    valueRange = 1f..10f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFF4CAF50),
                        activeTrackColor = Color(0xFF81C784)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4)),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Energy: ${energy.toInt()} ⚡", fontSize = 18.sp)
                Text("⚡", fontSize = 32.sp)
                Slider(
                    value = energy,
                    onValueChange = { energy = it },
                    valueRange = 1f..10f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFFF9800),
                        activeTrackColor = Color(0xFFFFB74D)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                suggestion = analyzeState(mood.toInt(), energy.toInt())
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
        ) {
            Text("✨ Get Suggestion", color = Color.White)
        }

        AnimatedVisibility(visible = suggestion.isNotEmpty()) {
            Column(modifier = Modifier.padding(top = 24.dp)) {
                Text(
                    text = "💡 Suggestion",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF388E3C)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = suggestion,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp
                )
            }
        }
    }
}

