package com.example.quest6_186.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.latihanmvvm.ui.view.screen.MahasiswaFormView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.latihanmvvm.ui.view.screen.RencanaStudyView
import com.example.quest6_186.ui.view.screen.Splashview
import com.example.quest6_186.ui.view.screen.TampilView
import com.example.quest6_186.ui.view.viewmodel.MahasiswaViewModel
import com.example.quest6_186.ui.view.viewmodel.RencanaStudyViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    krsViewModel: RencanaStudyViewModel = viewModel(),
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    viewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uiState = krsViewModel.krsStateUi.collectAsState().value
    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value


    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name
    ){
        composable(
            route = Halaman.Splash.name
        ){
            Splashview(
                onMulaiButton  = {
                    navController.navigate(Halaman.Mahasiswa.name)})
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {viewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }

        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onBackButtonClicked = {navController.popBackStack()},
                onSubmitButtonClicked ={krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name)}
                )
        }

        composable(route = Halaman.Tampil.name){
            TampilView(mahasiswa = mahasiswaUiState,
                krs = uiState,
                onResetButtonClicked = {navController.navigate(Halaman.Splash.name)},
                onBackButtonClicked = {navController.popBackStack()})
            }
    }
}