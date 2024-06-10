package dev.jaysonguillen.personapp.presentation.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dev.jaysonguillen.personapp.domain.usecase.GetPersonLocalUseCase
import dev.jaysonguillen.personapp.domain.usecase.GetPersonRemoteUseCase
import dev.jaysonguillen.personapp.domain.usecase.InsertPersonLocalUseCase
import dev.jaysonguillen.personapp.presentation.viewmodel.factory.PersonLocalViewModelFactory
import dev.jaysonguillen.personapp.presentation.viewmodel.factory.PersonRemoteViewModelFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
class FactoryModule {

    @ActivityRetainedScoped
    @Provides
    fun providesPersonLocalViewModelFactory(getPersonLocalUseCase: GetPersonLocalUseCase,
                                            insertPersonLocalUseCase: InsertPersonLocalUseCase): PersonLocalViewModelFactory{
        return PersonLocalViewModelFactory(getPersonLocalUseCase, insertPersonLocalUseCase)
    }

    @ActivityRetainedScoped
    @Provides
    fun providesPersonRemoteViewModelFactory(getPersonRemoteUseCase: GetPersonRemoteUseCase): PersonRemoteViewModelFactory{
        return PersonRemoteViewModelFactory(getPersonRemoteUseCase)
    }


}