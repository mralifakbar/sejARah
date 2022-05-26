package com.apps.sejarah.domain.usecase

import com.apps.sejarah.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface SejarahUseCase {
    fun getAllArticles(): Flow<List<Article>>

    suspend fun insertArticleList(articleList: List<Article>)
}