package com.nicole.whatsappclone.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

data class Users(val name: String, var image: String?, val message: String)

@Composable
fun ChatListItem(user: Users){
    Row(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash),
            contentDescription = "User/Group profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .border(
                    BorderStroke(2.dp, color = MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(1.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column (verticalArrangement = Arrangement.Center){
            Text(
                user.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                user.message,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun ChatList(data: List<Users>){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
            items(data){
                item -> ChatListItem(item)
            }

    }
}

@Composable
fun TabRowBar(){
    var state by remember { mutableStateOf(0) }
    val titles = listOf("Chats", "States", "Calls")
    TabRow(selectedTabIndex = state){
        titles.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = state == index,
                onClick = { state = index }
            )
        }
    }
}

@Composable
fun TopBarConf() {
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
fun ChatsListScreen(){
    val context = LocalContext.current
    Scaffold (
        topBar = {
            TopBarConf()
        },
        content = { innerPadding ->
            Column (modifier = Modifier.padding(innerPadding)){
                TabRowBar()
                ChatList(ListItems.chatsGroupsData)

            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "In construction", Toast.LENGTH_SHORT).show()
                },
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ){
                Icon(Icons.Outlined.Chat, contentDescription = null)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun previewTopAppBar(){
    WhatsAppCloneTheme {
        TopBarConf()
    }
}

@Preview(showBackground = true)
@Composable
fun previewTabRowBar(){
    WhatsAppCloneTheme {
        TabRowBar()
    }
}

@Preview (showBackground = true)
@Composable
fun ChatListItemPreview(){
    WhatsAppCloneTheme {
        val user = Users("nicole", "", "hola q tal?")
        ChatListItem(user)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPreview(){
    WhatsAppCloneTheme {
        ChatList(ListItems.chatsGroupsData)
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview(){
    WhatsAppCloneTheme {
        ChatsListScreen()
    }
}
