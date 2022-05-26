package com.apps.sejarah.di

import android.content.Context
import androidx.room.Room
import com.apps.sejarah.data.SejarahRepository
import com.apps.sejarah.data.source.local.LocalDataSource
import com.apps.sejarah.data.source.local.SejarahDao
import com.apps.sejarah.data.source.local.SejarahDatabase
import com.apps.sejarah.domain.repository.ISejarahRepository
import com.apps.sejarah.domain.usecase.SejarahInteractor
import com.apps.sejarah.domain.usecase.SejarahUseCase
import com.apps.sejarah.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context): SejarahDatabase{
        val passphrase: ByteArray = SQLiteDatabase.getBytes(Constants.PASSPHRASE.toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(app, SejarahDatabase::class.java, Constants.DB_NAME)
            .openHelperFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: SejarahDatabase): SejarahDao{
        return database.sejarahDao()
    }

    @Singleton
    @Provides
    fun provideRepository(dao: SejarahDao): ISejarahRepository{
        val localDataSource = LocalDataSource(dao)
        return SejarahRepository(localDataSource)
    }

    @Singleton
    @Provides
    fun provideScannerUseCase(repository: ISejarahRepository): SejarahUseCase {
        return SejarahInteractor(repository)
    }
}