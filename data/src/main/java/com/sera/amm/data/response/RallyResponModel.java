package com.sera.amm.data.response;


import java.io.Serializable;

/**
 * Created by Fahmi Hakim on 05/12/2018.
 * for SERA
 */
public class RallyResponModel  implements Serializable{
    private String title;
    private String artist;

    public RallyResponModel() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
