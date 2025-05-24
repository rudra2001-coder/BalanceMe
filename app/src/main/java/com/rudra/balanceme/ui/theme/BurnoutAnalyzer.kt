package com.rudra.balanceme.ui.theme




// Sample analyzeState function
fun analyzeState(mood: Int, energy: Int): String {
    return when {
        mood >= 8 && energy >= 8 -> "You're on fire! 🔥 Keep riding this positive wave!"
        mood <= 3 && energy <= 3 -> "Take a deep breath 🌬️. Maybe a short nap or a walk will help."
        mood < 5 -> "Feeling low? Try doing something you enjoy 💖."
        energy < 5 -> "Low energy? Recharge with some rest or music 🎵."
        else -> "You're doing alright 😊. Stay balanced and take it easy."
    }
}
