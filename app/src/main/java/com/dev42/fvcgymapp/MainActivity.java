package com.dev42.fvcgymapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Dialog onCreateDialog(int id){
        // show disclaimer....
        // for example, you can show a dialog box...
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage( R.string.disclaimerText)
                .setCancelable(false)
                .setPositiveButton("Agree", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // and, if the user accept, you can execute something like this:
                        // We need an Editor object to make preference changes.
                        // All objects are from android.context.Context
                        SharedPreferences settings = getSharedPreferences("prefs", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean("accepted", true);
                        // Commit the edits!
                        editor.commit();
                    }
                })
                .setNegativeButton("Disagree", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.exit(0);
                    }
                });
        AlertDialog alert = builder.create();
        return alert;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean accepted = settings.getBoolean("accepted", false);
        if( !accepted ){
            showDialog(0);
        }

        Button btn2 = (Button)findViewById(R.id.button2);
        Button btnDisclaimer = (Button)findViewById(R.id.btnDisclaimer);
        Button btnDisclaimerV2 = (Button)findViewById(R.id.btnDisclaimerV2);


           btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Exercises.class));
            }
        });

        btnDisclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });

        btnDisclaimerV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisclaimerV2.class));
            }
        });



    }
}
