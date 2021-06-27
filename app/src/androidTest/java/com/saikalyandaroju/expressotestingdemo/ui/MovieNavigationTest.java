package com.saikalyandaroju.expressotestingdemo.ui;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.saikalyandaroju.expressotestingdemo.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MovieNavigationTest {

    @Test
    public void testMovieFragmentsNavigation() {
        // SETUP
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class); // it is needed becuse it is host of our fragments.

        // NAV DirectorsFragment
        onView(withId(R.id.movie_directiors)).perform(click());

        // VERIFY
        onView(withId(R.id.fragment_directors_parent))
                .check(matches(isDisplayed()));

        // NAV MovieDetailFragment
        pressBack();

        // VERIFY
        onView(withId(R.id.fragment_movie_detail_parent))
                .check(matches(isDisplayed()));

        // NAV StarActorsFragment
        onView(withId(R.id.movie_star_actors)).perform(click());

        // VERIFY
        onView(withId(R.id.fragment_star_actors_parent))
                .check(matches(isDisplayed()));

        // NAV MovieDetailFragment
        pressBack();

        // VERIFY
        onView(withId(R.id.fragment_movie_detail_parent))
                .check(matches(isDisplayed()));
    }
}
