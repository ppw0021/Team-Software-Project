package com.mycompany.groupproject;


import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GroupProject {

    private String adminPassword;
    static Scanner scanner = new Scanner(System.in);
    private List<AbstractFile> files;

    private AbstractFile abstractFile;

    private static String directoryPath = System.getProperty("user.dir");

    public GroupProject() {//Constructor that sets default values
        adminPassword = "Admin";
        files = new ArrayList<>();
    }

    public AbstractFile getAbstractFile() {
        return abstractFile;
    }

    public void setAbstractFile(AbstractFile abstractFile) {
        this.abstractFile = abstractFile;
    }

    public void createFile() {//method that creates files and calls Createfile class
        scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        AbstractFile fileCreator = new CreateFile();

        fileCreator.create(fileName);

    }

    public static boolean viewFile() {
        //List Files
        ListFiles listFilesApplication = new ListFiles();
        return listFilesApplication.listFiles(directoryPath);
    }

    public static void readFile(boolean status, boolean edits, int fileNumber, GroupProject application) {
        //Set mode DisplayContents
        application.setAbstractFile(new DisplayContents());
        application.getAbstractFile().viewFile(directoryPath, fileNumber, status, edits); // Call the viewFile method from FileViewer class
    }

    public static void editFile(int fileNumber, String adminPassword, GroupProject application) {
        System.out.println("\nPlease Enter the Administrator Password:");
        String passwordInput = scanner.nextLine();
        if (passwordInput.equals(adminPassword)) {
            System.out.println("Correct password.");

            //Change mode to DisplayContents
            application.setAbstractFile(new DisplayContents());
            application.getAbstractFile().viewFile(directoryPath, fileNumber, false, false);

            File passThroughFile = application.getAbstractFile().getThisFile();

            //Change mode to EditFile
            application.setAbstractFile(new EditFile(passThroughFile));
            System.out.println("Please type what you would like to remove: (leave blank to append at end of document, or type just x to cancel)");
            String find = scanner.nextLine();
            if (find.toLowerCase().equals("x")) {
                System.out.println("No changes made.");
            } else {
                System.out.println("Please type what you would like to replace it with: (Leave blank to only remove selected text, or type just x to cancel)");
                String replace = scanner.nextLine();
                switch (application.getAbstractFile().findAndReplace(find, replace)) {
                    case 0:
                        System.out.println("Operation aborted. No changes made.");
                        break;
                    case 1:
                        System.out.println("Data successfully appended.");
                        break;
                    case 2:
                        System.out.println("Find and Replace completed successfully.");
                        break;
                    case 3:
                        System.out.println("No changes made.");
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public static void createFile(String adminPassword, GroupProject application) {
        System.out.println("\nPlease Enter the Administrator Password:");
        String passwordInput = scanner.nextLine();
        if (passwordInput.equals(adminPassword)) {
            application.createFile();
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public static void deleteFile(int fileNumber, String adminPassword, GroupProject application) {
        System.out.println("\nPlease Enter the Administrator Password:");
        String passwordInput = scanner.nextLine();
        if (passwordInput.equals(adminPassword)) {
            System.out.println("Correct password.");

            //Change mode to DisplayContents
            application.setAbstractFile(new DisplayContents());
            application.getAbstractFile().viewFile(directoryPath, fileNumber, false, false);

            File passThroughFile = application.getAbstractFile().getThisFile();

            //Change mode to EditFile
            application.setAbstractFile(new EditFile(passThroughFile));

            System.out.println("Are you sure you want to delete this file? (Press y for yes, press any other key for no.)");
            String find = scanner.nextLine();
            if (find.toLowerCase().equals("y")) {
                application.getAbstractFile().deleteFileAndEdits();
            } else {
                System.out.println("No changes made.");
            }
        } else {
            System.out.println("Incorrect password.");
        }
    }

    public static void main(String[] args) {//Start of the main code
        GroupProject application = new GroupProject();

        System.out.println("Welcome to the Knowledge Depository");
        boolean status = true;
        while (status) {//Infinte loop starts
            //Displays menu
            System.out.println("\nPlease select from the following options:");
            System.out.println("Press 1 to view information pages.");
            System.out.println("Press 2 to create a new information page.");
            //System.out.println("Press 3 to delete a text file. ");
            System.out.println("Press 3 to change admin password.");
            System.out.println("Press x to exit.");

            try {

                String choice = scanner.nextLine();
                choice = choice.toLowerCase();

                switch (choice) {
                    case "1" -> {//Displays information 
                        boolean doFilesExist = viewFile();
                        if (doFilesExist) {//checkks if files exists
                            System.out.print("Enter the file number to view: ");//Asks for user input
                            Scanner input = new Scanner(System.in);
                            int fileNumber = input.nextInt();
                            input.nextLine(); // Consume the newline character

                            readFile(true, false, fileNumber, application);
                            System.out.println("Press 1 to view information.");
                            //System.out.println("Press 2 to view summary");
                            System.out.println("Press 2 to edit information.");
                            System.out.println("Press 3 to view edit history.");
                            System.out.println("Press 4 to delete file.");
                            System.out.println("Press b to go back.");
                            System.out.println("Press X to go exit.");
                            try {

                                String state = scanner.nextLine();
                                state = state.toLowerCase();

                                switch (state) {
                                    case "1" -> {
                                        //View file
                                        readFile(false, false, fileNumber, application);
                                    }
                                    case "2" -> {
                                        //Edit file
                                        editFile(fileNumber, application.adminPassword, application);
                                    }
                                    case "3" -> {
                                        //View edit history
                                        readFile(false, true, fileNumber, application);
                                    }
                                    case "4" -> {
                                        deleteFile(fileNumber, application.adminPassword, application);
                                    }
                                    case "b" -> {
                                        state = "1";
                                    }
                                    case "x" ->
                                        status = false;

                                    default ->
                                        System.out.println("Invalid menu input.");
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                                System.out.println("You must input integer values.");

                                scanner.next();//remove bad input from the scanner.
                            }
                        }
                    }
                    case "2" -> {

                        createFile(application.adminPassword, application);

                    }

                   
                    case "3" -> {//Changes password
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
                        System.out.println("Invalid menu input.");
                }
            } catch (Exception e) {
                System.out.println("You must input integer values.");

                scanner.next();//remove bad input from the scanner.
            }

        }
    }

}
