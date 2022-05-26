package com.apps.sejarah.utils

import com.apps.sejarah.data.entity.ArticleEntity
import com.apps.sejarah.domain.model.Article

object DataMapper {

    fun mapEntityToDomain(data: ArticleEntity): Article {
        return Article(data.id, data.title, data.content, data.imageUrl)
    }

    fun mapEntitiesToDomain(data: List<ArticleEntity>): List<Article> {
        return data.map {
            mapEntityToDomain(it)
        }
    }

    fun mapDomainToEntity(data: Article): ArticleEntity {
        return ArticleEntity(data.id, data.title, data.content, data.imageUrl)
    }

    fun mapDomainToEntities(data: List<Article>): List<ArticleEntity> {
        return data.map {
            mapDomainToEntity(it)
        }
    }
}