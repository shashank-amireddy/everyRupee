package com.application.everyrupee.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.application.everyrupee.components.TableRow
import com.application.everyrupee.components.UnstyledTextField
import com.application.everyrupee.ui.theme.BackgroundElevated
import com.application.everyrupee.ui.theme.Divider
import com.application.everyrupee.ui.theme.Shapes
import com.application.everyrupee.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Add(navController: NavController){
    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
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
                    TableRow(label ="Amount"){
                        UnstyledTextField(value = "Amount", onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.End
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                            )
                        )
                    }
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Recurrence")
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Date")
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Note"){
                        UnstyledTextField(value = "",
                            onValueChange = {},
                            placeholder = { Text("Leave some notes")},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.End
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                            )
                        )
                    }
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Category")
                }
            }

        }

    )
}