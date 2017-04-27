package com.example.francoisluc.ift2905_projet;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rosalie on 2017-04-26.
 */

public class ResultsListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater myInflater;
    private ArrayList<Station> dataSource;


    public ResultsListAdapter(Context c, ArrayList<Station> data){
        context = c;
        dataSource = data;
        myInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(ArrayList<Station> newData){
        dataSource = newData;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View rowView = myInflater.inflate(R.layout.results_list_item, parent, false);

        final Station s = (Station) getItem(position);

        //Get elements references
        TextView stationName = (TextView) rowView.findViewById(R.id.stationName);
        TextView nbBixis = (TextView) rowView.findViewById(R.id.nbBixis);
        TextView nbDocks = (TextView) rowView.findViewById(R.id.nbDocks);
        ImageButton delete = (ImageButton) rowView.findViewById(R.id.delete_button);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("i","add click");
                ((ListView) parent).performItemClick(v, position, 0);
            }
        });


        stationName.setText(s.getName());
        nbBixis.setText("" + s.getNbBixis());
        nbDocks.setText("" + s.getNbDocks());

        return rowView;
    }
}
