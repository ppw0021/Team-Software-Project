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

    private static String directoryPath = System.getProperty("user.dir");
    
    public GroupProject() {
        adminPassword = "Admin";
        files = new ArrayList<>();
    }

    public void createFile() {
        scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        AbstractFile fileCreator = new CreateFile();

        fileCreator.create(fileName);

    }

    public static void viewFile() {
        ListFiles listFilesApplication = new ListFiles();
        listFilesApplication.listFiles(directoryPath);
    }

    public static void readFile(int status, int fileNumber) {
        DisplayContents readFileApplication = new DisplayContents();
        readFileApplication.viewFile(directoryPath, fileNumber, status); // Call the viewFile method from FileViewer class
    }

    public static void editFile(int fileNumber, String adminPassword) {
        System.out.println("Please Enter the Administrator Password:");
        String passwordInput = scanner.nextLine();
        if (passwordInput.equals(adminPassword))
        {
            System.out.println("Correct.");
        }
        else
        {
            System.out.println("Incorrect.");
        }
    }
    
    public static void main(String[] args) {
        GroupProject application = new GroupProject();

        System.out.println("Welcome to the Knowledge Depository");
        boolean status = true;
        while (status) {

            System.out.println("Please select from the following options");
            System.out.println("Press 1 to view files");
            System.out.println("Press 2 to create a text file.");
            System.out.println("Press 3 to delete a text file. ");
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

                        readFile(1, fileNumber);
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
                                    readFile(0, fileNumber);

                                }

                                case "2" -> {
                                    //view summarry 
                                }

                                case "3" -> {
                                    editFile(fileNumber, application.adminPassword); 
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
