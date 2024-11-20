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
import com.example.quest6_186.ui.view.screen.Splashview
import com.example.quest6_186.ui.view.viewmodel.MahasiswaViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uiState = viewModel.statusUI.collectAsState()

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
                onSubmitButtonClicked = {viewModel.saveDataMahasiswa(it)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
    }
}