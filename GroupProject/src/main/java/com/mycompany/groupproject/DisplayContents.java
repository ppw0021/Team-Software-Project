package com.mycompany.groupproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayContents extends AbstractFile {

    public DisplayContents() {
        super();
    }
    
    public DisplayContents(File file) {
        super(file);
    }

    @Override
    public void viewFile(String directoryPath, int fileNumber, boolean setIfTrue, boolean viewEdits) {
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> !name.startsWith("EDITS_") && !name.equals("pom.xml") && name.endsWith(".txt"));

            if (viewEdits){
                setThisFile(files[fileNumber - 1]);
                String fileContent = "";
                try {
                    fileContent = new String(Files.readAllBytes(Paths.get(getThisFileEdits().getAbsolutePath())));
                } catch (IOException ex) {
                    System.out.println("Error Opening edits file, please check that EDITS_ file exists.");
                    return;
                }
                System.out.println("\nEdit History of " + getThisFile().getName() + ":\n" + fileContent + "\n\n");
                return;
                
            }
            
            if (!setIfTrue) {
                //SetThisFile
                setThisFile(files[fileNumber - 1]);
                String fileContent = "";
                try {
                    fileContent = new String(Files.readAllBytes(Paths.get(getThisFile().getAbsolutePath())));
                    System.out.println("\nFile content of " + getThisFile().getName() + ":\n" + fileContent + "\n\n");
                } catch (IOException ex) {
                    System.out.println("Error Opening file, please check that file exists.");;
                }
                return;
            }

            if (files != null) {
                Arrays.sort(files); // Sort files alphabetically
                if (fileNumber >= 1 && fileNumber <= files.length) {
                    File selectedFile = files[fileNumber - 1];
                    if (selectedFile.isFile()) {
                        try {
                            String fileContent = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));
                            System.out.println("\nYou have selected '" + selectedFile.getName() + "' Please select an option.");

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
                System.out.println("No files in the directory. Please create a new information page.");
                return;
            }
        } else {
            System.out.println("Invalid directory path.");
        }
        return;
    }
}
