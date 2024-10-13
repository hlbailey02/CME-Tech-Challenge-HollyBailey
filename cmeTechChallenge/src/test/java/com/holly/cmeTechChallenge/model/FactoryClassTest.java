package com.holly.cmeTechChallenge.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FactoryClassTest {

    FactoryClass factoryClass = new FactoryClass();

    @Test
    public void testCorrectInputs(){
        String testvalue1 = "12345";
        String testvalue2 = "1234567890";

        Sequence sequence1 = factoryClass.checkSequence(testvalue1);
        Sequence sequence2 = factoryClass.checkSequence(testvalue2);

        assertTrue(sequence1.isCorrectSeq());
        assertTrue(sequence2.isCorrectSeq());

        assertEquals("This sequence can be used", sequence1.getMessage());
        assertEquals("This sequence can be used", sequence2.getMessage());
    }

    @Test
    public void testSpaceInputs(){
        String testvalue1 = " 12345";
        String testvalue2 = "123456 7890";

        Sequence sequence1 = factoryClass.checkSequence(testvalue1);
        Sequence sequence2 = factoryClass.checkSequence(testvalue2);

        assertFalse(sequence1.isCorrectSeq());
        assertFalse(sequence2.isCorrectSeq());

        assertEquals("This sequence contains spaces", sequence1.getMessage());
        assertEquals("This sequence contains spaces", sequence2.getMessage());
    }

    @Test
    public void testLettersInputs(){
        String testvalue1 = "adghsj";
        String testvalue2 = "12d345A6789s0";

        Sequence sequence1 = factoryClass.checkSequence(testvalue1);
        Sequence sequence2 = factoryClass.checkSequence(testvalue2);

        assertFalse(sequence1.isCorrectSeq());
        assertFalse(sequence2.isCorrectSeq());

        assertEquals("This sequence contains letters", sequence1.getMessage());
        assertEquals("This sequence contains letters", sequence2.getMessage());
    }

    @Test
    public void testSpecialCharInputs(){
        String testvalue1 = "@!%^";
        String testvalue2 = "12@345!6789^0";

        Sequence sequence1 = factoryClass.checkSequence(testvalue1);
        Sequence sequence2 = factoryClass.checkSequence(testvalue2);

        assertFalse(sequence1.isCorrectSeq());
        assertFalse(sequence2.isCorrectSeq());

        assertEquals("This sequence contains special characters", sequence1.getMessage());
        assertEquals("This sequence contains special characters", sequence2.getMessage());
    }

    @Test
    public void testNullInput(){
        Sequence sequence = factoryClass.checkSequence(null);

        assertFalse(sequence.isCorrectSeq());

        assertEquals("This sequence is empty", sequence.getMessage());

    }

}
