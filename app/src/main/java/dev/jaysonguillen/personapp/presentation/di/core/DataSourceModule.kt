package dev.jaysonguillen.personapp.presentation.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jaysonguillen.personapp.data.api.ApiService
import dev.jaysonguillen.personapp.data.db.PersonDao
import dev.jaysonguillen.personapp.data.repository.datasource.PersonLocalDataSource
import dev.jaysonguillen.personapp.data.repository.datasource.PersonRemoteDataSource
import dev.jaysonguillen.personapp.data.repository.datasourceimpl.PersonLocalDataSourceImpl
import dev.jaysonguillen.personapp.data.repository.datasourceimpl.PersonRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesRemoteDataSource(apiService: ApiService): PersonRemoteDataSource{
        return PersonRemoteDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesPersonLocalDataSource(personDao: PersonDao): PersonLocalDataSource{
        return PersonLocalDataSourceImpl(personDao)
    }

}