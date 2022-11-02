package edu.ucne.parcial2_sander.ui.verboList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_sander.model.Verbo
import edu.ucne.parcial2_sander.repository.verboRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class verboUiState(
    val verbos: List<Verbo> = emptyList()
)

@HiltViewModel
class verboList_ViewModel @Inject constructor(
    val repository: verboRepository
):ViewModel(){
    var uiState = MutableStateFlow(verboUiState())
        private set

    init{
        viewModelScope.launch {
            val list = repository.getVerbos()

            uiState.update {
                it.copy(
                    repository.getVerbos()
                )
            }
        }
    }
}


