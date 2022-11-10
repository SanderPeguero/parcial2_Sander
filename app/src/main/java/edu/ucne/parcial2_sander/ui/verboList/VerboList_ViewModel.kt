package edu.ucne.parcial2_sander.ui.verboList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_sander.repository.verboRepository
import edu.ucne.parcial2_sander.remote.verboDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerboUiState(
    val verbos: List<verboDTO> = emptyList()
)

@HiltViewModel
class VerboList_ViewModel @Inject constructor(
    val repository: verboRepository
):ViewModel(){

    var uiState = MutableStateFlow(VerboUiState())
        private set

    init{
        viewModelScope.launch {
            uiState.update{
                it.copy(
                    repository.getVerbos()
                )
            }
        }
    }
}


