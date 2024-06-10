package dev.jaysonguillen.personapp.presentation.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jaysonguillen.personapp.data.repository.PersonRepositoryImpl
import dev.jaysonguillen.personapp.data.repository.datasource.PersonLocalDataSource
import dev.jaysonguillen.personapp.data.repository.datasource.PersonRemoteDataSource
import dev.jaysonguillen.personapp.domain.repository.PersonRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesPersonRepository(personRemoteDataSource: PersonRemoteDataSource,
                                 personLocalDataSource: PersonLocalDataSource): PersonRepository{
        return PersonRepositoryImpl(personRemoteDataSource, personLocalDataSource)
    }

}