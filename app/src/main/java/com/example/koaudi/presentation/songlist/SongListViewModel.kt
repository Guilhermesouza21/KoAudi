package com.example.koaudi.presentation.songlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koaudi.domain.usecase.GetSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel da tela de listagem de músicas.
 *
 * Responsabilidades:
 * - Expor o estado da UI via [StateFlow] imutável para a camada Compose.
 * - Receber o resultado da solicitação de permissão e reagir adequadamente.
 * - Delegar a busca de músicas ao [GetSongsUseCase].
 *
 * A flag [permissionAlreadyRequested] evita que a UI solicite a permissão
 * em recomposições desnecessárias.
 */
@HiltViewModel
class SongListViewModel @Inject constructor(
    private val getSongsUseCase: GetSongsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<SongListUiState>(SongListUiState.Loading)
    val uiState: StateFlow<SongListUiState> = _uiState.asStateFlow()

    /**
     * Chamado pela tela quando a permissão foi concedida (ou já estava concedida).
     * Dispara a busca das músicas via use case.
     */
    fun onPermissionGranted() {
        _uiState.value = SongListUiState.Loading
        viewModelScope.launch {
            val songs = getSongsUseCase()
            _uiState.value = if (songs.isEmpty()) {
                SongListUiState.Empty
            } else {
                SongListUiState.Success(songs)
            }
        }
    }

    /**
     * Chamado pela tela quando o usuário nega a permissão de leitura de mídia.
     */
    fun onPermissionDenied() {
        _uiState.value = SongListUiState.PermissionDenied
    }
}
