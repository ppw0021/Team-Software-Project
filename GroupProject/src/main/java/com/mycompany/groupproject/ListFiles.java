package com.mycompany.groupproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ListFiles {

    public boolean listFiles(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> !name.startsWith("EDITS_") && !name.equals("pom.xml") && name.endsWith(".txt"));
            if (files != null && files.length > 0) {
                Arrays.sort(files); // Sort files alphabetically
                System.out.println("\nFiles in directory " + directoryPath + ":");

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        System.out.println((i + 1) + ". " + files[i].getName());
                    }
                }
                return true;
            } else {
                System.out.println("No files in the directory. Please create a new knowledge file.");
                return false;
            }
        } else {
            System.out.println("Invalid directory path.");
        }
        return false;
    }
}
