package com.saikalyandaroju.expressotestingdemo.factory;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.saikalyandaroju.expressotestingdemo.ui.DirectorsFragment;
import com.saikalyandaroju.expressotestingdemo.ui.MovieDetailFragment;
import com.saikalyandaroju.expressotestingdemo.ui.StarActorsFragment;

public class MovieFragmentFactory extends FragmentFactory {

    @NonNull
    @Override
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Fragment f = null;

        switch (className) {
            case "DirectorsFragment":
                f = new DirectorsFragment();
                break;

            case "MovieDetailFragment":
                f = new MovieDetailFragment();
                break;

            case "StarActorsFragment":
                f = new StarActorsFragment();
                break;

            default:
                f = super.instantiate(classLoader, className);
                break;
        }
        return f;
    }
}
