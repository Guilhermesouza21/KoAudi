package com.example.koaudi.domain.repository

import com.example.koaudi.domain.model.Song

/**
 * Contrato da camada de domínio para acesso à biblioteca de músicas.
 * A implementação concreta fica na camada data (SongRepositoryImpl).
 */
interface SongRepository {

    /**
     * Retorna a lista de músicas MP3 disponíveis no dispositivo.
     * A busca é feita via MediaStore; o resultado é emitido uma única vez.
     */
    suspend fun getSongs(): List<Song>
}
