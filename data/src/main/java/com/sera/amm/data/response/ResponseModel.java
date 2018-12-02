package com.sera.amm.data.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Fahmi Hakim on 9/5/17.
 */

public class ResponseModel implements Parcelable {
  @SerializedName("title") private int title;
  @SerializedName("artist") private String artist;
  @SerializedName("image") private String image;

  protected ResponseModel(Parcel in) {
    title = in.readInt();
    artist = in.readString();
    image = in.readString();
  }

  public static final Creator<ResponseModel> CREATOR = new Creator<ResponseModel>() {
    @Override public ResponseModel createFromParcel(Parcel in) {
      return new ResponseModel(in);
    }

    @Override public ResponseModel[] newArray(int size) {
      return new ResponseModel[size];
    }
  };

  public int getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getImage() {
    return image;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(title);
    dest.writeString(artist);
    dest.writeString(image);
  }
}
