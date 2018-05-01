package ru.odnoklassniki.generateIntSequence;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;

public class TestGenerateIntSequence {

    @Test
    public void testLengthOfSequenceIsEqualToItemsCount() throws Exception{
        final List<Integer> Result = ClassToBeTested.generateIntSequence(0,5);
        Assert.assertThat(
                "The length of sequence isn't equal to 5",
                Result,
                hasSize(equalTo(5))
        );
    }

    @Test
    public void testSequenceContainsRightNumbers() throws Exception{
        final List<Integer> Result = ClassToBeTested.generateIntSequence(-2,4);
        Assert.assertThat(
                "The length of sequence isn't equal to 3",
                Result,
                hasItems(-2,-1,0,1)
        );
    }
    @Test
    public void testSequenceIsCorrect() throws Exception{

        final List<Integer> Result = ClassToBeTested.generateIntSequence(4,3);
        Assert.assertNotNull(Result);
        Assert.assertEquals(3, Result.size());
        Assert.assertEquals(4, (long)Result.get(0));
        Assert.assertEquals(5, (long)Result.get(1));
        Assert.assertEquals(6, (long)Result.get(2));
    }

    @Test
    public void testIfItemCounterIsNegativeExceptionThrown() throws Exception{
        try{
            ClassToBeTested.generateIntSequence(1,-9);
            Assert.fail("Method didn't throw an exception when ItemCounter is negative");
        }
        catch(IllegalArgumentException e){
                    Assert.assertEquals("itemsCount must be greater than 0",e.getMessage());
        }
    }

    @Test
    public void testIfFinishNumberIsGreaterThenIntMaxValueExceptionThrown() throws Exception{
        try {
            ClassToBeTested.generateIntSequence(2147483600 ,54);
            Assert.fail("Method didn't throw an exception when final number is greater then integer max_value");
        }
        catch(IllegalArgumentException e){
            Assert.assertEquals("can't generate an int greater than integer's max value",e.getMessage());
        }
    }

}
