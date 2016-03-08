package com.it.antares.antarescalciobalilla.adapter;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.it.antares.antarescalciobalilla.R;


public class SettingsItemAdapter extends ArrayAdapter<String>
{
    private Context _context;
    int _resourceLayout;


    private List<String> models;
    private SQLiteDatabase _sqldb;


    public SettingsItemAdapter(Context context, int resource, ArrayList<String> objects)
    {
        super(context, resource, objects);
        _context = context;
        _resourceLayout = resource;
        this.models = objects;

    }
    public List<String> GetActualModels()
    {
        return models;
    }

    @Override
    public View getView(int pos, View cnvtView, ViewGroup prnt)
    {
        return getCustomView(pos, cnvtView, prnt);
    }
    private View getCustomView(int position, View cnvtView, ViewGroup parent)
    {

        final LayoutInflater inflater = LayoutInflater.from(_context);
        View rowView = null;
        rowView = inflater.inflate(_resourceLayout, null);

        String l = getItem(position);
        // ImageView iv = (ImageView)
        // rowView.findViewById(R.id.img_type_settings);
        // iv.setImageResource(android.R.drawable.ic_dialog_info);
         TextView tv = (TextView) rowView.findViewById(R.id.description);
         tv.setText(l);
        return rowView;

    }

    @Override
    public int getCount()
    {

        return models.size();
    }

    @Override
    public String getItem(int arg0)
    {

        return models.get(arg0);
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return getCustomView(position, convertView, parent);
    }

}