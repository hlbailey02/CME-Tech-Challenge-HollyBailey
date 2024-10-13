package com.holly.cmeTechChallenge.handler;


import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    FileReader fileReader = new FileReader();

    @Test
    public void testCorrectFilePathWithData(){
        String fileName = "src/test/resources/ReaderTest.txt";

        ArrayList<String> outcome = fileReader.readFile(fileName);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("3");
        expected.add("5");
        expected.add("7");

        assertEquals(expected,outcome);

    }

    @Test
    public void testCorrectFilePathWithNoData(){
        String fileName = "src/test/resources/EmptyReaderTest.txt";

        ArrayList<String> outcome = fileReader.readFile(fileName);

        ArrayList<String> expected = new ArrayList<>();

        assertEquals(outcome,expected);
    }

    @Test
    public void testInCorrectFilePath(){
        String fileName = "src/test/resources/Test.txt";
        ArrayList<String> outcome = fileReader.readFile(fileName);

        ArrayList<String> expected = new ArrayList<>();

        assertEquals(outcome,expected);
    }
}
