package com.example.guest.congress.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.congress.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.photoImage)ImageView mPhotoImage;
    @Bind(R.id.titleText)TextView mTitleText;
    @Bind(R.id.firstNameText) TextView mFirstNameText;
    @Bind(R.id.lastNameText) TextView mLastNameText;
    @Bind(R.id.partyText) TextView mPartyText;
    @Bind(R.id.emailText) TextView mEmailText;
    @Bind(R.id.phoneText) TextView mPhoneText;
    @Bind(R.id.officeText) TextView mOfficeText;
    @Bind(R.id.websiteText) TextView mWebsiteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        mTitleText.setText(bundle.getString("title"));
        mFirstNameText.setText(bundle.getString("first_name"));
        mLastNameText.setText(bundle.getString("last_name"));
        mPartyText.setText("( "+ bundle.getString("party") + " )");
        mEmailText.setText(bundle.getString("oc_email"));
        mPhoneText.setText(bundle.getString("phone"));
        mOfficeText.setText(bundle.getString("office"));
        mWebsiteText.setText(bundle.getString("website"));

    }

}


// "bioguide_id"  -> photo
