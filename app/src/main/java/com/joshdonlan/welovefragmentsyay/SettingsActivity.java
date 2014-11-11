package com.joshdonlan.welovefragmentsyay;

import android.app.Activity;
import android.os.Bundle;

import com.joshdonlan.welovefragmentsyay.fragments.SettingsFragment;

/**
 * Created by jdonlan on 11/10/14.
 */
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getFragmentManager().beginTransaction()
                .replace(R.id.settingsContainer, new SettingsFragment(), SettingsFragment.TAG)
                .commit();
    }
}
