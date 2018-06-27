package com.weather.bsaweather.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by fengjw on 2018/6/27.
 */

public interface RetrofitInterface {

    @GET("weather")
    Call<WeatherCurrent> getWeatherCurrent(@Query("q") String cityName,
                                           @Query("units") String units,
                                           @Query("APPID") String ApiId);

    @GET("forecast")
    Call<WeatherForecast> getWeatherForecast(@Query("q") String cityName,
                                             @Query("units") String units,
                                             @Query("cnt") int count,
                                             @Query("APPID") String ApiId);

}
