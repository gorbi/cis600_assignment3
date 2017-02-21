package com.nnataraj.assignment3;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class FrontPageActivityFragment extends Fragment {

    private static final String ARG_BUTTON_NUMBER = "button_number";

    public FrontPageActivityFragment() {
    }

    public static FrontPageActivityFragment newInstance(int button) {
        FrontPageActivityFragment fragment = new FrontPageActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BUTTON_NUMBER, button);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_front_page, container, false);

        Button aboutMe = (Button) rootView.findViewById(R.id.button_about_me);
        Button task2 = (Button) rootView.findViewById(R.id.button_task_2);
        Button task3 = (Button) rootView.findViewById(R.id.button_task_3);

        final HandleNavigationListener handleNavigationListener;
        try {
            handleNavigationListener = (HandleNavigationListener) rootView.getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException("Hosting activity error");

        }

        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNavigationListener.navigationToItemSelected(R.id.button_about_me);
            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNavigationListener.navigationToItemSelected(R.id.button_task_2);
            }
        });

        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNavigationListener.navigationToItemSelected(R.id.button_task_3);
            }
        });

        return rootView;
    }


}
