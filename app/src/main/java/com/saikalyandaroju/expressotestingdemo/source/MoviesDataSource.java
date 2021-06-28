package com.saikalyandaroju.expressotestingdemo.source;

import com.saikalyandaroju.expressotestingdemo.model.Movie;

import java.util.List;

public interface MoviesDataSource {

   Movie getMovie(int movieId);

   List<Movie> getMovies();
}
