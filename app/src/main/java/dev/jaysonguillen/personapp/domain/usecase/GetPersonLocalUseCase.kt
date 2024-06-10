package dev.jaysonguillen.personapp.domain.usecase

import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

class GetPersonLocalUseCase(private val personRepository: PersonRepository) {

    suspend fun invoke(): Flow<List<PersonLocal>>{
        return personRepository.getSavedPersons()
    }
}