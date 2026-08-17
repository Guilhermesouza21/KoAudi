package com.example.koaudi.domain.usecase

import com.example.koaudi.domain.model.Song
import com.example.koaudi.domain.repository.SongRepository
import javax.inject.Inject

/**
 * Use case responsável por buscar a lista de músicas MP3 do dispositivo.
 *
 * Encapsula a lógica de negócio: por enquanto apenas delega ao repositório,
 * mas é o ponto correto para aplicar ordenações, filtros ou validações futuramente.
 */
class GetSongsUseCase @Inject constructor(
    private val repository: SongRepository,
) {
    /**
     * Executa a busca de músicas.
     * @return Lista de [Song] ordenada por título.
     */
    suspend operator fun invoke(): List<Song> =
        repository.getSongs().sortedBy { it.title.lowercase() }
}
