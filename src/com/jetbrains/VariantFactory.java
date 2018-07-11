package com.jetbrains;

import java.util.*;

//generate new terms through replaceing group of chars
public class VariantFactory {
    List<String> terms;
    String[] equivalents;

    public VariantFactory(List<String> terms, String[] equivalents) {
        this.terms = terms;
        this.equivalents = equivalents;
    }

    public Map<String, Set<String>> generate() {
        Map<String, Set<String>> setMap = new HashMap<>();

        for (String term : terms) {
            for (String chrs : equivalents) {
                if (term.contains(chrs)) {
                    String toTerm = term.replaceAll(chrs, equivalents[0]);
                    if (!setMap.containsKey(toTerm)){
                        Set<String> variants = new HashSet<>();
                        for (int i = 1; i <= equivalents.length; i++) {
                            variants.add(term.replaceAll(chrs, equivalents[i]));

                        }
                        setMap.put(term.replaceAll(chrs, equivalents[0]), variants);

                    }

                }

            }

        }

        return setMap;
    }



}
