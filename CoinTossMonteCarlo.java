// github.com/cohaolain

import java.util.Scanner;

public class CoinTossMonteCarlo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Number of tosses:");
        int n = input.nextInt();
        System.out.println("Tails in a row:");
        int t = input.nextInt();
        input.close();

        final int iterations = 10000000;
        int countTrue = 0;

        for (int i = 0; i < iterations; i++) {

            int recordRepeats = 0;
            int repeatCount = 0;
            for (int j = 0; j < n; j++) {

                boolean isTails = false;

                if (Math.random() > 0.5f) {
                    isTails = true;
                }

                if (isTails) {
                    repeatCount++;
                    if (repeatCount > recordRepeats) {
                        recordRepeats = repeatCount;
                    }
                } else {
                    repeatCount = 0;
                }

            }
            if (recordRepeats >= t) {
                countTrue++;
            }
        }

        System.out.println(Math.round((100f * countTrue) / iterations));

    }
}