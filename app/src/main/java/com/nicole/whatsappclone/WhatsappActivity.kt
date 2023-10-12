package com.nicole.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nicole.whatsappclone.data.service.StorageImpl
import com.nicole.whatsappclone.data.service.StorageService
import com.nicole.whatsappclone.ui.GroupsViewModel
import com.nicole.whatsappclone.ui.WhatsappTabRow
import com.nicole.whatsappclone.ui.WhatsappTopBar
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

class WhatsappActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = GroupsViewModel(storageService = StorageImpl())
            WhatsappApp(viewModel)
        }
    }
}

@Composable
fun WhatsappApp(viewModel: GroupsViewModel) {
    viewModel.getGroup()
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
                    WhatsappTabRow(
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

/*
@Preview
@PreviewParameter
@Composable
fun WhatsappAppPreview(viewModel: GroupsViewModel) {
    WhatsAppCloneTheme {
       WhatsappApp(viewModel)
    }
}*/