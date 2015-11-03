package com.example.guest.congress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LegislatorsActivity extends AppCompatActivity {

    String mZipcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislators);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        mZipcode = extras.getString("zipcode");

        Toast.makeText(this, mZipcode, Toast.LENGTH_LONG).show();

    }


    public void getLegislators (int zipcode){

    }

//
// https://congress.api.sunlightfoundation.com/legislators/locate?apikey=c7dff4303dd844eeaaeebdce9ca1fa8d&zip=


//
}
