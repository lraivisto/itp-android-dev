package com.lukar.unit3thirtydaysapp

import com.lukar.unit3thirtydaysapp.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme()) {
                ThirtyDaysApp()
            }
        }
    }
}

data class Band(
    val day: Int,
    val name: String,
    val description: String,
    val imageResId: Int
)

@Composable
fun ThirtyDaysApp() {
    val bands = listOf(
        Band(1, "Death", "Foundational death metal band from Florida, led by Chuck Schuldiner.", R.drawable.death),
        Band(2, "Morbid Angel", "Known for chaotic riffs, blast beats, and Lovecraftian lyrics.", R.drawable.morbidangel),
        Band(3, "Entombed", "Pioneers of the Swedish buzzsaw guitar sound.", R.drawable.entombed),
        Band(4, "Napalm Death", "Inventors of grindcore. Short, fast, loud.", R.drawable.napalmdeath),
        Band(5, "Obituary", "Florida death legends with swampy, brutal riffing.", R.drawable.placeholder),
        Band(6, "Autopsy", "Misanthropic gore-driven death/doom from California.", R.drawable.placeholder),
        Band(7, "Bolt Thrower", "War-themed death metal with tank-sized groove.", R.drawable.placeholder),
        Band(8, "Pestilence", "Dutch progressive death metal with jazzy elements.", R.drawable.placeholder),
        Band(9, "At the Gates", "Melodic death from Gothenburg, creators of Slaughter of the Soul.", R.drawable.placeholder),
        Band(10, "In Flames", "Pioneers of melodic death metal with shifting styles.", R.drawable.placeholder),
        Band(11, "Dark Tranquillity", "Atmospheric, melancholic Swedish death metal.", R.drawable.placeholder),
        Band(12, "Edge of Sanity", "Progressive and melodic death from Dan Swanö.", R.drawable.placeholder),
        Band(13, "Grave", "Buzzsaw-heavy old-school Swedish death metal.", R.drawable.placeholder),
        Band(14, "Dismember", "Melodic aggression with iconic HM-2 tone.", R.drawable.placeholder),
        Band(15, "Carnage", "Short-lived but classic early Swedish death metal.", R.drawable.placeholder),
        Band(16, "Unleashed", "Viking-themed old-school death metal.", R.drawable.placeholder),
        Band(17, "Deicide", "Blasphemous brutality from Florida.", R.drawable.placeholder),
        Band(18, "Demigod", "Cult Finnish death with eerie atmospheres.", R.drawable.placeholder),
        Band(19, "Convulse", "Finnish old-schoolers with a psychedelic edge.", R.drawable.placeholder),
        Band(20, "Sentenced", "Started as death metal, moved toward gothic melancholy.", R.drawable.placeholder),
        Band(21, "Nihilist", "The proto-form of Entombed, raw and aggressive.", R.drawable.placeholder),
        Band(22, "Morgoth", "Germany's death metal response to the Florida scene.", R.drawable.placeholder),
        Band(23, "Asphyx", "Dutch death/doom legends with crushing vocals.", R.drawable.placeholder),
        Band(24, "Vader", "Poland's precise, thrashing death veterans.", R.drawable.placeholder),
        Band(25, "Behemoth", "Started as black/death; evolved into theatrical brutality.", R.drawable.placeholder),
        Band(26, "Seance", "Underrated Swedish band with a unique, fast style.", R.drawable.placeholder),
        Band(27, "The Crown", "Blackened death 'n' roll chaos.", R.drawable.placeholder),
        Band(28, "Malevolent Creation", "Florida-based death/thrash hybrid intensity.", R.drawable.placeholder),
        Band(29, "Sinister", "Long-running Dutch death metal force.", R.drawable.placeholder),
        Band(30, "Hypocrisy", "Melodic, atmospheric, and alien-obsessed death metal.", R.drawable.placeholder)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(bands) { band ->
                BandCard(band)
            }
        }
    }
}

@Composable
fun BandCard(band: Band) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = band.imageResId),
                contentDescription = band.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = band.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = band.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThirtyDaysApp() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        ThirtyDaysApp()
    }
}