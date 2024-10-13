package com.holly.gradTechChallenge.model;

public class SpecialCharacters extends Sequence {
    private SpecialCharacters(){
    }

    public SpecialCharacters(String sequence){
        this.inputSeq = sequence;
        this.correctSeq = false;
        this.message = "This sequence contains special characters";
    }

}
