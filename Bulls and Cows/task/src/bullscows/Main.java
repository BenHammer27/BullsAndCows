package bullscows;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length:");

        boolean correctDigits = false;
        int digits = 0;

        while (!correctDigits) {
            digits = scanner.nextInt();

            if (digits > 10) {
                System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough" +
                        "digits. Please try again.");
            } else {
                correctDigits = true;
            }
        }

        System.out.println("Input the number of possible symbols in the code:");
        int range = scanner.nextInt();
        scanner.nextLine();

        char[] secretCode = generateSecretNumber(digits, range);

        System.out.println("\nOkay let's start the game!");

        int turns = 1;
        int bulls;
        boolean solved = false;

        while (!solved){
            System.out.println("Turn " + turns + ":");
            String guess = scanner.nextLine();
            bulls = bullsAndCows(secretCode, guess);
            turns++;
            if(bulls == digits) {
                System.out.println("Congratulation");
                solved = true;
            }
        }
    }

    public static char[] generateSecretNumber (int digits, int range) {
        char[] secretCode = new char[digits];

        char[] characters = fillPossible(range);

        int lastInserted = 0;

        Arrays.fill(secretCode, (char) 100);

        while (lastInserted != digits - 1 || secretCode[0] == 100) {
            for (int i = lastInserted; i < digits; i++) {
                int random = (int) (Math.random() * range);

                if (i == 0 && characters[random] != 0) {
                    secretCode[i] = characters[random];

                } else if (i != 0 && !containing(secretCode, characters[random])) {
                    secretCode[i] = characters[random];
                    lastInserted = i;
                }
            }
        }
        System.out.printf("The secret is prepared:");
        for (int j = 0; j < digits; j++) {
            System.out.print("*");
        }
        if (range < 11) {
             System.out.printf(" (0-%d)", range-1);
        } else {
            System.out.printf(" (0-9, a-%s)", (char) (range+86));
        }
        return secretCode;
    }


    /*public static int[] generateCode(int digits) {

        int[] secretCode = new int[digits];

        int lastInserted = 0;

        for (int m = 0; m < secretCode.length; m++) {
            secretCode[m] = -1;
        }

        while (lastInserted != digits - 1 || secretCode[0] == -1) {
            int[] pseudoRandomNumber = getNewPseudoRandomNumber();
            for (int i = lastInserted; i < digits; i++) {
                for (int j = pseudoRandomNumber.length - 1; j >= 0; j--) {
                    if (i == 0 && pseudoRandomNumber[j] != 0) {
                        secretCode[i] = pseudoRandomNumber[j];
                        break;
                    } else if (i != 0 && !containing(secretCode, pseudoRandomNumber[j])) {
                        secretCode[i] = pseudoRandomNumber[j];
                        lastInserted = i;
                        break;
                    }
                }
            }
        }
        return secretCode;
    }

    public static int[] getNewPseudoRandomNumber () {
        double number = Math.random() * 1000000000;
        long pseudoRandomNumber = (long) number * 1000000000000000000L;
        String pseudoRandomString = Long.toString(pseudoRandomNumber);
        char[] PseudoChar = pseudoRandomString.toCharArray();
        int[] PseudoInt = new int[15];
        for (int j = 0; j < 15; j++) {
            PseudoInt[j] = Character.getNumericValue(PseudoChar[j]);
        }
        return PseudoInt;
    }*/

    public static int bullsAndCows (char[] array, String input) {

        int cows = 0;
        int bulls = 0;

        char[] testCode = input.toCharArray();

        for (int k = 0; k < array.length; k++) {
            if (testCode[k] == array[k]) {
                bulls++;
            } else if (containing(array, testCode[k]) && testCode[k] != array[k])
                cows++;
        }

        if (bulls == 0 && cows == 0) {
            System.out.print("None.\n");
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
        }
        return bulls;
        //System.out.print("The secret code is 9305.");
    }

    public static boolean containing (char[] array, int number) {
        boolean containing = false;
        for (char c : array) {
            if (c == number) {
                containing = true;
                break;
            }
        }
        return containing;
    }

    public static char[] fillPossible (int range) {
        char[] possible = new char[range];
        for (int i = 0; i < possible.length; i++) {
            if (i < 10) {
                possible[i] = (char) (i+48);
            } else {
                possible[i] = (char) (i+87);
            }
        }
        return possible;
    }
}
