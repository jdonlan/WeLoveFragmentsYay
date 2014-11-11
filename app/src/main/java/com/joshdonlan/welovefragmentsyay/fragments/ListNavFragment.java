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
import android.widget.ListView;

import com.joshdonlan.welovefragmentsyay.NavInterface;
import com.joshdonlan.welovefragmentsyay.R;

/**
 * Created by jdonlan on 11/10/14.
 */
public class ListNavFragment extends Fragment {

    public static final String TAG = "LIST_NAV_FRAGMENT";

    private NavInterface mListener;

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

        return inflater.inflate(R.layout.listnav_fragment,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView) getActivity().findViewById(R.id.navlist);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.peeps));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG, "You have selected: " + i);

                mListener.simonSays(i);
            }
        });
    }
}
