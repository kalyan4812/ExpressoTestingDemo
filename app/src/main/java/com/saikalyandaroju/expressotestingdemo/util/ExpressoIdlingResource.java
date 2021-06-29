package com.saikalyandaroju.expressotestingdemo.util;

import androidx.test.espresso.idling.CountingIdlingResource;

public class ExpressoIdlingResource {
    private static final String RESOURCE="GLOBAL";
    public static CountingIdlingResource countingIdlingResource=new CountingIdlingResource(RESOURCE);
    public static void increment(){
        countingIdlingResource.increment();
    }
    public static void decrement(){
        if(!countingIdlingResource.isIdleNow()){
            countingIdlingResource.decrement();
        }
    }
}
