package com.example.francoisluc.ift2905_projet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.francoisluc.ift2905_projet.Database.StationsDB;

public class MainActivity extends AppCompatActivity {

    private StationsDB database;
    TabLayout mainhost;
    ViewPager pager;
    PagerAdapter pagerAdapter;
    EditText bixiLocation, docksLocation, itinStartLocation, itinDestLocation;
    Button bixiLocate, bixiList, docksLocate, docksList, itinerary;
    public final int NB_TABS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create database
        database = new StationsDB(this);

        mainhost = (TabLayout) findViewById(R.id.tab_layout);
        pager = (ViewPager)findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        mainhost.setupWithViewPager(pager);

        mainhost.getTabAt(0).setIcon(R.drawable.ic_bicycle_pictogram);
        mainhost.getTabAt(1).setIcon(R.drawable.ic_docks_30px);
        mainhost.getTabAt(2).setIcon(R.drawable.ic_road_with_two_placeholders);

        bixiLocation = (EditText) findViewById(R.id.bixilocationtextView);
        bixiLocate = (Button) findViewById(R.id.bixibutton);
        bixiList = (Button) findViewById(R.id.bixilistbutton);

        docksLocation = (EditText) findViewById(R.id.dockslocationtextView);
        docksLocate = (Button) findViewById(R.id.docksbutton);
        docksList = (Button) findViewById(R.id.dockslistbutton);

        itinStartLocation = (EditText) findViewById(R.id.starttextView);
        itinDestLocation = (EditText) findViewById(R.id.desttextView);
        itinerary = (Button) findViewById(R.id.itinerarybutton);


    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            SimpleFragment fragment = new SimpleFragment();
            Bundle args =new Bundle();
            args.putInt("id",position);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return NB_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Favorite:
                Intent intent = new Intent(getApplicationContext(), FavoritesActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void StartActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        this.startActivity(intent);
    }
}
