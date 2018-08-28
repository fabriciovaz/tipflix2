package com.example.fabriciovaz.bottomnavigation2;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import Common.Common;

import Model.Movie;

public class MovieDetail extends AppCompatActivity {



    KenBurnsView movie_image;
    TextView movie_title,movie_summary;
    int a;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie_image = (KenBurnsView)findViewById(R.id.movie_image);
        movie_title = (TextView)findViewById(R.id.movie_title);
        movie_summary = (TextView)findViewById(R.id.movie_summary);


        if (getIntent() != null)
        {
            Intent intent = getIntent();
            //int movie_index = intent.getExtras().getInt();
            Bundle bundle = getIntent().getExtras();
            // int movie_index = intent.getExtras("movie_index");
            int  movie_index = bundle.getInt("a",0);
            //Toast.makeText(this,movie_index,Toast.LENGTH_SHORT).show();
            //movie_index = movie_index;
            //   int movie_index= bundle.getInt("b");
            if (movie_index != -1 )
                loadMovieDetail(movie_index);
        }
    }

    private void loadMovieDetail(int index) {
        Movie movie = Common.movieList.get(index);

        Picasso.with(getBaseContext()).load(movie.getUrl()).into(movie_image);
        Log.d("Problema1","problema1: " + index);
        movie_title.setText(movie.getTitle());

        movie_summary.setText(movie.getSummary());


    }
}
