package com.it.antares.antarescalciobalilla;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by emiliomarino on 15/03/16.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("--", "--LoginAct1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameET = (EditText) findViewById(R.id.usernameET);
        final EditText passwordET = (EditText) findViewById(R.id.passwordET);
        Button entra = (Button) findViewById(R.id.entra);
        entra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(usernameET.getText().toString(), passwordET.getText().toString(), new LogInCallback()

                {
                    public void done(ParseUser user, ParseException e)
                    {
                        if (user != null) {
                            Toast.makeText(LoginActivity.this, "loggato", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            finish();
                            startActivity(intent);
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }
                });
            }
        });


    }

}
