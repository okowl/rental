package controller.utility;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.BiConsumer;

public class Utility {

    /**
     *
     * @param text
     */

    public static void prnt(String text){

        System.out.println("----------------------------------------\n");
        System.out.println(text);
        System.out.println("\n----------------------------------------");
    }
    public static void prntMe(String text){

        System.out.println(text);
    }


    /**
     *
     * @param regex - regex to check input
     * @param message - what to print
     * @return - result of the buffer reader that will be saved
     */

    public static String readInput(String regex, String message){

        String result = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            prnt(message);
            do {
                result = br.readLine();
                if(!validateMe(regex, result)){
                    prntMe("Please, enter the correct input");
                }
            } while (!validateMe(regex, result));

        }catch (Exception e) {
            prnt("Something went wrong, contact you system administrator");
        }
        return result;
    }

    /**
     *
     * @param regex
     * @param whatToCheck
     * @return
     */

    public static Boolean validateMe(String regex, String whatToCheck){
        return whatToCheck.matches(regex);
    }



}
