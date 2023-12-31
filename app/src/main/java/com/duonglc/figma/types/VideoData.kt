package com.duonglc.figma.types


data class VideoData(
    val videoTitle: String,
    val videoView: Int,
    val videoTimeAgo: String,
    val videoThumb: Int,
)

data class VideoCategory(
    val categoryId: Int,
    val categoryName: String
)