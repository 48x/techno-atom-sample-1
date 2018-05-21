package ru.odnoklassniki;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

/**
 Список тестов:
 1. Проверка правильной последовательности
 2. Проверка нулевого количества элементов
 3. Проверка максимального количества элементов
 4. Проверка превышения Int
 5. Проверка отрицательного количества элементов
 */


public class TestIntegerSequence {

    @Test
    public void testCorrectSequence(){
        int startNum = -1;
        int count = 3;
        List<Integer> response = new ArrayList<Integer>();

        for (int i = startNum; i < startNum + count; i++){
            response.add(i);
        }

        List<Integer> sequence = ClassToBeTested.generateIntSequence(startNum, count);

        Assert.assertNotNull(sequence);
        Assert.assertEquals(sequence.size(), count);
        Assert.assertEquals(response, sequence);
    }

    @Test
    public void testZeroItemCount() {
        try{
            ClassToBeTested.generateIntSequence(3, 0);
            Assert.fail("Method didn't throw exception when item counter is negative");
        }
        catch (IllegalArgumentException e){
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void testMaxItemCount(){
        int startNum = -1;
        int count = Integer.MAX_VALUE;
        try {
            List<Integer> sequence = ClassToBeTested.generateIntSequence(startNum, count);
        } catch (Error e){
            Assert.fail("Method didn't throw out of memory exception");;
        }
    }

    @Test
    public void testOverInteger() throws Exception{
        try {
            ClassToBeTested.generateIntSequence(3, Integer.MAX_VALUE);
            Assert.fail("Method didn't throw exception when over Integer");
        }
        catch (IllegalArgumentException e){
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }

    @Test
    public void testNegativeCounter() throws Exception{
        try{
            ClassToBeTested.generateIntSequence(3, -2);
            Assert.fail("Method didn't throw exception when item counter is negative");
        }
        catch (IllegalArgumentException e){
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }
}