package dev.jaysonguillen.personapp.presentation.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jaysonguillen.personapp.domain.repository.PersonRepository
import dev.jaysonguillen.personapp.domain.usecase.GetPersonLocalUseCase
import dev.jaysonguillen.personapp.domain.usecase.GetPersonRemoteUseCase
import dev.jaysonguillen.personapp.domain.usecase.InsertPersonLocalUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetPersonRemoteUseCase(personRepository: PersonRepository): GetPersonRemoteUseCase{
        return GetPersonRemoteUseCase(personRepository)
    }

    @Singleton
    @Provides
    fun providesGetLocalUseCase(personRepository: PersonRepository): GetPersonLocalUseCase{
        return GetPersonLocalUseCase(personRepository)
    }

    @Singleton
    @Provides
    fun providesInsertLocalUseCase(personRepository: PersonRepository): InsertPersonLocalUseCase{
        return InsertPersonLocalUseCase(personRepository)
    }
}