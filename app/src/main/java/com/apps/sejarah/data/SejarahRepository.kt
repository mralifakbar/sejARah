package com.apps.sejarah.data

import com.apps.sejarah.data.source.local.LocalDataSource
import com.apps.sejarah.domain.model.Article
import com.apps.sejarah.domain.repository.ISejarahRepository
import com.apps.sejarah.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SejarahRepository @Inject constructor(private val localDataSource: LocalDataSource) :
    ISejarahRepository {
    override fun getAllArticles(): Flow<List<Article>> {
        return localDataSource.getAllArticles().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override suspend fun insertArticleList(articleList: List<Article>) {
        localDataSource.insertArticleList(DataMapper.mapDomainToEntities(articleList))
    }

}