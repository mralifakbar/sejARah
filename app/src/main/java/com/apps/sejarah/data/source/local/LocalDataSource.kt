package com.apps.sejarah.data.source.local

import com.apps.sejarah.data.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val dao: SejarahDao) {
    fun getAllArticles(): Flow<List<ArticleEntity>> = dao.getAllArticles()

    suspend fun insertArticleList(articleList: List<ArticleEntity>) = dao.insertArticleList(articleList)
}