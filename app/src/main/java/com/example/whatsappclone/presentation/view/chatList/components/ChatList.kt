package com.example.whatsappclone.presentation.view.chatList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme

@Composable
fun ChatList(data: List<Users>){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(data){
                item -> ChatListItem(item)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPreview(){
    WhatsAppCloneTheme {
        ChatList(ChatListAux.chatsGroupsData)
    }
}