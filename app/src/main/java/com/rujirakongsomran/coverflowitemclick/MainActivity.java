package com.rujirakongsomran.coverflowitemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.rujirakongsomran.coverflowitemclick.Adapter.MovieAdapter;
import com.rujirakongsomran.coverflowitemclick.Common.Common;
import com.rujirakongsomran.coverflowitemclick.Model.Movie;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter adapter;
    TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        adapter = new MovieAdapter(Common.movieList, this);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverFlow);
        mTitle = (TextSwitcher) findViewById(R.id.tsTitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView text = (TextView) inflater.inflate(R.layout.layout_title, null);
                return text;
            }
        });
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        // Example data
        Movie movie = new Movie("Batman vs Superman",
                "https://m.media-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
                "The general public is concerned over having Superman on their planet and letting the \"Dark Knight\" - Batman - pursue the streets of Gotham. While this is happening, a power-phobic Batman tries to attack Superman. Meanwhile, Superman tries to settle on a decision, and Lex Luthor, the criminal mastermind and millionaire, tries to use his own advantages to fight the \"Man of Steel\". Written by Mine Turtle");
        Common.movieList.add(movie);

        movie = new Movie("Civil War",
                "https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "With many people fearing the actions of super heroes, the government decides to push for the Hero Registration Act, a law that limits a hero's actions. This results in a division in The Avengers. Iron Man stands with this Act, claiming that their actions must be kept in check otherwise cities will continue to be destroyed, but Captain America feels that saving the world is daring enough and that they cannot rely on the government to protect the world. This escalates into an all-out war between Team Iron Man (Iron Man, Black Panther, Vision, Black Widow, War Machine, and Spider-Man) and Team Captain America (Captain America, Bucky Barnes, Falcon, Scarlet Witch, Hawkeye, and Ant Man) while a new villain emerges.");

        Common.movieList.add(movie);
    }
}