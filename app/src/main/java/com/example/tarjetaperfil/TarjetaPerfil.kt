package com.example.tarjetaperfil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Diseño Cards_01: banner arriba, foto encimada y texto centrado
@Composable
fun TarjetaPerfil(
    nombre: String,
    descripcion: String,
    siguiendo: Boolean,
    meGusta: Boolean,
    likes: Int,
    onSeguir: () -> Unit,
    onMeGusta: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // El Box encima la foto sobre el banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = "Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            )
            FotoPerfil(
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = nombre,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = descripcion,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BotonMeGusta(meGusta, likes, onMeGusta)
                BotonSeguir(siguiendo, onSeguir)
            }
        }
    }
}

@Composable
private fun FotoPerfil(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.cr7),
        contentDescription = "Foto de perfil",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(104.dp)
            .border(4.dp, Color.White, CircleShape)
            .padding(4.dp)
            .clip(CircleShape)
            .background(Color(0xFFB9CDD4))
    )
}

@Composable
private fun BotonMeGusta(meGusta: Boolean, likes: Int, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = if (meGusta) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = if (meGusta) "Quitar me gusta" else "Dar me gusta",
            tint = if (meGusta) Color(0xFFD32F2F) else MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("$likes")
    }
}

@Composable
private fun BotonSeguir(siguiendo: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = if (siguiendo) Icons.Default.Check else Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(if (siguiendo) "Siguiendo" else "Seguir")
    }
}
