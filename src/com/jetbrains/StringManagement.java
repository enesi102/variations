package com.jetbrains;

import java.util.LinkedList;
import java.util.List;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class StringManagement {

    //TODO
    //(could check if all encounters follow these patterns just to see what else is possible)
    //instead of replaceAll use (/do) replaceALLbyCasePattern
    enum Case {
        UPPER, LOWER, CAPITALIZED//,notAlpha TODO: manage case
    }

    //searches chars caseInsensitive/(?i) https://regex101.com/r/eS7fC2/3
    //maps the caseStatus of each encounter(ALLUPPER, alllower, Capitalized [for now]
    private static List<Case> mapCharsCase(String str, String chars){//private?
        List<Case> casePattern = new LinkedList<>();
        int substringIndex = -1;
        int lenChars = chars.length();
        //TODO: handle special groups exceptions. e.g. IJ
        //TODO work on this loop, IT SUCKS!!!
        while ((substringIndex = str.indexOf(chars, substringIndex + 1)) > -1){ //the chars matching should be case insensitive because of "(?i)"
            if (Character.isUpperCase(str.codePointAt(substringIndex))){
                if (Character.isUpperCase(str.codePointAt(substringIndex+1))){
                    casePattern.add(Case.UPPER);
                            
                }else casePattern.add(Case.CAPITALIZED);
                    
            }else casePattern.add(Case.LOWER);
            substringIndex = substringIndex + lenChars; //TO SKIP THE SEARCHED CHUNK

        }
        return casePattern;
        
    }
    
    //replaces all occurrences of chars with replacement according to casePattern
    //TODO: handle exceptions
    public static String replaceAllByCasePattern(String str, String chars, String replacement){
        List<Case> casePattern = mapCharsCase(str, chars);
//        int substringIndex = 0;
//        int charsLength = chars.length();
        for (Case thisCase : casePattern){
            switch (thisCase){
                case LOWER: str = str.replaceFirst(chars, replacement.toLowerCase()); break;
                case UPPER: str = str.replaceFirst(chars, replacement.toUpperCase()); break;
                case CAPITALIZED: str = str.replaceFirst(chars, capitalize(replacement)); break;
                    
            }
            
        }
        return str;
    }


    public static List<String> replaceAllByCasePattern(String str, String chars, List<String> replacements){
        List<Case> casePattern = mapCharsCase(str, chars);
        List<String> list =  new LinkedList<>();
//        int substringIndex = 0;
//        int charsLength = chars.length();
        for(String replacement : replacements){
            String ttt =replaceAllByCasePattern(str, chars, replacement);
            if (!ttt.equals(str)) {
                list.add(ttt);
            }
        }

        return list;
    }

}
