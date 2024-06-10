package dev.jaysonguillen.personapp.presentation.di.core

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.jaysonguillen.personapp.data.db.PersonDao
import dev.jaysonguillen.personapp.data.db.PersonDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Singleton
    @Provides
    fun providesPersonRoomDatabase(app: Application): PersonDatabase{
        return Room.databaseBuilder(app, PersonDatabase::class.java, "weather_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesPersonDao(personDatabase: PersonDatabase): PersonDao{
        return personDatabase.getPersonDao()
    }
}