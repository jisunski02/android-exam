package dev.jaysonguillen.personapp.data.repository.datasource

import dev.jaysonguillen.personapp.data.model.PersonLocal
import kotlinx.coroutines.flow.Flow

interface PersonLocalDataSource {

    suspend fun insertPerson(personLocal: PersonLocal)

    fun getSavedPersons(): Flow<List<PersonLocal>>
}