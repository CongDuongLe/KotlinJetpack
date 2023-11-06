package com.duonglc.figma.screens.video_detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.ui.theme.FigmaTheme
import androidx.compose.ui.unit.*
import com.duonglc.figma.R
import com.duonglc.figma.types.VideoCategory
import com.duonglc.figma.types.VideoData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoDetailScreen(modifier: Modifier = Modifier, openCategoryScreen: () -> Unit) {
    val videoData = fakerData()
    val listState = rememberLazyListState()
    val isShowFilterCategory by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
    ){


    stickyHeader {

        VideoDetail(
            videoThumb = R.drawable.video_thumbnail,
            videoTitle = "Android Jetpack Compose List and Grid",
            views = 1210,
            timeAgo = "1 day ago",
            isShowFilterCategory = isShowFilterCategory
        )

    }

    items(videoData.size) { index ->
        NextVideo(
            videoTitle = videoData[index].videoTitle,
            views = videoData[index].videoView,
            timeAgo = videoData[index].videoTimeAgo,
            modifier = Modifier.padding(
                bottom = if (index == videoData.size - 1) 4.dp else 0.dp,
            )
        )
    }}

}



fun fakerData(): List<VideoData> {
    val list = mutableListOf<VideoData>()
    for (i in 0..10) {
        list.add(
            VideoData(
                videoThumb = R.drawable.video_thumbnail,
                videoTitle = "Android Jetpack Compose List and Grid",
                videoView = 999,
                videoTimeAgo = "1 day ago"
            )
        )
    }
    return list
}


fun fakerCategory(): List<VideoCategory> {
    val list = mutableListOf<VideoCategory>()
    for (i in 0..10) {
        list.add(
            VideoCategory(
                // fake categoryId == index when loop
                categoryId = i,
                // name is random
                 categoryName = "Category $i"            )
        )
    }
    return list
}




@Composable
fun FilterCategory(
    modifier: Modifier = Modifier,
){
    val categories = fakerCategory()

    var isSelectedCategory by remember{
        mutableIntStateOf(1)
    }


    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(
            horizontal = 12.dp
        )
    ) {
        items(categories){
            category ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .background(color = if (isSelectedCategory == category.categoryId) Color(0xFF6C6C6C) else Color(0xFFECECEC))
                        .border(
                            width = 1.dp,
                            color = Color(0xFFCECECE),
                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .clickable {
                            // log
                            isSelectedCategory = category.categoryId
                        }
                ) {
                    Text(
                        text = category.categoryName,
                        style = TextStyle(
                            color = if (isSelectedCategory == category.categoryId) Color.White else Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400
                        ),
                    )

                }

        }
    }
    

}







@Composable
fun VideoActionItem(modifier: Modifier = Modifier, @DrawableRes icon: Int, name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {

        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(name, style = TextStyle(fontSize = 12.sp))
    }
}

@Composable
fun VideoAction(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        VideoActionItem(icon = R.drawable.ic_thumbup, name = "25.6K")
        VideoActionItem(icon = R.drawable.ic_thumbdown, name = "200K")
        VideoActionItem(icon = R.drawable.ic_share, name = "Share")
        VideoActionItem(icon = R.drawable.ic_download, name = "Download")
        VideoActionItem(icon = R.drawable.ic_save_to_playlist, name = "Save")

    }
}

@Composable
fun VideoDetailInfo(
    modifier: Modifier = Modifier,
    videoTitle: String,
    views: Int,
    timeAgo: String
) {
    Column(modifier = modifier.fillMaxWidth()) {

        Row(verticalAlignment = Alignment.Top) {
            Text(
                videoTitle,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1f)
            )
            Icon(
                painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Text(
                "$views views",
                style = TextStyle(
                    color = Color(0xff6C6C6C),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                timeAgo,
                style = TextStyle(
                    color = Color(0xff6C6C6C),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            )
        }
    }
}

@Composable
fun VideoDetail(
    modifier: Modifier = Modifier,
    @DrawableRes videoThumb: Int,
    videoTitle: String,
    views: Int,
    timeAgo: String,
    isShowFilterCategory: Boolean = true
) {

    Column(
        modifier = modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = videoThumb), contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(top = 12.dp)
        ) {



            if (isShowFilterCategory){
                Box(
                    modifier= Modifier.padding(
                        vertical = 12.dp
                    ).fillMaxWidth().background(color = Color.White)
                ){

                FilterCategory()
                }
            } else {
                VideoDetailInfo(
                    videoTitle = videoTitle,
                    views = views,
                    timeAgo = timeAgo,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                VideoAction()
            }


        }

    }
}

@Composable
fun NextVideoInfo(videoTitle: String, views: Int, timeAgo: String, modifier: Modifier = Modifier) {

//    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
//        val (imgAvatar, tvVideoTitle, layoutInfo, imgMore) = createRefs()
//
//        Image(
//            painter = painterResource(id = R.drawable.jetpack_compose),
//            contentDescription = null,
//            modifier = Modifier
//                .size(36.dp)
//                .clip(CircleShape)
//                .constrainAs(imgAvatar) {
//                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                }
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.ic_more),
//            contentDescription = null,
//            modifier = Modifier
//                .size(24.dp)
//                .constrainAs(imgMore) {
//                    top.linkTo(parent.top)
//                    end.linkTo(parent.end)
//                }
//        )
//
//        Text(text = videoTitle, style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
//            modifier = Modifier.constrainAs(tvVideoTitle) {
//                start.linkTo(imgAvatar.end, margin = 4.dp)
//                end.linkTo(imgMore.start, margin = 4.dp)
//                top.linkTo(parent.top)
//                width = Dimension.fillToConstraints
//            }
//        )
//
//        Row(modifier = Modifier.constrainAs(layoutInfo) {
//            top.linkTo(tvVideoTitle.bottom, margin = 4.dp)
//            start.linkTo(tvVideoTitle.start)
//        }) {
//            Text(
//                "$views views",
//                style = TextStyle(
//                    color = Color(0xff6C6C6C),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 12.sp
//                )
//            )
//            Spacer(modifier = Modifier.width(4.dp))
//            Text(
//                timeAgo,
//                style = TextStyle(
//                    color = Color(0xff6C6C6C),
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 12.sp
//                )
//            )
//        }
//    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        // Image, Detail
        Row(
            modifier = Modifier.weight(7f)
        ){
            // image
            Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
            )
            // Column with video name and detail
            Column(
                modifier = Modifier.padding(start = 4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    videoTitle,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 4.dp)
                )
                Row {
                    Text(
                        "$views views",
                        style = TextStyle(
                            color = Color(0xff6C6C6C),
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        timeAgo,
                        style = TextStyle(
                            color = Color(0xff6C6C6C),
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
        // Icon More
        IconButton(
            modifier = Modifier.weight(1f),
            onClick = {},
        ){
            Icon(
                painterResource(id = R.drawable.ic_more),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

    }


}

@Composable
fun NextVideo(videoTitle: String, views: Int, timeAgo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.thumbnail_next_video),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        )
        Spacer(modifier = Modifier.height(6.dp))
        NextVideoInfo(
            videoTitle = videoTitle,
            views = views,
            timeAgo = timeAgo,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}






//@Composable
//@Preview(name = "Next Video Info Preview", showBackground = true)
//private fun NextVideoInfoPreview() {
//    FigmaTheme {
//        NextVideoInfo(videoTitle = "Jetpack Compose Basic Layout", views = 22, timeAgo = " 2 years ago")
//    }
//}
//
//
//
//@Composable
//@Preview(name = "Video Info Item Preview", showBackground = true)
//fun VideoActionItemPreview() {
//    FigmaTheme {
//        VideoActionItem(icon = R.drawable.ic_thumbup, name = "25.6K")
//    }
//}
//
//@Composable
//@Preview(name = "Video Info Preview", showBackground = true)
//fun VideoActionPreview() {
//    FigmaTheme {
//        VideoAction()
//    }
//}
//
//@Composable
//@Preview(name = "video detail preview", showBackground = true)
//fun VideoDetailPreview() {
//    VideoDetail(
//        videoThumb = R.drawable.video_thumbnail,
//        videoTitle = "Android Jetpack Compose List and Grid",
//        views = 999,
//        timeAgo = "1 day ago"
//    )
//}
//
//@Composable
//@Preview(name = "Next video preview", showBackground = true)
//fun NextVideoPreview() {
//    NextVideo(videoTitle = "Jetpack Compose Basic Layout", views = 22, timeAgo = " 20 years ago")
//}

@Composable
@Preview(name = "Video Detail Preview", showSystemUi = true, showBackground = true)
fun VideoDetailScreenPreview() {
    FigmaTheme {
        VideoDetailScreen(){

        }
    }
}