package com.apps.sejarah.domain.repository

import com.apps.sejarah.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ISejarahRepository {
    fun getAllArticles(): Flow<List<Article>>

    suspend fun insertArticleList(articleList: List<Article>)
}