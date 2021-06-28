package com.saikalyandaroju.expressotestingdemo.source;

import com.saikalyandaroju.expressotestingdemo.model.DummyMovies;
import com.saikalyandaroju.expressotestingdemo.model.Movie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.saikalyandaroju.expressotestingdemo.model.DummyMovies.provideMovies;

public class MoviesRemoteDataSource implements MoviesDataSource  {

    public    LinkedHashMap<Integer, Movie> MOVIES_REMOTE_DATA = new LinkedHashMap<Integer, Movie>(DummyMovies.provideMovies().size());

    public MoviesRemoteDataSource() {
        for(Movie movie:DummyMovies.provideMovies()){
            MOVIES_REMOTE_DATA.put(movie.getId(), movie);
        }



    }

   // @Override
    public  Movie getMovie(int movieId) {
        return MOVIES_REMOTE_DATA.get(movieId);
    }

    @Override
    public List<Movie> getMovies() {
        return new ArrayList<>(MOVIES_REMOTE_DATA.values());
    }
}
