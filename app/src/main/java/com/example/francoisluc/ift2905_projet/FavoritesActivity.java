package com.example.francoisluc.ift2905_projet;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
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
    private FavoritesAdapter adapter;
    private ArrayList<Station> favorite_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        Log.i("i","favorite");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFav);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create database
        db = new StationsDB(this);

        ////////TEST : add stations in favorite database
        db.open();
        db.insertStation(new StationsTableElement(1));
        db.insertStation(new StationsTableElement(3));
        db.close();
        ////////////////////

        //Create ListView
        listView = (ListView) findViewById(R.id.favorite_list_view);

        //Get favorites from database
        favorite_list = getFavoritesList() ;

        adapter = new FavoritesAdapter(this, favorite_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("i","onItemClick");
                Station s = favorite_list.get(position);
                db.open();
                db.removeStation(s.getId());
                db.close();
                remakeList();
            }
        });
    }

    private void remakeList(){
        favorite_list = getFavoritesList() ;
        adapter.setData(favorite_list);
        adapter.notifyDataSetChanged();
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
