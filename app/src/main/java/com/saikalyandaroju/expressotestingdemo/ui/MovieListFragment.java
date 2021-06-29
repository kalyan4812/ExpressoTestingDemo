package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.model.Movie;
import com.saikalyandaroju.expressotestingdemo.source.MovieListAdapter;
import com.saikalyandaroju.expressotestingdemo.source.MoviesDataSource;
import com.saikalyandaroju.expressotestingdemo.util.ExpressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

public class MovieListFragment extends Fragment implements MovieListAdapter.Interaction {

    private MoviesDataSource moviesDataSource;
    private MovieListAdapter movieListAdapter;
    private List<Movie> moviesList = new ArrayList<>();

    public MovieListFragment(MoviesDataSource moviesDataSource) {
        this.moviesDataSource = moviesDataSource;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView(view);
        getData();
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        movieListAdapter = new MovieListAdapter(moviesList, getContext());
        movieListAdapter.setInteraction(this);
        recyclerView.setAdapter(movieListAdapter);
    }

    private void getData() {

        /* This will fail the test cases.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        moviesList.addAll(moviesDataSource.getMovies());
                        movieListAdapter.notifyDataSetChanged();
                    }
                });
            }
        });*/

        ExpressoIdlingResource.increment(); // once gets incremneted expresso wait.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        moviesList.clear();
        moviesList.addAll(moviesDataSource.getMovies());
        movieListAdapter.notifyDataSetChanged();
        ExpressoIdlingResource.decrement(); // once it decrements expresso continues test cases.
    }





        @Override
        public void onItemSelected ( int position, Movie item){
            Bundle bundle = new Bundle();
            bundle.putInt("movie_id", item.getId());
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MovieDetailFragment.class, bundle)
                    .addToBackStack("MovieDetailFragment")
                    .commit();
        }
    }