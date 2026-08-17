package com.example.koaudi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Classe Application do KoAudi.
 *
 * Anotada com [@HiltAndroidApp] para que o Hilt gere o componente raiz
 * de injeção de dependência e inicialize o grafo de DI ao iniciar o app.
 */
@HiltAndroidApp
class KoAudiApplication : Application()
