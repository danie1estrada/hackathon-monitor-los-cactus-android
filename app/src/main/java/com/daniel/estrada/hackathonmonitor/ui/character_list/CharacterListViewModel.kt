package com.daniel.estrada.hackathonmonitor.ui.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniel.estrada.hackathonmonitor.domain.models.Character
import com.daniel.estrada.hackathonmonitor.domain.models.Response
import com.daniel.estrada.hackathonmonitor.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharacterListUIState(
    val result: Response<List<Character>>? = null,
    val isLoading: Boolean = false
)
@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _characterListUIState: MutableStateFlow<CharacterListUIState> = MutableStateFlow(CharacterListUIState())
    val characterListUIState: StateFlow<CharacterListUIState> = _characterListUIState

    init {
        viewModelScope.launch {
            _characterListUIState.value = CharacterListUIState(isLoading = true)
            val result = getCharactersUseCase()
            _characterListUIState.value = CharacterListUIState(result = result)
        }
    }
}