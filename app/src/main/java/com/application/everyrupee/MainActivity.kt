package com.application.everyrupee

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.application.everyrupee.pages.Expenses
import com.application.everyrupee.pages.Settings
import com.application.everyrupee.ui.theme.EveryRupeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EveryRupeeTheme {
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                Scaffold (
                    bottomBar = {
                         NavigationBar {
                             NavigationBarItem(
                                 selected = backStackEntry.value?.destination?.route == "expenses",
                                 onClick = { navController.navigate("expenses") },
                                 icon = {
                                        Icon(
                                            painterResource(id = R.drawable.currency_rupee),
                                            contentDescription = "Upload"
                                        )
                                 },
                                 label = {
                                     Text("Expenses")
                                 }
                                 )


                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "report",
                                onClick = { navController.navigate("report") },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.barchart),
                                        contentDescription = "Report"
                                    )
                                },
                                label = {
                                    Text("Report")
                                }
                            )
                             NavigationBarItem(
                                 selected = backStackEntry.value?.destination?.route == "add",
                                 onClick = { navController.navigate("add") },
                                 icon = {
                                     Icon(
                                         painterResource(id = R.drawable.add),
                                         contentDescription = "Add"
                                     )
                                 },
                                 label = {
                                     Text("Add")
                                 }
                             )
                             NavigationBarItem(
                                 selected = backStackEntry.value?.destination?.route == "settings",
                                 onClick = { navController.navigate("settings") },
                                 icon = {
                                     Icon(
                                         painterResource(id = R.drawable.settings_outline),
                                         contentDescription = "Settings"
                                     )
                                 },
                                 label = {
                                     Text("Settings")
                                 }
                             )
                        }
                    },
                    content = { innerPadding ->
                        NavHost(navController = navController, startDestination = "expenses"){
                            composable("expenses") {
                                Surface(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ) {
                                    Expenses(navController,"Expenses")
                                }
                            }
                                composable("report"){
                                    Surface (
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding),
                                    ){
                                        Greeting(name = "Report")
                                    }

                            }
                            composable("add"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ){
                                    Greeting(name = "Add")
                                }

                            }
                            composable("settings"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ){
                                    Settings(navController)
                                }

                            }
                            composable("settings/categories"){
                                Surface (
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(innerPadding),
                                ){
                                    Greeting(name = "Categories")
                                }

                            }


                    }

                }
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    EveryRupeeTheme {

        Greeting("Android")
        }

}}