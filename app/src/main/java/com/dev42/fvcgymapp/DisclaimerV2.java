package com.dev42.fvcgymapp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class DisclaimerV2 extends AppCompatActivity {

    int checkboxes []= {R.id.checkBox,R.id.checkBox2, R.id.checkBox3, R.id.checkBox4, R.id.checkBox5,
            R.id.checkBox6,R.id.checkBox7,R.id.checkBox8,R.id.checkBox10,R.id.checkBox11,R.id.checkBox12,
            R.id.checkBox14,R.id.checkBox15
    };
    boolean check = false;
    CheckBox cb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer_v2);





        Button btn = (Button)findViewById(R.id.buttonDisclaimer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean notChecked= false;
                for (int i=0; i<checkboxes.length; i++)
                {
                    cb= (CheckBox)findViewById(checkboxes[i]);
                    if (cb.isChecked()) {
                        Log.e("check", "Checkboxes checked");
                       Snackbar mySnackbar = Snackbar.make(findViewById(android.R.id.content),"Checkbox checked", Snackbar.LENGTH_SHORT);
                        mySnackbar.show();
                        notChecked=false;
                         break;
                    } else {
                        notChecked= true;
                    }
                }
                if (notChecked)
                {
                    Log.e("check", "checkboxes not checked");
                    Snackbar mySnackbar2 = Snackbar.make(findViewById(android.R.id.content),"Checkbox NOT checked", Snackbar.LENGTH_SHORT);
                    mySnackbar2.show();
                }
            }
        });


    }
}
