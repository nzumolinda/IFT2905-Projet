package com.example.francoisluc.ift2905_projet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.gms.maps.MapView;

/**
 * Created by François Luc on 2017-04-26.
 */

public class BixiFragment extends Fragment {
    EditText bixiLocation;
    ImageButton bixiLocate, bixiListButton;
    MapView bixiMap;
    ListView bixiList;
    boolean showingBixiMap;

    public BixiFragment()
    {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_bixi, container, false);
        bixiLocation = (EditText) container.findViewById(R.id.bixilocationtextView);
        bixiLocate = (ImageButton) container.findViewById(R.id.bixibutton);
        bixiListButton = (ImageButton) container.findViewById(R.id.bixilistbutton);
        bixiMap = (MapView) container.findViewById(R.id.biximapView);
        bixiList = (ListView) container.findViewById(R.id.bixilistView);
        showingBixiMap=true;

       /* bixiListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showingBixiMap)
                {
                    bixiMap.setVisibility(View.INVISIBLE);
                    bixiList.setVisibility(View.VISIBLE);
                }
                else
                {
                    bixiMap.setVisibility(View.VISIBLE);
                    bixiList.setVisibility(View.INVISIBLE);
                }
                showingBixiMap=!showingBixiMap;
            }
        });*/

        return v;
    }
}
