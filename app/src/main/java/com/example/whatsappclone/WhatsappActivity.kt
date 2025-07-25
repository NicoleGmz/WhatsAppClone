package com.example.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.whatsappclone.ui.WhatsappApp
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
                WhatsappApp()
            }
        }
    }
}