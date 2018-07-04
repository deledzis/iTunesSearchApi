package com.forasoft.albumslib.server.request;

import java.util.List;

public interface ApiRequestCallback<T> {
    void onSuccess(List<T> list);
    void onEmptyResponse();
    void onError(Throwable t);
}
