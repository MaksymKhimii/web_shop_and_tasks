package com.epam.khimii.task8.searchingByteSequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadByteSequenceTest {
    private ReadByteSequence readByteSequence;
    private Sequence sequence;

    @Before
    public void beforeTest() {
        readByteSequence = new ReadByteSequence();
        sequence = new Sequence("123", 0, 6);
    }

    @Test
    public void shouldGetFirstSequenceIndexTest() {
        readByteSequence.findLongestSequence("123888123");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0, sequence.getFirstIndex());
        Assert.assertEquals(sequence.toString(), readByteSequence.getSequence().toString());
    }
}