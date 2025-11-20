package com.example.quest6_071.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.quest6_071.model.DataJK.JenisK
import com.example.quest6_071.view.FormIsian
import com.example.quest6_071.view.TampilData
import com.example.quest6_071.viewmodel.SiswaViewModel


enum class Navigasi {

    Formulirku,

    Detail
}

@Composable
fun DataApp(
   modifier: Modifier,
   viewModel: SiswaViewModel = viewModel(),
   navController : NavHostController = rememberNavController()
){
    Scaffold { isiRuang->

        val uiState = viewModel.statusUI.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)) {
            composable(route = Navigasi.Formulirku.name) {
                val konteks = LocalContext.current
                FormIsian(
                    pilihanJK = JenisK.map {id -> konteks.resources.getString(id)},
                    OnSubmitBtnClick = {
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)

                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    // Untuk tombol "Back"
                    onBackBtnClick = {
                        navController.popBackStack()
                    },
                    // --- TAMBAHKAN INI UNTUK TOMBOL BARU ---
                    // Untuk tombol "Ke Formulir Pendaftaran"
                    onToFormulirClick = {
                        navController.navigate(Navigasi.Formulirku.name)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirku(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.Formulirku.name,inclusive = false)
}