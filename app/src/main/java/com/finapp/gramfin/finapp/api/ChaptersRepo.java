package com.finapp.gramfin.finapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChaptersRepo {
    private static final String API_URL = "http://167.71.64.44/";

    private static ChaptersAPI API;
    private static ChaptersRepo instance = null;

    private ChaptersRepo() { }



    public static ChaptersAPI getAPI() {
        if (instance == null) {
            instance = new ChaptersRepo();
            API = createAdapter();
        }
        return API;
    }

    private static ChaptersAPI createAdapter() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(ChaptersAPI.class);
    }
}
