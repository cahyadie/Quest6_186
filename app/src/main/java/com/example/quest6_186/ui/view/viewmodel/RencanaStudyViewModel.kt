package com.example.quest6_186.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quest6_186.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMatakuliah(mkPilihan: String) {
        _krsState.update {stateMK -> stateMK.copy(namaMK = mkPilihan)}
    }

    fun setKelas(KelasPilihan: String) {
        _krsState.update {stateKelas -> stateKelas.copy(kelas = KelasPilihan)}
    }

    fun saveDataKRS(ls: MutableList<String>) {
        _krsState.update { state ->
            state.copy(
                namaMK = ls[0],
                kelas = ls[1]
            )
        }
    }
}

