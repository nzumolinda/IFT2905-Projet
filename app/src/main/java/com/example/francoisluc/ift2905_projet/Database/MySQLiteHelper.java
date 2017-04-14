package com.example.francoisluc.ift2905_projet.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Rosalie on 2017-04-06.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{

    private static final String TABLE_STATIONS = "table_stations";
    private static final String COL_ID = "ID";
    private static final String CREATE_DB = "CREATE TABLE " + TABLE_STATIONS + " (" + COL_ID +
            " INTEGER PRIMARY KEY );";

    public MySQLiteHelper(Context context, String name, CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
