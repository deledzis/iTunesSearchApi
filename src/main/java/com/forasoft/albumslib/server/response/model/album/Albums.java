package com.forasoft.albumslib.server.response.model.album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Albums implements Serializable
{

    @SerializedName("resultCount")
    @Expose
    private int resultCount;
    @SerializedName("results")
    @Expose
    private List<AlbumPOJO> results = new ArrayList<AlbumPOJO>();
    private final static long serialVersionUID = -3305817094736123170L;

    public Albums() {
    }

    /**
     *
     * @param results list of Albums found
     * @param resultCount number of albums found
     */
    public Albums(int resultCount, List<AlbumPOJO> results) {
        super();
        this.resultCount = resultCount;
        this.results = results;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public Albums withResultCount(int resultCount) {
        this.resultCount = resultCount;
        return this;
    }

    public List<AlbumPOJO> getResults() {
        return results;
    }

    public void setResults(List<AlbumPOJO> results) {
        this.results = results;
    }

    public Albums withResults(List<AlbumPOJO> results) {
        this.results = results;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("resultCount", resultCount)
                .append("results", results)
                .toString();
    }
}