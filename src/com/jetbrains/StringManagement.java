package com.jetbrains;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.xml.internal.ws.util.StringUtils.capitalize;

public class StringManagement {

    //TODO
    //(could check if all encounters follow these patterns just to see what else is possible)
    enum Case {
        UPPER, LOWER, CAPITALIZED//,notAlpha TODO: manage case
    }
//https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html

    /**
     * https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html
     * matcher.start();
     * matcher.end();
     *
     * @param str
     * @param chars
     * @return
     */
    //searches chars caseInsensitive/(?i) https://regex101.com/r/eS7fC2/3
    //maps the caseStatus of each encounter(ALLUPPER, alllower, Capitalized [for now]
    //TODO: handle special groups exceptions. e.g. IJ
    // go letter by letter
    //TODO: work on this loop, IT SUCKS!!!
    private static List<Case> mapCharsCase(String str, String chars){//private?
        List<Case> casePattern = new LinkedList<>();
        Pattern pattern = Pattern.compile("(?i)" + chars);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            int startIndex = matcher.start();
            if (Character.isUpperCase(str.codePointAt(startIndex))){
                if (Character.isUpperCase(str.codePointAt(startIndex + 1))){
                    casePattern.add(Case.UPPER);
                }else casePattern.add(Case.CAPITALIZED);

            }else casePattern.add(Case.LOWER);

        }
//        int substringIndex = -1;
//        int lenChars = chars.length();
//        while ((substringIndex = str.indexOf(chars, substringIndex + 1)) > -1){ //(the chars matching should be case insensitive because of "(?i)")
//            if (Character.isUpperCase(str.codePointAt(substringIndex))){
//                if (Character.isUpperCase(str.codePointAt(substringIndex+1))){
//                    casePattern.add(Case.UPPER);
//
//                }else casePattern.add(Case.CAPITALIZED);
//
//            }else casePattern.add(Case.LOWER);
//            substringIndex = substringIndex + lenChars; //TO SKIP THE SEARCHED CHUNK
//
//        }
        return casePattern;
        
    }
    
    //replaces all occurrences of chars with replacement according to casePattern
    //TODO: handle exceptions
    //    early detection of language, case irrelevant for ar, he, zh, etc
    public static String replaceAllByCasePattern(String str, String chars, String replacement){
        List<Case> casePattern = mapCharsCase(str, chars);
        for (Case thisCase : casePattern){
            switch (thisCase){
                case LOWER: str = str.replaceFirst(chars.toLowerCase(), replacement.toLowerCase()); break;
                case UPPER: str = str.replaceFirst(chars.toUpperCase(), replacement.toUpperCase()); break;
                case CAPITALIZED: str = str.replaceFirst(capitalize(chars), capitalize(replacement)); break;

            }

        }
        return str;
    }


    public static List<String> replaceAllByCasePattern(String str, String chars, List<String> replacements){
        List<String> list =  new LinkedList<>();
        for(String replacement : replacements){
            String ttt = replaceAllByCasePattern(str, chars, replacement);
            if (!ttt.equals(str)) {
                list.add(ttt);
            }
        }

        return list;
    }

}
