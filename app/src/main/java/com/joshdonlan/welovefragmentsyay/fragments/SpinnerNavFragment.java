package com.joshdonlan.welovefragmentsyay.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.joshdonlan.welovefragmentsyay.MainActivity;
import com.joshdonlan.welovefragmentsyay.NavInterface;
import com.joshdonlan.welovefragmentsyay.R;

/**
 * Created by jdonlan on 11/10/14.
 */
public class SpinnerNavFragment extends Fragment {

    public static final String TAG = "SPINNER_NAV_FRAGMENT";

    private NavInterface mListener;

    public static SpinnerNavFragment newInstance(int peep){
        SpinnerNavFragment frag = new SpinnerNavFragment();
        Bundle args = new Bundle();
        args.putInt("peep", peep);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof NavInterface){ //Hey activity do you implement NavInterface?
            mListener = (NavInterface) activity;
        } else {
            throw new IllegalArgumentException("This guy is trying to molest me.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.spinnernav_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Spinner spinner = (Spinner) getActivity().findViewById(R.id.navspinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.peeps));
        spinner.setAdapter(adapter);
        Bundle args = getArguments();
        if(args != null){
            spinner.setSelection(args.getInt("peep"));
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG,"You have selected: " + i);

                mListener.simonSays(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
