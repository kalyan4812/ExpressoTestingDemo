package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().setFragmentFactory(new MovieFragmentFactory());

        init();

    }

    private void init() {
        if (getSupportFragmentManager().getFragments().size() == 0) {
            int movieId = 1;
            Bundle bundle = new Bundle();
            bundle.putInt("movie_id", movieId);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MovieDetailFragment.class, bundle)
                    .commit();
        }
    }


}