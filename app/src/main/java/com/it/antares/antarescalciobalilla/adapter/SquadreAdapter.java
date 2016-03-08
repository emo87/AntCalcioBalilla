package com.it.antares.antarescalciobalilla.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.it.antares.antarescalciobalilla.R;


import java.util.List;

/**
 * Created by Fabio on 08/03/2016.
 */
public class SquadreAdapter extends ArrayAdapter<String> {

    private int mResource;
    private LayoutInflater mInflater;
    private List<String> mObjects;

    public SquadreAdapter(Context context, int resource, List<String> objects) {

        super(context, resource, objects);
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mObjects = objects;
    }

    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt) {
        String str = mObjects.get(pos);
        cnvtView= mInflater.inflate(mResource,null);
        TextView tv = (TextView) cnvtView.findViewById(R.id.textView2);
        tv.setText(str);


        return cnvtView;
    }
}
