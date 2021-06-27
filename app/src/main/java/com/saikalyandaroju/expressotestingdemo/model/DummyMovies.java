package com.saikalyandaroju.expressotestingdemo.model;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class DummyMovies {
    public static ArrayList<Movie> provideMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        ArrayList<String> m1dir = new ArrayList<>();
        m1dir.add("Anthony Russo");
        m1dir.add("Joe Russo");

        ArrayList<String> m1actor = new ArrayList<>();
        m1actor.add("Robert Downey Jr.");
        m1actor.add("Chris Hemsworth");
        m1actor.add("Mark Ruffalo");

        Movie m1 = new Movie(
                0,
                "Avengers: Infinity War",
                "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/Infinity_War-infinity_war.png",
                "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                        "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                        "the universe.",
                new ArrayList<String>(asList("alex", "brian", "charles")),
                new ArrayList<String>(asList("alex", "brian", "charles"))
        );


        ArrayList<String> m2dir = new ArrayList<>();
        m2dir.add("R.J. Stewart");
        m2dir.add("James Vanderbilt");

        ArrayList<String> m2actor = new ArrayList<>();
        m2actor.add("Dwayne Johnson");
        m2actor.add("Seann William Scott");
        m2actor.add("Rosario Dawson");

        Movie m2 = new Movie(
                1,
                "The Rundown",
                "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
                "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                        "becomes involved in the fight against an oppressive town operator and the search " +
                        "for a legendary treasure.",
               m2dir,m2actor
        );
        movies.add(m1);
        movies.add(m2);
        return movies;

    }
}
