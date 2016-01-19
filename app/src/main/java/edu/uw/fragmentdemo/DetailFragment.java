package edu.uw.fragmentdemo;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uw.fragmentdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        Bundle bundle = getArguments();

        if(bundle != null) {
            TextView titleView = (TextView) rootView.findViewById(R.id.txtMovieTitle);
            TextView imdbView = (TextView) rootView.findViewById(R.id.txtMovieIMDB);

            titleView.setText(bundle.getString("title"));
            imdbView.setText(bundle.getString("imdb"));
        }

        return rootView;
    }

}
