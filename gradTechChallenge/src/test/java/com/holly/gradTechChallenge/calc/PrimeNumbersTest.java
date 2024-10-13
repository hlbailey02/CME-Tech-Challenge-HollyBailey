package com.holly.gradTechChallenge.calc;

import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeNumbersTest {
    PrimeNumbers primeNumbers = new PrimeNumbers();


    @Test
    public void testGetNumsFromSeq(){
        ArrayList<Integer> outcome = primeNumbers.getNumbersFromSequence("123");
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(12);
        expected.add(123);
        expected.add(2);
        expected.add(23);
        expected.add(3);
        expected.sort(null);

        assertEquals(outcome,expected);
    }

    @Test
    public void testPrimeNumber1(){
        boolean outcome = primeNumbers.calculatePrime(1);
        assertFalse(outcome);
    }

    @Test
    public void testPrimeNumber2(){
        boolean outcome = primeNumbers.calculatePrime(2);
        assertTrue(outcome);
    }

    @Test
    public void testPrimeNumber3(){
        boolean outcome = primeNumbers.calculatePrime(3);
        assertTrue(outcome);
    }

    @Test
    public void testPrimeNumber4(){
        boolean outcome = primeNumbers.calculatePrime(4);
        assertFalse(outcome);
    }

    @Test
    public void testPrimeNumber5(){
        boolean outcome = primeNumbers.calculatePrime(5);
        assertTrue(outcome);
    }

    @Test
    public void testPrimeNumber25(){
        boolean outcome = primeNumbers.calculatePrime(25);
        assertFalse(outcome);
    }

    @Test
    public void testPrimeNumber3469(){
        boolean outcome = primeNumbers.calculatePrime(3469);
        assertTrue(outcome);
    }

    @Test
    public void testPrimeNumber3468(){
        boolean outcome = primeNumbers.calculatePrime(3468);
        assertFalse(outcome);
    }

    @Test
    public void testCheckForPrimes(){
        ArrayList<String> knownPrimeNums = new ArrayList<>();
        knownPrimeNums.add("2");
        knownPrimeNums.add("3");
        ArrayList<Integer> numsToCheck = new ArrayList<>();
        numsToCheck.add(2);
        numsToCheck.add(3);
        numsToCheck.add(23);
        numsToCheck.add(4);
        ArrayList<String> outcome = primeNumbers.checkForPrimes(knownPrimeNums,numsToCheck);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("23");
        assertEquals(outcome,expected);
    }

}
