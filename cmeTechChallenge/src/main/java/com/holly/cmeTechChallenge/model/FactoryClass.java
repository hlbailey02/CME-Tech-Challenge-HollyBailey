package com.holly.cmeTechChallenge.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FactoryClass {
    public Sequence checkSequence(String inSeq){


        if (inSeq == null){
            return new Null(inSeq);
        } else if (inSeq.contains(" ")) {
            return new Spaces(inSeq);
        } else {
            Pattern letters = Pattern.compile(".*[a-zA-Z]+.*");
            Pattern specialChar = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher lettersMatcher = letters.matcher(inSeq);
            Matcher specialMatcher = specialChar.matcher(inSeq);
            if(lettersMatcher.find()){
                return new Letters(inSeq);
            } else if (specialMatcher.find()) {
                return new SpecialCharacters(inSeq);
            } else {
                return new Numbers(inSeq);
            }
        }
    }
}
