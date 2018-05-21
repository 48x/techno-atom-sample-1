package ru.odnoklassniki;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

/**
 Список тестов:
 1. Проверка правильной сортировки
 2. Проверка пустой строки
 3. Проверка строк одинаковой длины
 4. Проверка строки, состоящей из пробелов
 */

public class TestSortStrings {

    @Test
    public void correctSort() throws  Exception{
        String str1 = "test";
        String str2 = "try it";
        List<String> response1 = ClassToBeTested.sortStringsByLength(str1, str2);
        List<String> response2 = ClassToBeTested.sortStringsByLength(str2, str1);

        Assert.assertEquals(response1.size(), 2);
        Assert.assertEquals(response2.size(), 2);
        Assert.assertEquals(str1, response1.get(1));
        Assert.assertEquals(str2, response1.get(0));
        Assert.assertEquals(str1, response2.get(1));
        Assert.assertEquals(str2, response2.get(0));
    }

    @Test
    public void emptyStrings() throws Exception{
        String str1 = "test";
        String str2 = "";

        try {
            List<String> response = ClassToBeTested.sortStringsByLength(str1, str2);
            Assert.fail("Method didn't throw any exception");
        } catch (IllegalArgumentException e){
            Assert.assertEquals("string2 must not be null or empty", e.getMessage());
        }

        try {
            List<String> response = ClassToBeTested.sortStringsByLength(str2, str1);
            Assert.fail("Method didn't throw any exception");
        } catch (IllegalArgumentException e){
            Assert.assertEquals("string1 must not be null or empty", e.getMessage());
        }
    }

    @Test
    public void EqualLength() throws Exception{
        String str1 = "test";
        String str2 = "cats";

        try {
            List<String> response = ClassToBeTested.sortStringsByLength(str1, str2);
            Assert.fail("Method didn't throw any exception");
        } catch (IllegalStateException e){
            Assert.assertEquals("strings must be of different length", e.getMessage());
        }
    }

    @Test
    public void stringOfSpaces() throws  Exception{
        String str = "test";
        String spaces = "     ";

        try {
            List<String> response = ClassToBeTested.sortStringsByLength(str, spaces);
            Assert.fail("Method didn't throw any exception");
        } catch (IllegalArgumentException e){
            Assert.assertEquals("string2 must not be null or empty", e.getMessage());
        }
    }
}