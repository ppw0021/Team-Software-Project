package com.mycompany.groupproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GroupProject {

    private String adminPassword;
    static Scanner scanner = new Scanner(System.in);
    private List<AbstractFile> files;
    
    private AbstractFile abstractFile;

    private static String directoryPath = System.getProperty("user.dir");

    public GroupProject() {
        adminPassword = "Admin";
        files = new ArrayList<>();
    }

    public AbstractFile getAbstractFile()
    {
        return abstractFile;
    }
    
    public void setAbstractFile(AbstractFile abstractFile)
    {
        this.abstractFile = abstractFile;
    }
    
    public void createFile() {
        scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        AbstractFile fileCreator = new CreateFile();

        fileCreator.create(fileName);

    }

    public static void viewFile() {
        //List Files
        ListFiles listFilesApplication = new ListFiles();
        listFilesApplication.listFiles(directoryPath);
    }

    public static void readFile(int status, int fileNumber, GroupProject application) {
        //Set mode DisplayContents
        application.setAbstractFile(new DisplayContents());
        application.getAbstractFile().viewOrSetFile(directoryPath, fileNumber, status); // Call the viewFile method from FileViewer class
    }

    public static void editFile(int fileNumber, String adminPassword, GroupProject application) {
        System.out.println("\nPlease Enter the Administrator Password:");
        String passwordInput = scanner.nextLine();
        if (passwordInput.equals(adminPassword)) {
            System.out.println("Correct password.\n Here are the file contents:");
            
            //Change mode to DisplayContents
            application.setAbstractFile(new DisplayContents());
            application.getAbstractFile().viewOrSetFile(directoryPath, fileNumber, 0);
            
            //Change mode to EditFile
            application.setAbstractFile(new EditFile());
            System.out.println("Please type what you would like to remove: (leave blank to append at end of document)");
            String find = scanner.nextLine();
            System.out.println("Please type what you would like to replace it with: (Leave blank to cancel)");
            String replace = scanner.nextLine();
            application.getAbstractFile().findAndReplace(find, replace);
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public static void main(String[] args) {
        GroupProject application = new GroupProject();

        System.out.println("Welcome to the Knowledge Depository");
        boolean status = true;
        while (status) {

            System.out.println("\nPlease select from the following options");
            System.out.println("Press 1 to view files");
            System.out.println("Press 2 to create a text file.");
            System.out.println("Press 3 to delete a text file. ");
            System.out.println("Press 4 to change admin password.");
            System.out.println("Press x to exit");

            try {

                String choice = scanner.nextLine();
                choice = choice.toLowerCase();

                switch (choice) {
                    case "1" -> {
                        viewFile();
                        System.out.print("Enter the file number to view: ");
                        Scanner input = new Scanner(System.in);
                        int fileNumber = input.nextInt();
                        input.nextLine(); // Consume the newline character

                        readFile(1, fileNumber, application);
                        System.out.println("Press 1 to view file");
                        System.out.println("Press 2 to view summary");
                        System.out.println("Press 3 to edit file");
                        System.out.println("Press b to go back.");
                        System.out.println("Press X to go exit");
                        try {

                            String state = scanner.nextLine();
                            state = state.toLowerCase();

                            switch (state) {
                                case "1" -> {
                                    readFile(0, fileNumber, application);

                                }

                                case "2" -> {
                                    //view summarry 
                                }

                                case "3" -> {
                                    editFile(fileNumber, application.adminPassword, application);
                                }
                                case "b" -> {
                                    state = "1";
                                }
                                case "x" ->
                                    status = false;

                                default ->
                                    System.out.println("Invalid menu input");
                            }
                        } catch (Exception e) {
                            System.out.println("You must input integer values");

                            scanner.next();//remove bad input from the scanner.
                        }
                    }

                    case "2" -> {

                        application.createFile();

                    }

                    case "3" -> {
                    }
                    case "4" -> {
                        System.out.println("Please enter old password:");
                        try {
                            String oldPassword = scanner.nextLine();
                            if (oldPassword.equals(application.adminPassword)) {
                                System.out.println("Password correct, please enter new password:");
                                try {
                                    application.adminPassword = scanner.nextLine();
                                } catch (Exception e) {
                                    System.out.println("Error with password entry.");
                                }
                            } else {
                                System.out.println("Password Incorrect.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error with password entry.");
                        }
                    }
                    case "x" ->
                        status = false;

                    default ->
                        System.out.println("Invalid menu input");
                }
            } catch (Exception e) {
                System.out.println("You must input integer values");

                scanner.next();//remove bad input from the scanner.
            }

        }
    }

}
