package com.example.francoisluc.ift2905_projet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by François Luc on 2017-04-26.
 */

public class SimpleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args =getArguments();
        int fragmentId = args.getInt("id");
        View v = null;
        switch(fragmentId) {
            case 0:
                v=inflater.inflate(R.layout.content_bixi, container, false);
                break;
            case 1:
                v=inflater.inflate(R.layout.content_docks, container, false);
                break;
            case 2:
                v=inflater.inflate(R.layout.content_itinerary, container, false);
                break;
            default:break;
        }

        return v;
    }
}
