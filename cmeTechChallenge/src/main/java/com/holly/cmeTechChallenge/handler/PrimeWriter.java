package com.holly.cmeTechChallenge.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeWriter {
    private static final Logger log = LogManager.getLogger(PrimeWriter.class);

    public void appendFile(ArrayList<String> newPrimeNums, String fileName){
        try{
            log.info("Writing Primes to File");
            FileWriter writer = new FileWriter(fileName,true);
            BufferedWriter bwriter = new BufferedWriter(writer);
            for (String num : newPrimeNums){
                bwriter.write(num);
                bwriter.newLine();
            }
            bwriter.close();
        } catch (Exception e) {
            log.error("Exception found: "+ e );
        }
        log.info("Primes written to file");
    }
}