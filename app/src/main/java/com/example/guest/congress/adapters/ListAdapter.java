package com.example.guest.congress.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.congress.R;
import com.example.guest.congress.models.Legislator;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Guest on 11/3/15.
 */
public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Legislator> mLegislators;

    public ListAdapter(Context context, ArrayList<Legislator> legislators){
        mContext = context;
        mLegislators = legislators;
    }

    public Context getContext() {
        return mContext;
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
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.titleLabel = (TextView)convertView.findViewById(R.id.titleLabel);
            holder.firstNameLabel = (TextView)convertView.findViewById(R.id.firstNameLabel);
            holder.lastNameLabel = (TextView)convertView.findViewById(R.id.lastNameLabel);
            holder.partyLabel = (TextView)convertView.findViewById(R.id.partyLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Legislator legislator = mLegislators.get(position);
        holder.titleLabel.setText(legislator.getTitle());
        holder.firstNameLabel.setText(legislator.getFirstName());
        holder.lastNameLabel.setText(legislator.getLastName());
        holder.partyLabel.setText(legislator.getParty());

        return convertView;
    }

    private static class ViewHolder{
        TextView titleLabel;
        TextView firstNameLabel;
        TextView lastNameLabel;
        TextView partyLabel;
    }
}
