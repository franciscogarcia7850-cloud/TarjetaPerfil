package com.example.tarjetaperfil

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val LIKES_BASE = 24

@Composable
fun PantallaPerfil(modifier: Modifier = Modifier) {
    // rememberSaveable conserva el estado al rotar la pantalla
    var nombre by rememberSaveable { mutableStateOf("Francisco Garcia") }
    var descripcion by rememberSaveable { mutableStateOf("Lic. en Tecnologías de la Información") }
    var siguiendo by rememberSaveable { mutableStateOf(false) }
    var meGusta by rememberSaveable { mutableStateOf(false) }

    val likes = if (meGusta) LIKES_BASE + 1 else LIKES_BASE

    Column(
        modifier = modifier
            .fillMaxSize()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Tarjeta de Perfil",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        TarjetaPerfil(
            // Si el nombre está vacío se muestra un texto de ejemplo
            nombre = nombre.ifBlank { "Tu nombre" },
            descripcion = descripcion,
            siguiendo = siguiendo,
            meGusta = meGusta,
            likes = likes,
            onSeguir = { siguiendo = !siguiendo },
            onMeGusta = { meGusta = !meGusta }
        )

        Text(
            text = "Editar perfil",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        // Lo que se escribe aquí cambia la tarjeta al momento
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
            maxLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun PantallaPerfilPreview() {
    PantallaPerfil()
}
