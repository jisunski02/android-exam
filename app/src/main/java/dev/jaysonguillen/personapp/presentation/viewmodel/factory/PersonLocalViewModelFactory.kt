package dev.jaysonguillen.personapp.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.jaysonguillen.personapp.domain.usecase.GetPersonLocalUseCase
import dev.jaysonguillen.personapp.domain.usecase.InsertPersonLocalUseCase
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonLocalViewModel

class PersonLocalViewModelFactory(private val getPersonLocalUseCase: GetPersonLocalUseCase,
                                  private val insertPersonLocalUseCase: InsertPersonLocalUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonLocalViewModel(getPersonLocalUseCase, insertPersonLocalUseCase) as T
    }
}