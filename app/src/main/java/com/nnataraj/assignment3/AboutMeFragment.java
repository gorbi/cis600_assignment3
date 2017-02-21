package com.nnataraj.assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeFragment extends Fragment {

    private static final String ARG_BUTTON_NUMBER = "button_number";

    public AboutMeFragment() {

    }

    public static AboutMeFragment newInstance(int button) {
        AboutMeFragment fragment = new AboutMeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BUTTON_NUMBER,button);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_about_me, container, false);
        return rootView;
    }

}
