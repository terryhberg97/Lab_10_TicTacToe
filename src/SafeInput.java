
import java.util.Scanner;
public class SafeInput {
    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {

        int retInt = 0;
        boolean done = false;
        do
        {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You entered an invalid input");
                pipe.nextLine();
            }
        } while (!done);
        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean done = false;
        do
        {
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("You have entered an invalid input");
                pipe.nextLine();
            }
        } while (!done);
        return retDouble;

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        int retRangedInt = 0;
        boolean done = false;
        do
        {
            System.out.println("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retRangedInt = pipe.nextInt();
                pipe.nextLine();

                if (retRangedInt <= high && retRangedInt >= low) {
                    done = true;
                }
                else
                {
                    System.out.println("Invalid, must be between " + low + " - " + high);
                }

            }
            else
            {
                System.out.println("You have entered an invalid input");
                pipe.nextLine();
            }

        } while (!done);
        return retRangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {

        double retRangedDouble = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.println("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retRangedDouble = pipe.nextDouble();
                pipe.nextLine();

                if (retRangedDouble <= high && retRangedDouble >= low)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Invalid, must be between " + low + " - " + high);
                }
            }
            else
            {
                System.out.println("You have entered an invalid input");
                pipe.nextLine();
            }
        } while (!done);
        return retRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {

        boolean retYNConfirm = false;
        boolean done = false;
        String input = "";
        String trash = "";

        do
        {
            System.out.println("\n" + prompt + ": ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y"))
            {
                retYNConfirm = true;
                done = true;

            }
            else if (input.equalsIgnoreCase("N"))
            {
                retYNConfirm = false;
                done = true;
            }
            else
            {
                System.out.println("Invalid, must be Y or N");
            }

        } while (!done);
        return retYNConfirm;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {

        String retRegExString = "";
        boolean done = false;

        do
        {
            System.out.println("\n" + prompt + ": ");
            retRegExString = pipe.nextLine();
            if (retRegExString.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Invalid input");
            }

        } while (!done);
        return retRegExString;
    }

    public static void prettyHeader(String msg)
    {

    }
}

