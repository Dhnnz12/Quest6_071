

package com.example.quest6_071.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quest6_071.R
import kotlin.collections.forEach


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    // Parameter lama untuk tombol kembali
    onBackBtnClick: () -> Unit,
    // --- PARAMETER BARU UNTUK TOMBOL FORMULIR ---
    onToFormulirClick: () -> Unit
){
    val items = listOf(
        Pair(stringResource(R.string.nama_lengkap), "Contoh Nama"),
        Pair(stringResource(R.string.jenis_kelamin), "Lainnya"),
        Pair(stringResource(R.string.alamat), "Yogyakarta")
    )
    Scaffold (
        topBar = { // TopAppBar seharusnya ditempatkan di dalam parameter topBar
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.tampil), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700) // Menggunakan containerColor
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding) // Menggunakan innerPadding dari Scaffold
                .padding(dimensionResource(id = R.dimen.padding_medium)), // Padding tambahan untuk konten
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            // Bagian untuk menampilkan data (forEach)
            items.forEach { item ->
                Column {
                    Text(
                        text = item.first.uppercase(),
                        fontSize = 16.sp
                    )
                    Text(
                        text = item.second,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 22.sp
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
            }

            Spacer(modifier = Modifier.weight(1f)) // Spacer untuk mendorong tombol ke bawah

            // --- TOMBOL BARU DITAMBAHKAN DI SINI ---
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onToFormulirClick // Menggunakan lambda baru
            ) {
                // Tambahkan string baru di strings.xml untuk ini jika perlu
                Text(text = "Ke Formulir Pendaftaran")
            }

            Spacer(modifier = Modifier.height(8.dp)) // Jarak antar tombol

            // Tombol "Back" yang sudah ada
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackBtnClick
            )  {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}
