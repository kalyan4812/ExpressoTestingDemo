package com.saikalyandaroju.expressotestingdemo.source;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.saikalyandaroju.expressotestingdemo.R;
import com.saikalyandaroju.expressotestingdemo.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private Context context;
    private Interaction interaction;

    public MovieListAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_movie_list_item,
                parent,
                false
        );
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(context).load(movie.getImage()).into(holder.imageView);
        holder.title.setText(movie.getTitle());
        holder.starActors.setText(stringBuilderForActors(movie.getStar_actors()));

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public static String stringBuilderForActors(ArrayList<String> starActors) {
        Log.i("size",starActors.size()+"");
        StringBuilder sb = new StringBuilder();
        for (String director : starActors) {
            sb.append(director + " ");
        }
        return sb.toString();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, starActors;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_image);
            title = itemView.findViewById(R.id.movie_title);
            starActors = itemView.findViewById(R.id.movie_star_actors);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAbsoluteAdapterPosition();
                    if (interaction != null && pos != -1) {
                        interaction.onItemSelected(pos, movies.get(pos));
                    }
                }
            });
        }
    }

   public interface Interaction {
        void onItemSelected(int position, Movie item);
    }

  public  void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }
}
