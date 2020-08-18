package com.finapp.gramfin.finapp.api;



import com.finapp.gramfin.finapp.api.chapters_model.ChapterRestModl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface ChaptersAPI {
    @GET("/chapters/")
    Call<List<ChapterRestModl>> loadChapters(@Header("Authorization") String token);
}
