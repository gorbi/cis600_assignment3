package com.nnataraj.assignment3;

import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class ViewPagerActivity extends AppCompatActivity {

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        int count;
        MovieData movieData = new MovieData();

        public MyFragmentPagerAdapter(FragmentManager fm, int size) {
            super(fm);
            count = size;
        }

        @Override
        public Fragment getItem(int position) {
            return DetailViewFragment.newInstance((HashMap<String, ?>) movieData.getItem(position));

        }

        @Override
        public int getCount() {
            return count;

        }

        @Override
        public CharSequence getPageTitle(int position) {
            String name = (String) moviedata.getItem(position).get("name");
            return name.toUpperCase();
        }

    }

    MovieData moviedata = new MovieData();
    ViewPager mViewPager;
    MyFragmentPagerAdapter myPagerAdapter;

    private void customizeViewPager() {
        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {

                    @Override
                    public void transformPage(View page, float position) {
                        final float normalized_position = Math.abs(Math.abs(position) - 1);
                        page.setScaleX(normalized_position / 2 + 0.5f);
                        page.setScaleY(normalized_position / 2 + 0.5f);
                    }
                }
        );

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        moviedata = new MovieData();
        myPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), moviedata.getSize());
        mViewPager = (ViewPager) findViewById(R.id.vpPager);
        mViewPager.setAdapter(myPagerAdapter);
        customizeViewPager();
    }
}
