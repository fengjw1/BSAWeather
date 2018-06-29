package com.weather.bsaweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.weather.bsaweather.model.WeatherForecast;

public class InfoActivity extends AppCompatActivity {

    private int position;

    private WeatherForecast.ListBean mListBean;

    private TextView mTvIcon;
    private TextView mTvWeather;
    private TextView mTvDescription;
    private TextView mTvPressure;
    private TextView mMinTvTemp;
    private TextView mMaxTvTemp;
    private TextView mLevelTvSea;
    private TextView mLevelTvGrnd;
    private TextView mTvHumidity;
    private TextView mKfTvTemp;
    private TextView mTvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        mListBean = (WeatherForecast.ListBean) intent.getSerializableExtra("ser");
        Log.d("fengjw", "Clouds: " + mListBean.getClouds() + "\n " +
                "Date: " + mListBean.getDt_txt() + "\n" +
                "Rain: " + mListBean.getRain());
        initView();
    }

    private void initView() {
        mTvIcon = (TextView) findViewById(R.id.icon_tv);
        mTvIcon.setText(mListBean.getWeather().get(0).getIcon());
        mTvWeather = (TextView) findViewById(R.id.weather_tv);
        mTvWeather.setText(mListBean.getWeather().get(0).getMain());
        mTvDescription = (TextView) findViewById(R.id.description_tv);
        mTvDescription.setText(mListBean.getWeather().get(0).getDescription());
        mTvPressure = (TextView) findViewById(R.id.pressure_tv);
        mTvPressure.setText(mListBean.getMain().getPressure() + "");
        mTvTemp = (TextView) findViewById(R.id.temp_tv);
        mTvTemp.setText(mListBean.getMain().getTemp() + "");
        mMinTvTemp = (TextView) findViewById(R.id.temp_min_tv);
        mMinTvTemp.setText(mListBean.getMain().getTemp_min() + "");
        mMaxTvTemp = (TextView) findViewById(R.id.temp_max_tv);
        mMaxTvTemp.setText(mListBean.getMain().getTemp_max() + "");
        mLevelTvSea = (TextView) findViewById(R.id.sea_level_tv);
        mLevelTvSea.setText(mListBean.getMain().getSea_level() + "");
        mLevelTvGrnd = (TextView) findViewById(R.id.grnd_level_tv);
        mLevelTvGrnd.setText(mListBean.getMain().getGrnd_level() + "");
        mTvHumidity = (TextView) findViewById(R.id.humidity_tv);
        mTvHumidity.setText(mListBean.getMain().getHumidity() + "");
        mKfTvTemp = (TextView) findViewById(R.id.temp_kf_tv);
        mKfTvTemp.setText(mListBean.getMain().getTemp_kf() + "");
    }


}
