package dev.jaysonguillen.personapp.data.repository.datasourceimpl

import dev.jaysonguillen.personapp.data.api.ApiService
import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.repository.datasource.PersonRemoteDataSource
import retrofit2.Response

class PersonRemoteDataSourceImpl(private val apiService: ApiService): PersonRemoteDataSource {

    override suspend fun getListOfPerson(results: String): Response<Person> {
        return apiService.getListOfPerson(results)
    }
}