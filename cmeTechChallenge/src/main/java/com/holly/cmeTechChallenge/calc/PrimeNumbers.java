package com.holly.cmeTechChallenge.calc;

import com.holly.cmeTechChallenge.handler.PrimeWriter;
import com.holly.cmeTechChallenge.model.FactoryClass;
import com.holly.cmeTechChallenge.model.Sequence;

import java.util.ArrayList;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrimeNumbers {
    FactoryClass factoryClass = new FactoryClass();
    PrimeWriter primeWriter = new PrimeWriter();
    private static final Logger log = LogManager.getLogger(PrimeNumbers.class);

    public void controller(String sequence,ArrayList<String> knownPrimes,String fileName){
        getInputs(sequence);
        ArrayList<Integer> numsToCheck = getNumbersFromSequence(sequence);
        ArrayList<String> newPrimesFound = checkForPrimes(knownPrimes,numsToCheck);
        primeWriter.appendFile(newPrimesFound,fileName);

    }

    public void getInputs(String sequence){
        Sequence checkedSeq = factoryClass.checkSequence(sequence);
        if (!checkedSeq.isCorrectSeq()){
            log.error("Sequence incorrect: " + checkedSeq.getMessage());
            log.debug("System exiting");
            System.exit(1);
        }
    }

    public ArrayList<Integer> getNumbersFromSequence(String sequence){
        ArrayList<Integer> numsToCheck = new ArrayList<>();
        log.debug("Splitting sequence into its array of numbers");
        for(int i=0; i<sequence.length(); i++){
            for(int j=i+1; j<sequence.length()+1;j++){
                String subNum = sequence.substring(i,j);
                numsToCheck.add(Integer.valueOf(subNum));
            }
        }
        numsToCheck.sort(null);
        log.info("Sequence split to numbers to check");
        return numsToCheck;
    }

    public ArrayList<String> checkForPrimes(ArrayList<String> knownPrimeNums, ArrayList<Integer> numsToCheck){
        ArrayList<Integer> primesFound = new ArrayList<>();
        ArrayList<String> newPrimesFound = new ArrayList<>();

        log.debug("Checking each number to see if its prime");

        for(Integer num : numsToCheck){
            if (primesFound.contains(num)) {
                log.info("Duplicate prime found, only outputting once");
            } else if (knownPrimeNums.contains(num.toString())){
                log.debug("Number found in cache");
                primesFound.add(num);
            } else {
                log.debug("Number being checked by calculations");
                if (calculatePrime(num)){
                    primesFound.add(num);
                    newPrimesFound.add(num.toString());
                    knownPrimeNums.add(num.toString());
                }
            }
        }
        String primeFound = primesFound.toString().replace("[","");
        primeFound = primeFound.replace("]","");
        System.out.println("Prime Numbers in Sequence: '" + primeFound +"'");
        return newPrimesFound;
    }

    public boolean calculatePrime(int num){
        if (num == 1){
            return false;
        } if (num == 2 || num == 3) {
            return true;
        } if (num % 2 == 0 || num % 3 == 0){
            return false;
        }
        for (int i = 5; i < (num / 2); i++){
            if(num % i == 0){
                return false;
            } else if ((i*i)>num) {
                return true;
            }
        }
        return true;
    }
}
