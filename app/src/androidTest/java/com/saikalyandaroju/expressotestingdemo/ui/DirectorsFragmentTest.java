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
public class DirectorsFragmentTest {
    @Test
    public  void test_isDirectorsListVisible() {

        // GIVEN
        ArrayList<String> directors = new ArrayList<String>(asList("R.J. Stewart", "James Vanderbilt"));
        MovieFragmentFactory fragmentFactory = new MovieFragmentFactory(null, null);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("args_directors", directors);
        FragmentScenario<DirectorsFragment> scenario=FragmentScenario.launchInContainer(DirectorsFragment.class,bundle,fragmentFactory);


        // VERIFY

        onView(withId(R.id.directors_text))
                .check(matches(withText(
                        DirectorsFragment.stringBuilderForDirectors(directors)
                )));
    }
}