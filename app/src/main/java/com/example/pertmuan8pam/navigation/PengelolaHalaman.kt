package com.example.pertmuan8pam.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertmuan8pam.ui.screen.MahasiswaFormView
import com.example.pertmuan8pam.ui.screen.SplashView
import com.example.pertmuan8pam.ui.screen.Tampil
import com.example.pertmuan8pam.ui.view.MahasiswaViewModel
import com.example.pertmuan8pam.ui.view.RencanaStudyViewModel
import com.example.petemuan8.ui.screen.RencanaStudyView

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
        composable(route = Halaman.Splash.name){
            SplashView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                modifier = Modifier.fillMaxSize(),
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUIState,
                onSubmitButtonClicked = {
                    MatakuliahViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Tampil.name) {
            Tampil(
                uiStateMahasiswa = mahasiswaUIState,
                krsState = MatakuliahViewModel.krsStateUI.collectAsState().value,
                onClikButton = {
                    navController.navigate(Halaman.Splash.name)
                }
            )
        }
    }
}



