package com.holly.gradTechChallenge.model;

public class Numbers extends Sequence {
    private Numbers(){
    }

    public Numbers(String sequence){
        this.inputSeq = sequence;
        this.correctSeq = true;
        this.message = "This sequence can be used";
    }
}
