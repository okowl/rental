package controller.utility;


import models.customers.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * TODO: if have time
     * @param filePath
     * @return
     */
    public static List listFiller(String filePath){

        List<String> newList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((br.readLine()) != null) {
            }

        } catch (IOException e){
            prntMe("404. Files not found or could not be parsed");
        }

        return newList;
    }

    /**
     * TODO: troubleshoot if have time
     * @param arrayListToWrite
     * @param pathToFile
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static void writeToFile(List<Customer> arrayListToWrite, String pathToFile) throws FileNotFoundException, IOException{

        FileOutputStream fos = new FileOutputStream(pathToFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arrayListToWrite);
        oos.close();

        prntMe("New Record has been written!");
    }



}
