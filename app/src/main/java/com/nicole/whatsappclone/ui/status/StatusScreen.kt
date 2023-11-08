package com.nicole.whatsappclone.ui.status

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddIcCall
import androidx.compose.material.icons.rounded.Camera
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import com.nicole.whatsappclone.ui.status.StatusList.statusData
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme
import com.nicole.whatsappclone.ui.utils.CircularImageWithCircularIcon
import com.nicole.whatsappclone.ui.utils.CircularImageWithDashedBorder

data class Status(val name: String, var image: String?, val nStates: Int, val hourPublished: String = "")

@Composable
fun StatusRow(status:Status){
    Row(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularImageWithDashedBorder(status.nStates)
        Spacer( modifier = Modifier.width(8.dp))
        Column (verticalArrangement = Arrangement.Center){
            Text(
                status.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                status.hourPublished,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )

        }

    }
}

@Composable
fun MyStatusRow(status: Status){
    Row(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){

        CircularImageWithCircularIcon(R.drawable.leio_mclaren_l2dtmhqzx4q_unsplash)

        Spacer(modifier = Modifier.width(8.dp))

        Column (verticalArrangement = Arrangement.Center){
            Text(
                "My State",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                "Tap to add status update",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun StatusHeader(status: Status){
    Column(modifier = Modifier.fillMaxWidth()) {
        MyStatusRow(status)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Recent updates", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.width(8.dp))
    }
}


@Composable
fun StatusList(data: List<Status>, paddingValues: PaddingValues){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp), contentPadding = paddingValues
    ) {
        item {
            val user = Status("Nicole", "", 1, "Tap to add status update")
            StatusHeader(user)
        }
        items(data){
                item -> StatusRow(item)
        }

    }
}

@Composable
fun StatusScreen(){
    val context = LocalContext.current
    Scaffold (
        content = { innerPadding ->
            StatusList(statusData, innerPadding)
        },
        floatingActionButton = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                SmallFloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "In construction", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(16.dp),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.secondary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    )
                ){
                    Icon(Icons.Rounded.Edit, contentDescription = null)
                }

                Spacer(modifier = Modifier.width(16.dp))

                FloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "In construction", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(16.dp),
                    containerColor = Color(0xFF25D366),
                    contentColor = MaterialTheme.colorScheme.secondary,
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp
                    )
                ){
                    Icon(Icons.Rounded.PhotoCamera, contentDescription = null)
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyStatusRowPreview(){
    WhatsAppCloneTheme {
        val user = Status("Nicole", "", 1, "Tap to add status update")
        MyStatusRow(user)
    }
}


@Preview(showBackground = true)
@Composable
fun StateItemPreview(){
    WhatsAppCloneTheme {
        val user = Status("Nicole", "", 3, "10:30")
        StatusRow(user)
    }
}

@Preview(showBackground = true)
@Composable
fun StatesListPreview(){
    WhatsAppCloneTheme {
        StatusList(statusData, paddingValues = PaddingValues(horizontal = 4.dp, vertical = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun StatusHeader(){
    WhatsAppCloneTheme {
        val user = Status("Nicole", "", 1, "Tap to add status update")
        StatusHeader(user)
    }
}

@Preview(showBackground = true)
@Composable
fun StatusScreenPreview(){
    WhatsAppCloneTheme {
        StatusScreen()
    }
}
