package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saikalyandaroju.expressotestingdemo.R;

import java.util.ArrayList;
import java.util.Collection;


public class StarActorsFragment extends Fragment {

    private ArrayList<String> starActors = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            starActors.addAll((ArrayList<String>) getArguments().get("args_actors"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star_actors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setActors(view);
    }

    private void setActors(View view) {
        TextView textView = (TextView) view.findViewById(R.id.star_actors_text);
        textView.setText(stringBuilderForActors(starActors));
    }

    public static String stringBuilderForActors(ArrayList<String> starActors) {
        Log.i("size",starActors.size()+"");
        StringBuilder sb = new StringBuilder();
        for (String director : starActors) {
            sb.append(director + "\n");
        }
        return sb.toString();
    }
}