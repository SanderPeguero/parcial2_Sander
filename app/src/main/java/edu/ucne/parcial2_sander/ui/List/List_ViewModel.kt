package edu.ucne.parcial2_sander.ui.List

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial2_sander.remote.verboDTO
import edu.ucne.parcial2_sander.repository.verboRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VerboUiState(
    val verbo: List<verboDTO> = emptyList()
)

@HiltViewModel
class List_ViewModel @Inject constructor(
    val repository: verboRepository
): ViewModel(){

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


//@HiltViewModel
//class ListViewModel @Inject constructor(
//    val repository: articuloRepository
//): ViewModel(){
//    //    private val _uiState = MutableStateFlow(articuloUiState())
////    val uiState: StateFlow<articuloUiState> = _uiState.asStateFlow()
////
//    var uiState = MutableStateFlow(articuloUiState())
//        private set
//
//    init{
//        viewModelScope.launch {
//            val list = repository.getArticulos()
//
//            uiState.update {
//                it.copy(
//                    repository.getArticulos()
//                )
//            }
////            repository.getAll().collect{ list ->
////                _uiState.update{
////                    it.copy( articulos = list)
////                }
////            }
//        }
//    }