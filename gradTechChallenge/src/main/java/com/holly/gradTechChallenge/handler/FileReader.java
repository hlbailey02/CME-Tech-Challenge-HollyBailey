package com.holly.gradTechChallenge.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private static final Logger log = LogManager.getLogger(FileReader.class);

    public ArrayList<String> readFile(String fileName){
        log.info("Reading file");
        ArrayList<String> fileOutputs = new ArrayList<>();
        try{
            File primeFile = new File(fileName);
            Scanner reader = new Scanner(primeFile);
            while (reader.hasNextLine()){
                String number = reader.nextLine();
                fileOutputs.add(number);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            log.info("No input file found, Cache not populated");
            return new ArrayList<>();
        }

        log.info("File Read, Cache populated - Number of primes added: " + fileOutputs.size());

        return fileOutputs;
    }

}