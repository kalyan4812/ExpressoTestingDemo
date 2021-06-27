package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;
import com.saikalyandaroju.expressotestingdemo.model.DummyMovies;
import com.saikalyandaroju.expressotestingdemo.model.Movie;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class MovieDetailFragmentTest {

    @Test
    public void test_isMovieDataVisible() {

        // SETUP
        Movie movie = DummyMovies.provideMovies().get(1);
        MovieFragmentFactory fragmentFactory = new MovieFragmentFactory();
        Bundle bundle = new Bundle();
        bundle.putInt("movie_id", movie.getId());
        FragmentScenario<MovieDetailFragment> scenario=FragmentScenario.launchInContainer(MovieDetailFragment.class,bundle,fragmentFactory);



        // VERIFY

        onView(withId(R.id.movie_title)).check(matches(withText(movie.getTitle())));

        onView(withId(R.id.movie_description)).check(matches(withText(movie.getDescription())));
    }
}