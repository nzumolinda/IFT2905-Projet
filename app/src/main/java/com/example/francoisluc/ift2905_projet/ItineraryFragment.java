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

import com.google.android.gms.maps.MapView;

/**
 * Created by François Luc on 2017-04-26.
 */

public class ItineraryFragment extends Fragment {
    EditText itinStartLocation, itinDestLocation;
    ImageButton itinerary;
    MapView itineraryMapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_itinerary, container, false);

        itinStartLocation = (EditText) container.findViewById(R.id.starttextView);
        itinDestLocation = (EditText) container.findViewById(R.id.desttextView);
        itinerary = (ImageButton) container.findViewById(R.id.itinerarybutton);
        return v;
    }
}
