package com.jetbrains;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Arrays;
import java.util.List;

public class Main {

    //UTF-8 upper to lower matching needed


    public static void main(String[] args) {
	//TODO generalize code, input equivalents
//THIS commented section WORKS:
//        DataManagement.listToFile(DataManagement.listFromFile(
//                "D:\\IdeaProjects\\variants\\data\\termexport_2018-07-04_09-07-20.csv",3),
//                "D:\\IdeaProjects\\variants\\data\\dutch-family-names.txt");

        List<String> equivalents = Arrays.asList( "ui", "uij", "uy");
        VariationsFactory variationsFactory = new VariationsFactory(
                DataManagement.listFromFile(
                "D:\\IdeaProjects\\data\\variations\\termexport_2018-07-04_09-07-20.csv",3),
                equivalents,
               true);


        DataManagement.mapToFile(variationsFactory.generate(),
                "D:\\IdeaProjects\\data\\variations\\dutch-old-spelling_uij.txt");

//        TODO ADD tests all over
    }
}
