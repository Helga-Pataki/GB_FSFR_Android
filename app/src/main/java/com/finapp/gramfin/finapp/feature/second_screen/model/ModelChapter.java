package com.finapp.gramfin.finapp.feature.second_screen.model;

public class ModelChapter {

    private String chapter;
    private int numberChapter;
    private int totalOfQuestions;
    private int itemIKnow;
    private int itemIdontKnow;

    public ModelChapter(String chapter, int numberChapter) {//public ModelChapter(String chapter, int numberOfQuetions, int itemIKnow, int itemIdontKnow)
        this.chapter = chapter;
        this.numberChapter = numberChapter;
       // this.totalOfQuestions = totalOfQuestions;

        // this.itemIKnow = itemIKnow;
        // this.itemIdontKnow = itemIdontKnow;
    }

    public String getChapter() {
        return chapter;
    }

    public int getTotalOfQuestions() {
        return totalOfQuestions;
    }

    public int getItemIKnow() {
        return itemIKnow;
    }

    public int getItemIdontKnow() {
        return itemIdontKnow;
    }
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setNumberChapter(int numberChapter) {
        this.numberChapter = numberChapter;
    }

    public void setTotalOfQuestions(int totalOfQuestions) {
        this.totalOfQuestions = totalOfQuestions;
    }

    public void setItemIKnow(int itemIKnow) {
        this.itemIKnow = itemIKnow;


    }
    public void setItemIdontKnow(int itemIdontKnow) {
        this.itemIdontKnow = itemIdontKnow;
    }
}
