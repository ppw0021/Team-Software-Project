package com.mycompany.groupproject;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class CreateFile extends AbstractFile {

    public String DocumentName;

    public String Password;

    public CreateFile() {
        super("default", "default");
    }

    @Override
    public void create(String DocumentName) {
        try {
            File myObj = new File(DocumentName + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
