package com.rujirakongsomran.coverflowitemclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
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
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MovieDetail.class);
                intent.putExtra("movie_index", i);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        // Example data
        Movie movie = new Movie("Captain America: The First Avenger",
                "https://m.media-amazon.com/images/M/MV5BMTc1ODQ1ODc4NF5BMl5BanBnXkFtZTcwMDAyODQ4NQ@@._V1_SY1000_CR0,0,675,1000_AL_.jpg",
                "It is 1942, America has entered World War II, and sickly but determined Steve Rogers is frustrated at being rejected yet again for military service. Everything changes when Dr. Erskine recruits him for the secret Project Rebirth. Proving his extraordinary courage, wits and conscience, Rogers undergoes the experiment and his weak body is suddenly enhanced into the maximum human potential. When Dr. Erskine is then immediately assassinated by an agent of Nazi Germany's secret HYDRA research department (headed by Johann Schmidt, a.k.a. the Red Skull), Rogers is left as a unique man who is initially misused as a propaganda mascot; however, when his comrades need him, Rogers goes on a successful adventure that truly makes him Captain America, and his war against Schmidt begins.");
        Common.movieList.add(movie);

        movie = new Movie("Civil War",
                "https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "With many people fearing the actions of super heroes, the government decides to push for the Hero Registration Act, a law that limits a hero's actions. This results in a division in The Avengers. Iron Man stands with this Act, claiming that their actions must be kept in check otherwise cities will continue to be destroyed, but Captain America feels that saving the world is daring enough and that they cannot rely on the government to protect the world. This escalates into an all-out war between Team Iron Man (Iron Man, Black Panther, Vision, Black Widow, War Machine, and Spider-Man) and Team Captain America (Captain America, Bucky Barnes, Falcon, Scarlet Witch, Hawkeye, and Ant Man) while a new villain emerges.");

        Common.movieList.add(movie);

        movie = new Movie("Thor: Ragnarok",
                "https://m.media-amazon.com/images/M/MV5BMjE1ODgwOTkzNF5BMl5BanBnXkFtZTgwMDcwMTg5MTI@._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "Thor (Chris Hemsworth) is imprisoned on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarök, the destruction of his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela (Cate Blanchett). Written by ahmetkozan");

        Common.movieList.add(movie);

        movie = new Movie("Guardians of the Galaxy",
                "https://m.media-amazon.com/images/M/MV5BMTAwMjU5OTgxNjZeQTJeQWpwZ15BbWU4MDUxNDYxODEx._V1_SY1000_CR0,0,674,1000_AL_.jpg",
                "After stealing a mysterious orb in the far reaches of outer space, Peter Quill from Earth is now the main target of a manhunt led by the villain known as Ronan the Accuser. To help fight Ronan and his team and save the galaxy from his power, Quill creates a team of space heroes known as the \"Guardians of the Galaxy\" to save the galaxy. Written by James Hake");

        Common.movieList.add(movie);

        movie = new Movie("Spider-Man: Homecoming",
                "https://m.media-amazon.com/images/M/MV5BNTk4ODQ1MzgzNl5BMl5BanBnXkFtZTgwMTMyMzM4MTI@._V1_SY1000_CR0,0,658,1000_AL_.jpg",
                "Thrilled by his experience with the Avengers, Peter returns home, where he lives with his Aunt May, under the watchful eye of his new mentor Tony Stark, Peter tries to fall back into his normal daily routine - distracted by thoughts of proving himself to be more than just your friendly neighborhood Spider-Man - but when the Vulture emerges as a new villain, everything that Peter holds most important will be threatened. Written by Benett Sullivan");

        Common.movieList.add(movie);
    }
}