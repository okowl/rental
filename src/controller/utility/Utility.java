package controller.utility;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utility {

    /**
     * Method to print things with visual division
     * @param text - string that will be printed
     */

    public static void printWithDashes(String text){
        System.out.println("----------------------------------------------------------------------\n");
        System.out.println(text);
        System.out.println("\n----------------------------------------------------------------------");
    }

    /**
     * Method to pring things without it
     * @param text - string that will be printed
     */

    public static void prntMe(String text){
        System.out.println(text);
    }



    /**
     * Simple method to print the message and then validate user input
     * @param regex - regex to check input
     * @param message - what to print
     * @return - result of the buffer reader that will be saved
     */

    public static String readInput(String regex, String message){

        String result = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            printWithDashes(message);
            do {
                result = br.readLine();
                if(!validateMe(regex, result)){
                    prntMe("Please, enter the correct input");
                }
            } while (!validateMe(regex, result));

        }catch (Exception e) {
            printWithDashes("Something went wrong, contact you system administrator");
        }
        return result;
    }

    /**
     * Small method to validate input based on the regex
     * @param regex - hold regex pattern
     * @param whatToCheck - hold string that should be matched to the regex pattern
     * @return true if it is a match, and false if it not
     */

    public static Boolean validateMe(String regex, String whatToCheck){
        return whatToCheck.matches(regex);
    }



}
