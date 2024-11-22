package com.example.quest6_186.ui.view.screen

import androidx.compose.runtime.Composable
import com.example.praktikum8.model.Mahasiswa
import com.example.quest6_186.model.RencanaStudi

@Composable

fun TampilView(
    mahasiswa: Mahasiswa,
    krs : RencanaStudi,
    onResetButtonClicked: () -> Unit,
    onBackButtonClicked:()->Unit
){}