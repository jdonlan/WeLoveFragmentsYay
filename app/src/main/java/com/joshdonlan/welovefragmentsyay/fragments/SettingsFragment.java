package com.joshdonlan.welovefragmentsyay.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.joshdonlan.welovefragmentsyay.R;

/**
 * Created by jdonlan on 11/10/14.
 */
public class SettingsFragment extends PreferenceFragment {

    public static final String TAG = "PREFERNCE_FRAGMENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }
}
