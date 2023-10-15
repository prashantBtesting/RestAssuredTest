package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Basic {
    public static void main(String[] args) throws IOException {
        /*
        String filePath = "C:\\Users\\Admin\\Downloads\\edition.txt";
        List<Character> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int line;
            while ((line = br.read()) != -1) {
                char character = (char) line;
                lines.add(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Character line : lines) {
            System.out.print(line);
        }

         */

    }
    public static void bufferReader() throws IOException {
        String filePath = "C:\\Users\\Admin\\Downloads\\edition.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            // System.out.println(line);
            if ((line.contains(".com") && (line.contains("RESELLER") || line.contains("DIRECT")))) {
                String[] A = line.trim().split(",");
                for (String str : A) {
                    if ((str.contains(".")) || ((str.contains("RESELLER") || str.contains("DIRECT")))){
                        System.out.print(str);
                        System.out.print("->");
                        System.out.println();
                    }

                }

            }

        }
    }


}

