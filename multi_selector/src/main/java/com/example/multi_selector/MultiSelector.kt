package com.example.multi_selector

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.resource.*
import com.example.resource.R

@Composable
fun MultiSelector() {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .padding(all = 20.dp), topBar = {
        Text(text = "Multi Select Box", style = MaterialTheme.typography.h4, color = Gray800)
    }, content = {
        MultiSelectView()
    })
}


@Composable
private fun MultiSelectView() {
    val config = LocalConfiguration.current

    var musicList by remember {
        mutableStateOf(
            (1..15).map {
                MusicDTO(
                    image = R.drawable.img_music,
                    title = "${it}번째 노래제목 ",
                    explain = "${it}번째 컨텐츠 ",
                    isSelected = mutableStateOf(true)
                )
            }
        )
    } // 총 15개의 dummy data를 만들어준다.

    LazyColumn(modifier = Modifier.padding(top = 48.dp)) {
        items(musicList.size) { index ->
            ConstraintLayout(modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height((config.screenWidthDp.dp - 40.dp) * 0.37f)
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, if (musicList[index].isSelected.value) Primary500 else Outline60, RoundedCornerShape(8.dp))
                .clickable {

                    /**
                    현재 렌더링 된 아이템과, 선택한 아이템의 포지션이 같을 경우에 선택상태를 뒤집는다.
                    그렇지 않으면 현재 아이템을 반환한다.
                     */

                    musicList = musicList.mapIndexed { mapIndex, musicDTO ->
                        if (index == mapIndex) {
                            musicDTO.copy(isSelected = mutableStateOf(!musicDTO.isSelected.value))
                        } else {
                            musicDTO
                        }
                    }
                },
                constraintSet = ConstraintSet {
                    val image = createRefFor("image")
                    val title = createRefFor("title")
                    val explain = createRefFor("explain")
                    val checkBox = createRefFor("checkBox")

                    constrain(image) {
                        linkTo(top = parent.top, bottom = parent.bottom, bias = 0.5f)
                        start.linkTo(parent.start, margin = 24.dp)
                    }

                    constrain(title) {
                        top.linkTo(image.top)
                        start.linkTo(image.end, margin = 20.dp)
                    }

                    constrain(explain) {
                        top.linkTo(title.bottom, margin = 6.dp)
                        start.linkTo(title.start)
                    }

                    constrain(checkBox) {
                        linkTo(top = parent.top, bottom = parent.bottom, bias = 0.5f)
                        end.linkTo(parent.end, margin = 20.dp)
                    }

                }
            ) {

                Icon(
                    modifier = Modifier
                        .layoutId("image")
                        .size(80.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = musicList[index].image),
                    tint = Color.Unspecified,
                    contentDescription = "image"
                )

                Text(
                    modifier = Modifier.layoutId("title"),
                    text = musicList[index].title,
                    style = MaterialTheme.typography.subtitle1,
                    color = Gray800
                )

                Text(
                    modifier = Modifier.layoutId("explain"),
                    text = musicList[index].explain,
                    style = MaterialTheme.typography.caption,
                    color = Gray600
                )
                Checkbox(
                    modifier = Modifier.layoutId("checkBox"),
                    checked = musicList[index].isSelected.value,
                    onCheckedChange = null
                )
            }
        }
    }
}

data class MusicDTO(
    val image: Int,
    val title: String,
    val explain: String,
    val isSelected: MutableState<Boolean>
)