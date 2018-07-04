package com.forasoft.albumslib.client.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Album implements Parcelable {

    private long id;
    private String artist;
    private String title;
    private String coverPath;
    private String genre;
    private String currency;
    private String link;
    private int year;
    private int price;
    private int tracksCount;
    private List<Track> tracks;

    public Album(long id,
                 String pArtist,
                 String pTitle,
                 String pCoverPath,
                 String pGenre,
                 String pCurrency,
                 String pLink,
                 int pYear,
                 int pPrice,
                 int tracksCount) {
        this.id = id;
        this.artist = pArtist;
        this.title = pTitle;
        this.coverPath = pCoverPath;
        this.genre = pGenre;
        this.currency = pCurrency;
        this.link = pLink;
        this.year = pYear;
        this.price = pPrice;
        this.tracksCount = tracksCount;
        this.tracks = new ArrayList<>(tracksCount);
    }

    private Album(Parcel in) {
        id = in.readLong();
        artist = in.readString();
        title = in.readString();
        coverPath = in.readString();
        genre = in.readString();
        currency = in.readString();
        link = in.readString();
        year = in.readInt();
        price = in.readInt();
        tracksCount = in.readInt();
        tracks = in.createTypedArrayList(Track.CREATOR);
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long pId) {
        id = pId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String pArtist) {
        artist = pArtist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String pTitle) {
        title = pTitle;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String pCoverPath) {
        coverPath = pCoverPath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String pGenre) {
        genre = pGenre;
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

    public int getYear() {
        return year;
    }

    public void setYear(int pYear) {
        year = pYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int pPrice) {
        price = pPrice;
    }

    public int getTracksCount() {
        return tracksCount;
    }

    public void setTracksCount(int pTracksCount) {
        tracksCount = pTracksCount;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> pTracks) {
        tracks = pTracks;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "\"%s\" by %s (%d) with %d tracks for %d$\nlink: %s",
                title, artist, year, tracksCount, price, link);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(artist);
        dest.writeString(title);
        dest.writeString(coverPath);
        dest.writeString(genre);
        dest.writeString(currency);
        dest.writeString(link);
        dest.writeInt(year);
        dest.writeInt(price);
        dest.writeInt(tracksCount);
        dest.writeTypedList(tracks);
    }
}
