package com.sera.amm.services.rallyService;


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
public class RallyResponModel extends BaseObservable implements Parcelable{
    @SerializedName("title") private String title;
    @SerializedName("artist") private String artist;


    public RallyResponModel(String title) {
        this.title = title;
        this.artist = "taior";
    }

    public RallyResponModel(Parcel in) {
        this.title = in.readString();
        this.artist = in.readString();
    }

    public static final Creator<RallyResponModel> CREATOR = new Creator<RallyResponModel>() {
        @Override public RallyResponModel createFromParcel(Parcel in) {
            return new RallyResponModel(in);
        }

        @Override public RallyResponModel[] newArray(int size) {
            return new RallyResponModel[size];
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
