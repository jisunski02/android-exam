package dev.jaysonguillen.personapp.data.repository

import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.data.repository.datasource.PersonLocalDataSource
import dev.jaysonguillen.personapp.data.repository.datasource.PersonRemoteDataSource
import dev.jaysonguillen.personapp.data.util.Resource
import dev.jaysonguillen.personapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class PersonRepositoryImpl(private val personRemoteDataSource: PersonRemoteDataSource,
                            private val personLocalDataSource: PersonLocalDataSource): PersonRepository {

    private fun responseToResource(response: Response<Person>): Resource<Person>{
        if(response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getListOfPerson(results: String): Resource<Person> {
        return responseToResource(personRemoteDataSource.getListOfPerson(results))
    }

    override suspend fun insertPerson(personLocal: PersonLocal) {
        return personLocalDataSource.insertPerson(personLocal)
    }

    override fun getSavedPersons(): Flow<List<PersonLocal>> {
        return personLocalDataSource.getSavedPersons()
    }
}