package com.lukar.unit2artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceApp() {
    // data for artwork
    val artworks = listOf(
        Artwork(R.drawable.art1, "Aatu Heikkinen", "Whisper Drummer, 2024"),
        Artwork(R.drawable.art2, "Peerapol Manmang", "Whisper Guitarist, 2024"),
        Artwork(R.drawable.art3, "Tobias Huzckowski", "Whisper Vocalist, 2024"),
        Artwork(R.drawable.art4, "Luka Raivisto", "Whisper Drummer, 2024")
    )

    var currentIndex by remember { mutableStateOf(0) }

    fun goToNext() {
        currentIndex = (currentIndex + 1) % artworks.size
    }

    fun goToPrevious() {
        currentIndex = if (currentIndex == 0) artworks.size - 1 else currentIndex - 1
    }

    val current = artworks[currentIndex]

    Surface(
        color = Color(0xFFF2EFEA),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ArtImage(current.imageRes)
            Spacer(modifier = Modifier.height(16.dp))
            ArtInfo(current.title, current.artist)
            Spacer(modifier = Modifier.height(16.dp))
            NavigationButtons(
                onPrevious = { goToPrevious() },
                onNext = { goToNext() }
            )
        }
    }
}

// class for artwork
data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String
)

@Composable
fun ArtImage(imageRes: Int) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        modifier = Modifier
            .border(2.dp, Color.Gray)
            .padding(16.dp)
            .fillMaxWidth()
            .height(400.dp)
    )
}

@Composable
fun ArtInfo(title: String, artist: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = artist,
            fontSize = 16.sp
        )
    }
}

@Composable
fun NavigationButtons(onPrevious: () -> Unit, onNext: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Button(onClick = onPrevious) {
            Text("Previous")
        }
        Button(onClick = onNext) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceApp()
}