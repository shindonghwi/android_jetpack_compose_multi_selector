package com.example.medium_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.medium_jetpackcompose.ui.theme.Medium_JetpackComposeTheme
import com.example.multi_selector.MultiSelector

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Medium_JetpackComposeTheme {
                MultiSelector()
            }
        }
    }
}
