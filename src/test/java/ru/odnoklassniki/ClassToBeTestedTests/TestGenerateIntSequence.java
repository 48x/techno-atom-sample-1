package ru.odnoklassniki.ClassToBeTestedTests;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;


/**
 * Created by Soldatov Artem as demotests
 */

public class TestGenerateIntSequence {

        @Test
        public void testSequenceGeneratedCorrectly() {
                final int startNum = 21;
                final int numCount = 3;
                final List<Integer> sequence = ClassToBeTested.generateIntSequence(startNum, numCount);

                Assert.assertNotNull(sequence);
                Assert.assertEquals(3, sequence.size());
                for (int i : sequence) Assert.assertEquals(startNum+i,sequence.get(i).intValue());
        }

        @Test(expected = IllegalArgumentException.class)
        public void testNullItemsCountExceptionThrown() {
                try { ClassToBeTested.generateIntSequence(5, 0);
                        Assert.fail("Method did not throw exception when second items count was 0");
                } catch (IllegalArgumentException e) {
                        Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
                }

        }

        @Test(expected = IllegalArgumentException.class)
        public void testMoreThenIntegerMaxValueSequenceGen() {
                for (int i = 0; i <1; i++) {
                        try { ClassToBeTested.generateIntSequence(i, Integer.MAX_VALUE);
                                Assert.fail("Method did not throw exception when sum startingNumber and itemsCount more then Integer max value");
                        } catch (IllegalArgumentException e) {
                                Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
                        }
                }
        }

}
