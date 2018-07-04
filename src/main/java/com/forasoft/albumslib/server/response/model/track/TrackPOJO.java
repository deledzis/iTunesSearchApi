
package com.forasoft.albumslib.server.response.model.track;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class TrackPOJO implements Serializable
{

    @SerializedName("wrapperType")
    @Expose
    private String wrapperType;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("artistId")
    @Expose
    private int artistId;
    @SerializedName("collectionId")
    @Expose
    private int collectionId;
    @SerializedName("trackId")
    @Expose
    private int trackId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("trackName")
    @Expose
    private String trackName;
    @SerializedName("collectionCensoredName")
    @Expose
    private String collectionCensoredName;
    @SerializedName("trackCensoredName")
    @Expose
    private String trackCensoredName;
    @SerializedName("artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    @Expose
    private String collectionViewUrl;
    @SerializedName("trackViewUrl")
    @Expose
    private String trackViewUrl;
    @SerializedName("previewUrl")
    @Expose
    private String previewUrl;
    @SerializedName("artworkUrl30")
    @Expose
    private String artworkUrl30;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    @Expose
    private int collectionPrice;
    @SerializedName("trackPrice")
    @Expose
    private int trackPrice;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("collectionExplicitness")
    @Expose
    private String collectionExplicitness;
    @SerializedName("trackExplicitness")
    @Expose
    private String trackExplicitness;
    @SerializedName("discCount")
    @Expose
    private int discCount;
    @SerializedName("discNumber")
    @Expose
    private int discNumber;
    @SerializedName("trackCount")
    @Expose
    private int trackCount;
    @SerializedName("trackNumber")
    @Expose
    private int trackNumber;
    @SerializedName("trackTimeMillis")
    @Expose
    private int trackTimeMillis;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;
    @SerializedName("isStreamable")
    @Expose
    private boolean isStreamable;
    private final static long serialVersionUID = -6573081889221202786L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TrackPOJO() {
    }

    /**
     * 
     * @param collectionExplicitness
     * @param trackCensoredName
     * @param artworkUrl60
     * @param collectionId
     * @param discCount
     * @param trackTimeMillis
     * @param collectionViewUrl
     * @param wrapperType
     * @param trackName
     * @param kind
     * @param currency
     * @param releaseDate
     * @param artistId
     * @param contentAdvisoryRating
     * @param collectionCensoredName
     * @param collectionName
     * @param trackCount
     * @param trackId
     * @param artworkUrl30
     * @param primaryGenreName
     * @param trackNumber
     * @param discNumber
     * @param country
     * @param previewUrl
     * @param trackExplicitness
     * @param artistViewUrl
     * @param trackPrice
     * @param isStreamable
     * @param artistName
     * @param artworkUrl100
     * @param trackViewUrl
     * @param collectionPrice
     */
    public TrackPOJO(String wrapperType, String kind, int artistId, int collectionId, int trackId, String artistName, String collectionName, String trackName, String collectionCensoredName, String trackCensoredName, String artistViewUrl, String collectionViewUrl, String trackViewUrl, String previewUrl, String artworkUrl30, String artworkUrl60, String artworkUrl100, int collectionPrice, int trackPrice, String releaseDate, String collectionExplicitness, String trackExplicitness, int discCount, int discNumber, int trackCount, int trackNumber, int trackTimeMillis, String country, String currency, String primaryGenreName, String contentAdvisoryRating, boolean isStreamable) {
        super();
        this.wrapperType = wrapperType;
        this.kind = kind;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.trackId = trackId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.collectionCensoredName = collectionCensoredName;
        this.trackCensoredName = trackCensoredName;
        this.artistViewUrl = artistViewUrl;
        this.collectionViewUrl = collectionViewUrl;
        this.trackViewUrl = trackViewUrl;
        this.previewUrl = previewUrl;
        this.artworkUrl30 = artworkUrl30;
        this.artworkUrl60 = artworkUrl60;
        this.artworkUrl100 = artworkUrl100;
        this.collectionPrice = collectionPrice;
        this.trackPrice = trackPrice;
        this.releaseDate = releaseDate;
        this.collectionExplicitness = collectionExplicitness;
        this.trackExplicitness = trackExplicitness;
        this.discCount = discCount;
        this.discNumber = discNumber;
        this.trackCount = trackCount;
        this.trackNumber = trackNumber;
        this.trackTimeMillis = trackTimeMillis;
        this.country = country;
        this.currency = currency;
        this.primaryGenreName = primaryGenreName;
        this.contentAdvisoryRating = contentAdvisoryRating;
        this.isStreamable = isStreamable;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public TrackPOJO withWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public TrackPOJO withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public TrackPOJO withArtistId(int artistId) {
        this.artistId = artistId;
        return this;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public TrackPOJO withCollectionId(int collectionId) {
        this.collectionId = collectionId;
        return this;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public TrackPOJO withTrackId(int trackId) {
        this.trackId = trackId;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public TrackPOJO withArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public TrackPOJO withCollectionName(String collectionName) {
        this.collectionName = collectionName;
        return this;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public TrackPOJO withTrackName(String trackName) {
        this.trackName = trackName;
        return this;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public TrackPOJO withCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
        return this;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public TrackPOJO withTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
        return this;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public TrackPOJO withArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
        return this;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public TrackPOJO withCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
        return this;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public TrackPOJO withTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
        return this;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public TrackPOJO withPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
        return this;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public TrackPOJO withArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
        return this;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public TrackPOJO withArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
        return this;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public TrackPOJO withArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
        return this;
    }

    public int getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(int collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public TrackPOJO withCollectionPrice(int collectionPrice) {
        this.collectionPrice = collectionPrice;
        return this;
    }

    public int getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(int trackPrice) {
        this.trackPrice = trackPrice;
    }

    public TrackPOJO withTrackPrice(int trackPrice) {
        this.trackPrice = trackPrice;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public TrackPOJO withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public TrackPOJO withCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
        return this;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public TrackPOJO withTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
        return this;
    }

    public int getDiscCount() {
        return discCount;
    }

    public void setDiscCount(int discCount) {
        this.discCount = discCount;
    }

    public TrackPOJO withDiscCount(int discCount) {
        this.discCount = discCount;
        return this;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(int discNumber) {
        this.discNumber = discNumber;
    }

    public TrackPOJO withDiscNumber(int discNumber) {
        this.discNumber = discNumber;
        return this;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public TrackPOJO withTrackCount(int trackCount) {
        this.trackCount = trackCount;
        return this;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public TrackPOJO withTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
        return this;
    }

    public int getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public TrackPOJO withTrackTimeMillis(int trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TrackPOJO withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public TrackPOJO withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public TrackPOJO withPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
        return this;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public TrackPOJO withContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
        return this;
    }

    public boolean isIsStreamable() {
        return isStreamable;
    }

    public void setIsStreamable(boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    public TrackPOJO withIsStreamable(boolean isStreamable) {
        this.isStreamable = isStreamable;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("wrapperType", wrapperType)
                .append("kind", kind)
                .append("artistId", artistId)
                .append("collectionId", collectionId)
                .append("trackId", trackId)
                .append("artistName", artistName)
                .append("collectionName", collectionName)
                .append("trackName", trackName)
                .append("collectionCensoredName", collectionCensoredName)
                .append("trackCensoredName", trackCensoredName)
                .append("artistViewUrl", artistViewUrl)
                .append("collectionViewUrl", collectionViewUrl)
                .append("trackViewUrl", trackViewUrl)
                .append("previewUrl", previewUrl)
                .append("artworkUrl30", artworkUrl30)
                .append("artworkUrl60", artworkUrl60)
                .append("artworkUrl100", artworkUrl100)
                .append("collectionPrice", collectionPrice)
                .append("trackPrice", trackPrice)
                .append("releaseDate", releaseDate)
                .append("collectionExplicitness", collectionExplicitness)
                .append("trackExplicitness", trackExplicitness)
                .append("discCount", discCount)
                .append("discNumber", discNumber)
                .append("trackCount", trackCount)
                .append("trackNumber", trackNumber)
                .append("trackTimeMillis", trackTimeMillis)
                .append("country", country)
                .append("currency", currency)
                .append("primaryGenreName", primaryGenreName)
                .append("contentAdvisoryRating", contentAdvisoryRating)
                .append("isStreamable", isStreamable)
                .toString();
    }

}
