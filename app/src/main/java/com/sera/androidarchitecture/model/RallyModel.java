package com.sera.androidarchitecture.model;



import java.io.Serializable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class RallyModel extends BaseObservable implements Serializable{




    private String title;

    private String artist;

    public RallyModel(String s) {
        this.title = s;
    }



    @Bindable
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
