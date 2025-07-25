package com.example.whatsappclone.presentation.view.chatList.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whatsappclone.R
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme

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
            painter = painterResource(id = R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash),
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

@Preview(showBackground = true)
@Composable
fun ChatListItemPreview(){
    WhatsAppCloneTheme {
        val user = Users("nicole", "", "hola q tal?")
        ChatListItem(user)
    }
}