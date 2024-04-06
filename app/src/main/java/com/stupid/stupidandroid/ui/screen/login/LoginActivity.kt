package com.stupid.stupidandroid.ui.screen.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stupid.stupidandroid.MainActivity
import com.stupid.stupidandroid.ui.theme.StupidAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StupidAndroidTheme {
                LoginScreen(
                    onLoginSuccess = {
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    },
                )
            }
        }
    }
}
