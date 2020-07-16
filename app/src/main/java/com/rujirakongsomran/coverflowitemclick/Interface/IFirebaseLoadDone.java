package com.rujirakongsomran.coverflowitemclick.Interface;

import com.rujirakongsomran.coverflowitemclick.Model.Movie;

import java.util.List;

public interface IFirebaseLoadDone {
    void onFirebaseLoadSuccess(List<Movie> movieList);

    void onFirebaseLoadFailed(String message);
}
