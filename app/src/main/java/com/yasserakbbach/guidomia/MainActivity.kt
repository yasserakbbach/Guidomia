package com.yasserakbbach.guidomia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.yasserakbbach.guidomia.presentation.HomeScreen
import com.yasserakbbach.guidomia.ui.theme.GuidomiaTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuidomiaTheme {
                HomeScreen()
            }
        }
    }
}