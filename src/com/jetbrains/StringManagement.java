package com.jetbrains;

import java.util.LinkedList;
import java.util.List;

public class StringManagement {

    //TODO
    //(could check if all encounters follow these patterns just to see what else is possible)
    //instead of replaceAll use (/do) replaceALLbyCasePattern
    enum Case {
        UPPER, LOWER, CAPITALIZED
    }
    public String str;

    public StringManagement(String str) {
        this.str = str;
    }

    //searches chars caseInsensitive/(?i) https://regex101.com/r/eS7fC2/3
    //maps the caseStatus of each encounter(ALLUPPER, alllower, Capitalized [for now]
    public  List<Case> mapCharsCase(String chars){
        List<Case> casePattern = new LinkedList<>();
        int substringIndex = 0;
        while ((substringIndex = str.indexOf("(?i)" + chars, substringIndex)) > -1){ //the chars matching should be case insensitive because of "(?i)"
            if (Character.isUpperCase(str.codePointAt(substringIndex))){
                if (Character.isUpperCase(str.codePointAt(substringIndex+1))){
                    casePattern.add(Case.UPPER);//TODO: handle special groups exceptions. e.g. IJ
                            
                }else casePattern.add(Case.CAPITALIZED);
                    
            }else casePattern.add(Case.LOWER);
//            startIndex = index + searchStrLen; VAR TO SKIP THE SEARCHED CHUNK

        }
        return casePattern;
        
    }
    
    //replaces all occurrences of chars with replacement according to casePattern
    //TODO: handle exceptions
    public String replaceAllByCasePattern(String chars, String replacement, List<Case> casePattern){
        int substringIndex = 0;
        int charsLength = chars.length();
        for (Case thisCase : casePattern){
            switch (thisCase){
                case LOWER: str = str.replaceFirst(chars, replacement.toLowerCase());
                case UPPER: str = str.replaceFirst(chars, replacement.toUpperCase());
                case CAPITALIZED: str = str.replaceFirst(chars, replacement.toUpperCase());
                    
            }
            
        }
        
        return str;
    }

}
