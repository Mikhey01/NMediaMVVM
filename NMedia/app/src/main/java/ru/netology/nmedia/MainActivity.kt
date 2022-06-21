package ru.netology.nmedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.viewModel.PostViewModel
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: PostViewModel by viewModels()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        avatar.setImageResource(R.drawable.ic_launcher_foreground)


        viewModel.data.observe(this) { post ->
            with(binding) {

                authorName.text = post.author
                date.text = post.publisher
                textPost.text = post.content
                quantityFavorit.text = Service.likesCounters(post.countLikes)
                quantity_share.text = Service.likesCounters(post.countShare)
                number_views.text = Service.likesCounters(post.countViews)
                likes.setImageResource(
                    if (post.likeByMe) R.drawable.outline_favorite_border_24
                    else R.drawable.ic_favorite_24dp
                )
            }
        }

        binding.likes.setOnClickListener {
            viewModel.like()
        }

        binding.share.setOnClickListener {
            viewModel.share()

        }

    }

}








