package com.nmj.androidtomatotest.server;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;

/**
 * Created by tomatomb on 15. 8. 23..
 */
public class UrlConnectionClientEx extends UrlConnectionClient {
    int connectionTimeout = 0;
    int readTimeout = 0;

    public UrlConnectionClientEx(int connectionTimeout, int readTimeout) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
    }

    @Override
    protected HttpURLConnection openConnection(Request request) throws IOException {
        HttpURLConnection connection = super.openConnection(request);
        connection.setConnectTimeout(connectionTimeout);
        connection.setReadTimeout(readTimeout);
        return connection;
    }
}

