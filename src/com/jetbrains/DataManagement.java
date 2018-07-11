package com.jetbrains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManagement {

//TODO interface
    public static List<String> listFromFile(String fileLocation, int column) {

        List<String> list = new ArrayList<>();

        BufferedReader bufferedReader;
        try{
            bufferedReader = Files.newBufferedReader(Paths.get(fileLocation), StandardCharsets.UTF_8);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.matches("\\d+.*"))
                list.add(line.split("\t")[column-1]);

            }

        } catch (IOException e){
            e.printStackTrace();

        }
        return list;

    }

    public static void listToFile(List<String> list, String fileLocation){
        Path path = Paths.get(fileLocation);
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            for (String element : list) {
                writer.append(element);
                writer.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();

        }
    }


    public static void mapToFile (HashMap<String, List<String>> map, String fileLocation){
        Path path = Paths.get(fileLocation);
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            for (String key : map.keySet()) {
                for (String value : map.get(key))
                    writer.append(key + "\t" + value + "\n");
            }

        } catch (IOException e){
            e.printStackTrace();

        }

    }

}
