package com.finapp.gramfin.finapp.api.question_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageRestModel {

    @SerializedName("chapter")
    @Expose
    public ChapterRESTModel dataChapter;
    @SerializedName("theme")
    @Expose
    public ThemeRESTModel dataTheme;
    @SerializedName("question")
    @Expose
    public QuestionRESTModel dataQuestion;
    @SerializedName("answers")
    @Expose
    public AllAnswerRestModel dataAnswers;

}
