package com.gamecrawl.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gamecrawl.movieapp.model.Movie
import com.gamecrawl.movieapp.model.getMovies
import com.gamecrawl.movieapp.navigation.MovieScreens
import com.gamecrawl.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) { Text("Movies") }
        },
    ) {
        MainContent(navController)
    }
}


@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(movieList) { movie ->
                MovieRow(movie = movie) {
                    Log.d("tag", "Clicked $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/${movie.id}")
                }
            }
        }
    }
}