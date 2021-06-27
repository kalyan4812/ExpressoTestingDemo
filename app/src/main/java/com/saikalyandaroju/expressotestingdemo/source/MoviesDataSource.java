package com.saikalyandaroju.expressotestingdemo.source;

import com.saikalyandaroju.expressotestingdemo.model.Movie;

public interface MoviesDataSource {

   Movie getMovie(int movieId);
}
