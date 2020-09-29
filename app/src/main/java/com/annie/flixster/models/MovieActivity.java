package com.annie.flixster.models;

import com.annie.flixster.adapter.MovieAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class MovieActivity {
    String posterPath;
    String backdropPath;
    String title;
    String overview;
    double rating;
    int movieid;

    // empty constructor for Parcel
    public MovieActivity(){}

    public MovieActivity(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieid = jsonObject.getInt("id");
    }

    public static List<MovieActivity> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<MovieActivity> movies = new ArrayList<>();
        for(int i = 0; i < movieJsonArray.length(); i++){
            movies.add(new MovieActivity(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getId() {
        return movieid;
    }

}
