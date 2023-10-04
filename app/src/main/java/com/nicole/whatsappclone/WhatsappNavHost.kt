package com.nicole.whatsappclone

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.nicole.whatsappclone.ui.CallsScreen
import com.nicole.whatsappclone.ui.ChatsListScreen
import com.nicole.whatsappclone.ui.NotWorkingScreen
import com.nicole.whatsappclone.ui.StatesScreen

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
        composable(route = States.route){
            NotWorkingScreen()
            //StatesScreen()
        }
        composable( route = Calls.route){
            NotWorkingScreen()
            //CallsScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route){
        launchSingleTop = true
    }