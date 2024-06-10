package dev.jaysonguillen.personapp.data.repository.datasource

import dev.jaysonguillen.personapp.data.model.Person
import retrofit2.Response

interface PersonRemoteDataSource {

    suspend fun getListOfPerson(results: String): Response<Person>
}