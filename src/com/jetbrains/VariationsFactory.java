package com.jetbrains;

import java.util.*;

public class VariationsFactory {

    List<String> list;
    StringEquivalents equivalents;
    boolean firstIsMain;//atm not used



    public VariationsFactory(List<String> list, List<String> equis, boolean firstIsMain) {
        this.list = list;
        this.equivalents = new StringEquivalents(equis);
        this.firstIsMain = firstIsMain;//

    }


    public HashMap<String, List<String>> generate () {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String term : list) {
            List<String> variations = new LinkedList<>();
            List<String> foundChars = new LinkedList<>();
            for (String chars : equivalents.values) {
                if (term.contains(chars) && !isContained(foundChars, chars)) {//https://regex101.com/r/eS7fC2/3
                    String mainTerm = StringManagement.replaceAllByCasePattern(term, chars, equivalents.main);
                    variations.addAll(StringManagement.replaceAllByCasePattern(mainTerm, equivalents.main, equivalents.values));
                    foundChars.add(chars);
                    map.put(mainTerm, variations);

                }
            }

        }
        return map;//Sent
    }


    private boolean isContained(List<String> list, String chars) {
        for(String element : list){
            if (element.contains(chars)) return true;

        }
        return false;
    }


}
