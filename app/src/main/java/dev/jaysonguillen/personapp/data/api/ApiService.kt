package dev.jaysonguillen.personapp.data.api

import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.model.PersonRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun getListOfPerson(
        @Query("results") results: String
    ): Response<Person>
}