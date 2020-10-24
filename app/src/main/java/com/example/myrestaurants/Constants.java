package com.example.myrestaurants;

import com.example.myrestaurants.BuildConfig;


public class Constants {

    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/";
    public static final String YELP_API_KEY = BuildConfig.YELP_API_KEY;

    public static final String PREFERENCES_LOCATION_KEY = "location";
//    The string "location" will act as the key in our key-value pair. (for shared prefences)

    public static final String FIREBASE_CHILD_SEARCHED_LOCATION = "searchedLocation";

}
