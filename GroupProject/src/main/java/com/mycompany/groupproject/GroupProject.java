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

        //CreateFile.create(fileName); // Call the create method from CreateFile class
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
                    }

                    case "2" -> {
                        /*System.out.println("Please enter a name for your document");
                        String title = scanner.nextLine();
                        System.out.println("Please enter an admin password for editing later");
                        String password = scanner.nextLine();*/
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
