package ru.odnoklassniki.ClassToBeTestedTests;

import org.junit.Assert;
import org.junit.Test;
import ru.odnoklassniki.ClassToBeTested;

import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * Created by Soldatov Artem as demotests
 */

public class TestSortStringsByLength {

    @Test
    public void testSortedListContainsStrings() throws Exception{
        final String str1 = "string01";
        final String str2 = "string0123";
        final List<String> sortedStrings = ClassToBeTested.sortStringsByLength(str1, str2);

        Assert.assertThat(
                "В ответе нет строк",
                sortedStrings,
                hasSize(notNullValue())
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
