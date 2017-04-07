package com.example.francoisluc.ift2905_projet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rosalie on 2017-04-07.
 */

public class FavoritesAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater myInflater;
    private ArrayList<Station> dataSource;


    public FavoritesAdapter(Context c, ArrayList<Station> data){
        context = c;
        dataSource = data;
        myInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = myInflater.inflate(R.layout.favorites_list_item, parent, false);

        //Get elements references
        TextView stationName = (TextView) rowView.findViewById(R.id.stationName);
        TextView nbBixis = (TextView) rowView.findViewById(R.id.nbBixis);
        TextView nbDocks = (TextView) rowView.findViewById(R.id.nbDocks);

        Station s = (Station) getItem(position);

        stationName.setText("" + s.getId());
        //nbBixis.setText(s.getNbBixis());
        //nbDocks.setText(s.getNbDocks());

        return rowView;
    }
}
