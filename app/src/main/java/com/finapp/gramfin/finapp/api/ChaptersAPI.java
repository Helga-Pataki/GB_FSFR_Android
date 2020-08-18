package com.finapp.gramfin.finapp.api;



import com.finapp.gramfin.finapp.api.chapters_model.ChaptersRestMod1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface ChaptersAPI {
    @GET("/chapters/")
    Call<List<ChaptersRestMod1>> loadChapters(@Header("Authorization") String token);
}
