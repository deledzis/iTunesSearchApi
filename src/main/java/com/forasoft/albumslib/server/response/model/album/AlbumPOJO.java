package com.forasoft.albumslib.server.response.model.album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class AlbumPOJO implements Serializable
{

    @SerializedName("wrapperType")
    @Expose
    private String wrapperType;
    @SerializedName("collectionType")
    @Expose
    private String collectionType;
    @SerializedName("artistId")
    @Expose
    private int artistId;
    @SerializedName("collectionId")
    @Expose
    private int collectionId;
    @SerializedName("amgArtistId")
    @Expose
    private int amgArtistId;
    @SerializedName("artistName")
    @Expose
    private String artistName;
    @SerializedName("collectionName")
    @Expose
    private String collectionName;
    @SerializedName("collectionCensoredName")
    @Expose
    private String collectionCensoredName;
    @SerializedName("artistViewUrl")
    @Expose
    private String artistViewUrl;
    @SerializedName("collectionViewUrl")
    @Expose
    private String collectionViewUrl;
    @SerializedName("artworkUrl60")
    @Expose
    private String artworkUrl60;
    @SerializedName("artworkUrl100")
    @Expose
    private String artworkUrl100;
    @SerializedName("collectionPrice")
    @Expose
    private int collectionPrice;
    @SerializedName("collectionExplicitness")
    @Expose
    private String collectionExplicitness;
    @SerializedName("contentAdvisoryRating")
    @Expose
    private String contentAdvisoryRating;
    @SerializedName("trackCount")
    @Expose
    private int trackCount;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("primaryGenreName")
    @Expose
    private String primaryGenreName;
    private final static long serialVersionUID = -8999562196133617994L;

    /**
     * No args constructor for use in serialization
     *
     */
    public AlbumPOJO() {
    }

    /**
     *
     * @param collectionExplicitness
     * @param collectionType
     * @param artworkUrl60
     * @param primaryGenreName
     * @param collectionId
     * @param wrapperType
     * @param collectionViewUrl
     * @param copyright
     * @param currency
     * @param country
     * @param releaseDate
     * @param artistId
     * @param artistViewUrl
     * @param contentAdvisoryRating
     * @param artistName
     * @param collectionCensoredName
     * @param artworkUrl100
     * @param amgArtistId
     * @param collectionName
     * @param trackCount
     * @param collectionPrice
     */
    public AlbumPOJO(String wrapperType, String collectionType, int artistId, int collectionId, int amgArtistId, String artistName, String collectionName, String collectionCensoredName, String artistViewUrl, String collectionViewUrl, String artworkUrl60, String artworkUrl100, int collectionPrice, String collectionExplicitness, String contentAdvisoryRating, int trackCount, String copyright, String country, String currency, String releaseDate, String primaryGenreName) {
        super();
        this.wrapperType = wrapperType;
        this.collectionType = collectionType;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.amgArtistId = amgArtistId;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.collectionCensoredName = collectionCensoredName;
        this.artistViewUrl = artistViewUrl;
        this.collectionViewUrl = collectionViewUrl;
        this.artworkUrl60 = artworkUrl60;
        this.artworkUrl100 = artworkUrl100;
        this.collectionPrice = collectionPrice;
        this.collectionExplicitness = collectionExplicitness;
        this.contentAdvisoryRating = contentAdvisoryRating;
        this.trackCount = trackCount;
        this.copyright = copyright;
        this.country = country;
        this.currency = currency;
        this.releaseDate = releaseDate;
        this.primaryGenreName = primaryGenreName;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public AlbumPOJO withWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
        return this;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public AlbumPOJO withCollectionType(String collectionType) {
        this.collectionType = collectionType;
        return this;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public AlbumPOJO withArtistId(int artistId) {
        this.artistId = artistId;
        return this;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public AlbumPOJO withCollectionId(int collectionId) {
        this.collectionId = collectionId;
        return this;
    }

    public int getAmgArtistId() {
        return amgArtistId;
    }

    public void setAmgArtistId(int amgArtistId) {
        this.amgArtistId = amgArtistId;
    }

    public AlbumPOJO withAmgArtistId(int amgArtistId) {
        this.amgArtistId = amgArtistId;
        return this;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public AlbumPOJO withArtistName(String artistName) {
        this.artistName = artistName;
        return this;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public AlbumPOJO withCollectionName(String collectionName) {
        this.collectionName = collectionName;
        return this;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public AlbumPOJO withCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
        return this;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public AlbumPOJO withArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
        return this;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public AlbumPOJO withCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
        return this;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public AlbumPOJO withArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
        return this;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public AlbumPOJO withArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
        return this;
    }

    public int getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(int collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public AlbumPOJO withCollectionPrice(int collectionPrice) {
        this.collectionPrice = collectionPrice;
        return this;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public AlbumPOJO withCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
        return this;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public AlbumPOJO withContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
        return this;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public AlbumPOJO withTrackCount(int trackCount) {
        this.trackCount = trackCount;
        return this;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public AlbumPOJO withCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AlbumPOJO withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AlbumPOJO withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AlbumPOJO withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public AlbumPOJO withPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("wrapperType", wrapperType)
                .append("collectionType", collectionType)
                .append("artistId", artistId)
                .append("collectionId", collectionId)
                .append("amgArtistId", amgArtistId)
                .append("artistName", artistName)
                .append("collectionName", collectionName)
                .append("collectionCensoredName", collectionCensoredName)
                .append("artistViewUrl", artistViewUrl)
                .append("collectionViewUrl", collectionViewUrl)
                .append("artworkUrl60", artworkUrl60)
                .append("artworkUrl100", artworkUrl100)
                .append("collectionPrice", collectionPrice)
                .append("collectionExplicitness", collectionExplicitness)
                .append("contentAdvisoryRating", contentAdvisoryRating)
                .append("trackCount", trackCount)
                .append("copyright", copyright)
                .append("country", country)
                .append("currency", currency)
                .append("releaseDate", releaseDate)
                .append("primaryGenreName", primaryGenreName)
                .toString();
    }
}