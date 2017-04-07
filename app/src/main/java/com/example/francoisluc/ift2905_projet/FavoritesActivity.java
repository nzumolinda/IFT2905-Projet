package com.example.francoisluc.ift2905_projet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.example.francoisluc.ift2905_projet.Database.StationsTableElement;
import com.example.francoisluc.ift2905_projet.Database.StationsDB;

import java.util.ArrayList;

/**
 * Created by Rosalie on 2017-04-03.
 */
public class FavoritesActivity extends AppCompatActivity {

    private StationsDB db;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create database
        db = new StationsDB(this);
        //Create ListView
        listView = (ListView) findViewById(R.id.favorite_list_view);
        //Get favorites from database
        ArrayList<Station> favorite_list = getFavoritesList() ;

        FavoritesAdapter adapter = new FavoritesAdapter(this, favorite_list);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.favorites_menu, menu);
        return true;
    }

    private ArrayList<Station> getFavoritesList(){

        ArrayList<Station> stationList = new ArrayList<Station>();
        db.open();
        Cursor c = db.getStations();

        if(c.getCount() != 0){
            while(c.moveToNext()) {
                int id = c.getInt(0);
                Station st = new Station(id);
                stationList.add(st);
            }
        }

        db.close();
        return stationList;
    }

}
