package com.saikalyandaroju.expressotestingdemo.source;

import com.saikalyandaroju.expressotestingdemo.model.Movie;

import java.util.LinkedHashMap;

import static com.saikalyandaroju.expressotestingdemo.model.DummyMovies.provideMovies;

public class MoviesRemoteDataSource  {

    public static   LinkedHashMap<Integer, Movie> MOVIES_REMOTE_DATA = new LinkedHashMap<Integer, Movie>(2);

    public MoviesRemoteDataSource() {
        MOVIES_REMOTE_DATA.put(provideMovies().get(0).getId(), provideMovies().get(0));
        MOVIES_REMOTE_DATA.put(provideMovies().get(1).getId(), provideMovies().get(1));

    }

   // @Override
    public static Movie getMovie(int movieId) {
        return MOVIES_REMOTE_DATA.get(movieId);
    }
}
