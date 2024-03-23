package com.application.everyrupee.pages


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.application.everyrupee.components.TableRow
import com.application.everyrupee.components.UnstyledTextField
import com.application.everyrupee.models.Recurrence
import com.application.everyrupee.ui.theme.BackgroundElevated
import com.application.everyrupee.ui.theme.Divider
import com.application.everyrupee.ui.theme.EveryRupeeTheme
import com.application.everyrupee.ui.theme.Primary
import com.application.everyrupee.ui.theme.Shapes
import com.application.everyrupee.ui.theme.TopAppBarBackground
import com.application.everyrupee.ui.theme.Typography
import com.application.everyrupee.viewmodels.AddViewModel
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import java.time.LocalDate
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable

fun Add(navController: NavController, vm : AddViewModel = viewModel()){
    val state by vm.uiState.collectAsState()

    val recurrences = listOf(
        Recurrence.None,
        Recurrence.Daily,
        Recurrence.Weekly,
        Recurrence.Monthly,
        Recurrence.Yearly
    )


    val categories = listOf(
        "Groceries",
        "Bills",
        "Hobbies",
        "Take Out"
    )



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
                        UnstyledTextField(value = state.amount,
                            onValueChange = vm::setAmount,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text(text = "0")},
                            arrangement = Arrangement.End,
                            maxLines = 1,
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right
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
                        TextButton(onClick = { recurrenceMenuOpened = true}, shape = Shapes.large) {
                            Text(text = state.recurrence?.name ?: Recurrence.None.name)
                            DropdownMenu(expanded = recurrenceMenuOpened, onDismissRequest = { recurrenceMenuOpened = false}) {
                                recurrences.forEach{recurrence ->
                                    DropdownMenuItem(text = { Text(recurrence.name)},
                                        onClick = {
                                            vm.setRecurrence(recurrence)
                                            recurrenceMenuOpened = false
                                        }
                                    )

                                }


                            }

                        }

                    }
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    var datePickerShowing by remember {
                        mutableStateOf(false)
                    }
                    TableRow(label ="Date"){
                        TextButton(onClick = { datePickerShowing = true}) {
                                Text(state.date.toString())
                        }
                        if(datePickerShowing){
                            DatePickerDialog(
                                onDismissRequest = {datePickerShowing = false},
                                onDateChange = {it ->
                                               vm.setDate(it)
                                    datePickerShowing = false
                                },
                                initialDate = state.date,
                                title = { Text(text = "Select Date", style = Typography.titleMedium)}
                            )
                        }

                    }
                    Divider(modifier = Modifier.padding(start = 16.dp),thickness =1.dp, color = Divider)
                    TableRow(label ="Note"){
                        UnstyledTextField(value = state.note,
                            onValueChange = vm::setNote,
                            placeholder = { Text("Leave some notes")},
                            arrangement = Arrangement.End,
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
                        TextButton(onClick = { categoriesMenuOpened = true}, shape = Shapes.large) {
                            Text(text = state.category ?: "Select a Category First")
                            DropdownMenu(expanded = categoriesMenuOpened, onDismissRequest = { categoriesMenuOpened = false}) {
                                categories.forEach{category ->
                                    DropdownMenuItem(text = {
                                        Row (verticalAlignment = Alignment.CenterVertically){
                                            Surface(modifier = Modifier.width(10.dp), shape= CircleShape, color = Primary) {

                                            }

                                            Text(category, modifier = Modifier.padding(start = 8.dp))
                                        }

                                                            },
                                        onClick = {
                                            vm.setCategory(category)
                                            categoriesMenuOpened = false
                                        }
                                    )

                                }

                            }

                        }

                    }
                }

                Button(onClick = vm::submitExpense,
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
