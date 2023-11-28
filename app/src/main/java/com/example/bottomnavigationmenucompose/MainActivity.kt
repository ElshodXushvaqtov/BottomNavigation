package com.example.bottomnavigationmenucompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationmenucompose.navigation.NavigationItem
import com.example.bottomnavigationmenucompose.ui.theme.BottomNavigationMenuComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationMenuComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MainScreen()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(NavigationItem.Home, NavigationItem.Info, NavigationItem.Settings)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                bottomNavItems.forEach {

                    NavigationBarItem(
                        selected = currentRoute == it.route,
                        onClick = {

                            if (currentRoute != it.route) {

                                navController.navigate(it.route)

                            }

                        },
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = null,
                                tint = if (currentRoute == it.route) Color.DarkGray else Color.Blue
                            )
                        })

                }

            }

        }) {

        NavigationController(navController = navController)

    }

}


@Composable
fun Greeting() {
}

@Composable
fun HomeScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(text = "Welcome to Home Screen")

    }

}

@Composable
fun InfoScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(text = "Welcome to Info Screen")

    }

}

@Composable
fun SettingsScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Text(text = "Welcome to Settings Screen")

    }

}

@Composable
fun NavigationController(navController: NavHostController) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreen()
        }

        composable(NavigationItem.Info.route) {
            InfoScreen()
        }

        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomNavigationMenuComposeTheme {
        MainScreen()
    }
}