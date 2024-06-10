package dev.jaysonguillen.personapp.domain.repository

import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PersonRepository {

    suspend fun getListOfPerson(results: String): Resource<Person>

    suspend fun insertPerson(personLocal: PersonLocal)

    fun getSavedPersons(): Flow<List<PersonLocal>>
}