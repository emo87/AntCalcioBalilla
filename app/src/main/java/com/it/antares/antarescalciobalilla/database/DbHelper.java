package com.it.antares.antarescalciobalilla.database;

/**
 * Created by emiliomarino on 25/02/16.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_PATH = "/data/data/com.it.antares.antarescalciobalilla/databases/";

    public static final int DATABASE_VERSION = 1;
    private final String mDbName;


    private SQLiteDatabase myDataBase;

    private final Context myContext;

    public DbHelper(Context context, String dbName) {

        super(context, dbName, null, DATABASE_VERSION);
        this.myContext = context;
        this.mDbName = dbName;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     */
    public void createDataBase() throws IOException {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(myContext);
        Log.d("VERSION", "" + prefs.getInt("DATABASE_VERSION", 1));
        if (prefs.getInt("DATABASE_VERSION", 1) == 1) {
            this.getReadableDatabase();
            this.close();
            Log.d("DbHelper", "this.getReadableDatabase();	this.close();");

            if (!prefs.getBoolean("iscopied", false)) {
                copyDataBase();

                Log.d("em.DbHelper", "copyDataBase");
                Editor editor = prefs.edit();
                editor.putInt("DATABASE_VERSION", 2);
                editor.putBoolean("iscopied", true);
                Log.d("DbHelper", "DATABASE_VERSION " + 2 + " iscopied" + true);
                editor.commit();

            }

        } else if (prefs.getInt("DATABASE_VERSION", 1) > DATABASE_VERSION) {


        }


    }

    /**
     * Check if the database already exist to avoid re-copying the file each time
     * you open the application.
     *
     * @return true if it exists, false if it doesn't
     */


    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {

        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(mDbName);

        // Path to the just created empty db
        String outFileName = DB_PATH + mDbName;

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        // Open the database
        String myPath = DB_PATH + mDbName;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // Add your public helper methods to access and get content from the
    // database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd
    // be easy
    // to you to create adapters for your views.

}