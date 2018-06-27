package com.weather.bsaweather.model;

import com.weather.bsaweather.presenter.IWeatherPresenter;
import com.weather.bsaweather.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fengjw on 2018/6/27.
 */

public class WeatherModel implements IWeatherModel {

    private IWeatherPresenter mIWeatherPresenter;
    private RetrofitInterface mRetrofitInterface;

    public WeatherModel(IWeatherPresenter IWeatherPresenter) {
        mIWeatherPresenter = IWeatherPresenter;
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
        mRetrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    @Override
    public void getCurrentWeather(final String city) {
        Call<WeatherCurrent> current = mRetrofitInterface.getWeatherCurrent(city, "metric",
                Constants.API_KEY);
        current.enqueue(new Callback<WeatherCurrent>() {
            @Override
            public void onResponse(Call<WeatherCurrent> call, Response<WeatherCurrent> response) {
                if (response.isSuccessful()) {
                    mIWeatherPresenter.onCurrentWeather(response.body());
                } else {
                    mIWeatherPresenter.onCurrentFail(city);
                }
            }

            @Override
            public void onFailure(Call<WeatherCurrent> call, Throwable t) {
                mIWeatherPresenter.onCurrentFail(t.getMessage());
            }
        });
    }

    @Override
    public void getForecastWeather(final String city) {
        Call<WeatherForecast> forecast = mRetrofitInterface.getWeatherForecast(city, "metric", 20,
                Constants.API_KEY);

        forecast.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                if (response.isSuccessful()) {
                    mIWeatherPresenter.onForecastWeather(response.body());
                } else {
                    mIWeatherPresenter.onForecastFail(city);
                }
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                mIWeatherPresenter.onForecastFail(t.getMessage());
            }
        });
    }
}
