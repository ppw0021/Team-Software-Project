package com.mycompany.groupproject;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class CreateFile extends AbstractFile {

    public CreateFile() {
        super();
    }

    @Override
    public void create(String DocumentName) {
        try {
            File primaryFile = new File(DocumentName + ".txt");
            File editsFile = new File("EDITS_" + DocumentName + ".txt");
            if (primaryFile.createNewFile() && editsFile.createNewFile()) {
                System.out.println("File created: " + primaryFile.getName());
                FileWriter primaryWriter = new FileWriter(primaryFile, true);
                System.out.println("Please add your information");
                Scanner tx=new Scanner(System.in);
                String text=tx.nextLine();
                primaryWriter.write(text);
                primaryWriter.close();
                System.out.println("Text added to file: " + primaryFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
