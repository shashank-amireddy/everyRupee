package com.application.everyrupee.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.application.everyrupee.components.TableRow
import com.application.everyrupee.components.UnstyledTextField
import com.application.everyrupee.ui.theme.BackgroundElevated
import com.application.everyrupee.ui.theme.Divider
import com.application.everyrupee.ui.theme.EveryRupeeTheme
import com.application.everyrupee.ui.theme.Shapes
import com.application.everyrupee.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Add(navController: NavController){
    val recurrences = listOf(
        "None",
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly"
    )
    var selectedRecurrence by remember {
        mutableStateOf(recurrences[0])
    }

    val categories = listOf(
        "None",
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly"
    )
    var selectedCategories by remember {
        mutableStateOf(categories[0])
    }

    Scaffold (
        topBar = {
            MediumTopAppBar(title = { Text("Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ) )
        },
        content = { innerpadding ->
            Column (modifier = Modifier.padding(innerpadding), horizontalAlignment = Alignment.CenterHorizontally){
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
                    TableRow(label ="Recurrence"){
                        var recurrenceMenuOpened by remember{
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { recurrenceMenuOpened = true}) {
                            Text(text = selectedRecurrence)
                            DropdownMenu(expanded = recurrenceMenuOpened, onDismissRequest = { recurrenceMenuOpened = false}) {
                                recurrences.forEach{recurrence ->
                                    DropdownMenuItem(text = { Text(recurrence)},
                                        onClick = {
                                            selectedRecurrence = recurrence
                                            recurrenceMenuOpened = false
                                        }
                                    )

                                }


//                                DropdownMenuItem(text = { Text(text = "None")}, onClick = { /*TODO*/ })
//                                DropdownMenuItem(text = { Text(text = "Daily")}, onClick = { /*TODO*/ })
//                                DropdownMenuItem(text = { Text(text = "Weekly")}, onClick = { /*TODO*/ })
//                                DropdownMenuItem(text = { Text(text = "Monthly")}, onClick = { /*TODO*/ })
//                                DropdownMenuItem(text = { Text(text = "Yearly")}, onClick = { /*TODO*/ })
                            }

                        }

                    }
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Date")
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Note"){
                        UnstyledTextField(value = "",
                            onValueChange = {},
                            placeholder = { Text("")},
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
                    TableRow(label ="Category"){
                        var categoriesMenuOpened by remember{
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { categoriesMenuOpened = true}) {
                            Text(text = selectedCategories)
                            DropdownMenu(expanded = categoriesMenuOpened, onDismissRequest = { categoriesMenuOpened = false}) {
                                categories.forEach{category ->
                                    DropdownMenuItem(text = { Text(category)},
                                        onClick = {
                                            selectedCategories = category
                                            categoriesMenuOpened = false
                                        }
                                    )

                                }

                            }

                        }

                    }
                }

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(16.dp),
                    shape = Shapes.large
                )
                {
                    Text(text = "Submit")
                }
            }

        }

    )
}


@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAdd(){
    EveryRupeeTheme {
        Add(navController = rememberNavController())
    }

}
