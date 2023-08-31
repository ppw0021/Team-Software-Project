
package com.mycompany.groupproject;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GroupProject {
private static Scanner scanner;
//Declan was here
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
                
		case "2" -> {}
                
                case "3" ->{}
                
                case "4"->{}
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
