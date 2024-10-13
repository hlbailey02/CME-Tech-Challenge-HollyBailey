package com.holly.gradTechChallenge.model;

public class Letters extends Sequence{
    private Letters(){
    }

    public Letters(String sequence){
        this.inputSeq = sequence;
        this.correctSeq = false;
        this.message = "This sequence contains letters";
    }


}
