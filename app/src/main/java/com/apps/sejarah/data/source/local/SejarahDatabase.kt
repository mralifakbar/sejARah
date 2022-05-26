package com.apps.sejarah.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apps.sejarah.data.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)

abstract class SejarahDatabase: RoomDatabase() {
    abstract fun sejarahDao(): SejarahDao
}