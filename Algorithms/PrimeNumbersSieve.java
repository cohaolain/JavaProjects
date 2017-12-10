// github.com/cohaolain

/* Simple program to list prime numbers up to
 * a specified target. This program utilises
 * the Sieve of Eratosthenes technique.
 */

package Algorithms;

import java.util.Scanner;
public class PrimeNumbersSieve {
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        int n = uInput.nextInt();
        boolean[] primes = new boolean[n];
        uInput.close();

        // Set all to true
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        // Set all non-primes in range to false
        for (int i = 2; i < primes.length; i++) {
            for (int j = 2; i * j < primes.length; j++) {
                primes[i * j] = false;
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
