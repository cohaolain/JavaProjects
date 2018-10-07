import java.util.Scanner;

public class LuhnAlgorithm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String cardNumberString = scanner.nextLine();
        long cardNumberLong = Long.parseLong(cardNumberString);

        System.out.println(isValidCardNumber(cardNumberString)?"VALID":"INVALID");

        // Uses faster maths library method (31% faster)
        System.out.println(mathIsValidCardNumber(cardNumberLong)?"VALID":"INVALID");

    }

    // Slower string method
    static boolean isValidCardNumber(String cardNumber) {
        boolean doubleThisDigit = cardNumber.length()%2==0;
        int total = 0;
        for (char c : cardNumber.toCharArray()) {
            int digitValue = Character.getNumericValue(c);

            if (doubleThisDigit && digitValue<5) total+=2*digitValue;
            else if (doubleThisDigit) total+=2*digitValue-9;
            else total += digitValue;

            doubleThisDigit = !doubleThisDigit;
        }
        return total%10==0;
    }

    // (Maths library method) ~31% faster!!
    static boolean mathIsValidCardNumber(long cardNumber) {
        int total = 0;
        int numberLength = (int) Math.ceil(Math.log10(cardNumber+1));
        for (int i = 0; i<numberLength; i++) {
            total += i%2==0?cardNumber%10:(cardNumber%10<5?(cardNumber%10)*2:(cardNumber%10)*2-9);
            cardNumber/=10;
        }
        return total%10==0;
    }

}
