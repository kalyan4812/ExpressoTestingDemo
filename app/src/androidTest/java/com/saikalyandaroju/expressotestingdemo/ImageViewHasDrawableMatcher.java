package com.saikalyandaroju.expressotestingdemo;

import android.view.View;
import android.widget.ImageView;

import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;

public class ImageViewHasDrawableMatcher {

    //testing presence of view ,i.e whetehr image is to set imageview or not.
    // there are other matchers like imageview matcher,recyclerview matcher etc.

    public  static BoundedMatcher<View, ImageView> hasDrawable(){  // it is one of the custom  matcher.
        return new BoundedMatcher<View, ImageView>(ImageView.class) {
            @Override
            protected boolean matchesSafely(ImageView item) {
                if(item!=null)
                return item.getDrawable()!=null;
                return false;
            }

            @Override
            public void describeTo(Description description) {
                if(description!=null) description.appendText("has drawable"); // it is for debugging.
            }
        };
    }
}
