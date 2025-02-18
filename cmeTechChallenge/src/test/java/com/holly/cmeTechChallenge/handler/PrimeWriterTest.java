package com.holly.cmeTechChallenge.handler;

import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class PrimeWriterTest {

    PrimeWriter primeWriter = new PrimeWriter();

    FileReader fileReader = new FileReader();

    @Before
    public void clearfile(){
        String fileName = "src/test/resources/WriterTest.txt";
        try {
            new FileWriter(fileName, false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCorrectPath(){
        ArrayList<String> newPrimes = new ArrayList<>();
        newPrimes.add("2");
        newPrimes.add("3");
        String fileName = "src/test/resources/WriterTest.txt";
        primeWriter.appendFile(newPrimes,fileName);

        ArrayList<String> outcome = fileReader.readFile(fileName);
        assertEquals(outcome,newPrimes);
    }




}
