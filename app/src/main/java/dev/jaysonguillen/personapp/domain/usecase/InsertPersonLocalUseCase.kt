package dev.jaysonguillen.personapp.domain.usecase

import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.domain.repository.PersonRepository

class InsertPersonLocalUseCase(private val personRepository: PersonRepository) {

    suspend fun invoke(personLocal: PersonLocal){
        return personRepository.insertPerson(personLocal)
    }
}