package ru.odnoklassniki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ClassToBeTested {

    private ClassToBeTested() {
    }

    public static List<String> sortStringsByLength(String string1, String string2) throws Exception {
        if (string1 == null || string1.trim().length() == 0) {
            throw new IllegalArgumentException("string1 must not be null or empty");
        }

        if (string2 == null || string2.trim().length() == 0) {
            throw new IllegalArgumentException("string2 must not be null or empty");
        }

        final int str1Len = string1.length();
        final int str2Len = string2.length();

        if (str1Len == str2Len) {
            throw new IllegalStateException("strings must be of different length");
        }

        if (str1Len > str2Len) {
            return Arrays.asList(
                    string1,
                    string2
            );
        }

        return Arrays.asList(string2, string1);
    }

    public static List<Integer> generateIntSequence(int startingNumber, int itemsCount) {
        if (itemsCount <= 0) {
            throw new IllegalArgumentException("itemsCount must be greater than 0");
        }

        long finishNumber = new Long(startingNumber) + new Long(itemsCount);

        if (finishNumber > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("can't generate an int greater than integer's max value");
        }

        List<Integer> intSequence = new ArrayList<Integer>();
        for (int i = startingNumber; i < startingNumber + itemsCount; i++) {
            intSequence.add(i);
        }

        return intSequence;
    }
}
