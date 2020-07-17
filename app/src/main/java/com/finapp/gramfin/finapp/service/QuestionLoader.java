package com.finapp.gramfin.finapp.service;

import androidx.annotation.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.finapp.gramfin.finapp.api.QuestionRepo;
import com.finapp.gramfin.finapp.api.question_model.PageRestModel;
import com.finapp.gramfin.finapp.feature.authorization_fragment.view.AuthFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {

    public final static String QUESTION_COMPLETE = "OK";
    public final static String QUESTION_NOT_FOUND = "question not found";
    private static QuestionLoader instance = null;
    //  private static DataRecordRestModel retrofitDataRecord;
    private static boolean requestDone;
    private int chapter;
    private OnRequestListener listener;
    private static ArrayList<PageRestModel> pageRestModelList = new ArrayList<>();

    String token = "Bearer " + AuthFragment.token;//переделать на getSharedPreferences()


    private QuestionLoader() {
    }


    public static QuestionLoader getInstance() {
        if (instance == null) {
            instance = new QuestionLoader();
        }
        return instance;
    }


    private void loadQuestionsRest(int chapter) {
        QuestionRepo.getAPI().loadQuestions(chapter,token)
                .enqueue(new Callback<List<PageRestModel>>() {
                    @Override
                    public void onResponse(Call<List<PageRestModel>> call, Response<List<PageRestModel>> response) {
                        if (response.isSuccessful()) {

                            pageRestModelList.addAll(response.body());
                            listener.onComplete(pageRestModelList, QUESTION_COMPLETE);

                            requestDone = true;

                        } else {
                            requestDone = true;
                            listener.onComplete(null, response.code() + " " + response.message());

                        }
                    }

                    @Override
                    public void onFailure(Call<List<PageRestModel>> call, Throwable t) {
                        requestDone = true;
                        listener.onComplete(null,  t.toString());
                    }
                });
    }

    public void getDataRecord(int chapter, OnRequestListener listener) {
        //  pageRestModelList = null;
        requestDone = false;
        this.listener = listener;
        this.chapter = chapter;
        loadQuestionsRest(chapter);
    }

    public void clearCash() {
        pageRestModelList.clear();
    }

    public interface OnRequestListener {
        void onComplete(@Nullable List<PageRestModel> result, String error);
    }

}
