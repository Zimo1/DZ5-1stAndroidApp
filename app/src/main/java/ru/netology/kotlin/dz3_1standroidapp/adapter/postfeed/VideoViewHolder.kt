package ru.netology.kotlin.dz3_1standroidapp.adapter.postfeed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.netology.kotlin.dz3_1standroidapp.adapter.PostAdapter
import ru.netology.kotlin.dz3_1standroidapp.dto.Post
//Отличие вьюхолдеров постов разных типов задается этой строчкой (ниже).
//В каждом классе-вьюхолдере она ссылается на свою собственную форму вывода, поэтому
//несмотря на то, что в разных формах есть одинаковые элементы с одинаковыми именами,
//неопределенности не возникает, т.к. программа видит к какому конкретному элементу нужно
//обратиться:
import kotlinx.android.synthetic.main.post_feed_video_card.view.*

class VideoViewHolder(adapter: PostAdapter, view: View)
    : BaseViewHolder(adapter, view) {
    init { //При инициализации вьюхолдера назначить универсальный лиснер кнопкам на форме
        with (itemView) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                likeBtn.setOnClickListener(btnListener(adapter.list[adapterPosition], likeQtyTv))
                commentBtn.setOnClickListener(btnListener(adapter.list[adapterPosition], commentQtyTv))
                shareBtn.setOnClickListener(btnListener(adapter.list[adapterPosition], shareQtyTv))
            }
        }
    }

    //Абстрактный метод bind сделать реализованным, используя готовый общий для всех метод
    // родительского класса, указывая в качестве параметров элементы текущей конкретной формы.
    override fun bind(post: Post) {
        with (itemView) {
            super.bind(
                post,
                createdTv,
                authorTv,
                contentTv,
                likeQtyTv,
                commentQtyTv,
                shareQtyTv,
                likeBtn,
                commentBtn,
                shareBtn
            )
        }
    }
}