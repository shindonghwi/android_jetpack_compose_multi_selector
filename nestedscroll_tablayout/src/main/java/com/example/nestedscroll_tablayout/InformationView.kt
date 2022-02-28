package com.example.nestedscroll_tablayout


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.resource.Primary500

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InformationView() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        repeat(50) {
            Text("정보 $it", color = Primary500, style = MaterialTheme.typography.subtitle2)
        }
    }
}