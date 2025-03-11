package com.example.whatsappclone.presentation.view.chatList

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappclone.presentation.view.chatList.components.ChatList
import com.example.whatsappclone.presentation.view.chatList.components.ChatListAux
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme

@Composable
fun ChatsListScreen(){
    val context = LocalContext.current
    Scaffold (
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                //TabRowBar()
                ChatList(ChatListAux.chatsGroupsData)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "In construction", Toast.LENGTH_SHORT).show()
                },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp
                )
            ){
                Icon(Icons.AutoMirrored.Outlined.Chat, contentDescription = null)
            }
        }
    )
}

@Preview
@Composable
fun ChatsListScreenPreview(){
    WhatsAppCloneTheme {
        ChatsListScreen()
    }
}