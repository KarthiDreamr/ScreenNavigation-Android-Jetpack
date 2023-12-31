package com.example.exercise3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exercise3.ui.theme.Exercise3Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Exercise3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            PageBuilder(
                navController = navController,
                pageName = "First Screen"
            )
        }
        composable("second_screen") {
            PageBuilder(
                navController = navController,
                pageName = "Second Screen"
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageBuilder(
    navController: NavController,
    pageName: String
) {
    val isFirstScreen = pageName=="First Screen"
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Navigation Drawer", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "First Screen") },
                    selected = isFirstScreen,
                    onClick = {
                        navController.navigate("first_screen")
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Second Screen") },
                    selected = !isFirstScreen,
                    onClick = {
                        navController.navigate("second_screen")
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null
                                )
                            }
                            Spacer(modifier = Modifier.size(40.dp))
                            Text(
                                "Screen Navigator", modifier = Modifier.padding(
                                    8.dp
                                )
                            )
                        }
                    }
                )
            }
        ) { contentPadding ->

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(contentPadding)
                    .fillMaxSize()
            ) {
                Text(
                    pageName
                )
            }
        }
    }
}

