package com.finapp.gramfin.finapp.api.question_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllAnswerRestModel {
    @SerializedName("a")@Expose public List<String> dataPossibleVariantA;
    @SerializedName("b")@Expose public List<String> dataPossibleVariantB;
    @SerializedName("c")@Expose public List<String> dataPossibleVariantC;
    @SerializedName("d")@Expose public List<String> dataPossibleVariantD;
    @SerializedName("e")@Expose public List<String> dataPossibleVariantE;
}
