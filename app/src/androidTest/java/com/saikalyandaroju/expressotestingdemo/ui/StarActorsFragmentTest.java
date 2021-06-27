package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;
import com.saikalyandaroju.expressotestingdemo.model.DummyMovies;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class StarActorsFragmentTest {
    @Test
    public void test_isActorsListVisible() {
        //GIVEN
        ArrayList<String> expectedvalues= DummyMovies.provideMovies().get(1).getStar_actors();
        MovieFragmentFactory movieFragmentFactory=new MovieFragmentFactory();
        Bundle bundle=new Bundle();
        bundle.putStringArrayList("args_actors", expectedvalues);
        FragmentScenario<StarActorsFragment> scenario=FragmentScenario.launchInContainer(StarActorsFragment.class,bundle,movieFragmentFactory);


        //check
        onView(withId(R.id.star_actors_text)).check(matches(withText(StarActorsFragment.stringBuilderForDirectors(expectedvalues))));
    }
}