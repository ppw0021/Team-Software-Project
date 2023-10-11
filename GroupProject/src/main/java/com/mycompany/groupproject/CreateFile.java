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
            File mainFile = new File(DocumentName + ".txt");//Creates a .txt file
            File editsFile = new File("EDITS_" + DocumentName + ".txt");//Creates a edit.txt file
            if (mainFile.createNewFile() && editsFile.createNewFile()) {
                System.out.println("File created: " + mainFile.getName());
                FileWriter TextWriter = new FileWriter(mainFile, true);
                System.out.println("Please add your information");
                Scanner tx = new Scanner(System.in);
                String text = tx.nextLine();//Allows the user to add text 
                
                TextWriter.write(text);//Adds text to file 
                TextWriter.close();//Closes the writer
                
                System.out.println("Text added: " + mainFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {//Catches errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
