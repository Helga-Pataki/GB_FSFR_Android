package com.finapp.gramfin.finapp.api.chapters_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChapterRestModl {
    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("name")
    @Expose
    private String name;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

}
