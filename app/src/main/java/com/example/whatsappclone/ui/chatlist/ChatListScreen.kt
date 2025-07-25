package com.example.whatsappclone.ui.chatlist

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.whatsappclone.ui.chatlist.components.ChatList
import com.example.whatsappclone.ui.chatlist.components.ChatListAux
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatsListScreen(modifier: Modifier = Modifier){
        ChatList(ChatListAux.chatsGroupsData)
}

@Preview
@Composable
fun ChatsListScreenPreview(){
    WhatsAppCloneTheme {
        ChatsListScreen()
    }
}