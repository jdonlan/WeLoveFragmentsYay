package com.joshdonlan.welovefragmentsyay;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.joshdonlan.welovefragmentsyay.fragments.DetailFragment;
import com.joshdonlan.welovefragmentsyay.fragments.ListNavFragment;
import com.joshdonlan.welovefragmentsyay.fragments.SpinnerNavFragment;


public class MainActivity extends Activity implements NavInterface {

    public static final String TAG ="MAINACTIVITY";

    private int mSelectedPeep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mSelectedPeep = savedInstanceState.getInt("peep");
        } else {
            mSelectedPeep = 0;
        }

        if(findViewById(R.id.navContainer).getTag().equals("portrait")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.navContainer, SpinnerNavFragment.newInstance(mSelectedPeep), SpinnerNavFragment.TAG)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .replace(R.id.navContainer, new ListNavFragment(), ListNavFragment.TAG)
                    .commit();
        }

        simonSays(mSelectedPeep);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("peep",mSelectedPeep);

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(this,SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //INTERFACE METHODS

    @Override
    public void simonSays(int peep) {
        mSelectedPeep = peep;

        getFragmentManager().beginTransaction()
                .replace(R.id.detailContainer, DetailFragment.newInstance(peep), DetailFragment.TAG)
                .commit();
    }
}
