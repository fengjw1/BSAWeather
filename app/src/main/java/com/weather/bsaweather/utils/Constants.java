package com.weather.bsaweather.utils;

import android.util.Log;

/**
 * Created by fengjw on 2018/6/25.
 */

public class Constants {

    public static final String API_KEY = "343cb181f9cfa66aa05e5caab8c30cfa";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";

    String key1 = "7e5dcacfa46a733e084fd65210c78e96";
    String key2 = "343cb181f9cfa66aa05e5caab8c30cfa";
    private static final boolean DEBUG = true;
    public static void debug(String str){
        if (DEBUG)
            Log.d("fengjw", str);
    }

}
