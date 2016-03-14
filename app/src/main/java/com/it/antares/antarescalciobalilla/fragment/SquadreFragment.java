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
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliomarino on 25/02/16.
 */
public class SquadreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_squadre, container, false);
        final ListView lvSquadre = (ListView)rootView.findViewById(R.id.lvSquadre);
        //ArrayList<String> listaTeam=new ArrayList<String>();
        //listaTeam.add("aaaa");listaTeam.add("bbbb");
        ParseQuery<Team> query = ParseQuery.getQuery(Team.class);
        query.findInBackground(new FindCallback<Team>() {

            @Override
            public void done(List<Team> teams, ParseException error) {
                if (teams != null) {
                    //mAdapter.clear();
                    //mAdapter.addAll(tasks);
                    lvSquadre.setAdapter(new SquadreAdapter(getActivity(), R.layout.list_item_squadre, teams));
                }
            }
        });
        //lvSquadre.setAdapter(new SquadreAdapter(getActivity(),R.layout.list_item_squadre,listaTeam));
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
