package com.weather.bsaweather.view;

import com.weather.bsaweather.model.WeatherCurrent;
import com.weather.bsaweather.model.WeatherForecast;

/**
 * Created by fengjw on 2018/6/27.
 */

public interface IWeatherView {

    void setCurrentWeather(WeatherCurrent weatherCurrent);

    void setForecastWeather(WeatherForecast weatherForecast);

    void onCurrentFail(String cause);

    void onForecastFail(String cause);

}
