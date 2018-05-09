package ru.odnoklassniki.GenerateIntSequence;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestGenerateIntSequence {
    @Test
    public void testTheStringIsZero() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(1, 0);
            Assert.fail("Method did not throw exception when itemsCount was 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testTheStringIsGreaterMaxInteger() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(2147483647, 10);
            Assert.fail("Method did not throw exception when startingNumber was more than Integer.MAX_VALUE");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }
    @Test
    public void testSumIsGreaterMaxIntegerFail() {

        try {
            ClassToBeTested.generateIntSequence(2147483647, 100);Assert.fail();
        }

        catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }
    @Test
    public void testTheStringIsLessZero() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(1, -10);
            Assert.fail("Method did not throw exception when itemsCount was less 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }
    @Test
    public void testCorrectString() throws Exception {
        final List<Integer> Sequence = ClassToBeTested.generateIntSequence(0, 10);
        Assert.assertNotNull(Sequence);
        Assert.assertFalse(Sequence.isEmpty());


    }

    @Test
    public void testCorrectSequenceCreation() throws Exception{
        final List<Integer> Result = ClassToBeTested.generateIntSequence(0, 10);
        Assert.assertThat(
                "The length of sequence isn't equal to 10",
                Result, hasSize(equalTo(10)));
    }



}

