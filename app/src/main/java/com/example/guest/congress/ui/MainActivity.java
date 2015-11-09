package com.example.guest.congress.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.guest.congress.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.zipcodeEditText) EditText mZipCodeEditText;
    @Bind(R.id.searchButton) ImageButton mSearchButton;
    @Bind(R.id.btnContact) Button mBtnContact;

    static final int PICK_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LegislatorsActivity.class);
                intent.putExtra("zipcode", mZipCodeEditText.getText().toString());
                startActivity(intent);
            }
        });

        mBtnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent pickContactIntent = new Intent(Intent.ACTION_PICK);
//                Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
//                pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
//                startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);

                Intent contactIntent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(contactIntent);
            }
        });

    }

}
