// Designed by Ciarán Ó hAoláin

import java.util.Scanner;
public class LuhnAlgorithm{	
        public static void main(String[] args) {
        boolean disableOptions = true; // If true the program will assume the user wants to enter their entire number
        boolean repeat = false; // If true the program will keep asking for more numbers to work with after a validation / check number generation 
        boolean findCheck = true;
        do {            
            Scanner userInput = new Scanner(System.in);
        	if (!disableOptions) {            
	        	System.out.println("Would you like to provide your entire number (or else you can leave out the last digit)? (Answer y/n)");
	            String response = userInput.nextLine();
		        if (response.charAt(0) == 'n') {            
		            System.out.println("Number (excluding the final digit) to be verified using the Luhn Algorithm:");            
		        }
		        else if (response.charAt(0) == 'y') {            
		            findCheck = false;
		            System.out.println("Full number to be verified using the Luhn Algorithm:");            
		        }
		        else {            
		            System.out.println("You provided an invalid answer. We'll assume you don't want to provide your whole number.");
		            System.out.println("\nNumber (excluding the final digit) to be verified using the Luhn Algorithm:");            
		        }	        
	        }
	        else {
	        	findCheck = false;
	        	System.out.println("Options disabled, please input your full number to be verified against the Luhn Algorithm:");
	        }
	        long number = userInput.nextLong();
	        if (!repeat) {
	        	userInput.close();
	        }
	        long temp = number;
	        int numberLength = Long.toString(number).length();
	        int[] digits = new int[numberLength];
	        
	        // Add digits to an array        
	        for (int i=0; i<numberLength; i++) {         
	            digits[i] = (int) (temp%10);
	            temp = temp/10;            
	        }    
	        int temparray[] = digits.clone();
	        int total = 0;  
	        
	        // Find value of every second digit for validity check
	        for (int i = 1; i<numberLength; i+=2) {
	            // Changes indexing position on first iteration if check digit isn't provided
	            if (findCheck && i==1) {                
	                i--;                
	            }
	            temparray[i] = temparray[i]*2;
	            if (temparray[i]>9) {                
	                temparray[i] = (temparray[i]-9);                      
	            }            
	            total = total+temparray[i];                     
	        }
	        
	        // Find total for validity check
	        for (int i = 0; i<numberLength; i+=2) {
	        	
	            // Changes indexing position on first iteration if check digit isn't provided
	            if (findCheck && i==0) {
	                i++;
	            }
	            total = total+temparray[i];            
	        }        
	        System.out.println();
	
	        // Decide course of action based on initial user input
	        if (findCheck) {
	        	
	        	// Find check number
	            System.out.println("Your check number (final digit) is: " + returnCheckNum(total));        	               
	        }
	        else {
	        	
	        	// Conduct validity check
	            if (isValid(total)) {                
	                System.out.println("Number IS valid.");                
	            }
	            else {                
	                System.out.println("Number is NOT valid.");               
	            }                       
	        } 
        } while (repeat);
    }
    
    // Takes total value and verifies the number, returns a boolean true if valid, false if invalid
    public static boolean isValid(int n) {        
        if (n%10==0) {
            return true;
        }
        else {
            return false;
        }       
    }
    
    public static int returnCheckNum(int n) {
    	return (n*9)%10;
    }
}