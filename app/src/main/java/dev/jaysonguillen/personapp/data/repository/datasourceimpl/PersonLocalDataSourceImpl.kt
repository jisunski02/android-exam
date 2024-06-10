package dev.jaysonguillen.personapp.data.repository.datasourceimpl

import dev.jaysonguillen.personapp.data.db.PersonDao
import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.data.repository.datasource.PersonLocalDataSource
import kotlinx.coroutines.flow.Flow

class PersonLocalDataSourceImpl(private val personDao: PersonDao): PersonLocalDataSource {

    override suspend fun insertPerson(personLocal: PersonLocal) {
        return personDao.insertPerson(personLocal)
    }

    override fun getSavedPersons(): Flow<List<PersonLocal>> {
        return personDao.getSavedPersons()
    }
}