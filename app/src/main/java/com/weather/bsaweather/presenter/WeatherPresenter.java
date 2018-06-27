package com.weather.bsaweather.presenter;

import com.weather.bsaweather.model.WeatherCurrent;
import com.weather.bsaweather.model.WeatherForecast;
import com.weather.bsaweather.model.WeatherModel;
import com.weather.bsaweather.view.IWeatherView;

/**
 * Created by fengjw on 2018/6/27.
 */

public class WeatherPresenter implements IWeatherPresenter{

    private IWeatherView mIWeatherView;
    private WeatherModel mWeatherModel;

    public WeatherPresenter(IWeatherView IWeatherView) {
        mIWeatherView = IWeatherView;
        mWeatherModel = new WeatherModel(this);
    }

    @Override
    public void getCurrentWeather(String city) {
        mWeatherModel.getCurrentWeather(city);
    }

    @Override
    public void getForecastWeather(String city) {
        mWeatherModel.getForecastWeather(city);
    }

    @Override
    public void onCurrentWeather(WeatherCurrent weatherCurrent) {
        mIWeatherView.setCurrentWeather(weatherCurrent);
    }

    @Override
    public void onForecastWeather(WeatherForecast weatherForecast) {
        mIWeatherView.setForecastWeather(weatherForecast);
    }

    @Override
    public void onCurrentFail(String city) {
        mIWeatherView.onCurrentFail(city);
    }

    @Override
    public void onForecastFail(String city) {
        mIWeatherView.onForecastFail(city);
    }
}
