package com.example.nestedscroll_tablayout


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.example.resource.Yellow500

@Composable
fun TopBarContent() {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Yellow500)
                .height(54.dp)
                .padding(horizontal = 20.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.left_arrow), contentDescription = "left_arrow")
            Icon(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.heart_off), contentDescription = "heart_off")
        }

        Image(
            painter = rememberImagePainter(
                data = "https://d2v80xjmx68n4w.cloudfront.net/gigs/G8NcM1611550140.jpg",
                builder = {
                    crossfade(true)
                    size(800)
                    scale(Scale.FILL)
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

    }
}