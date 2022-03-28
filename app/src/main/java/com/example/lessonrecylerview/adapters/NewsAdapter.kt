package com.example.lessonrecylerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonrecylerview.R
import com.example.lessonrecylerview.databinding.ItemNewsBinding
import com.example.lessonrecylerview.models.News
import com.squareup.picasso.Picasso

class NewsAdapter(var list: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(news: News) {
            val bind = ItemNewsBinding.bind(itemView)
            bind.name.text = news.name
            bind.description.text = news.description
            Picasso.get().load(news.imgUrl).into(bind.iv)
        }
    }
    //view yaratish
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myViewHolder = MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
        return myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}