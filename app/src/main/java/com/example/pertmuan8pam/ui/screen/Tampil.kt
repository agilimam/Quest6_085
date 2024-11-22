package com.example.pertmuan8pam.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertmuan8pam.model.Mahasiswa
import com.example.pertmuan8pam.model.RencanaStudy

@Composable
fun DataMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: Mahasiswa,
    krsState:RencanaStudy,

    onClikButton: () -> Unit
){
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("NIM", uiStateMahasiswa.nim),
        Pair("Email", uiStateMahasiswa.email),
        Pair("Mata Kuliah",krsState.mataKuliah),
        Pair("Kelas",krsState.kelas),
    )

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Tampilan Data",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))

        listDataMhs.forEach{items ->
            CardSection(
                judulParam = items.first,
                Isiparams  = items.second
            )
        }
        Button(onClick = {onClikButton()}) {
            Text(text = "Kembali")
        }
    }
}
@Composable
fun CardSection(judulParam : String, Isiparams : String){
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$Isiparams", modifier = Modifier.weight(2f))
        }

    }
}
