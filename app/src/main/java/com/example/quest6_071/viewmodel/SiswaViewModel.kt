package com.example.quest6_071.viewmodel

import androidx.lifecycle.ViewModel
import com.example.quest6_071.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class SiswaViewModel: ViewModel() {

    private val _statusUI = MutableStateFlow(Siswa())

    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[3]
            )
        }
    }
}
}