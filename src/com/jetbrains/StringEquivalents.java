package com.jetbrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringEquivalents {
    String main;
    List<String> values;

    public StringEquivalents(List<String> equis) {
        this.main = equis.get(0);
        Collections.sort(equis, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.length() - o2.length());
            }
        });
        this.values = equis;
    }

}
