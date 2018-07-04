package com.forasoft.albumslib.server;

import com.forasoft.albumslib.server.response.model.album.Albums;
import com.forasoft.albumslib.server.response.model.track.Tracks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITunesSearchAPI {
    @GET("search?country=ru&media=music&entity=album&attribute=albumTerm&limit=20")
    Call<Albums> searchAlbums(@Query("term") String term);

    @GET("lookup?country=ru&attribute=albumTerm&entity=song")
    Call<Tracks> lookupAlbumTracks(@Query("id") long albumId);
}
