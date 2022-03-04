package com.example.bigbucket.GridAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.bigbucket.R;

public class AdapterGrid extends BaseAdapter
{
    Context context;
    int logos[];
    LayoutInflater inflter;

    public AdapterGrid(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = inflter.inflate(R.layout.activity_grid_item, null);
        ImageView imageView = view.findViewById(R.id.iconn);
        imageView.setImageResource(logos[i]);
        return view;
    }
}
