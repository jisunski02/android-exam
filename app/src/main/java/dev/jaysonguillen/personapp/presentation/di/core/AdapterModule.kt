package dev.jaysonguillen.personapp.presentation.di.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jaysonguillen.personapp.presentation.adapter.PersonAdapter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun providesPersonAdapter(): PersonAdapter{
        return PersonAdapter()
    }
}