package com.example.associationmapping.comparators;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String> {
    @Override
    public int compare(String word1, String word2) {
        return word2.compareTo(word1);
    }

}
