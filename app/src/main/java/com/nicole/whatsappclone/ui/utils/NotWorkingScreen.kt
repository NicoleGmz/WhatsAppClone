package com.nicole.whatsappclone.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicole.whatsappclone.R
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

@Composable
fun NotWorkingScreen() {
    Surface(modifier = Modifier.padding(16.dp), shape = RectangleShape) {
        Column {
            Image(
                painter = painterResource( R.drawable.working_image),
                contentDescription = null,
            )
            Text(
                text = "Page under construction",
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotWorkingScreenPreview() {
    WhatsAppCloneTheme {
        NotWorkingScreen()
    }
}