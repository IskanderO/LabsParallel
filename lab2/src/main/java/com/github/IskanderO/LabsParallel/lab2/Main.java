package com.github.IskanderO.LabsParallel.lab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader("technicalTask/airports.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String row = "";
        while (true) {
            try {
                if (!((row = csvReader.readLine()) != null))
                    break;
                String[] data = row.split(",");
                // do something with the data
                csvReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
