package com.nmj.att.server;

import com.nmj.att.util.Logger;

import retrofit.RestAdapter;

public class ServerAdapter {
    private static RestAdapter adapter = null;
    private static String SLH_SERVER_URL        = "http://jsonplaceholder.typicode.com";

    public static RestAdapter getAdapter() {
        if (null == adapter) {
//            RequestInterceptor requestInterceptor = new RequestInterceptor() {
//                @Override
//                public void intercept(RequestInterceptor.RequestFacade request) {
//                    request.addHeader("Cookie", "set a cookie");
//                }
//            };

            adapter = new RestAdapter.Builder()
                    .setEndpoint(SLH_SERVER_URL)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setLog(a -> Logger.log("tomato_retrofit", a))
                    .setClient(new UrlConnectionClientEx(8 * 1000, 12 * 1000))
//                    .setRequestInterceptor(requestInterceptor)
                    .build();
        }

        return adapter;
    }
}
