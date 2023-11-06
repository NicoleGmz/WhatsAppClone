package com.nicole.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nicole.whatsappclone.data.service.StorageImpl
import com.nicole.whatsappclone.ui.GroupsViewModel
import com.nicole.whatsappclone.ui.utils.WhatsappTabRow
import com.nicole.whatsappclone.ui.utils.WhatsappTopBar
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WhatsappApp(viewModel: GroupsViewModel) {
    viewModel.getUserInfo()
    WhatsAppCloneTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            whatsappTabRowScreens.find { it.route == currentDestination?.route } ?: ChatsList

        val pagerState = rememberPagerState {
            whatsappTabRowScreens.size
        }

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
                        currentScreen = currentScreen,
                        pagerState = pagerState
                    )
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxWidth().weight(1f)){
                            WhatsappNavHost(
                                navController = navController,
                                modifier = Modifier
                            )
                    }
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