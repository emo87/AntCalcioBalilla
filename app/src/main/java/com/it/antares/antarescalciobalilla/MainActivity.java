package com.it.antares.antarescalciobalilla;


import android.app.ActionBar;
import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.it.antares.antarescalciobalilla.adapter.SettingsItemAdapter;
import com.it.antares.antarescalciobalilla.database.DbHelper;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends Activity {

    private ActionBarDrawerToggle mDrawerToggle;
    ViewPager mViewPager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> fragmentTitles;
    private PagerAdapter mSectionsPagerAdapter;
    private static DbHelper mDb;
    private SQLiteDatabase sqlDb;
    private String player_table;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Object mSettings;

    private LayoutInflater _inflater;
    private String objectId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetActionBar();
        setContentView(R.layout.activity_main);

        //INIZIALIZZAZIONE DATABASE
        SetDatabase("biliardino.db");
        sqlDb = mDb.getReadableDatabase();
        //DRAWERLAYOUT

        SetDrawerLayout();

    }
    private void SetActionBar()
    {
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);

            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setLogo(android.R.color.transparent);
            // actionBar.setBackgroundDrawable(getResources().getDrawable((R.drawable.actionbar)));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (mDrawerToggle.onOptionsItemSelected(item))
        {

            invalidateOptionsMenu();
            return true;

        }
        return true;

    }


    private void SetDatabase(String db) {
        mDb = new DbHelper(MainActivity.this, db);

        try {

            mDb.createDataBase();
            mDb.close();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            mDb.openDataBase();


        } catch (SQLException e) {

            throw e;
        } catch (java.sql.SQLException e) {

            e.printStackTrace();
        }

    }

    private void SetDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        ArrayList<String> menuString = new ArrayList<String>();
        menuString.add("OPZIONE 1");
        menuString.add("OPZIONE 2");
        menuString.add("OPZIONE 3");

        // Set the adapter for the list view
        mDrawerList.setAdapter(new SettingsItemAdapter(this, R.layout.list_item_settings, menuString));
        // Set the list's click listenermDrawerToggle

        mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
                mDrawerLayout, /* DrawerLayout object */
                R.drawable.ic_drawer, /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open, /* "open drawer" description for accessibility */
                R.string.drawer_close /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle("Invia Formazione Fantacalcio");
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle("Impostazioni");
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //
                        break;

                }

            }


        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.setClickable(true);




    }

}
