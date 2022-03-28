package com.example.lessonrecylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lessonrecylerview.adapters.NewsAdapter
import com.example.lessonrecylerview.databinding.ActivityMainBinding
import com.example.lessonrecylerview.models.News

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        newsAdapter = NewsAdapter(list)
//        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)
        val gridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, true)
//        val staggeredGridLayoutManager =
//            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rv.adapter = newsAdapter
        binding.rv.layoutManager = gridLayoutManager
    }

    private fun setData() {
        list = ArrayList()
        for (i in 0..10) {
            list.add(
                News(
                    "https://cdn.pixabay.com/photo/2017/09/25/13/12/cocker-spaniel-2785074__480.jpg",
                    "bithovin",
                    "kuchulani bri (it)"
                )
            )
            list.add(
                News(
                    "https://i.guim.co.uk/img/media/fe1e34da640c5c56ed16f76ce6f994fa9343d09d/0_174_3408_2046/master/3408.jpg",
                    "bithovin",
                    "kuchulani bri (it)"
                )
            )
            list.add(
                News(
                    "https://kb.rspca.org.au/wp-content/uploads/2018/11/golder-retriever-puppy.jpeg",
                    "bithovin",
                    "loremWhat kinds of royalty-free files are available on iStock?"
                )
            )
        }
    }
}