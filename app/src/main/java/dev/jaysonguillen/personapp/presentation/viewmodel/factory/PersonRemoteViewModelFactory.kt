package dev.jaysonguillen.personapp.presentation.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.jaysonguillen.personapp.domain.usecase.GetPersonRemoteUseCase
import dev.jaysonguillen.personapp.presentation.viewmodel.PersonRemoteViewModel

class PersonRemoteViewModelFactory(private val getPersonRemoteUseCase: GetPersonRemoteUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonRemoteViewModel(getPersonRemoteUseCase) as T
    }
}