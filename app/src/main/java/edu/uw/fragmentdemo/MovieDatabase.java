package edu.uw.fragmentdemo;

import android.provider.BaseColumns;

/**
 * Class to manage a database to store movie info
 * Ideally this should be made into a Provider
 */
public final class MovieDatabase {

    //empty constructor so cannot be called
    public MovieDatabase(){}

    public static abstract class FavoriteEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COL_TITLE = "title";
        public static final String COL_YEAR = "year";
        public static final String COL_IMDB_ID = "imdbId";
        public static final String COL_POSTER_URL = "posterUrl";

    }




}
