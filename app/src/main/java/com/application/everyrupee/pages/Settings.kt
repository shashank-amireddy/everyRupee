package com.application.everyrupee.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.application.everyrupee.components.TableRow
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
                Column (modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()) {
                    TableRow(label ="Categories", hasArrow = true, modifier = Modifier.clickable {
                        navController.navigate("settings/categories")
                    })
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = com.application.everyrupee.ui.theme.Divider)
                    TableRow(label ="Erase all data", isDestructive = true)
                }
            }

        }

    )
}