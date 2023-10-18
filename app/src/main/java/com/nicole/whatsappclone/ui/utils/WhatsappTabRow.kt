package com.nicole.whatsappclone.ui.utils

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.nicole.whatsappclone.WhatsappDestination

@Composable
fun WhatsappTabRow(
    allScreens: List<WhatsappDestination>,
    onTabSelected: (WhatsappDestination) -> Unit,
    currentScreen: WhatsappDestination
){
    val state by remember { mutableIntStateOf(0) }
    TabRow(selectedTabIndex = state){
        allScreens.forEach { screen ->
            Tab(
                text = { Text(screen.route) },
                selected = currentScreen == screen,
                onClick = { onTabSelected(screen) }
            )
        }
    }
}

///Another implementation not used here
/*
@Composable
fun WhatsappTabBar(
    allScreens: List<WhatsappDestination>,
    onTabSelected: (WhatsappDestination) -> Unit,
    currentScreen: WhatsappDestination
){
    Surface(
        Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                WhatsappTab(
                    text = screen.route,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}

@Composable
fun WhatsappTab(text: String, onSelected: () -> Unit, selected: Boolean){
    Row(
        modifier = Modifier.padding(16.dp).height(56.dp).selectable(
            selected = selected,
            onClick = onSelected,
            role = Role.Tab,
            interactionSource = remember{ MutableInteractionSource() },
            indication = rememberRipple(
                bounded = false,
                radius = Dp.Unspecified,
                color = Color.Unspecified
            )
        )
            .clearAndSetSemantics { contentDescription = text }
    ){
        Text(text.uppercase(), color = MaterialTheme.colorScheme.primary)
    }
}*/
