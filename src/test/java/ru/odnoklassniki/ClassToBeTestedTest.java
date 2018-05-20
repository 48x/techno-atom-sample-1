package ru.odnoklassniki;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.*;

public class ClassToBeTestedTest {

    /**
     * Тест1: проверка частных значений string1 = "qwerty"; string2 = "Angelina";
     *        проверка того, что возвращаемый список не NULL
     * Тест2: проверка того, что размер возвращаемого списка = 2
     * Тест3: проверка правильности сортировки
     * Тест4: ввод string1 = "" (ожидается вывод "string1 must not be null or empty")
     * Тест5: ввод string2 = "" (ожидается вывод "string2 must not be null or empty")
     * тест6: ввод string1 = string2 (ожидается вывод "strings must be of different length")
     * */

    @Test
    public void sortStringsByLengthTest1() throws Exception {
        String string1 = "qwerty";
        String string2 = "Angelina";
        List<String> B = new ArrayList<String>();
        B = ClassToBeTested.sortStringsByLength(string1,string2);

        Assert.assertNotNull(B);
    }

    @Test
    public void sortStringsByLengthTest2() throws Exception {
        String string1 = "qwerty";
        String string2 = "Angelina";
        List<String> B = new ArrayList<String>();
        B = ClassToBeTested.sortStringsByLength(string1,string2);

        Assert.assertEquals(B.size(), 2);
    }


    @Test
    public void sortStringsByLengthTest3() throws Exception {
        String string1 = "qwerty";
        String string2 = "Angelina";
        List<String> B = new ArrayList<String>();
        B = ClassToBeTested.sortStringsByLength(string1,string2);

        Assert.assertEquals(B.get(0), string2);
        Assert.assertEquals(B.get(1), string1);
    }

    @Test
    public void sortStringsByLengthTest4() throws Exception {
        try {
            String string1 = "";
            String string2 = "Angelina";
            ClassToBeTested.sortStringsByLength(string1, string2);
            Assert.fail("Method did not throw exception when string1 = null ");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("string1 must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void sortStringsByLengthTest5() throws Exception {
        try {
            String string1 = "qwerty";
            String string2 = "";
            ClassToBeTested.sortStringsByLength(string1, string2);
            Assert.fail("Method did not throw exception when string2 = null ");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("string2 must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void sortStringsByLengthTest6() throws Exception {
        try {
            String string1 = "qwerty";
            String string2 = "qwerty";
            ClassToBeTested.sortStringsByLength(string1, string2);
            Assert.fail("Method did not throw exception when string2 = string1");
        } catch (IllegalStateException e) {
            Assert.assertEquals("strings must be of different length", e.getMessage());
        }
    }


    /**
     * Тест1: проверка частных значений StartingNumber = 1; itomsCount = 3;
     * Тест2: ввод StartingNumber = Integer.MAX_VALUE (ожидается вывод "can't generate an int greater than integer's max value")
     * Тест3: ввод itomsCount = 0 и itomsCount = -345 (ожидается вывод "itemsCount must be greater than 0")
     * Тест4: ввод отрицательного StartingNumber (проверка частного случая)
     * Тест5*: ввод отрицательного StartingNumber и itomsCount = Integer.MAX_VALUE        -  этот тест не реализован, потому что компилятор зависает, но в теории такой тест должен быть пройден успешно
     * тест6: проверка правильности размера возвращаемого списка
     * */

    @Test
    public void generateIntSequenceTest1() {
        int StartingNumber = 1;
        int itomsCount = 3;
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        List<Integer> B = ClassToBeTested.generateIntSequence(1,3);

        Assert.assertNotNull(B);
        Assert.assertEquals(A,B);
    }

    @Test
    public void generateIntSequenceTest2() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(Integer.MAX_VALUE, 454);
            Assert.fail("Method did not throw exception when limit of integer broke");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("can't generate an int greater than integer's max value", e.getMessage());
        }
    }

    @Test
    public void generateIntSequenceTest3() throws Exception {
        try {
            ClassToBeTested.generateIntSequence(555, 0);
            Assert.fail("Method did not throw exception when itomsCount = 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
        try {
            ClassToBeTested.generateIntSequence(555, -345);
            Assert.fail("Method did not throw exception when itomsCount = 0");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("itemsCount must be greater than 0", e.getMessage());
        }
    }

    @Test
    public void generateIntSequenceTest4() {
        int StartingNumber = -5;
        int itomsCount = 3;
        List<Integer> A = new ArrayList<Integer>();
        A.add(-5);
        A.add(-4);
        A.add(-3);
        List<Integer> B = ClassToBeTested.generateIntSequence(-5, 3);

        Assert.assertNotNull(B);
        Assert.assertEquals(A, B);
    }

    @Test
    public void generateIntSequenceTest6() {
        List<Integer> A = ClassToBeTested.generateIntSequence(1, 3);

        Assert.assertEquals(A.size(), 3);
    }
}