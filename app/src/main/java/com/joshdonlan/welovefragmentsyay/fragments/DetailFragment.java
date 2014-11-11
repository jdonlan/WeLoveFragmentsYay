package com.joshdonlan.welovefragmentsyay.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joshdonlan.welovefragmentsyay.R;

/**
 * Created by jdonlan on 11/10/14.
 */
public class DetailFragment extends Fragment {

    public static final String TAG = "DETAIL_FRAGMENT";

    public static DetailFragment newInstance(int peep){
        DetailFragment frag = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("peep",peep);
        frag.setArguments(args);
        return frag;
    }

//    public DetailFragment(){
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] peeps = getResources().getStringArray(R.array.peeps);
        Bundle args = getArguments();
        if(args != null) {
            String peep = peeps[args.getInt("peep")];
            ((TextView) getActivity().findViewById(R.id.firstname)).setText(peep);
        }
    }
}
