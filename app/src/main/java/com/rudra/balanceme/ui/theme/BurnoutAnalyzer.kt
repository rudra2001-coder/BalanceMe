package com.rudra.balanceme.ui.theme



fun analyzeState(mood: Int, energy: Int): String {
    return when {
        mood < 4 && energy < 4 -> "You might be burned out. Try resting today. 🛌"
        mood < 5 -> "Low mood detected. Try journaling or walking. ✍️🚶"
        energy < 5 -> "Low energy. Hydrate & take breaks. 💧🧘"
        else -> "You're doing okay! Keep it up 💪"
    }
}
