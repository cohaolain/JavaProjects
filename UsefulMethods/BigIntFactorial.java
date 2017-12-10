// github.com/cohaolain

package UsefulMethods;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntFactorial{
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long num = input.nextLong();
		String answer = returnFactorial(num);
		System.out.println(num + "! = " + answer);
		input.close();
	}
	
	private static String returnFactorial(long n) {
		BigInteger nBig = new BigInteger(Long.toString(n));
		for (long i=Math.abs(n); i>1; i--) {
			BigInteger iBig = new BigInteger(Long.toString(i-1));
			nBig = nBig.multiply(iBig);
		}
		return nBig.toString();
	}
	
}