package com.holly.gradTechChallenge.model;

public abstract class Sequence {
    String inputSeq;
    boolean correctSeq;
    String message;

    public boolean isCorrectSeq() {
        return correctSeq;
    }

    public String getMessage() {
        return message;
    }


}