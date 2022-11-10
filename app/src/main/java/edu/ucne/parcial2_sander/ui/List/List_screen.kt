package edu.ucne.parcial2_sander.ui.List

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import edu.ucne.parcial2_sander.ui.verboList.VerboList_ViewModel


@Composable
fun List_Screen(
    viewModel: VerboList_ViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = { Text("Verbo List") }
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
                    Image(painter = rememberAsyncImagePainter(verbo.Imagen) , contentDescription = "")

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}