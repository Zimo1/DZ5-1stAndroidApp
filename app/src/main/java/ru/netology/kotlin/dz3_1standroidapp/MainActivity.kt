package ru.netology.kotlin.dz3_1standroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.netology.kotlin.dz3_1standroidapp.adapter.PostAdapter
import ru.netology.kotlin.dz3_1standroidapp.dto.Post
import ru.netology.kotlin.dz3_1standroidapp.dto.PostType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meetup = Post(
                4, "Netology", "«Цифровой прорыв» — всероссийский конкурс" +
                 " для IT-специалистов, дизайнеров и управленцев в сфере цифровой экономики. " +
                 "Участие бесплатное! Казань, 27-29 сентября 2019 года.", "15.08.2019",
                true, false, true,
                1, 5,3,
                 PostType.EVENT,
                "Казань",
                55.798818 to 49.110315)

        var list = mutableListOf(
            Post(
                8, "Netology", "First post in our network!", "20.08.2019",
                false, true, true,
                0, 8, 2,
                 PostType.EVENT,
                "Ижевск",
                56.852562 to 53.208176),
            Post(
                7, "Netology", "First post in our network!", "19.08.2019",
                true, false, true,
                2, 13, 1,
                 PostType.POST),
            Post(6, "Netology", "Kotlin MeetUp!", "18.08.2019",
                 likedByMe = false, postType = PostType.REPLY, source = meetup),
            Post(5, "Netology", "Kotlin MeetUp!", "17.08.2019",
                 likedByMe = false, postType = PostType.REPOST, source = meetup),
            meetup,
            Post(3, "Netology", "Реклама. Курсы по Котлину в Нетологии!",
                "16.08.2019", true, false, true,
                5, 4, 1,
                 PostType.ADVERT,
                 reference = "https://geekbrains.ru/professions/android_developer"),
            Post(2, "Netology", "Посмотрите это видео о кошках!",
                "15.08.2019", likedByMe = true, postType = PostType.VIDEO,
                 reference = "https://www.youtube.com/watch?time_continue=1&v=BhJO2Urrq94"),
            Post(1, "Netology", "First it in our network!", "14.08.2019")
        )

        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter(list)
        }
    }
}

// Загрузка на гитхаб через командную строку в Терминале: git push origin master