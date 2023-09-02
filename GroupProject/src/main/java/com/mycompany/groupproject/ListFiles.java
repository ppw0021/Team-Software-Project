
package com.mycompany.groupproject;
import java.io.File;
import java.util.Arrays;

public class ListFiles {
    
    public static void listFiles(String directoryPath) {
          File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                Arrays.sort(files); // Sort files alphabetically
                System.out.println("Files in directory " + directoryPath + ":");

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        System.out.println((i + 1) + ". " + files[i].getName());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }}
