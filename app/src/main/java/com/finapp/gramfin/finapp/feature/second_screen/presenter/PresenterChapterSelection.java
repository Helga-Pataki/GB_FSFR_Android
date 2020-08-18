package com.finapp.gramfin.finapp.feature.second_screen.presenter;

import android.os.Bundle;

import com.finapp.gramfin.finapp.api.ChaptersRepo;
import com.finapp.gramfin.finapp.api.chapters_model.ChapterRestModl;
import com.finapp.gramfin.finapp.feature.authorization_fragment.view.AuthFragment;
import com.finapp.gramfin.finapp.feature.question_viewpager.QuestionViewpagerFragment;
import com.finapp.gramfin.finapp.feature.second_screen.model.ModelChapter;
import com.finapp.gramfin.finapp.service.FragmentRouter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterChapterSelection {

    private IFragmentChooseChapter ifragmentChooseChapter;
    private List<ModelChapter> listChapters = new ArrayList<>();
    String token = "Bearer " + AuthFragment.token;
    private List<ChapterRestModl> chapterRESTModelsList = new ArrayList<>();



    public PresenterChapterSelection(IFragmentChooseChapter ifragmentChooseChapter) {
        this.ifragmentChooseChapter = ifragmentChooseChapter;
        setModelChapters();
    }

    private void setModelChapters() {
        ChaptersRepo.getAPI().loadChapters(token) //TODO перенести в лоадер
                .enqueue(new Callback<List<ChapterRestModl>>() {
                    @Override
                    public void onResponse(Call<List<ChapterRestModl>> call, Response<List<ChapterRestModl>> response) {
                        chapterRESTModelsList.addAll(response.body());
                        if (chapterRESTModelsList != null) {
                            for (ChapterRestModl item : chapterRESTModelsList) {
                                ModelChapter model = new ModelChapter(item.getName(), item.getNumber());

                                listChapters.add(model);
                            }
                        }

                        ifragmentChooseChapter.setChapters(listChapters);
                    }

                    @Override
                    public void onFailure(Call<List<ChapterRestModl>> call, Throwable t) {

                        //TODO

                    }
                });



    }

    public void callBackIdModelChapters(int id) {
        int chapterForTraining = id+1;
        Bundle bundle = new Bundle();
        bundle.putInt("chapterForTraining",chapterForTraining);
        FragmentRouter.getInstance().placeFragment(QuestionViewpagerFragment.class, bundle);

    }


}
