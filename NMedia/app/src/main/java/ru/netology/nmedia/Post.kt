package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val publisher: String,
    var countLikes: UInt,
   // var countComment: UInt,
    var countShare: UInt,
    var countViews: UInt,
    var likeByMe: Boolean = false
)

{

}