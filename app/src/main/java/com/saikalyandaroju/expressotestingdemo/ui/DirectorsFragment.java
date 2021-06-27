package com.saikalyandaroju.expressotestingdemo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.saikalyandaroju.expressotestingdemo.R;

import java.util.ArrayList;
import java.util.Collection;


public class DirectorsFragment extends Fragment {

    private ArrayList<String> directors = new ArrayList();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            directors.addAll((Collection<? extends String>) getArguments().get("args_directors"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDirectors(view);

    }

    private void setDirectors(View view) {
        TextView textView = (TextView) view.findViewById(R.id.directors_text);
        textView.setText(stringBuilderForDirectors(directors));

    }

    public static String stringBuilderForDirectors(ArrayList<String> directors) {
        StringBuilder sb = new StringBuilder();
        for (String director : directors) {
            sb.append(director + "\n");
        }
        return sb.toString();
    }
}