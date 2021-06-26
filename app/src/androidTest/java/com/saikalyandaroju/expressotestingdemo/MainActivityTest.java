package com.saikalyandaroju.expressotestingdemo;

import android.app.Instrumentation;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.activity.result.ActivityResult;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.Activity.RESULT_OK;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {


    @Rule
   public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void test_validateGalleryIntent() {
        //Given
        Matcher<Intent> expectedIntent = Matchers.allOf(IntentMatchers.hasAction(Intent.ACTION_PICK), IntentMatchers
                .hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)); // you can have category,extras attahed to itnent.

        Instrumentation.ActivityResult activityResult = createGalleryPickActivityResultStub();
        intending(expectedIntent).respondWith(activityResult);

        // Execute and Verify
        onView(withId(R.id.button_open_gallery)).perform(click());
        intended(expectedIntent);

    }

    private Instrumentation.ActivityResult createGalleryPickActivityResultStub() {
        Resources resources = InstrumentationRegistry.getInstrumentation().getContext().getResources();


        //testing launcher image,becuase it avaialable on each device which we test.
        Uri imageUri = Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                        resources.getResourcePackageName(R.drawable.ic_launcher_background) + '/' +
                        resources.getResourceTypeName(R.drawable.ic_launcher_background) + '/' +
                        resources.getResourceEntryName(R.drawable.ic_launcher_background)
        );
        Intent resultIntent = new Intent();
        resultIntent.setData(imageUri);
        return new Instrumentation.ActivityResult(RESULT_OK, resultIntent);
    }
}