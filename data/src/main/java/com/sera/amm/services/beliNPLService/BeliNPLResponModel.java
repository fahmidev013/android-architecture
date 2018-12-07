package com.sera.amm.services.beliNPLService;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class BeliNPLResponModel extends BaseObservable implements Parcelable{
    @SerializedName("title") private String title;
    @SerializedName("artist") private String artist;


    public BeliNPLResponModel(String title) {
        this.title = title;
        this.artist = "taior";
    }

    public BeliNPLResponModel(Parcel in) {
        this.title = in.readString();
        this.artist = in.readString();
    }

    public static final Creator<BeliNPLResponModel> CREATOR = new Creator<BeliNPLResponModel>() {
        @Override public BeliNPLResponModel createFromParcel(Parcel in) {
            return new BeliNPLResponModel(in);
        }

        @Override public BeliNPLResponModel[] newArray(int size) {
            return new BeliNPLResponModel[size];
        }
    };


    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }


    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(title);
        dest.writeString(artist);
    }
}
