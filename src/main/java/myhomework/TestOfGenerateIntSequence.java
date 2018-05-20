package myhomework;


/**
 * Created by Xenia Ivanushkina
 *
 * Проверка метода ClassToBeTested.generateIntSequence(int startingNumber, int itemsCount)
 */


import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;
import java.util.Random;

public class TestOfGenerateIntSequence {

    /**
     * 1)Проверка корректной работы метода при передаче двух аргументов,
     * сумма которых меньше максимально допустимого значения типа Int
     */
    @Test
    public void CorrectGenerationWhenSumIsLessThanIntegerMaxValue() {
        int startingNumber = 8;
        List<Integer> intSequence = ClassToBeTested.generateIntSequence(startingNumber, 14);
        Assert.assertNotNull(intSequence);
        Assert.assertFalse(intSequence.isEmpty());
        Assert.assertEquals(intSequence.size(), 14);
        for (int result : intSequence) {
            Assert.assertEquals(startingNumber++, result);
        }
    }


    /**
     * 2)Проверка корректной работы метода при передаче двух аргументов,
     * сумма которых равна максимально допустимому значению типа int
     */
    @Test
    public void CorrectGenerationWhenSumIsIntegerMaxValue() {
        int startingNumber = 0;
        List<Integer> intSequence = ClassToBeTested.generateIntSequence(startingNumber, Integer.MAX_VALUE);
        Assert.assertNotNull(intSequence);
        Assert.assertFalse(intSequence.isEmpty());
        Assert.assertEquals(intSequence.size(), Integer.MAX_VALUE);
    }


    /**
     * 3)Проверка корректной работы программы при передаче отрицательного значения itemsCount
     */
    @Test
    public void WhenitemsCountIsLessThanZero() {
        try {
            ClassToBeTested.generateIntSequence(0, -3);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("itemsCount must be greater than 0", ex.getMessage());
        }
    }


    /**
     * 4)Проверка корректной работы программы при передаче itemsCount=0
     */
    @Test
    public void WhenitemsCountIsZero() {
        try {
            ClassToBeTested.generateIntSequence(5, 0);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("itemsCount must be greater than 0", ex.getMessage());
        }
    }

    /**
     * 5)Проверка корректной работы программы при передаче двух аргументов,
     * сумма которых больше максимально допустимого значения типа int
     */
    @Test
    public void WhenSumIsMoreThanIntegerMaxValue() {
        try {
            ClassToBeTested.generateIntSequence(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals("can't generate an int greater than integer's max value", ex.getMessage());
        }
    }
}