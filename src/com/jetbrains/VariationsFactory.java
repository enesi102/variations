package com.jetbrains;

import java.util.*;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class VariationsFactory {

    List<String> list;
    Equivalents equivalents;
    boolean firstIsMain;

    public VariationsFactory(List<String> list, List<String> equis, boolean firstIsMain) {
        this.list = list;
        this.equivalents = new Equivalents("ei", equis);
        this.firstIsMain = firstIsMain;//

    }


    public HashMap<String, List<String>> generate () {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String term : list) {
            List<String> variations = new LinkedList<>();
            List<String> foundChars = new LinkedList<>();
            StringManagement thisTerm;
            
//            String a = "Uijenkruijer";
//            if (term.equals(a)) {
//                int iolo=0;
//                iolo++;
//            }
            for (String chars : equivalents.values) {
                if (term.contains("(?i)"+chars) && !isContained(foundChars, chars)) {//https://regex101.com/r/eS7fC2/3
                    
//                    mapCharsCaseInString(returns pattern telling if chunk appears as upper/lower/ capitalized/)
                    use StringManagement
                    
                    
                    
                    String mainTerm = term.replaceAll(chars, equivalents.main);
                    variations.addAll(getVariations(mainTerm));
                    foundChars.add(chars);

                    map.put(capitalize(mainTerm), variations);

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

    private List<String> getVariations(String term) {
        List<String> list = new LinkedList<>();
        for (String value : equivalents.values ) {
            if (!value.equals(equivalents.main))
                list.add(capitalize(term.replaceAll(equivalents.main, value)));

        }
        return list;

    }


}
