/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dec50
 */
public class EditFile extends AbstractFile {

    public EditFile() {
        super();
    }

    public EditFile(File file) {
        super(file);
    }

    @Override
    public int findAndReplace(String find, String replace) {

        if (replace.toLowerCase().equals("x")) {
            //Useer cancelled
            return 0;
        }

        FileWriter writerEdits = null;
        FileWriter writerFile = null;
        
        String fileContents = "";
        try {
            writerEdits = new FileWriter(this.getThisFileEdits().getName(), true);
            if (find.equals("")) {
                //Append Mode
                writerFile = new FileWriter(this.getThisFile().getName(), true);
            }
        } catch (IOException ex) {
            System.out.println("Error Opening edits file, please check that EDITS_ file exists.");
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy ");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);

        String editsHeader = ("___________________________________________\nEdits made by Admin at: " + formattedDateTime + "\n");
        String edits = "";
        String editsFootNote = ("\nEnd of edits.\n*******************************************\n");

        //Make no changes mode
        if (replace.equals("") && find.equals("")) {

            return 0;
        }
        //Append mode
        if (find.equals("")) {
            //System.out.println(this.getThisFileEdits());
            edits += "*APPENDED DATA:*\n" + replace;
            try {
                edits = (editsHeader + edits + editsFootNote);
                writerEdits.write(edits);
                writerEdits.close();
                writerFile.write(("\n" + replace));
                writerFile.close();
                //Data appended
                return 1;
            } catch (IOException ex) {
                System.out.println("Error opening edits file, please check that EDITS_ file exists.");
                return 3;
            }
        } //Find and replace mode
        else {
            edits += "*DELETED AND REPLACED DATA.*\n*DELETED:*\n" + find + "\nREPLACED:\n" + replace;
            try {
                fileContents = new String(Files.readAllBytes(Paths.get(this.getThisFile().getAbsolutePath())));
                writerFile = new FileWriter(this.getThisFile().getName(), false);
                if (!fileContents.contains(find)){
                    System.out.println(fileContents + "\n");
                    System.out.println(find);
                    return 3;
                }
                fileContents = fileContents.replace(find, replace);
                edits = (editsHeader + edits + editsFootNote);
                writerEdits.write(edits);
                writerEdits.close();
                writerFile.write(fileContents);
                writerFile.close();
                
            } catch (IOException ex) {
                System.out.println(ex);
                System.out.println("Error Reading File");
                return 3;
            }
            return 2;
        }
    }
}
