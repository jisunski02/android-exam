package dev.jaysonguillen.personapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.jaysonguillen.personapp.data.model.PersonLocal

@Database(
    entities = [PersonLocal::class],
    version = 1,
    exportSchema = false
)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun getPersonDao(): PersonDao
}