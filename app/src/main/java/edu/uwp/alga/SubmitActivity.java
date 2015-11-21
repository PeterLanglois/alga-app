package edu.uwp.alga;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import edu.uwp.alga.utils.DataUtils;
import edu.uwp.alga.utils.SubmitSectionsPagerAdapter;

public class SubmitActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private SubmitSectionsPagerAdapter mSectionsPagerAdapter;
    SharedPreferences DataInputLog;
    SharedPreferences.Editor editor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        setFragmentPagers();
        setTabLayout();
        setToolbar();

        DataInputLog = getSharedPreferences(DataUtils.mPreference,
                Context.MODE_PRIVATE);
        editor2 = DataInputLog.edit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);


                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setFragmentPagers() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SubmitSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.submit_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    /**
     * The {@link Toolbar} is a generalization of {@link ActionBar} for use within application layouts.
     */
    private void setToolbar() {
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.submit_toolbar);
        mToolbar.setTitle("Result");
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            // method invoked only when the actionBar is not null.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

    }

    private void setTabLayout() {
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.submit_tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void onBackPressed(){

        //super.onBackPressed();
        editor2.clear();
        editor2.commit();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        Log.d("Debug","test");
    }


}