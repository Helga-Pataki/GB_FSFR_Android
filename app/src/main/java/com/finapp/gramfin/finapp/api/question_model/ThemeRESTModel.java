package com.finapp.gramfin.finapp.api.question_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThemeRESTModel {

     @SerializedName("number") @Expose int number;
     @SerializedName("name")@Expose String name;

     public int getNumber() {
          return number;
     }

     public String getName() {
          return name;
     }
}
