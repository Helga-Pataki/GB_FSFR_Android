package com.finapp.gramfin.finapp.feature.question_viewpager.presenter;

import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;

import java.util.List;

public interface IQuestionViewpager {
    void setQuestion(List<ModelQuestion> listQuestion);

    void gotoNextPage();

    void setRedColor(int choice);

    void setGreenolor(int choice);

}
