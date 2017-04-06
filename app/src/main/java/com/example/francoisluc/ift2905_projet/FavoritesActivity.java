package com.example.francoisluc.ift2905_projet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.example.francoisluc.ift2905_projet.Database.Station;
import com.example.francoisluc.ift2905_projet.Database.StationsDB;

/**
 * Created by Rosalie on 2017-04-03.
 */
public class FavoritesActivity extends AppCompatActivity {

    private StationsDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //
        //This is a test
        //
        Station st  = new Station(2);
        //Open database
        db = new StationsDB(this);
        db.open();
        db.insertStation(st);

        Cursor c = db.getStations();
        if(c.getCount() != 0){
           while(c.moveToNext()) {
               int id = c.getInt(0);
               Toast.makeText(this, "" + id, Toast.LENGTH_LONG).show();
           }
        }
        //
        // End of test
        //
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.favorites_menu, menu);
        return true;
    }

}
