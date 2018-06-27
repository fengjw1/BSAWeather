package com.weather.bsaweather.model;

/**
 * Created by fengjw on 2018/6/27.
 */

public interface IWeatherModel {

    void getCurrentWeather(String city);

    void getForecastWeather(String city);

}
