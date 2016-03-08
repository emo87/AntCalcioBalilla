package com.it.antares.antarescalciobalilla.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.it.antares.antarescalciobalilla.R;
import com.it.antares.antarescalciobalilla.adapter.SquadreAdapter;
import com.it.antares.antarescalciobalilla.model.Team;

import java.util.ArrayList;

/**
 * Created by emiliomarino on 25/02/16.
 */
public class SquadreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_squadre, container, false);
        ListView lvSquadre = (ListView)rootView.findViewById(R.id.lvSquadre);
        ArrayList<String> listaTeam=new ArrayList<String>();
     listaTeam.add("aaaa");listaTeam.add("bbbb");
        lvSquadre.setAdapter(new SquadreAdapter(getActivity(),R.layout.list_item_squadre,listaTeam));
        return rootView;
    }

    public static SquadreFragment newInstance(int position) {
        SquadreFragment f = new SquadreFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

}
