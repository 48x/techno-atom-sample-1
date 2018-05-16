package ru.odnoklassniki.ClassToBeTestedTests;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.AllOf.allOf;


/**
 * Created by Soldatov Artem as demotests
 */

public class TestSortStringsByLength {

    @Test
    public void testSortedListContainsCorrectLength() throws Exception{
        final String str1 = "string01";
        final String str2 = "string0123";
        final List<String> sortedStrings = ClassToBeTested.sortStringsByLength(str1, str2);

        Assert.assertThat(
                "Некорретный размер коллекции",
                sortedStrings,
                allOf(
                        notNullValue(),
                        hasSize(equalTo(2))
                )
        );
    }

    @Test
    public void testSortedListContainsFirstString() throws Exception{
        final String str1 = "string1";
        final String str2 = "string11";
        final List<String> sortedStrings = ClassToBeTested.sortStringsByLength(str1, str2);

        Assert.assertThat(
                "Ответ не содержит первую строку",
                sortedStrings,
                contains(str1)
        );
    }
}
