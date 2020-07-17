package com.finapp.gramfin.finapp.feature.question_viewpager.presenter;

import com.finapp.gramfin.finapp.api.question_model.AllAnswerRestModel;

import com.finapp.gramfin.finapp.api.question_model.PageRestModel;

import com.finapp.gramfin.finapp.feature.question_viewpager.model.ModelQuestion;
import com.finapp.gramfin.finapp.service.QuestionLoader;

import java.util.ArrayList;
import java.util.List;


import androidx.annotation.Nullable;

public class PresenterQuestionViewpager {
    private static final int QUESTIONS_AMOUNT = 221;
    private static final int QUESTIONS_NEEDED = 10;

    private int chapter_id;
    private IQuestionViewpager iQuestionViewpager;
    private List<ModelQuestion> questionList = new ArrayList<>();


    public PresenterQuestionViewpager(IQuestionViewpager iQuestionViewpager, int chapter_id) {
        this.iQuestionViewpager = iQuestionViewpager;
        this.chapter_id = chapter_id;
        addModelQuestions();
    }

    public String calcRightAnswersAmount() {
        int result = 0;

        for (ModelQuestion model : questionList) {
            if (model.getHaveRightChoice()) result++;
        }

        return String.valueOf(new StringBuilder().append(result).append(" / ").append(QUESTIONS_NEEDED));
    }


    private void addModelQuestions() {
        QuestionLoader.getInstance()
                .getDataRecord(chapter_id, new QuestionLoader.OnRequestListener() {
                    @Override
                    public void onComplete(@Nullable List<PageRestModel> result, String error) {


                        if (result != null) {
                            for (PageRestModel item : result) {
                                ModelQuestion model = new ModelQuestion(chapter_id, item.dataQuestion.getDataSubject(), item.dataAnswers);
                                model.setChapterName(item.dataChapter.name);
                                if (item.dataTheme != null) {
                                    model.setTopicName(item.dataTheme.getName());
                                }
                                questionList.add(model);
                            }


                        } else if (!error.equals(QuestionLoader.QUESTION_NOT_FOUND)) {
                            ModelQuestion model = new ModelQuestion(chapter_id, error, new AllAnswerRestModel());
                            questionList.add(model);
                        }

                        if (questionList.size() == QUESTIONS_NEEDED) {
                            QuestionLoader.getInstance().clearCash();
                            iQuestionViewpager.setQuestion(questionList);
                        } else addModelQuestions();
                    }
                });
    }

    private void setAnswer(ModelQuestion modelQuestion, int choice) {
        modelQuestion.setUserChoice(choice);
        iQuestionViewpager.gotoNextPage();
    }

    public void callBack(int id, int choice) {
        ModelQuestion modelQuestion = questionList.get(id);
        setAnswer(modelQuestion, choice);
    }
}
