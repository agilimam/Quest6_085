package com.example.pertmuan8pam.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pertmuan8pam.ui.view.MahasiswaViewModel
import com.example.pertmuan8pam.ui.view.RencanaStudyViewModel

enum class Halaman{
    Mahasiswa,
    Matakuliah,
    Splash,
    Tampil
}
@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    MatakuliahViewModel: RencanaStudyViewModel = viewModel(),

){
    val mahasiswaUIState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding(8.dp)
    ){

    }
}



