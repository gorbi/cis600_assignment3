package com.nnataraj.assignment3;

import android.os.Bundle;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

public class FrontPageActivity extends AppCompatActivity implements HandleNavigationListener {

    Fragment mcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState!=null) {
            mcontent = getSupportFragmentManager().getFragment(savedInstanceState, "mcontent");
        }
        else {
            mcontent= FrontPageActivityFragment.newInstance(R.id.content_front_page);
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment,mcontent)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"mcontent",mcontent);
    }

    @Override
    public void navigationToItemSelected(int button) {
        switch (button) {
            case R.id.button_about_me:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment,AboutMeFragment.newInstance(R.id.about_me))
                        .addToBackStack("store")
                        .setTransitionStyle(TRANSIT_FRAGMENT_FADE)
                        .commit();
                return;
            case R.id.button_task_2:
                startActivity(new Intent(FrontPageActivity.this,
                        ViewPagerActivity.class));
                return;
            case R.id.button_task_3:
                startActivity(new Intent(FrontPageActivity.this,
                        MasterDetailActivity.class));
                return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_about_me:
                navigationToItemSelected(R.id.button_about_me);
                return true;
            case R.id.action_task_2:
                navigationToItemSelected(R.id.button_task_2);
                return true;
            case R.id.action_task_3:
                navigationToItemSelected(R.id.button_task_3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void navigate(int buttonId, int index) {

    }

}
