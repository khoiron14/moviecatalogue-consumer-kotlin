package com.example.moviecatalogueconsumer.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogueconsumer.BuildConfig
import com.example.moviecatalogueconsumer.R
import com.example.moviecatalogueconsumer.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by khoiron14 on 9/7/2019.
 */
class MovieAdapter :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movies: List<Movie> = listOf()

    fun setData(items: List<Movie>) {
        movies = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_movie, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(movies[p1])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie) {
            itemView.tv_title.text = movie.title
            Glide.with(itemView)
                .load(BuildConfig.BASE_IMAGE_PATH_URL + movie.posterPath)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(itemView.img_poster)
        }
    }
}