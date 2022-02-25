package com.example.bigbucket;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.bigbucket.R;

public class GridAdapter extends BaseAdapter
{
    private Context mContext;

    public  GridAdapter(Context c)
    {
        mContext = c;
    }
    @Override
    public int getCount()
    {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds =
            {
                    R.drawable.fruit, R.drawable.vegetables,R.drawable.foodgrains,
                    R.drawable.oilmasala, R.drawable.beverage,R.drawable.snacks,
                    R.drawable.dairy,R.drawable.combo,
            };
}
