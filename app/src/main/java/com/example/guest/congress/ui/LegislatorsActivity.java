package com.example.guest.congress.ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.guest.congress.R;
import com.example.guest.congress.models.Legislator;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class LegislatorsActivity extends ListActivity {
    public static final String TAG = LegislatorsActivity.class.getSimpleName();

    ArrayList<Legislator> mLegislators;

    private String mZipcode;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legislators);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        mZipcode = extras.getString("zipcode");

        Toast.makeText(this, mZipcode, Toast.LENGTH_LONG).show();

        getLegislators(mZipcode);

    }


    public void getLegislators(String zipcode){
        String apiKey = "c7dff4303dd844eeaaeebdce9ca1fa8d";

        String legislatorsURL = "https://congress.api.sunlightfoundation.com/legislators/locate?apikey=" + apiKey + "&zip=" + zipcode;

        if(isNetworkAvailable()) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(legislatorsURL)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {

                @Override
                public void onFailure(Request request, IOException e) {
                    alertUserAboutError();
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    try {String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mLegislators = getLegislatorDetails(jsonData);
                                } else {
                            alertUserAboutError();
                        }

                    } catch(IOException e) {
                        Log.e(TAG, getString(R.string.exception_caught), e);
                    }
                }
            });
        }
        else {
            Toast.makeText(this, R.string.Network_Unavailable, Toast.LENGTH_LONG).show();
        }
    }

    private ArrayList<Legislator> getLegislatorDetails(String jsonData) {



        return null;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =  manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }
}
