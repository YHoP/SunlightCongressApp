package com.example.guest.congress.models;


/**
 * Created by Guest on 11/3/15.
 */
public class Legislator {

    private static String mFirstName, mLastName, mParty, mTitle;

    public Legislator(String firstName, String lastName, String party, String title){
        mFirstName = firstName;
        mLastName = lastName;
        mParty = party;
        mTitle = title;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getParty() {
        return mParty;
    }

    public void setParty(String party) {
        this.mParty = party;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }


}
