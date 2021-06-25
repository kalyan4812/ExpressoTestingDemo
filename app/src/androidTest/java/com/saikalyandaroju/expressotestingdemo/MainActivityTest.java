package com.saikalyandaroju.expressotestingdemo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void test_isActivityInView() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.main)).check(matches(isDisplayed())); // check whether activity is visible.
    }

    @Test
    public void test_visibiltyOfTextAndButton() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()));

        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()));  //method 1

        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))); //method 2.
    }


    @Test
    public void test_isTextDisplayed_Correctly() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)));
    }

    @Test
    public void test_navigateToSecondaryActivity() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.button_next_activity)).perform(click()); // perform click.

        onView(withId(R.id.secondary)).check(matches(isDisplayed())); // check next activity is displayed.
    }

    @Test
    public void test_backPressToMainActivity() {
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.button_next_activity)).perform(click()); // perform click.

        onView(withId(R.id.secondary)).check(matches(isDisplayed())); // check next activity is displayed.

        // onView(withId(R.id.button_back)).perform(click()); // perform click. method1

        pressBack(); // method 2 back press using expresso.

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }


}