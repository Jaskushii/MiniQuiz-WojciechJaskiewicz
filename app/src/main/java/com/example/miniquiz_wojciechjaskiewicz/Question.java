package com.example.miniquiz_wojciechjaskiewicz;

public class Question {
    String text;
    String answerA;
    String answerB;
    String answerC;
    String correct;

    public Question(String text, String answerA, String answerB, String answerC, String correct) {
        this.text = text;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.correct = correct;
    }
}

