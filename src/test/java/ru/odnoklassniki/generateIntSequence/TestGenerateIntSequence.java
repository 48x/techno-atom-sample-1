package ru.odnoklassniki.generateIntSequence;


import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestGenerateIntSequence {

    @Test
    public void testLengthOfSequenceIsEqualToItemsCount() throws Exception {
        final int startingNumber = 0;
        final int itemsCounts = 5;
        final List<Integer> result = ClassToBeTested.generateIntSequence(startingNumber, itemsCounts);

        Assert.assertThat(
                "The length of sequence isn't equal to 5",
                result,
                hasSize(equalTo(itemsCounts))
        );
    }

    @Test
    public void testSequenceIsCorrect() throws Exception {
        final int startingNumber = 4;
        final int itemsCounts = 3;
        final List<Integer> result = ClassToBeTested.generateIntSequence(startingNumber, itemsCounts);

        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(4, result.get(0).intValue());
        Assert.assertEquals(5, result.get(1).intValue());
        Assert.assertEquals(6, result.get(2).intValue());
    }

    @Test
    public void testIfItemCounterIsNegativeExceptionThrown() throws Exception {
        final int startingNumber = 1;
        final int itemsCounts = -9;

        try {
            ClassToBeTested.generateIntSequence(startingNumber, itemsCounts);
            Assert.fail("Method didn't throw an exception when ItemCounter is negative");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testIfFinishNumberIsGreaterThenIntMaxValueExceptionThrown() throws Exception {
        final int startingNumber = Integer.MAX_VALUE - 1;
        final int itemsCounts = 50;

        try {
            ClassToBeTested.generateIntSequence(startingNumber, itemsCounts);
            Assert.fail("Method didn't throw an exception when final number is greater then integer.MAX_VALUE");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }
}   
