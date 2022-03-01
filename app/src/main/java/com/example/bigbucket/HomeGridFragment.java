package com.example.bigbucket;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeGridFragment extends Fragment {

    GridView gridView;
    ArrayList<String> mItems;
    ThumbnailDownloader<ImageView> mThumbnailThread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_grid, container, false);
        gridView = (GridView) view.findViewById(R.id.navhome);
        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        if (getActivity() == null || gridView == null) return;
        if (mItems != null) {
            gridView.setAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_gallery_item, mItems));
        } else {
            gridView.setAdapter(null);
        }
    }

    private class FetchItemsTask extends AsyncTask<Void, Void, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            ArrayList<String> quotes = DatabaseManager.get(getActivity()).getAllActiveQuotes();
            return quotes;
        }

        @Override
        protected void onPostExecute(ArrayList<String> items) {
            mItems = items;
            setupAdapter();
        }

        @Override
        public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }
    }
}