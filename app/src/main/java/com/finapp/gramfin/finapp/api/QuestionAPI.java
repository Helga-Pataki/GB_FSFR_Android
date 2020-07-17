package com.finapp.gramfin.finapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

import com.finapp.gramfin.finapp.api.question_model.PageRestModel;

import java.util.List;

public interface QuestionAPI {
    @GET("/question/{chapter}")
    Call<List<PageRestModel>> loadQuestions(@Path("chapter") int chapterForTraining, @Header("Authorization") String token);
}
