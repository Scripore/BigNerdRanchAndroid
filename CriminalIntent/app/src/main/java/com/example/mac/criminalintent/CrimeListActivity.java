package com.example.mac.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mac on 7/2/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
