package dev.jaysonguillen.personapp.domain.usecase

import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.util.Resource
import dev.jaysonguillen.personapp.domain.repository.PersonRepository

class GetPersonRemoteUseCase(private val personRepository: PersonRepository) {

    suspend fun invoke(results: String): Resource<Person>{
        return personRepository.getListOfPerson(results)
    }
}