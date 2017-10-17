// Designed by Ciarán Ó hAoláin

/* Simple program to list prime numbers up to
 * a specified target. This program utilises
 * the Sieve of Eratosthenes technique.
 */

import java.util.Scanner;

public class findPrimeNumbers {
	
	public static void main(String[] args) {
		
		Scanner uInput = new Scanner(System.in);
		int n = uInput.nextInt();
		boolean[] primes = new boolean[n];
		uInput.close();
		
		// Set all to true
		for (int i = 2; i < primes.length; i++) {
			
			primes[i]=true;
			
		}
		
		// Set all non-primes in range to false
		for (int i = 2; i < primes.length; i++) {
			
			int j = 2;
			while (i*j<primes.length) {
				
				primes[i*j]=false;
				j++;
				
			}
			
		}
		
		// Print all indexes with value true (prime)
		for (int i = 0; i < primes.length; i++) {
			
			if (primes[i]) {

				System.out.println(i);
				
			}
			
		}
		
	}
	
}
