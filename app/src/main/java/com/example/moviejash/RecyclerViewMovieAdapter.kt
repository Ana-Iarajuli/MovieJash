package com.example.moviejash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewMovieAdapter(private val list: List<Movie>) : RecyclerView.Adapter<RecyclerViewMovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val MoviePoster: ImageView
        val MovieName: TextView
        val Runtime: TextView
        val Genre: TextView
        val DirectorName: TextView
        val ActorName: TextView
        val IMDB_Rating: TextView

        init {
            MoviePoster = itemView.findViewById(R.id.moviePoster)
            MovieName = itemView.findViewById(R.id.movieName)
            Runtime = itemView.findViewById(R.id.runtime)
            Genre = itemView.findViewById(R.id.genre)
            DirectorName = itemView.findViewById(R.id.directorName)
            ActorName = itemView.findViewById(R.id.actorName)
            IMDB_Rating = itemView.findViewById(R.id.imdbRating)
        }

        fun SetData(movie: Movie) {

            Glide.with(itemView).load(movie.image).into(MoviePoster)
            MovieName.text = movie.movieName
            Runtime.text = movie.time
            Genre.text = movie.genre
            DirectorName.text = movie.DirectorName
            ActorName.text = movie.StarName
            IMDB_Rating.text = movie.rating

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = list[position]
        holder.SetData(movie)

    }

    override fun getItemCount() = list.size
    }

