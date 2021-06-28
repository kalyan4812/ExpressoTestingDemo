package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.bumptech.glide.request.RequestOptions;
import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;
import com.saikalyandaroju.expressotestingdemo.model.Movie;
import com.saikalyandaroju.expressotestingdemo.source.MoviesDataSource;
import com.saikalyandaroju.expressotestingdemo.source.MoviesRemoteDataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@RunWith(AndroidJUnit4ClassRunner.class)
public class MovieDetailFragmentTest {
    @Test
    public void test_isMovieDataVisible() {
        // SETUP
        int movieId = 0;

        Movie m1 = new Movie(
                0,
                "Avengers: Infinity War",
                "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/Infinity_War-infinity_war.png",
                "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                        "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                        "the universe.",
                new ArrayList<String>(asList("alex", "brian", "charles")),
                new ArrayList<String>(asList("alex", "brian", "charles"))
        );
        String title=m1.getTitle();
        String description=m1.getDescription();

        // NOTE:
        // Also could have built a "FakeMoviesRemoteDataSource" (AKA a STUB).
        // I don't think it matters in this case.
        // Probably for a larger repository and more complex app I would stub the repository. Then
        // you could test errors, various success cases, etc...

       MoviesDataSource moviesDataSource=mock(MoviesRemoteDataSource.class);
       when(moviesDataSource.getMovie(movieId)).thenReturn(m1);


        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);
        MovieFragmentFactory fragmentFactory =new  MovieFragmentFactory(requestOptions, moviesDataSource);
        Bundle bundle = new Bundle();
        bundle.putInt("movie_id", movieId);
        FragmentScenario<MovieDetailFragment> scenario =FragmentScenario.launchInContainer(MovieDetailFragment.class,bundle,fragmentFactory);

        // VERIFY

        onView(withId(R.id.movie_title)).check(matches(withText(title)));

        onView(withId(R.id.movie_description)).check(matches(withText(description)));

    }
}