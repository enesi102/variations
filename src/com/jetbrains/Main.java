package com.jetbrains;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	//TODO generalize code, input equivalents, !capital letter  sentence case!
//THIS commented section WORKS:
//        DataManagement.listToFile(DataManagement.listFromFile(
//                "D:\\IdeaProjects\\variants\\data\\termexport_2018-07-04_09-07-20.csv",3),
//                "D:\\IdeaProjects\\variants\\data\\dutch-family-names.txt");

        List<String> equivalents = Arrays.asList("eij", "ei", "ey");
        VariationsFactory variationsFactory = new VariationsFactory(
                DataManagement.listFromFile("D:\\dev\\variants\\data\\termexport_2018-07-04_09-07-20.csv",3),
                equivalents,
               true);


        DataManagement.mapToFile(variationsFactory.generate(), "D:\\dev\\variants\\data\\dutch-old-spelling_ei-eij-ey.txt");
    }
}
