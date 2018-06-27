package com.weather.bsaweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weather.bsaweather.model.WeatherForecast;
import com.weather.bsaweather.utils.Constants;

/**
 * Created by fengjw on 2018/6/27.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> implements View.OnClickListener{

    private Context mContext;
    private WeatherForecast mForecast;

    private OnItemClickListener mOnItemClickListener = null;

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(v, mForecast.getList().get((int)v.getTag()));
        }
    }

    public static interface OnItemClickListener{
        void onItemClick(View view,WeatherForecast.ListBean listBean);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }


    public RecyclerAdapter(Context context) {
        mContext = context;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvDate, mTvWeather, mTvTemperature;
        public ImageView mIvWeather;

        public ItemViewHolder(View v) {
            super(v);
            mTvDate = v.findViewById(R.id.textView_date);
            mTvWeather = v.findViewById(R.id.textView_weather);
            mTvTemperature = v.findViewById(R.id.textView_temperature);
            mIvWeather = v.findViewById(R.id.imageView_icon);
        }
    }

    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                .recycler_item, parent, false);
        view.setOnClickListener(this);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ItemViewHolder holder, final int position) {
        holder.mTvDate.setText(mForecast.getList().get(position).getDt_txt());
        holder.mTvWeather.setText(mForecast.getList().get(position).getWeather().get(0).getMain());
        holder.mTvTemperature.setText(String.format(mContext.getResources().getString(R.string
                .city_temperature), mForecast.getList().get(position).getMain().getTemp()));
        Glide.with(mContext).load(Constants.ICON_URL + mForecast.getList().get(position).getWeather
                ().get(0).getIcon() + ".png").error(Glide.with(mContext).load(R.drawable
                .ic_thumb_down_black_120dp)).into(holder.mIvWeather);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (mForecast != null)
            return mForecast.getCnt();
        return 0;
    }

    public void setForecast(WeatherForecast forecast) {
        mForecast = forecast;
    }
}
