package com.example.tarjetaperfil

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val Colores = lightColorScheme(
    primary = Color(0xFF0B4F6C),
    onPrimary = Color.White,
    surfaceVariant = Color(0xFFE6EFF2),
    surfaceContainerHighest = Color(0xFFE6EFF2), // fondo de los TextField
    onSurfaceVariant = Color(0xFF3F4F55),
    background = Color.White
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.light(TRANSPARENT, TRANSPARENT))
        setContent {
            MaterialTheme(colorScheme = Colores) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPerfil(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
