package com.application.everyrupee.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.application.everyrupee.ui.theme.BackgroundElevated
import com.application.everyrupee.ui.theme.Shapes
import com.application.everyrupee.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController) {
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text("Settings")}, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ) )
        },
        content = { innerpadding ->
            Column (modifier = Modifier.padding(innerpadding)){
                Column (modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(Shapes.medium)).background(BackgroundElevated).fillMaxWidth()) {
                    Text("Categories")
                    Text("Erase all data")
                }
            }

        }

    )
}