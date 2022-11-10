package edu.ucne.parcial2_sander.ui.verboList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.Image
//import coil.compose.rememberAsyncImagePainter

@Composable
fun verboList_Screen(
    viewModel: VerboList_ViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {Text("Verbo List")}
    ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
        ) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(it) ){

                items(uiState.verbos){ verbo ->
                    Text( text = "Verbo: ${verbo.Verbo}" )
                    Text( text = "Nivel: ${verbo.Nivel}" )
                    Text( text = "Categoria: ${verbo.Categoria}" )
                    Text( text = "Imagen: ${verbo.Imagen}" )
//                    Image(painter = rememberAsyncImagePainter({verbo.imagen}) , contentDescription = "")
                }
            }
        }
    }
}