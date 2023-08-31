package com.mycompany.groupproject;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile extends AbstractFile {

    //public String DocumentName;
    //public String Password;
    public CreateFile() {
        super("default.txt", "EDITS_default.txt");
    }

    @Override
    public void create(String DocumentName) {
        try {
            File primaryFile = new File(DocumentName + ".txt");
            File editsFile = new File("EDITS_" + DocumentName + ".txt");
            if (primaryFile.createNewFile() && editsFile.createNewFile()) {
                System.out.println("File created: " + primaryFile.getName());
                this.setDocumentName(DocumentName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
