package com.forasoft.albumslib.server.request;

import android.support.annotation.NonNull;
import com.forasoft.albumslib.server.ITunesSearchAPI;
import com.forasoft.albumslib.server.response.model.album.AlbumPOJO;
import com.forasoft.albumslib.server.response.model.album.Albums;
import com.forasoft.albumslib.server.response.model.track.TrackPOJO;
import com.forasoft.albumslib.server.response.model.track.Tracks;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.forasoft.albumslib.client.util.App.ITUNES_SEARCH_API_BASE_URL;

public class Caller {
    public static final Caller INSTANCE = new Caller();

    private Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(ITUNES_SEARCH_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private ITunesSearchAPI miTunesSearchAPI = mRetrofit.create(ITunesSearchAPI.class);

    public void searchAlbum(String term, final ApiRequestCallback<AlbumPOJO> callback) {
        miTunesSearchAPI.searchAlbums(term).enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(@NonNull Call<Albums> call,
                                   @NonNull Response<Albums> response) {
                if (response.body() != null) {
                    if (response.body().getResults().size() > 0) {
                        callback.onSuccess(response.body().getResults());
                    }
                    else {
                        callback.onEmptyResponse();
                    }
                }
                else {
                    // TODO
                }
            }

            @Override
            public void onFailure(@NonNull Call<Albums> call,
                                  @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void lookupTracks(long id, final ApiRequestCallback<TrackPOJO> callback) {
        miTunesSearchAPI.lookupAlbumTracks(id).enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(@NonNull Call<Tracks> call,
                                   @NonNull Response<Tracks> response) {
                if (response.body() != null) {
                    if (response.body().getResults().size() > 0) {
                        callback.onSuccess(response.body().getResults().subList(1, response.body().getResults().size()));
                    }
                    else {
                        callback.onEmptyResponse();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Tracks> call,
                                  @NonNull Throwable t) {
                callback.onError(t);
            }
        });
    }
}
