package com.shikhar.cinema;

import com.shikhar.cinema.model.Movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> mInTheaterMovieList = new ArrayList<>();
    List<Movie> mUpComingMovieList = new ArrayList<>();

    RecyclerView mInTheaterRecyclerView;
    RecyclerView mUpComingRecyclerView;

    MovieAdapter mMovieAdapter;
    MovieAdapter mUpcomingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add dummy content
        addSampleContent();

        //setting top recycler view (In Theaters)
        mInTheaterRecyclerView = (RecyclerView) findViewById(R.id.in_theaters);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        mInTheaterRecyclerView.setLayoutManager(gridLayoutManager);

        mMovieAdapter = new MovieAdapter(mInTheaterMovieList, this);
        mInTheaterRecyclerView.setAdapter(mMovieAdapter);
        mInTheaterRecyclerView.setHasFixedSize(true);
        mInTheaterRecyclerView.setNestedScrollingEnabled(false);


        //setting bottom recycler view (Upcoming Movies )
        mUpComingRecyclerView = (RecyclerView) findViewById(R.id.upcoming);

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        mUpComingRecyclerView.setLayoutManager(gridLayoutManager2);

        mUpcomingAdapter = new MovieAdapter(mUpComingMovieList, this);
        mUpComingRecyclerView.setAdapter(mUpcomingAdapter);
        mUpComingRecyclerView.setHasFixedSize(true);
        mUpComingRecyclerView.setNestedScrollingEnabled(false);

    }

    void addSampleContent() {

        mInTheaterMovieList.add(new Movie("Rogue One",
                "The Rebel Alliance makes a risky move to steal the plans for the Death Star, setting up the epic saga to follow.",
                "133 min",
                4.5f,
                R.drawable.rogueone,
                Arrays.asList("Wji-BZ0oCwg","sC9abcLLQpI","eUmcneReow8","frdj1zb9sMY","BBNc7Pz35OA")));

        mInTheaterMovieList.add(new Movie("Arrival",
                "When twelve mysterious spacecraft appear around the world, linguistics professor Louise Banks is tasked with interpreting the language of the apparent alien visitors.",
                "116 min",
                4.0f,
                R.drawable.arrival,
                Arrays.asList("tFMo3UJ4B4g","ZLO4X6UI8OY","WH9F4WkvhRk","Yyv3JczSsy4")));

        mInTheaterMovieList.add(new Movie("Hacksaw Ridge",
                "WWII American Army Medic Desmond T. Doss, who served during the Battle of Okinawa, refuses to kill people, and becomes the first man in American history to receive the Medal of Honor without firing a shot.",
                "139 min",
                3.5f,
                R.drawable.hacksaw,
                Arrays.asList("s2-1hz1juBI","3B6lCXzefjU","tk0OEs0ewlw")));

        mInTheaterMovieList.add(new Movie("Incarnation",
                "After a single mother witnesses terrifying symptoms of demonic possession in her 11-year-old son, a Vatican representative calls on wheelchair-bound scientist to rid him of the evil spirit",
                "115 min",
                2.5f,
                R.drawable.incarnation,
                Arrays.asList("dyRqcSjYsB4","LUVwbhc0j18","1BDwnp4DQK8")));

        mInTheaterMovieList.add(new Movie("Logan",
                "In the near future, a weary Logan cares for an ailing Professor X somewhere on the Mexican border. However, Logan's attempts to hide from the world and his legacy are upended when a young mutant arrives, pursued by dark forces.",
                "137 min",
                4.0f,
                R.drawable.logan,
                Arrays.asList("Div0iP65aZo","DekuSxJgpbY","pvVPNOPVg3I","GkbHpKsIS8U","BthInJ4fAoI","oyKilRrS3jI")));

        mInTheaterMovieList.add(new Movie("Assassin's Creed",
                "When Callum Lynch explores the memories of his ancestor Aguilar and gains the skills of a Master Assassin, he discovers he is a descendant of the secret Assassins society.",
                "115 min",
                4.5f,
                R.drawable.creed,
                Arrays.asList("gfJVoF5ko1Y","9pC2IjvLSKs","0fITmuqh4g8","fwWXTDKqI38")));

        mInTheaterMovieList.add(new Movie("La la land",
                "Sebastian (Ryan Gosling) and Mia (Emma Stone) are drawn together by their common desire to do what they love. But as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair",
                "133 min",
                5.0f,
                R.drawable.lalaland,
                Arrays.asList("0pdqf4P9MB8","VDMf9m7FXd4","76ULWmMfHcU")));

        mInTheaterMovieList.add(new Movie("Lion",
                "A five-year-old Indian boy gets lost on the streets of Calcutta, thousands of kilometers from home. He survives many challenges before being adopted by a couple in Australia; 25 years later, he sets out to find his lost family.",
                "118 min",
                4.0f,
                R.drawable.lion,
                Arrays.asList("RNI9o06vqo","D_dD5mDssT0","IHdw7XxqTq8","j8juIIPT_jI")));

        mUpComingMovieList.add(new Movie("Wonder Woman",
                "Before she was Wonder Woman (Gal Gadot), she was Diana, princess of the Amazons, trained to be an unconquerable warrior. Raised on a sheltered island paradise, Diana meets an American pilot (Chris Pine) who tells her about the massive conflict that's raging in the outside world. ",
                "120 min",
                -1.0f,
                R.drawable.wonder,
                Arrays.asList("T1j7qWUQjog","INLzqh7rZ-U","5lGoQhFb4NM","DRmOi2P68nU","yJV63nMARQI","jJnuF06YdRo","W25a6C9jh6U")));

        mUpComingMovieList.add(new Movie("Transformers5",
                "Humans are at war with the Transformers, and Optimus Prime is gone. The key to saving the future lies buried in the secrets of the past and the hidden history of Transformers on Earth.",
                "180 min",
                -1.0f,
                R.drawable.trans,
                Arrays.asList("AntcyqJ6brc","V14yJba0KEE","rW1byMeeZNA","RzUt-rXKG2s","qOR-Av4qG1A")));

        mUpComingMovieList.add(new Movie("Justice League",
                "Months after the events of Batman v Superman and inspired by Superman's sacrifice for humanity, Bruce Wayne and Diana Prince assemble a team of metahumans to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.",
                "155 min",
                -1.0f,
                R.drawable.league,
                Arrays.asList("fIHH5-HVS9o","Ek-W-9v76is","VyadyxuTVPo","HsCkjNOzalo")));

        mUpComingMovieList.add(new Movie("The Mummy",
                "Thousands of years ago, an ancient princess whose destiny was unjustly taken from her, was mummified and entombed in an ancient tomb buried deep beneath the desert. She awakens in the contemporary world, bringing with her a malevolent grudge that has grown over millennia and terrors that will defy all of humanity.",
                "125 min",
                -1.0f,
                R.drawable.mummy,
                Arrays.asList("IjHgzkQM2Sg","-V1kXtEfMpU","LAWo9_V2qOg")));

        mUpComingMovieList.add(new Movie("Kong: Skull Island",
                "A team of scientists explore an uncharted island in the Pacific, venturing into the domain of the mighty Kong, and must fight to escape a primal Eden.",
                "110 min",
                -1.0f,
                R.drawable.kong,
                Arrays.asList("44LdLqgOpjo","AP0-9FBs2Rs","YAbI4w95cTE")));

        mUpComingMovieList.add(new Movie("Spider Man",
                "Thrilled by his experience with the Avengers, young Peter Parker (Tom Holland) returns home to live with his Aunt May. Under the watchful eye of mentor Tony Stark, Parker starts to embrace his newfound identity as Spider-Man.",
                "173 min",
                -1.0f,
                R.drawable.spider,
                Arrays.asList("DYaHetc_h9U","xrzXIaTt99U","ERx8Z9BIalU","_v_Cdx0mbLw")));

        mUpComingMovieList.add(new Movie("Furious 8",
                "When a mysterious woman seduces Dom into the world of crime and a betrayal of those closest to him, the crew face trials that will test them as never before.",
                "143 min",
                -1.0f,
                R.drawable.furious,
                Arrays.asList("nVdxF6Setvk","Opsu9gd90JU","GwXo-IWe8FM","NxhEZG0k9_w","Jkal-Bs23f0")));

        mUpComingMovieList.add(new Movie("Dunkirk",
                "Allied soldiers from Britain, Belgium, Canada, and France are surrounded by the German Army on the beaches on Dunkirk and evacuated in Operation Dynamo between 26 May and 4 June 1940, during the early stages of the Second World War.",
                "193 min",
                -1.0f,
                R.drawable.dunkirk,
                Arrays.asList("F-eMt3SrfFU","yM9BWtppzko","5J-eD1G67UE")));

    }

}
