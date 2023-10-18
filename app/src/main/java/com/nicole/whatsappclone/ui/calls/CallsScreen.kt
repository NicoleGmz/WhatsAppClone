package com.nicole.whatsappclone.ui.calls

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddIcCall
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.CallMade
import androidx.compose.material.icons.rounded.CallReceived
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

data class Call(val name: String, val image: String?, val date: String, val state: Int, val vCall: Boolean)
@Composable
fun CallListItem(call: Call){
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
                call.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row(horizontalArrangement = Arrangement.Center){
                when(call.state){
                    1 -> Icon(Icons.Rounded.CallMade, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Green)
                    2 -> Icon(Icons.Rounded.CallMade, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Red)
                    3 -> Icon(Icons.Rounded.CallReceived, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Green)
                    else -> {
                        Icon(Icons.Rounded.CallReceived, contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Red)
                    }
                }

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    call.date,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        val icon = if(call.vCall) Icons.Rounded.Videocam else Icons.Rounded.Call
        Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary, modifier = Modifier.padding(horizontal = 8.dp).size(24.dp))
    }
}

@Composable
fun CallListHeader(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)){
            IconButton(
                onClick = {  },
                modifier = Modifier.clip(CircleShape).size(48.dp).background(MaterialTheme.colorScheme.primaryContainer)
            ){
                Icon(Icons.Rounded.Link, null)
            }
            Column(modifier = Modifier.padding(16.dp)){
                Text("Create a call link", style = MaterialTheme.typography.titleSmall)
                Text("Share a link for your call", style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text("Recent", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.width(8.dp))
    }
}

@Composable
fun CallsList(data: List<Call>, paddingValues: PaddingValues){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp), contentPadding = paddingValues
    ) {
        item {
            CallListHeader()
        }
        items(data){
                item -> CallListItem(item)
        }

    }
}

@Composable
fun CallsScreen(){
    val context = LocalContext.current
    Scaffold (
        content = { innerPadding ->
            CallsList(CallsList.callsData, innerPadding)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "In construction", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(16.dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ){
                Icon(Icons.Rounded.AddIcCall, contentDescription = null)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CallScreenItemPreview(){
    WhatsAppCloneTheme {
       val call = Call("nicole", "","21 diciembre 2023", 1, false)
       CallListItem(call)
    }
}

@Preview(showBackground = true)
@Composable
fun CallListPreview(){
    WhatsAppCloneTheme {
        CallsList(CallsList.callsData, paddingValues = PaddingValues(horizontal = 4.dp, vertical = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CallListHeaderPreview(){
    WhatsAppCloneTheme {
        CallListHeader()
    }
}
@Preview(showBackground = true)
@Composable
fun CallListScreenPreview(){
    WhatsAppCloneTheme {
        CallsScreen()
    }
}