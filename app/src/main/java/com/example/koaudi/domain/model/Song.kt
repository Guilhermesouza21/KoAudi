package com.example.koaudi.domain.model

import android.net.Uri

/**
 * Modelo de domínio que representa uma música MP3 do dispositivo.
 *
 * @param id       ID único do MediaStore.
 * @param title    Título da faixa.
 * @param artist   Nome do artista (pode ser "<desconhecido>" se ausente).
 * @param duration Duração em milissegundos.
 * @param uri      URI de conteúdo para reprodução via MediaPlayer/ExoPlayer.
 */
data class Song(
    val id: Long,
    val title: String,
    val artist: String,
    val duration: Long,
    val uri: Uri,
)
