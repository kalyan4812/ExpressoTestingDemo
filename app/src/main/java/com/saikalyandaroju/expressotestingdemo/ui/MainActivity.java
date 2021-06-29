package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.request.RequestOptions;
import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;
import com.saikalyandaroju.expressotestingdemo.source.MoviesDataSource;
import com.saikalyandaroju.expressotestingdemo.source.MoviesRemoteDataSource;

public class MainActivity extends AppCompatActivity {
    // dependencies (typically would be injected with dagger)
    MoviesDataSource moviesRemoteDataSource;
    RequestOptions requestOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initDependencies();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

    }

    private void initDependencies() {
        // glide
        if (requestOptions == null) {
            requestOptions = RequestOptions
                    .placeholderOf(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);
        }
        // Data Source
        if (moviesRemoteDataSource == null) {
            moviesRemoteDataSource = new MoviesRemoteDataSource();
        }

        getSupportFragmentManager().setFragmentFactory(new MovieFragmentFactory(requestOptions, moviesRemoteDataSource));

    }

    private void init() {
        if (getSupportFragmentManager().getFragments().size() == 0) {
            int movieId = 1;
            Bundle bundle = new Bundle();
            bundle.putInt("movie_id", movieId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,
                            MovieListFragment.class, bundle)
                    .commit();
        }
    }


}