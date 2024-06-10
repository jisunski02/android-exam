package dev.jaysonguillen.personapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jaysonguillen.personapp.data.model.PersonLocal
import dev.jaysonguillen.personapp.domain.usecase.GetPersonLocalUseCase
import dev.jaysonguillen.personapp.domain.usecase.GetPersonRemoteUseCase
import dev.jaysonguillen.personapp.domain.usecase.InsertPersonLocalUseCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PersonLocalViewModel(private val getPersonLocalUseCase: GetPersonLocalUseCase,
                        private val insertPersonLocalUseCase: InsertPersonLocalUseCase): ViewModel() {

    fun insertPersonLocalData(personLocal: PersonLocal) = viewModelScope.launch {
             insertPersonLocalUseCase.invoke(personLocal)
        }

    fun getPersonLocalData() = flow {
            getPersonLocalUseCase.invoke().collect{
                emit(it)
            }
    }

}