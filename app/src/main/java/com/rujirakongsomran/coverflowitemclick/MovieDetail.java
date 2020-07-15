package com.rujirakongsomran.coverflowitemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.rujirakongsomran.coverflowitemclick.Common.Common;
import com.rujirakongsomran.coverflowitemclick.Model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    KenBurnsView movieImage;
    TextView tvMovieTitle, tvMovieSummary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movieImage = (KenBurnsView) findViewById(R.id.movieImage);
        tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        tvMovieSummary = (TextView) findViewById(R.id.tvMovieSummary);

        if (getIntent() != null) {
            int movie_index = getIntent().getIntExtra("movie_index", -1);
            if (movie_index != -1) {
                loadMovieDetail(movie_index);
            }
        }
    }

    private void loadMovieDetail(int index) {
        Movie movie = Common.movieList.get(index);

        // Load image
        Picasso.get().load(movie.getUrl())
                .into(movieImage);
        tvMovieTitle.setText(movie.getTitle());
        tvMovieSummary.setText(movie.getSummary());
    }
}