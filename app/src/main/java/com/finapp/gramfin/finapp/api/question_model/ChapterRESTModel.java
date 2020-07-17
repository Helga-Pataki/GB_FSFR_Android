package com.finapp.gramfin.finapp.api.question_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

 public class ChapterRESTModel {
    @SerializedName("number") @Expose public int number ;
    @SerializedName("name")@Expose public String name;
}
