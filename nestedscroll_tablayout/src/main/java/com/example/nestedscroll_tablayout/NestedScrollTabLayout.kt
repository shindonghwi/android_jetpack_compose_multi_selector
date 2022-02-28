package com.example.nestedscroll_tablayout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.nestedscroll_tablayout.model.TabItemMenu

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NestedScrollTabLayout(
    modifier: Modifier = Modifier,
    selectedTabIndex: MutableState<Int> = mutableStateOf(0),
    tabItemList: List<TabItemMenu>,
    TopBarContent: @Composable () -> Unit
) {

    val lazyListState = rememberLazyListState()

    LazyColumn(modifier = modifier, state = lazyListState) {

        item {
            TopBarContent()
        }

        stickyHeader {
            MutableTabLayout(tabItemList = tabItemList, selectedIndex = selectedTabIndex)
        }

        item {
            tabItemList[selectedTabIndex.value].view()
        }
    }
}