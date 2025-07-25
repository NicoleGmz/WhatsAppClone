package com.example.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.whatsappclone.presentation.view.chatList.ChatsListScreen
import com.example.whatsappclone.ui.theme.WhatsAppCloneTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class WhatsappActivity : ComponentActivity() {

    private var keepSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply{
            setKeepOnScreenCondition{
                keepSplash
            }
        } //Use .apply if you want to do any process during the splash screen

        enableEdgeToEdge()

        runBlocking {
            delay(2000)
            keepSplash = false

        }
        setContent {
            WhatsAppCloneTheme {
                WhatsappAppScreen()
            }
        }
    }
}

@Composable
fun WhatsappAppScreen(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        ChatsListScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun WhatsappAppScreenPreview(){
    WhatsappAppScreen()
}

