package com.nnataraj.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MasterDetailActivity extends AppCompatActivity implements HandleNavigationListener {

    private boolean mTwoPane;
    MovieData movieData;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);

        movieData = new MovieData();


        if (findViewById(R.id.detail_container) != null) {
            mTwoPane = true;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_master_detail, MovieListFragment.newInstance(R.id.layout,index))
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, MovieListFragment.newInstance(R.id.layout,index))
                    .commit();
        }
    }

    @Override
    public void navigationToItemSelected(int button) {

    }

    @Override
    public void navigate(int buttonId, int index) {
        if (mTwoPane) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail_container, DetailViewFragment.newInstance(movieData.getItem(index)))
                    .addToBackStack("store")
                    .commit();

            TextView indexText = (TextView) findViewById(R.id.index);
            indexText.setText(String.valueOf(index+1));

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_container, DetailViewFragment.newInstance(movieData.getItem(index)))
                    .addToBackStack("store")
                    .commit();

        }
    }
}
