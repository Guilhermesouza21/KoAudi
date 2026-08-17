package com.example.koaudi.data.di

import com.example.koaudi.data.repository.SongRepositoryImpl
import com.example.koaudi.domain.repository.SongRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo Hilt que vincula a interface [SongRepository] à sua implementação concreta
 * [SongRepositoryImpl], com escopo Singleton (uma única instância em todo o app).
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSongRepository(
        impl: SongRepositoryImpl,
    ): SongRepository
}
