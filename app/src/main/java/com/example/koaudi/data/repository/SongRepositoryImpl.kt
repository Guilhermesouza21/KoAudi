package com.example.koaudi.data.repository

import android.content.ContentUris
import android.content.Context
import android.os.Build
import android.provider.MediaStore
import com.example.koaudi.domain.model.Song
import com.example.koaudi.domain.repository.SongRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementação concreta de [SongRepository] usando a API MediaStore do Android.
 *
 * Busca todos os arquivos de áudio do tipo MP3 armazenados no dispositivo,
 * extraindo: título, artista, duração e URI de conteúdo.
 *
 * A query é executada em [Dispatchers.IO] para não bloquear a thread principal.
 */
class SongRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : SongRepository {

    override suspend fun getSongs(): List<Song> = withContext(Dispatchers.IO) {
        val songs = mutableListOf<Song>()

        // Coleção correta dependendo da versão do Android
        val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        }

        // Colunas que queremos recuperar
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION,
        )

        // Filtra apenas arquivos MP3 com duração válida (> 0)
        val selection = "${MediaStore.Audio.Media.MIME_TYPE} = ? AND ${MediaStore.Audio.Media.DURATION} > 0"
        val selectionArgs = arrayOf("audio/mpeg")
        val sortOrder = "${MediaStore.Audio.Media.TITLE} ASC"

        context.contentResolver.query(
            collection,
            projection,
            selection,
            selectionArgs,
            sortOrder,
        )?.use { cursor ->
            val idColumn       = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val titleColumn    = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn   = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val durationColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)

            while (cursor.moveToNext()) {
                val id       = cursor.getLong(idColumn)
                val title    = cursor.getString(titleColumn).orEmpty().ifBlank { "Sem título" }
                val artist   = cursor.getString(artistColumn).orEmpty()
                    .let { if (it == "<unknown>" || it.isBlank()) "Artista desconhecido" else it }
                val duration = cursor.getLong(durationColumn)
                val uri      = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id)

                songs += Song(
                    id       = id,
                    title    = title,
                    artist   = artist,
                    duration = duration,
                    uri      = uri,
                )
            }
        }

        songs
    }
}
