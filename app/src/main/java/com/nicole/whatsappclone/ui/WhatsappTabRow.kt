package com.nicole.whatsappclone.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import com.nicole.whatsappclone.WhatsappDestination
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme
import com.nicole.whatsappclone.whatsappTabRowScreens

@Composable
fun WhatsappTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.primary)
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/}
            ){
                Icon(Icons.Outlined.PhotoCamera, contentDescription = null)
            }
            IconButton(
                onClick = { /*TODO*/}
            ){
                Icon(Icons.Outlined.Search, contentDescription = null)
            }
            IconButton(
                onClick = { /*TODO*/}
            ){
                Icon(Icons.Outlined.MoreVert, contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    )
}

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
}

@Composable
fun TabRowBar(
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
    }/*
    when(state){
        0 -> ChatsListScreen()
        1 -> NotWorkingScreen()
        2 -> NotWorkingScreen()
        /*1 -> StatesScreen()
        2 -> CallsScreen()*/
    }*/
}
