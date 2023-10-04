package com.nicole.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nicole.whatsappclone.ui.ChatList
import com.nicole.whatsappclone.ui.ListItems
import com.nicole.whatsappclone.ui.TabRowBar
import com.nicole.whatsappclone.ui.WhatsappTabBar
import com.nicole.whatsappclone.ui.WhatsappTopBar
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

class WhatsappActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsappApp()
        }
    }
}

@Composable
fun WhatsappApp() {
    WhatsAppCloneTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            whatsappTabRowScreens.find { it.route == currentDestination?.route } ?: ChatsList

        Scaffold(
            topBar = {
                WhatsappTopBar()
            },
            content = { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    TabRowBar(
                        whatsappTabRowScreens,
                        onTabSelected = { newScreen ->
                            navController.navigateSingleTopTo(newScreen.route)
                        },
                        currentScreen = currentScreen
                    )
                    WhatsappNavHost(
                        navController = navController,
                        modifier = Modifier
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WhatsappAppPreview() {
    WhatsAppCloneTheme {
       WhatsappApp()
    }
}