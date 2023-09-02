package com.mycompany.groupproject;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class DisplayContents {

    public static void viewFile(String directoryPath, int fileNumber,int status) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                Arrays.sort(files); // Sort files alphabetically
                if (fileNumber >= 1 && fileNumber <= files.length) {
                    File selectedFile = files[fileNumber - 1];
                    if (selectedFile.isFile()) {
                        try {
                            String fileContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));
                            if (status==1){
                                System.out.println("You have selected '" + selectedFile.getName() + "' Please select an option.");
                            }
                            else{
                            System.out.println("File content of " + selectedFile.getName() + ":\n" + fileContent+"\n\n");
                            }
                            
                        } catch (IOException e) {
                            System.out.println("An error occurred while reading the file.");
                        }
                    } else {
                        System.out.println("Selected item is not a file.");
                    }
                } else {
                    System.out.println("Invalid file number.");
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}
