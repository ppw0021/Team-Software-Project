
package com.mycompany.groupproject;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class GroupProject {
private List<File> files;

    public GroupProject(){
        files=new ArrayList<>();
    }
private static Scanner scanner;

public static void createFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scanner.nextLine();
        CreateFile.create(fileName); // Call the create method from CreateFile class
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Knowledge Depository");
        boolean status=true;
        while(status){
        scanner = new Scanner(System.in);
        System.out.println("Please select from the following options");
            System.out.println("Press 1 to view files");
            System.out.println("Press 2 to create a text file.");
            System.out.println("Press 3 to delete a text file. ");
            System.out.println("Press x to exit");
            
        try {
		
		String choice = scanner.nextLine();
                choice=choice.toLowerCase();
                
		switch(choice) {
		case "1" -> {}
                
		case "2" -> {
                    System.out.println("Please enter a name for your document");
                    String title= scanner.nextLine();
                    System.out.println("Please enter an admin password for editing later");
                    String password=scanner.nextLine();
                    createFile();
                    
        
                    
                }
                
                case "3" ->{}
                
                
                case "x"->status=false;
                
                
                
                    
		default -> 
                    System.out.println("Invalid menu input");
		}
        }
		catch(Exception e)
		{
		System.out.println("You must input integer values");
		
		scanner.next();//remove bad input from the scanner.
		}
        
        
        
    }
    }
}
