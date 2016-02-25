package com.it.antares.antarescalciobalilla.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.antares.antarescalciobalilla.R;

/**
 * Created by emiliomarino on 25/02/16.
 */
public class PrimoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.test_fragm, container, false);


    }

    public static PrimoFragment newInstance(int position) {
        PrimoFragment f = new PrimoFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

}
