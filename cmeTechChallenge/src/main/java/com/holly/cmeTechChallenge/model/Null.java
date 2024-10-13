package com.holly.cmeTechChallenge.model;

public class Null extends Sequence{
    private Null(){
    }

    public Null(String sequence){
        this.inputSeq = sequence;
        this.correctSeq = false;
        this.message = "This sequence is empty";
    }
}
