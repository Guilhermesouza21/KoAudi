package com.example.koaudi.presentation.songlist

import com.example.koaudi.domain.model.Song

/**
 * Representa os possíveis estados da tela de listagem de músicas.
 *
 * Segue o padrão Sealed Class para que o compilador garanta
 * que todos os estados sejam tratados no `when`.
 */
sealed class SongListUiState {

    /** Buscando músicas ou aguardando resultado da permissão. */
    data object Loading : SongListUiState()

    /** Músicas carregadas com sucesso. */
    data class Success(val songs: List<Song>) : SongListUiState()

    /** Nenhuma música MP3 foi encontrada no dispositivo. */
    data object Empty : SongListUiState()

    /** O usuário negou a permissão de leitura de mídia. */
    data object PermissionDenied : SongListUiState()
}
