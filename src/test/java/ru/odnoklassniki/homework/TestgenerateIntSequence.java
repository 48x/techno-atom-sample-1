package ru.odnoklassniki.stringSorter;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Ruslan Astapov on 4/15/18 at 8:53 AM
 */
public class TestStringSorter {

    @Test
    public void testCorrectly() throws Exception {
        final int s1 = 5;
        final int s2 = 6;
        final List<Integer> sorted = ClassToBeTested.generateIntSequence(s1, s2);

        Assert.assertNotNull(sorted);
        Assert.assertEquals(6, sorted.size());
        Assert.assertEquals(5,(int)  sorted.get(0));
        Assert.assertEquals(6, (int) sorted.get(1));
        Assert.assertEquals(7, (int) sorted.get(2));
        Assert.assertEquals(8, (int) sorted.get(3));
        Assert.assertEquals(9, (int) sorted.get(4));
        Assert.assertEquals(10, (int) sorted.get(5));
    }

    @Test
    public void testReturnedInResponse() throws Exception{
        final int s1 = 0;
        final int s2 = 1;
        final List<Integer> sorted = ClassToBeTested.generateIntSequence(s1, s2);

        Assert.assertThat(
                "В ответе неправильное количество элементов",
                sorted,
                hasSize(equalTo(1))
        );
    }

    @Test
    public void testIfSecondIsZeroExceptionIsThrown() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(24,0);
            Assert.fail("Method did not throw exception when itemsCount was 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testIfFinishIsMaxExceptionIsThrown() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(2147483647,5);
            Assert.fail("Method did not throw exception when finishNumber was more than Integer.MAX_VALUE");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }

}
