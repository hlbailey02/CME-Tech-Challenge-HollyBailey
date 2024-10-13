package com.holly.cmeTechChallenge.runner;

import com.holly.cmeTechChallenge.calc.PrimeNumbers;
import com.holly.cmeTechChallenge.handler.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeRunner {
    PrimeNumbers primeNumbers = new PrimeNumbers();
    FileReader fileReader = new FileReader();
    private static final Logger log = LogManager.getLogger(PrimeRunner.class);

    Scanner scanner = new Scanner(System.in);

    public ArrayList<String> startUp(String fileName){
        ArrayList<String> knownPrimes = fileReader.readFile(fileName);

        System.out.println("Enter Username (letters and numbers only): ");
        String username = scanner.nextLine();
        if(username.matches(".*[a-zA-Z0-9]+.*")){
            log.info("Welcome " + username);
        } else {
            log.error("Access Denied");
            System.exit(1);
        }

        return knownPrimes;
    }

    public boolean primeCaller(String fileName,ArrayList<String> knownPrimes){
        System.out.println("Enter a sequence to find prime numbers: ");
        String sequence = scanner.nextLine();

        primeNumbers.controller(sequence,knownPrimes,fileName);

        System.out.println("Type y to go again or anything else to quit");
        if (scanner.nextLine().equalsIgnoreCase("y")){
            return true;
        } else {
            return false;
        }
    }
}

