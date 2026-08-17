package com.example.koaudi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.koaudi.presentation.songlist.SongListScreen
import com.example.koaudi.theme.KoAudiTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Ponto de entrada do app KoAudi.
 *
 * Anotada com [@AndroidEntryPoint] para que o Hilt consiga injetar
 * dependências nos ViewModels e Composables usados nesta Activity.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KoAudiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SongListScreen()
                }
            }
        }
    }
}
