import java.util.Scanner;
public class safeInput {
    public static String getNonZeroLengthString(Scanner scanner, String prompt) {
        String nonZeroLength = "";

        do {
            System.out.print("\n" + prompt);
            nonZeroLength = scanner.nextLine();

            if (nonZeroLength.isEmpty()) {
                System.out.println("\nYou must enter some characters!");
            }

        } while (nonZeroLength.isEmpty());

        return nonZeroLength;
    }

    public static int getInt(Scanner scanner, String prompt) {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt);
            if (scanner.hasNextInt()) {
                retValue = scanner.nextInt();
                scanner.nextLine();
                done = true;
            } else {
                trash = scanner.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        } while (!done);

        return retValue;
    }

    public static double getDouble(Scanner scanner, String prompt) {
        double retValue = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt);
            if (scanner.hasNextDouble()) {
                retValue = scanner.nextDouble();
                done = true;
            } else {
                trash = scanner.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        } while (!done);

        return retValue;
    }

    public static int getRangedInt(Scanner scanner, String prompt, int low, int high) {
        int retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (scanner.hasNextInt()) {
                retValue = scanner.nextInt();
                scanner.nextLine();
                if (retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retValue);
            } else {
                trash = scanner.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        } while (!done);

        return retValue;
    }

    public static double getRangedDouble(Scanner scanner, String prompt, double low, double high) {
        double retValue = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (scanner.hasNextDouble()) {
                retValue = scanner.nextDouble();
                scanner.nextLine();
                if (retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("\nNumber is out of range [" + low + " - " + high + "] not: " + retValue);
            } else {
                trash = scanner.nextLine();
                System.out.println("You must enter a valid number not: " + trash);
            }
        } while (!done);

        return retValue;
    }

    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        String response = "";
        while(true){
            System.out.print("\n" + prompt + " [Y/N] ");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                return true;
            } else if (response.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("You must answer [Y/N]! Not " + response);
            }
        }
    }

    public static String getRegExString(Scanner scanner, String prompt, String regEx) {
        String value = "";
        boolean gotAValue = false;

        do
        {
            System.out.print(prompt);
            value = scanner.nextLine();
            if(value.matches(regEx))
            {
                gotAValue = true;
            } else {
                System.out.print("\nInvalid input: " + value);
            }
        }while(!gotAValue);
        return value;
    }
}