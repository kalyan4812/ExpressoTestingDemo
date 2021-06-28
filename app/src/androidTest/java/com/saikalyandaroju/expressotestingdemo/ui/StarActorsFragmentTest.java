package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.factory.MovieFragmentFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class StarActorsFragmentTest {
    @Test
    public  void test_isStarActorsListVisible() {

        // GIVEN
        ArrayList<String> actors = new ArrayList<>();
        actors.add("Dwayne Johnson");
        actors.add("Seann William Scott");
        actors.add("Rosario Dawson");
        MovieFragmentFactory fragmentFactory = new MovieFragmentFactory(null, null);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("args_actors",actors);
        FragmentScenario<StarActorsFragment> scenario=FragmentScenario.launchInContainer(StarActorsFragment.class,bundle,fragmentFactory);


        // VERIFY

        onView(withId(R.id.star_actors_text))
                .check(matches(withText(
                        StarActorsFragment.stringBuilderForDirectors(actors)
                )));
    }
}