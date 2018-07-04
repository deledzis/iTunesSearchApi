package com.forasoft.albumslib.client.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Locale;

public class Track implements Parcelable {
    private String title;
    private String currency;
    private String link;
    private long duration;
    private int price;

    public Track(String pTitle,
                 String pCurrency,
                 String pLink,
                 long pDuration,
                 int pPrice) {
        this.title = pTitle;
        this.currency = pCurrency;
        this.link = pLink;
        this.duration = pDuration;
        this.price = pPrice;
    }

    private Track(Parcel in) {
        title = in.readString();
        currency = in.readString();
        link = in.readString();
        duration = in.readLong();
        price = in.readInt();
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String pTitle) {
        this.title = pTitle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String pCurrency) {
        currency = pCurrency;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String pLink) {
        link = pLink;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long pDuration) {
        this.duration = pDuration;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int pPrice) {
        this.price = pPrice;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "\"%s\" (%d:%02d) for %d %s",
                title,
                duration / 60000 /* minutes */,
                (duration - ((duration / 60000) * 60000)) / 1000 /* seconds */,
                price,  currency);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(currency);
        dest.writeString(link);
        dest.writeLong(duration);
        dest.writeInt(price);
    }
}
