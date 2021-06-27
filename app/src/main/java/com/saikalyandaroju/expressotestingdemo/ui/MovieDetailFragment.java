package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.model.Movie;
import com.saikalyandaroju.expressotestingdemo.source.MoviesRemoteDataSource;


public class MovieDetailFragment extends Fragment {

    private Movie movie;
    TextView moviedir, movieactors, movieTitle, movieDescription;
    ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            int movieId = getArguments().getInt("movie_id");
            MoviesRemoteDataSource moviesRemoteDataSource=new MoviesRemoteDataSource();
            movie = moviesRemoteDataSource.getMovie(movieId);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviedir = view.findViewById(R.id.movie_directiors);
        movieactors = view.findViewById(R.id.movie_star_actors);
        imageView = view.findViewById(R.id.movie_image);
        movieTitle = view.findViewById(R.id.movie_title);
        movieDescription = view.findViewById(R.id.movie_description);
        setMovieDetails(view);
        Log.i("size",movie.getDirectors()+"");
        moviedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putStringArrayList("args_directors", movie.getDirectors());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, DirectorsFragment.class, b)
                        .addToBackStack("DirectorsFragment").commit();
            }
        });
        movieactors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putStringArrayList("args_actors", movie.getStar_actors());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, StarActorsFragment.class, b)
                        .addToBackStack("StarActorsFragment").commit();
            }
        });


    }

    private void setMovieDetails(View view) {
        Glide.with(this)
                .load(movie.getImage())
                .into(imageView);
        movieTitle.setText(movie.getTitle());
        movieDescription.setText(movie.getDescription());

    }
}