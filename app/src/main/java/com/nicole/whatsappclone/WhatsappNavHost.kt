package com.nicole.whatsappclone

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.nicole.whatsappclone.ui.calls.CallsScreen
import com.nicole.whatsappclone.ui.chatslist.ChatsListScreen
import com.nicole.whatsappclone.ui.status.StatusScreen
import com.nicole.whatsappclone.ui.utils.NotWorkingScreen

@Composable
fun WhatsappNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = ChatsList.route,
        modifier = modifier
    ){
        composable(route = ChatsList.route){
            ChatsListScreen()
        }
        composable(route = Status.route){
            //NotWorkingScreen()
            StatusScreen()
        }
        composable( route = Calls.route){
            //NotWorkingScreen()
            CallsScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route){
        launchSingleTop = true
    }