package com.it.antares.antarescalciobalilla;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by emiliomarino on 15/03/16.
 */
public class LoginActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("--", "--LoginAct1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

}
