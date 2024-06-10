package dev.jaysonguillen.personapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jaysonguillen.personapp.data.model.Person
import dev.jaysonguillen.personapp.data.util.Resource
import dev.jaysonguillen.personapp.domain.usecase.GetPersonRemoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonRemoteViewModel(private val getPersonRemoteUseCase: GetPersonRemoteUseCase): ViewModel() {

    private val personMutableStateFlow: MutableStateFlow<Resource<Person>> = MutableStateFlow(Resource.Loading())

    val personStateFlow: StateFlow<Resource<Person>>
        get() = personMutableStateFlow

    fun getPersonRemote(results: String){
        if(personStateFlow.value.data == null){
            viewModelScope.launch {

                personMutableStateFlow.value = Resource.Loading()

                try {
                    val personData = getPersonRemoteUseCase.invoke(results)
                    personMutableStateFlow.value = personData
                }

                catch (e: Exception){
                    personMutableStateFlow.value = Resource.Error(e.toString())
                }
            }
        }
    }
}