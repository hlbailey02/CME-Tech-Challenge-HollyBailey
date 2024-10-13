package com.holly.gradTechChallenge.model;

public class Spaces extends Sequence{
    private Spaces(){
    }

    public Spaces(String sequence){
        this.inputSeq = sequence;
        this.correctSeq = false;
        this.message = "This sequence contains spaces";
    }

}
