
# KoAudi
# Documento de Visão — App de Música (Android)

## 1. Objetivo do Projeto

Desenvolver um aplicativo Android nativo, em Kotlin, para reprodução de arquivos de música (MP3) armazenados no dispositivo do usuário, com foco em uma experiência de player completa e profissional. O projeto tem como principal finalidade compor o portfólio técnico do desenvolvedor, demonstrando domínio de arquitetura Android moderna, boas práticas de desenvolvimento e aplicação de metodologia de projeto de software.

## 2. Problema / Motivação

Muitos usuários ainda possuem arquivos de música baixados localmente (MP3) e buscam um player leve, funcional e sem dependência de streaming ou conexão com a internet. O app resolve essa necessidade oferecendo controle total sobre a biblioteca local de músicas, com uma experiência de reprodução contínua e confiável, mesmo em segundo plano.

## 3. Escopo do Produto

### Incluído (MVP — Produto Mínimo Viável)
- Listagem das músicas MP3 presentes no dispositivo
- Player com ações padrão: tocar, pausar, próxima, anterior, barra de progresso
- Reprodução em segundo plano (com a tela desligada)
- Reprodução contínua mesmo com o app fechado (Foreground Service)
- Controles de mídia na notificação / tela de bloqueio
- Mini player persistente (acessível durante a navegação pelo app)

### Fora do escopo (por enquanto)
- Streaming de música online
- Download de músicas de fontes externas dentro do app
- Sincronização em nuvem
- Versão iOS

## 4. Funcionalidades Futuras (Backlog pós-MVP)
- Criação de playlists personalizadas
- Sistema de favoritos
- Histórico de reprodução
- Temas claro/escuro
- Equalizador de áudio
- Testes automatizados (unitários e de UI)

## 5. Público-Alvo

Usuários que possuem uma biblioteca local de músicas (MP3) no celular e preferem um player offline, leve e funcional — sem anúncios, sem exigir conta ou conexão com internet.

## 6. Stack Tecnológica

| Camada | Tecnologia |
|---|---|
| Linguagem | Kotlin |
| Interface (UI) | Jetpack Compose + Material 3 |
| Arquitetura | MVVM + Clean Architecture (camadas data/domain/presentation) |
| Assíncrono | Kotlin Coroutines + Flow |
| Player de áudio | Media3 (ExoPlayer) |
| Persistência local | Room + DataStore |
| Injeção de dependência | Hilt |
| Navegação | Navigation Compose |
| Controle de versão | Git + GitHub |

## 7. Metodologia de Desenvolvimento

Projeto individual, desenvolvido com **Kanban pessoal** (colunas: Backlog → To Do → Em Progresso → Teste → Concluído), com controle de versão via Git (branches por funcionalidade e commits semânticos). Documentação incremental no README do repositório, incluindo decisões técnicas relevantes.

## 8. Critérios de Sucesso

- App instalável e funcional, sem crashes nos fluxos principais
- Reprodução de áudio estável em segundo plano e com tela desligada
- Código organizado em camadas, seguindo a arquitetura definida
- Repositório público no GitHub com README completo, prints/gif de demonstração e histórico de commits organizado
- Projeto citável em entrevistas técnicas como exemplo de domínio de Android moderno

## 9. Riscos Conhecidos

- Gerenciamento de permissões de armazenamento (scoped storage) pode variar entre versões do Android
- Manter a reprodução estável em segundo plano exige configuração cuidadosa do Foreground Service e da MediaSession
- Escopo pode crescer (scope creep) — importante manter o MVP enxuto antes de partir para as funcionalidades futuras
