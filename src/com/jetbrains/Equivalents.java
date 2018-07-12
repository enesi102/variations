package com.jetbrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Equivalents {
    String main;
    List<String> values;

    public Equivalents(String main, List<String> values) {
        this.main = main;
        this.values = values;
    }

    public Equivalents(List<String> values) {
        this.main = values.get(0);
        values.remove(0);
        this.values = values;
    }
}
