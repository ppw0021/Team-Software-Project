package exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeProductMenu {
	private static Scanner scanner;

	public static void product() throws InputMismatchException {
		try {

			System.out.println("Enter first number:");
			int value1 = scanner.nextInt();
			System.out.println("Enter second number:");
			int value2 = scanner.nextInt();
			System.out.println("Product is: " + (value1 * value2));
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("You must input integer values");
			
			scanner.next();// remove bad input from the scanner.
		}

	}

	public static void main(String args[]) {
                    scanner = new Scanner(System.in);
                    int choice =0;
		while(choice!=2) {
			System.out.println("Welcome to the calculator.");
			System.out.println("1. Compute Product");
			System.out.println("2. quit");	
		
		try {
		
		 choice = scanner.nextInt();
		scanner.nextLine();
		switch(choice) {
		case 1:
			product();
			break;
		case 2:
			System.out.println("Goodbye");
			break;
		default:
			System.out.println("Invalid menu input");
			break;
		}
		}
		catch(InputMismatchException inputMismatchException)
		{
		System.out.println("You must input integer values");
		
		scanner.next();//remove bad input from the scanner.
		}
		
		
	}
}
}
