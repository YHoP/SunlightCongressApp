package com.example.guest.congress.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.congress.R;
import com.koushikdutta.ion.Ion;

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

    String mPhoneNumber;
    String mAddress;
    String [] addressArray;
    String mZipcode;
    String mWebsite;

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

        mPhoneNumber = bundle.getString("phone");
        mPhoneText.setText(mPhoneNumber);
        mPhoneNumber = "tel:" + mPhoneNumber;

        mAddress = bundle.getString("office");
        mOfficeText.setText(mAddress);
        addressArray = mAddress.split(" ");
        mZipcode = bundle.getString("zipcode");

        mWebsite = bundle.getString("website");
        mWebsiteText.setText(mWebsite);

        String photoUrl = "https://theunitedstates.io/images/congress/225x275/" + bundle.getString("bioguide_id") + ".jpg";
        Ion.with(mPhotoImage)
                //.placeholder(R.drawable.person)
                .load(photoUrl);


        mPhoneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse(mPhoneNumber);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        mOfficeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoLocation = "geo:0,0?q=";

                for (int i = 0; i < addressArray.length; i++){
                    geoLocation += addressArray[i];
                    geoLocation += "+";
                }

                geoLocation += mZipcode;
                // http://ziptasticapi.com/

                Uri location = Uri.parse(geoLocation);

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });

        mWebsiteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse(mWebsite);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });

    }

}
