package com.it.antares.antarescalciobalilla.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.it.antares.antarescalciobalilla.R;
import com.parse.ParseUser;

/**
 * Created by emiliomarino on 25/02/16.
 */
public class PrimoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
       View rootView=(View) inflater.inflate(R.layout.test_fragm, container, false);
        TextView tv=(TextView)rootView.findViewById(R.id.nome_utente);
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null)
        tv.setText("Ciao "+ currentUser.getUsername());

        return rootView;
    }

    public static PrimoFragment newInstance(int position) {
        PrimoFragment f = new PrimoFragment();
        return f;
    }

}
