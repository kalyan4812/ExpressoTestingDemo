package com.saikalyandaroju.expressotestingdemo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.saikalyandaroju.expressotestingdemo.ImageViewHasDrawableMatcher.hasDrawable;
import static com.saikalyandaroju.expressotestingdemo.MainActivity.KEY_IMAGE_DATA;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void test_cameraIntent_isBitmapSetToImageView() {
        // GIVEN
        Instrumentation.ActivityResult activityResult = createImageCaptureActivityResultStub();

        Matcher<Intent> expectedIntent = Matchers.allOf(IntentMatchers.hasAction(MediaStore.ACTION_IMAGE_CAPTURE));
        intending(expectedIntent).respondWith(activityResult);

        // Execute and Verify

      /*  onView(withId(R.id.button_launch_camera)).perform(click());
        intended(expectedIntent);*/

        onView(withId(R.id.image)).check(matches(not(hasDrawable()))); //before picking there should be no drawable.
        onView(withId(R.id.button_launch_camera)).perform(click());
        intended(expectedIntent);
        onView(withId(R.id.image)).check(matches(hasDrawable()));

    }

    private Instrumentation.ActivityResult createImageCaptureActivityResultStub() {
        Bundle bundle =new  Bundle();
        bundle.putParcelable(
                KEY_IMAGE_DATA, BitmapFactory.decodeResource(
                        intentsTestRule.getActivity().getResources(),
                        R.drawable.ic_launcher_background
                )
        );
        Intent resultData = new Intent();
        resultData.putExtras(bundle);
        return new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);
    }
}