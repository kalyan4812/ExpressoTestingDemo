package com.saikalyandaroju.expressotestingdemo.util;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ExpressoIdlingResourecRule extends TestWatcher {

    //Testwatcher implements TestRule.
    private CountingIdlingResource countingIdlingResource = ExpressoIdlingResource.countingIdlingResource;


    //Before
    @Override
    protected void starting(Description description) {
        super.starting(description);
        IdlingRegistry.getInstance().register(countingIdlingResource);
    }

    //After
    @Override
    protected void finished(Description description) {
        super.finished(description);
        IdlingRegistry.getInstance().unregister(countingIdlingResource);
    }
}
