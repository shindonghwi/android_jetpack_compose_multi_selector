package com.example.medium_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.medium_jetpackcompose.ui.theme.Medium_JetpackComposeTheme
import com.example.nestedscroll_tablayout.*
import com.example.nestedscroll_tablayout.model.TabItemMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Medium_JetpackComposeTheme {


                val tabItemList = listOf(
                    TabItemMenu("정보", remember { mutableStateOf(true) }) { InformationView() },
                    TabItemMenu("노래목록", remember { mutableStateOf(true) }) { MusicListView() },
                    TabItemMenu("팔로워", remember { mutableStateOf(true) }) { FollowerView() },
                    TabItemMenu("리뷰", remember { mutableStateOf(true) }) { ReviewView() },
                )

                NestedScrollTabLayout(
                    tabItemList = tabItemList,
                    TopBarContent = { TopBarContent() },
                )


            }
        }
    }


}
