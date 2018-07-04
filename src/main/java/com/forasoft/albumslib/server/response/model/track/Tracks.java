
package com.forasoft.albumslib.server.response.model.track;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tracks implements Serializable
{

    @SerializedName("resultCount")
    @Expose
    private int resultCount;
    @SerializedName("results")
    @Expose
    private List<TrackPOJO> results = new ArrayList<TrackPOJO>();
    private final static long serialVersionUID = -3830577716379104147L;

    public Tracks() {
    }

    /**
     * 
     * @param results List of POJO Track objects
     * @param resultCount amount of tracks
     */
    public Tracks(int resultCount, List<TrackPOJO> results) {
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

    public Tracks withResultCount(int resultCount) {
        this.resultCount = resultCount;
        return this;
    }

    public List<TrackPOJO> getResults() {
        return results;
    }

    public void setResults(List<TrackPOJO> results) {
        this.results = results;
    }

    public Tracks withResults(List<TrackPOJO> results) {
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
