package com.nicole.whatsappclone.ui.states

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nicole.whatsappclone.ui.theme.WhatsAppCloneTheme

@Composable
fun StatesScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    WhatsAppCloneTheme {
        StatesScreen("Android")
    }
}