package com.example.nestedscroll_tablayout.model

import androidx.annotation.Keep
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Keep
data class TabItemMenu(
    val menu: String,
    val isNew: MutableState<Boolean>,
    val view: @Composable () -> Unit
)