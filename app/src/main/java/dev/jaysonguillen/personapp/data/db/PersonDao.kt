package dev.jaysonguillen.personapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.jaysonguillen.personapp.data.model.PersonLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(personLocal: PersonLocal)

    @Query("SELECT * FROM persons")
    fun getSavedPersons(): Flow<List<PersonLocal>>

}