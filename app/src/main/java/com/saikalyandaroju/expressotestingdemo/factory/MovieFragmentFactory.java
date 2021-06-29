package com.saikalyandaroju.expressotestingdemo.factory;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.bumptech.glide.request.RequestOptions;
import com.saikalyandaroju.expressotestingdemo.source.MovieListAdapter;
import com.saikalyandaroju.expressotestingdemo.source.MoviesDataSource;
import com.saikalyandaroju.expressotestingdemo.ui.DirectorsFragment;
import com.saikalyandaroju.expressotestingdemo.ui.MovieDetailFragment;
import com.saikalyandaroju.expressotestingdemo.ui.MovieListFragment;
import com.saikalyandaroju.expressotestingdemo.ui.StarActorsFragment;

public class MovieFragmentFactory extends FragmentFactory {  //goal is to provide arguments to fragment constructor.

    private final RequestOptions requestOptions;
    private final MoviesDataSource moviesRemoteDataSource;

    public MovieFragmentFactory(RequestOptions requestOptions, MoviesDataSource moviesRemoteDataSource) {
        this.requestOptions = requestOptions;
        this.moviesRemoteDataSource = moviesRemoteDataSource;
    }


    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Fragment f = null;
        Log.i("check",className);
        switch (className) {

            case "com.saikalyandaroju.expressotestingdemo.ui.MovieListFragment":
                f = new MovieListFragment(moviesRemoteDataSource);
                break;

            case "com.saikalyandaroju.expressotestingdemo.ui.DirectorsFragment":
                f = new DirectorsFragment();
                break;

            case "com.saikalyandaroju.expressotestingdemo.ui.MovieDetailFragment":

                    f = new MovieDetailFragment(requestOptions,moviesRemoteDataSource);

                break;

            case "com.saikalyandaroju.expressotestingdemo.ui.StarActorsFragment":
                f = new StarActorsFragment();
                break;

            default:
                f = super.instantiate(classLoader, className);
                break;
        }
        return f;
    }
}
