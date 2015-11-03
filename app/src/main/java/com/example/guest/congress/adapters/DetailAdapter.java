package com.example.guest.congress.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.guest.congress.models.Legislator;

import java.util.ArrayList;

/**
 * Created by Guest on 11/3/15.
 */

class DetailAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Legislator> mLegislators;

    public DetailAdapter(Context context, ArrayList<Legislator> legislators){
        this.context = context;
        this.mLegislators = legislators;
    }

    @Override
    public int getCount() {
        return mLegislators.size();
    }

    @Override
    public Object getItem(int position) {
        return mLegislators.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
