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

public class DocksFragment extends Fragment {
    EditText docksLocation;
    ImageButton docksLocate, docksListButton;
    MapView docksMap;
    ListView docksList;
    boolean showingDocksMap;

    public DocksFragment()
    {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_bixi, container, false);
        docksLocation = (EditText) container.findViewById(R.id.dockslocationtextView);
        docksLocate = (ImageButton) container.findViewById(R.id.docksbutton);
        docksListButton = (ImageButton) container.findViewById(R.id.dockslistbutton);
        docksMap = (MapView) container.findViewById(R.id.docksmapView);
        docksList = (ListView) container.findViewById(R.id.dockslistView);
        showingDocksMap=true;

       docksListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showingDocksMap)
                {
                    docksMap.setVisibility(View.INVISIBLE);
                    docksList.setVisibility(View.VISIBLE);
                }
                else
                {
                    docksMap.setVisibility(View.VISIBLE);
                    docksList.setVisibility(View.INVISIBLE);
                }
                showingDocksMap=!showingDocksMap;
            }
        });

        return v;
    }
}
