package com.example.moviejash.fragments_nav_bar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviejash.Movie
import com.example.moviejash.R
import com.example.moviejash.RecyclerViewMovieAdapter

class MoviesFragment: Fragment (R.layout.fragment_movies) {

    private lateinit var recyclerViewMovieAdapter: RecyclerViewMovieAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewMovieAdapter = RecyclerViewMovieAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = recyclerViewMovieAdapter


    }

    private fun getData(): List<Movie> {

        val MovieList = ArrayList<Movie>()

        MovieList.add(
            Movie(
                1,
                "https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_FMjpg_UX1000_.jpg",
                "Dune",
                "2h 35m",
                "Adventure | Sci-Fi",
                "Denis Villeneuve",
                "Timothee Chalamet,Rebecca Ferguson",
                "8,1/10"
            )
        )
        MovieList.add(
            Movie(
                2,
                "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQk9OCsH_5eiPw9P4ua7hwmqO9XxRKkI-C_1N1_MDHuNjkzWV74",
                "house Of Gucci",
                "2h 38m",
                "Crime | Drama",
                "Ridley Scott",
                "lady Gaga,Adam Driver,Al Pacino",
                "6,9/10"
            )
        )
        MovieList.add(
            Movie(
                3,
                "https://m.media-amazon.com/images/M/MV5BYWQ2NzQ1NjktMzNkNS00MGY1LTgwMmMtYTllYTI5YzNmMmE0XkEyXkFqcGdeQXVyMjM4NTM5NDY@._V1_.jpg",
                "No Time To Die",
                "2h 43m",
                "Action | Thriller",
                "Cary Joji Fukunaga",
                "Daniel Craig, Ana De Armas",
                "7,4/10"
            )
        )
        MovieList.add(
            Movie(
                4,
                "https://upload.wikimedia.org/wikipedia/en/0/00/Spider-Man_No_Way_Home_poster.jpg",
                "Spider-Man: No way Home",
                "2h 28m",
                "Fantasy | Action",
                "Jon Watts",
                "Tom Holland,Zendaya,Benedict Cumberbatch",
                "8,7/10"
            )
        )
        MovieList.add(
            Movie(
                5,
                "https://m.media-amazon.com/images/M/MV5BMDEzZDY2ZDktNTlmOS00NThjLThkNTEtMjE5MzI5NWEwZmRjXkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg",
                "The King's Man",
                "2h 11m",
                "Thriller | Action",
                "Matthew Vaughn",
                "Ralph Fiennes,Gemma Arterton,Rhys Ifans",
                "6,8/10"
            )
        )

        return MovieList

    }

}