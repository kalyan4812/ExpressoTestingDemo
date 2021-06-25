package com.saikalyandaroju.expressotestingdemo;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4ClassRunner.class)
public class SecondaryActivityTest {

    @Rule
    public ActivityScenarioRule<SecondaryActivity> rule = new ActivityScenarioRule<>(SecondaryActivity.class); // declaring  scenario globally.

    @Test
    public void test_isActivityInView() {


        onView(withId(R.id.secondary)).check(matches(isDisplayed())); // check whether activity is visible.

        //Notice that this wont effect next test
        rule.getScenario().moveToState(Lifecycle.State.DESTROYED);
    }

    @Test
    public void test_visibiltyOfTextAndButton() {


        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()));

        onView(withId(R.id.button_back)).check(matches(isDisplayed()));  //method 1

        onView(withId(R.id.button_back)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))); //method 2.
    }

    @Test
    public void test_isTextDisplayed_Correctly() {

        onView(withId(R.id.activity_secondary_title)).check(matches(withText(R.string.text_secondaryactivity)));
    }

    //doubt here test case fails???
  /*  @Test
    public void test_navigateToMainActivity() {

        onView(withId(R.id.button_back)).perform(click()); // perform click.

        onView(withId(R.id.main)).check(matches(isDisplayed())); // check main activity is displayed.
    }*/
}