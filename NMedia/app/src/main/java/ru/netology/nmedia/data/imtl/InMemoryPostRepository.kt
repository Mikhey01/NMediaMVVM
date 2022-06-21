package ru.netology.nmedia.data.imtl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.Post
import ru.netology.nmedia.Service
import ru.netology.nmedia.data.PostRepository

class InMemoryPostRepository : PostRepository {

    private var post = Post(
        id = 1,
        author = "Нетология. Университет - профессий",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов" +
                " по онлайн-маркетингую Затем появились курсы по дизайну, разработке, " +
                "аналитике и управлению. Мы растем сами и помогаем расти студентам: от новичков до" +
                "уверенных профессионалов.но самое важное остается с нами: мы верим, что в каждом" +
                "уже есть сила, которая заставляет хотетьбольше, целиться выше, бежать быстрее." +
                "Наша миссия - помочь встать на путь роста и начать цепочку перемен." +
                " - http://netolo.gy/fyb",
        publisher = "18 мая в 23:47",
        likeByMe = false,
        countLikes = 999U,
        // countComment = 0U,
        countShare = 0U,
        countViews = 0U,
    )

    private val data = MutableLiveData<Post>()

    override fun get(): LiveData<Post> = data

    override fun likes() {
        post = post.copy(
            likeByMe = !post.likeByMe
        )
        data.value = post
        if (post.likeByMe) post.countLikes++ else post.countLikes--
    }

    override fun share() {
        val postShare = post.copy(
            countShare = post.countShare++
        )
        data.value = postShare

    }

}
