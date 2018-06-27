package com.weather.bsaweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.weather.bsaweather.model.WeatherCurrent;
import com.weather.bsaweather.model.WeatherForecast;
import com.weather.bsaweather.view.IWeatherView;

public class InfoActivity extends AppCompatActivity{

    private int position;

    private WeatherForecast.ListBean mListBean;

    private TextView iconTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        mListBean = (WeatherForecast.ListBean) intent.getSerializableExtra("ser");
        iconTv = (TextView) findViewById(R.id.text);
        Log.d("fengjw", "Clouds: " + mListBean.getClouds() + "\n " +
                "Date: " + mListBean.getDt_txt() + "\n" +
                "Rain: " + mListBean.getRain());
    }


}
