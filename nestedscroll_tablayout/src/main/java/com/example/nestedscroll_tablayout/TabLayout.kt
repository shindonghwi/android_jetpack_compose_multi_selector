package com.example.nestedscroll_tablayout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.nestedscroll_tablayout.model.TabItemMenu
import com.example.resource.Gray400
import com.example.resource.Gray800
import com.example.resource.Outline100
import com.example.resource.Primary500

@Composable
fun MutableTabLayout(
    tabItemList: List<TabItemMenu>,
    selectedIndex: MutableState<Int>
){
    TabRow(backgroundColor = Color.White, selectedTabIndex = selectedIndex.value, divider = {
        TabRowDefaults.Divider(
            thickness = 1.dp,
            color = Outline100
        )
    }) {
        tabItemList.forEachIndexed { index, item ->
            val selected = selectedIndex.value == index

            Tab(selected = selected, onClick = {
                selectedIndex.value = index
            }) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(Color.White)
                ) {
                    val (text, newIcon) = createRefs()

                    Text(
                        modifier = Modifier
                            .constrainAs(text) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        text = item.menu,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Center,
                        color = if (selectedIndex.value == index) Gray800 else Gray400
                    )

                    if (item.isNew.value) {
                        Canvas(modifier = Modifier
                            .constrainAs(newIcon) {
                                start.linkTo(text.end, margin = 2.dp)
                                top.linkTo(text.top, margin = 1.5.dp)
                            }
                            .size(5.dp)) {
                            val canvasWidth = size.width
                            val canvasHeight = size.height
                            drawCircle(
                                color = Primary500,
                                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                                radius = size.minDimension / 2
                            )
                        }
                    }
                }
            }
        }
    }
}