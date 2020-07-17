package com.finapp.gramfin.finapp.api.question_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionRESTModel {
    @SerializedName("number")@Expose int dataNumber;
    @SerializedName("subject")@Expose String dataSubject;
    @SerializedName("cod")@Expose String dataCod;

    public int getDataNumber() {
        return dataNumber;
    }

    public String getDataSubject() {
        return dataSubject;
    }

    public String getDataCod() {
        return dataCod;
    }
}
