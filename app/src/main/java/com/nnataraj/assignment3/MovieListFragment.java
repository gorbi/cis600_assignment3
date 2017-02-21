package com.nnataraj.assignment3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends Fragment {

    private static final String ARG_BUTTON_NUMBER = "button_number";
    private static int indexFrag = 0;

    public MovieListFragment() {
        // Required empty public constructor
    }

    public static MovieListFragment newInstance(int button, int index) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BUTTON_NUMBER, button);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        final HandleNavigationListener handleNavigationListener;
        try {
            handleNavigationListener = (HandleNavigationListener) rootView.getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException("Hosting activity error");

        }
        TextView indexText = (TextView) rootView.findViewById(R.id.index);
        indexText.setText(String.valueOf(indexFrag));
        Button next = (Button) rootView.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexFrag < new MovieData().getSize()) {
                    handleNavigationListener.navigate(R.id.next, indexFrag);
                    indexFrag++;
                }

            }
        });
        Button previous = (Button) rootView.findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexFrag > 1) {
                    --indexFrag;
                    handleNavigationListener.navigate(R.id.previous, indexFrag - 1);
                }
            }
        });


        return rootView;
    }

}
