package com.finapp.gramfin.finapp.feature.question_viewpager.model;

import com.finapp.gramfin.finapp.api.question_model.AllAnswerRestModel;

import java.util.ArrayList;
import java.util.List;

public class ModelQuestion {

    private int chapter_id;
    private String chapterName;
    private String topicName;
    private int id;
    private int userChoice;
    private boolean haveRightChoice;
    private String caption;
    private AllAnswerRestModel answers;
    private ArrayList<AnswerVariant> answersList = new ArrayList<>();

     public class AnswerVariant {


        private String answerVariant;
        private int correct;

        public AnswerVariant(String answerVariant, int correct) {
            this.answerVariant = answerVariant;
            this.correct = correct;
        }

        public void setAnswerVariant(String answerVariant) {
            this.answerVariant = answerVariant;
        }

        public void setCorrect(int correct) {
            this.correct = correct;
        }


        public String getAnswerVariant() {
            return answerVariant;
        }

        public int getCorrect() {
            return correct;
        }
    }
    public ModelQuestion(int chapter_id, String caption, AllAnswerRestModel answers) {
        this.chapter_id = chapter_id;
        this.answers = answers;
        this.caption = caption;


        answersList.add(new AnswerVariant(answers.dataPossibleVariantA.get(0),Integer.parseInt(answers.dataPossibleVariantA.get(1))));
        answersList.add(new AnswerVariant(answers.dataPossibleVariantB.get(0),Integer.parseInt(answers.dataPossibleVariantB.get(1))));
        answersList.add(new AnswerVariant(answers.dataPossibleVariantC.get(0),Integer.parseInt(answers.dataPossibleVariantC.get(1))));
        answersList.add(new AnswerVariant(answers.dataPossibleVariantD.get(0),Integer.parseInt(answers.dataPossibleVariantD.get(1))));
       // answersList.add(new AnswerVariant(answers.dataPossibleVariantE.get(0),Integer.parseInt(answers.dataPossibleVariantE.get(1))));

        setUserChoice(-1);
    }

    public int getChapterId() {
        return chapter_id;
    }


    public int getUserChoice() {
        return userChoice;
    }

    public String getCaption() {
        return caption;
    }

    public String getChapterName() {
        return chapterName;
    }

    public String getTopicName() {
        return topicName;
    }

    public boolean getHaveRightChoice() {
        return haveRightChoice;
    }

    public AllAnswerRestModel getAnswers() {
        return answers;
    }

    public List<AnswerVariant> getAnswersList() {
        return answersList;
    }



    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;

        int choseId = 0;
        switch (userChoice) {
            case 1:
                choseId = Integer.parseInt(answers.dataPossibleVariantA.get(1));
            case 2:
                choseId = Integer.parseInt(answers.dataPossibleVariantB.get(1));
            case 3:
                choseId = Integer.parseInt(answers.dataPossibleVariantC.get(1));
            case 4:
                choseId = Integer.parseInt(answers.dataPossibleVariantD.get(1));
//            case 5:
//                choseId = Integer.parseInt(answers.dataPossibleVariantE.get(1));
        }

        if (userChoice >= 0 && userChoice < 5) {
            this.haveRightChoice = choseId == 1;

        } else {
            this.haveRightChoice = false;
        }
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
