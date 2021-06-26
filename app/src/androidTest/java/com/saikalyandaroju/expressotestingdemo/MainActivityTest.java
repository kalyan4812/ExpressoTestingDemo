package com.saikalyandaroju.expressotestingdemo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void test_Dialog_check_input_also() {

        // GIVEN
        ActivityScenario<MainActivity> activityScenario =ActivityScenario.launch(MainActivity.class); // launch simulated testing version of  mainactivity.
        String Expecetd_Name = "Kalyan";


        // Execute and Verify
        onView(withId(R.id.button_launch_dialog)).perform(click());

        onView(withId(R.id.editTextTextPersonName)).check(matches(isDisplayed()));  // edit text should be in view

        onView(withText(R.string.button)).perform(click());

        // make sure dialog is still visible (can't click ok without entering a name)
        onView(withId(R.id.editTextTextPersonName)).check(matches(isDisplayed()));

        // enter a name
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(Expecetd_Name));

        onView(withText(R.string.button)).perform(click());

        // make sure dialog is gone
        onView(withId(R.id.editTextTextPersonName)).check(doesNotExist());


        onView(withId(R.id.text_name)).check(matches(withText(Expecetd_Name)));



    }
}