package com.apps.sejarah.domain.usecase

import com.apps.sejarah.domain.model.Article
import com.apps.sejarah.domain.repository.ISejarahRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SejarahInteractor @Inject constructor(private val repository: ISejarahRepository) :
    SejarahUseCase {
    override fun getAllArticles(): Flow<List<Article>> {
        return repository.getAllArticles()
    }

    override suspend fun insertArticleList(articleList: List<Article>) {
        repository.insertArticleList(articleList)
    }
}