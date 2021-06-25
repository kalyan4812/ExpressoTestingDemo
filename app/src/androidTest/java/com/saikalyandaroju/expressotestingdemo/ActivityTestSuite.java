package com.saikalyandaroju.expressotestingdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityTest.class,SecondaryActivityTest.class})
public class ActivityTestSuite {
    // this test suit class runs all the test activities at a time.instead of running manually.
}
