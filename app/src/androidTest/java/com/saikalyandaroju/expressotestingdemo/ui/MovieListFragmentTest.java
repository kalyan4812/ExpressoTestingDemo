package com.saikalyandaroju.expressotestingdemo.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.model.DummyMovies;
import com.saikalyandaroju.expressotestingdemo.model.Movie;
import com.saikalyandaroju.expressotestingdemo.util.ExpressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MovieListFragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenario = new ActivityScenarioRule<>(MainActivity.class);


    int LIST_ITEM_IN_TEST = 3;
    Movie MOVIE_IN_TEST = DummyMovies.provideMovies().get(LIST_ITEM_IN_TEST);

    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(ExpressoIdlingResource.countingIdlingResource);
    }

    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(ExpressoIdlingResource.countingIdlingResource);
    }

    @Test
    public void test_isListFragmentVisible_onAppLaunch() {

        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void test_selectListItem_isDetailFragmentVisible() {
        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view)).perform(actionOnItemAtPosition(LIST_ITEM_IN_TEST, click()));

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.getTitle())));
    }

    @Test
    public void test_backNavigation_toMovieListFragment() {
        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view))
                .perform(actionOnItemAtPosition(LIST_ITEM_IN_TEST, click()));

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.getTitle())));

        pressBack();

        // Confirm MovieListFragment in view
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }

    @Test
    public void test_navDirectorsFragment_validateDirectorsList() {

        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view))
                .perform(actionOnItemAtPosition(LIST_ITEM_IN_TEST, click()));

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.getTitle())));

        // Nav to DirectorsFragment
        onView(withId(R.id.movie_directiors)).perform(click());

        // Confirm correct directors are visible
        onView(withId(R.id.directors_text))
                .check(matches(withText(
                        DirectorsFragment.stringBuilderForDirectors(MOVIE_IN_TEST.getDirectors())
                )));
    }

    @Test
    public void test_navStarActorsFragment_validateActorsList() {
        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view))
                .perform(actionOnItemAtPosition(LIST_ITEM_IN_TEST, click()));

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.getTitle())));

        // Nav to DirectorsFragment
        onView(withId(R.id.movie_star_actors)).perform(click());

        // Confirm correct directors are visible
        onView(withId(R.id.star_actors_text))
                .check(matches(withText(
                        StarActorsFragment.stringBuilderForActors(MOVIE_IN_TEST.getStar_actors())
                )));
    }


}
