package com.weather.bsaweather.presenter;

import com.weather.bsaweather.model.WeatherCurrent;
import com.weather.bsaweather.model.WeatherForecast;

/**
 * Created by fengjw on 2018/6/27.
 */

public interface IWeatherPresenter {

    void getCurrentWeather(String city);

    void getForecastWeather(String city);

    void onCurrentWeather(WeatherCurrent weatherCurrent);

    void onForecastWeather(WeatherForecast weatherForecast);

    void onCurrentFail(String city);

    void onForecastFail(String city);

}
