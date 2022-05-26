package com.apps.sejarah.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apps.sejarah.data.entity.ArticleEntity
import com.apps.sejarah.domain.model.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface SejarahDao {

    @Query("SELECT * FROM sejarah_article")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticleList(articleList: List<ArticleEntity>)
}