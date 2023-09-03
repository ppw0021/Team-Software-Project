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
    public void create(String DocumentName) {//Used to create files
        try {
            File primaryFile = new File(DocumentName + ".txt");//Creates a .txt file
            File editsFile = new File("EDITS_" + DocumentName + ".txt");//Creates a edit.txt file
            if (primaryFile.createNewFile() && editsFile.createNewFile()) {
                System.out.println("File created: " + primaryFile.getName());
                FileWriter primaryWriter = new FileWriter(primaryFile, true);
                System.out.println("Please add your information");
                Scanner tx = new Scanner(System.in);
                String text = tx.nextLine();//Allows the user to add text 
                primaryWriter.write(text);
                primaryWriter.close();
                System.out.println("Text added to file: " + primaryFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {//Catches errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
