package controller;
/**
 * @author Olga Kiseleva 2017136
 * @date 10.05.2019
 */

import models.customers.*;
import models.rent.Rent;
import models.titles.*;
import sun.jvm.hotspot.utilities.Interval;

import static controller.utility.Utility.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/***
 * This is singleton controller
 * because it's best practice
 */

public class Controller implements Options4Menu {


    private List <Customer> customerList;
    private List <Titles> titlesList;
    private List <Rent> rentedItems;
    //private String pathToCustomers = "/Users/olgakiseleva/Desktop/@rental_19/src/files/customers.txt";

    private static Controller controller;


    public static Controller getInstance() {
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }

    private Controller() {
        customerList = new ArrayList<>();
        titlesList = new ArrayList<>();
        rentedItems = new ArrayList<>();
        fillList4Test();

        menu();

    }
    //method that creates couple of record in every list so you have something to test
    //eg has overdue items rented to test penalty points
    //PS I could add to customer enable/disable status and if customer goes into -100 loyalty points to disable account
    //but I dont have time I guess

    public void fillList4Test(){

        SimpleDateFormat myFormat = new SimpleDateFormat("hh:mm:ss dd MM yyyy");
        String myDate = "14:00:00 01 05 2019";
        Date dateOfRent = null;
        try {
            dateOfRent = myFormat.parse(myDate); } catch (ParseException e) { e.printStackTrace(); }

        //couple of record to play with
        customerList.add(new MusicL("Oli","bad time managment street"));
        customerList.add(new TVL("Joe Doe", "Amsterdam"));
        customerList.add(new PremiumC("Taras", "Slava Ukraine street"));
        customerList.add(new MovieL("Felipe", "super hero lane"));


        titlesList.add( new Movies("Java","1999","Amilcar","thriller","Oscar"));
        titlesList.add( new BoxSet("Best teacher of the year", "2019", "Amilcar Aponte", "Documentary", 4));
        titlesList.get(0).setRented(true);

        customerList.get(3).getMembershipCard().setLoyalty_points(60);

        rentedItems.add(new Rent(1, customerList.get(3), titlesList.get(0)));
        rentedItems.get(0).setStatus("rented");
        rentedItems.get(0).setDateOfRent(dateOfRent);


        titlesList.get(1).setRented(true);

        customerList.get(1).getMembershipCard().setLoyalty_points(40);

        rentedItems.add(new Rent(2, customerList.get(1), titlesList.get(1)));
        rentedItems.get(1).setStatus("rented");
        rentedItems.get(1).setDateOfRent(dateOfRent);


    }

    /**
     * menu navigation method
     * it just print stuff and redirect user based on the chosen option
     */

    public void menu(){

        String chosenOption = readInput("[1-7]", "Please chose one of the menu item:" +
                "\n1. Search for title\n2. Search for customer\n3. Add new customer \n4. Add new title\n" +
                "5. Update customer profile\n6. Record a new rent\n7. Return a rented item");
        switch (chosenOption){

            case "1":
                search4Title();
                break;
            case "2":
                search4Customers();
                break;
            case "3":
                addNewCustomers();
                break;
            case "4":
                addNewTitle();
                break;
            case "5":
                updCustomer();
                break;
            case "6":
                recordRent();
                break;
            case "7":
                returnRent();
                break;

        }

    }

    /**
     * Lambda method to search for a title name
     * it runs through array list of titles and streams all objects that maches to the input into the separate stream
     * This stream will be printed to the stuff
     */

    @Override
    public void search4Title() {

        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert title name, ID or customer address");
        List<Titles> filteredTitles = titlesList.stream().filter(title->{
            //if title belongs to the live concert or music we also checking band name
            if(title.getClass().getSimpleName().equals(Music.class.getSimpleName())){
                return ((Music)title).getBand_name().toLowerCase().contains(input.toLowerCase());
            }
            if(title.getClass().getSimpleName().equals(LiveConcert.class.getSimpleName())){
                return ((LiveConcert)title).getBand_name().toLowerCase().contains(input.toLowerCase());
            }
            return title.getName().toLowerCase().contains(input.toLowerCase());
        }).collect(Collectors.toList());

        if(filteredTitles.isEmpty()){
            prntMe("No matches found");
        }

        for (Titles titles :filteredTitles
        ) {
            System.out.println(titles);
        }

        menu();
    }

    /**
     * Lambda method to search for a customer
     * It run through Customers list and streams all objects that matches to the search string to the new array
     * This array get prints in the end
     */

    @Override
    public void search4Customers() {
        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert Name or customer address");
        List<Customer> filteredCustomers = customerList.stream().filter(cm->cm.getName()
                .toLowerCase().contains(input.toLowerCase()) ||
                cm.getAddress().toLowerCase().contains(input.toLowerCase())).collect(Collectors.toList());
        if(filteredCustomers.isEmpty()){
            prntMe("No matches found");
        }

        for (Customer customer :filteredCustomers
             ) {
            System.out.println(customer);
        }
        menu();

    }

    /**
     * Method to find customer by ID for update customer method
     * @param ID - customer id
     * @return - list of customer sthat matches this ID
     */

    public List searchCustomerID(int ID) {
         List<Customer> filteredCustomers = customerList.stream().filter(cm-> cm.getID().equals(ID)).collect(Collectors.toList());

         if(filteredCustomers.isEmpty()){
            prntMe("No matches found");
         }
        return filteredCustomers;
    }

    /**
     * method to check how many items currently rented by customer
     * @param customerID - id of customer
     * @return returns size of a new list collected
     */

    public Integer rentedItems(int customerID){
        List <Rent> itemsCurrentlyRented = rentedItems.stream().filter(rent -> rent.getStatus()
        .contains("rented") && rent.getCustomer().getID().equals(customerID)).collect(Collectors.toList());
       return itemsCurrentlyRented.size();

    }

    /**
     * Parsing all rented items
     * @return list with results
     */

    public List allRentedItems(){
        List <Rent> itemsRented = rentedItems.stream().filter(rent -> rent.getStatus().contains("rented"))
                .collect(Collectors.toList());
        return itemsRented;

    }

    /**
     * Method that adds new titles to the titles list
     * After stuff chose which title in particular they want to add it will redirect it to the specefic method
     * which will feel all the parameters for a new title and add it then to the Title list
     */

    @Override
    public void addNewTitle() {

        printWithDashes("Please chose one of the following options:" +
                "\n1 - new Music Album\n2 - new Live Concert\n3 - new TV-show\n4 - new Movie");

        //buitiful map for mapping purposes .)
       Map <String, Titles> titleMapper = new HashMap<>();
        titleMapper.put("1", new Music());
        titleMapper.put("2", new LiveConcert());
        titleMapper.put("3", new BoxSet());
        titleMapper.put("4", new Movies());

        Titles title = null;

        String optionChosen = readInput("[1-4]", "Please use just numbers");

        switch (optionChosen){
            case "1":
                title = createMusic((Music)titleMapper.get("1"));
                break;
            case "2":
                title = createLiveConcert((LiveConcert)titleMapper.get("2"));
                break;
            case "3":
                title = createBoxSet((BoxSet)titleMapper.get("3"));
                break;
            case "4":
                title = createMovie((Movies)titleMapper.get("4"));
                break;
        }
        //adding many boxes of the same title if shop will get more than one
        Integer copiesOfTitle = Integer.parseInt(readInput
                ("[0-9]+", "Hom many copies you want to add? (please use just numbers)"));

        //if user decide to put 0 here
        if (copiesOfTitle <= 0){
            copiesOfTitle = 1;
        }

        //for loop that adds title to the list with a new ID
        for(int i = 0; i < copiesOfTitle; i++){
            titlesList.add(Titles.factory(title, optionChosen));
            Titles.incrementCounter();
        }
        menu();
    }

    /** TODO: refactor 4 methods below
     * Method to set all of the parameters of the new movie title
     * Using utility to validate and print message
     * @param movies
     * @return movie object back to addNewTitle method in order to add it to the TitleList
     */

    private Titles createMovie(Movies movies) {

        movies.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a movie name"));
        movies.setDirector(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a director name"));
        movies.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a movie genre"));
        movies.setRewards(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter any rewards that movie won"));
        movies.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));

        return movies;
    }

    /**
     * Method to set all of the parameters of the new movie title
     * Using utility to validate and print message
     * @param boxSet
     * @return TV show object back to addNewTitle method in order to add it to the TitleList
     */
    private Titles createBoxSet(BoxSet boxSet) {

        boxSet.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a TV-show name"));
        boxSet.setDirector(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a director name"));
        boxSet.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a TV-Show genre"));
        boxSet.setNumSeasons(Integer.parseInt(readInput("[0-9]+","Please enter number of seasons")));
        boxSet.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));

        return boxSet;
    }

    /**
     * Method to set all of the parameters of the new movie title
     * Using utility to validate and print message
     * @param liveConcert
     * @return a Live Concert object back to addNewTitle method in order to add it to the TitleList
     */

    private Titles createLiveConcert(LiveConcert liveConcert) {

        liveConcert.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a Live concert name"));
        liveConcert.setBandName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a band name"));
        liveConcert.setEventName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an Event name"));
        liveConcert.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));


        return liveConcert;
    }

    /**
     * Method to set all of the parameters of the new movie title
     * Using utility to validate and print message
     * @param music
     * @return a new album object back to addNewTitle method in order to add it to the TitleList
     */
    private Titles createMusic(Music music) {

        music.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an album name"));
        music.setBandName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a band name"));
        music.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an album genre"));
        music.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));


        return music;
    }

    /**
     * Method to make a new customer
     */

    @Override
    public void addNewCustomers() {

        Customer cm = new Customer(
                readInput("^[A-Za-z _]*[A-Za-z][A-Za-z _]*$","Please enter customer full name"),
                readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter customer full address")
        );


        Map<String, Customer> options = new HashMap<>();
        options.put("1", new MusicL(cm));
        options.put("2", new TVL(cm));
        options.put("3", new MovieL(cm));
        options.put("4", new PremiumC(cm));

        printWithDashes("Ask the customer what subscription type they want buy");
        prntMe("Choose one of options above:");
        prntMe("1 - for Music Lovers, 2 - TV Lovers, 3 - Movie Lovers, 4 - for Premium");


        String chosenOption = readInput("[1-4]", "Please just use numbers");

        switch (chosenOption){
            case "1":
                customerList.add(options.get("1"));
                break;
            case "2":
                customerList.add(options.get("2"));
                break;
            case "3":
                customerList.add(options.get("3"));
                break;
            case "4":
                customerList.add(options.get("4"));
                break;
        }

        //setting up customer card
        int newCustomerID = customerList.size()-1;
        Integer opcard = Integer.parseInt(readInput("[1-2]", "What card does customer hold: \n1. Debit\n2. Credit"));
        if(opcard.equals(1))
        { customerList.get(newCustomerID).getMembershipCard().setCard(CardType.DEBIT);}
        else {customerList.get(newCustomerID).getMembershipCard().setCard(CardType.CREDIT);}

        menu();
    }

    /**
     * method to update selected customer information and then change it
     * TODO: change customer id to index in Array and troubleshoot
     */

    @Override
    public void updCustomer() {

        int customerID = Integer.parseInt(readInput("[0-9]+", "Please, enter customer ID (use just numbers)"));
        List <Customer> cm = searchCustomerID(customerID);
        if(cm.isEmpty()){
            prntMe("This customer doesn't exist, check your input!");
            menu();
        }
        //printing result
        for (Customer customer :cm) { System.out.println(customer); }

        String optionChosen = readInput("[1-4]", "What do you want to change: " +
                "\n1. Name \n2. Address\n3. Membership type\n4. All of the above");

        switch (optionChosen){
            case "1":
                updateCustomerName(customerID);
                break;
            case "2":
                updateCustomerAddress(customerID);
                break;
            case "3":
                updateMembership(customerID);
                break;
            case "4":
                updateCustomerName(customerID);
                updateCustomerAddress(customerID);
                updateMembership(customerID);
                break;
        }

        menu();
    }

    /**
     * method to update customer name
     * @param customerID to find customer in array of customers
     */

    private void updateCustomerName(int customerID) {
        String  newName= readInput("^[A-Za-z _]*[A-Za-z][A-Za-z _]*$","Please new name");
        customerList.get(customerID-1).setName(newName);
        prntMe("Customer name was successfully updated");
    }

    /**
     * method to update customer address
     * @param customerID to find customer in array of customers
     */

    private void updateCustomerAddress(int customerID) {
        String  newAddress = readInput("^[A-Za-z _]*[A-Za-z][A-Za-z _]*$","Please new address");
        customerList.get(customerID-1).setAddress(newAddress);
        prntMe("Customer address was successfully updated");
    }

    /**
     * method to change customer membership type
     * @param customerID to find customer in array of customers
     */

    private void updateMembership(int customerID) {
        String newPlan = "";
        String optionChosen = readInput("[1-4]","Please chose one of the following options:" +
                "\n1 - for Music Lovers, 2 - TV Lovers, 3 - Movie Lovers, 4 - for Premium");
        if(optionChosen.equals("1")){ newPlan = "MusicL";
        } else if(optionChosen.equals("2")){ newPlan = "TVL";
        } else if (optionChosen.equals("3")){newPlan = "MovieL";
        }else if(optionChosen.equals("4")){newPlan = "PremiumC";}

        customerList.get(customerID-1).setCustomerType(newPlan);
        prntMe("Customer plan was successfully updated");
    }

    /**
     * method to create a record of the rent and add it to the array list of rented items
     * TODO: customer rentHistory
     */

    @Override
    public void recordRent() {

        //just small validation from crush because of empty lists
        if(titlesList.isEmpty() || customerList.isEmpty()){
            prntMe("This system doesn't have registered users or items\n" +
                    "Please upload database first");
            menu();
        }
        try {

            //check if the chosen item available
            Integer titleID = Integer.parseInt(readInput("[0-9]+", "Please enter ID of title"));
            if (isRented(titleID)) {
                prntMe("Sorry this Title currently rented by other customer\nTry another one");
                recordRent();
            }
            //check if customer already rented 4 items
            Integer customerID = Integer.parseInt(readInput("[0-9]+", "Please insert customer ID"));
            if (rentedItems(customerID) >= 4) {
                prntMe("This customer already rented 4 items.\nAsk customer to return Titles and come back after");
                menu();
            }
            if (!eligibleToRent(titleID, customerID)) {
                prntMe("This item can not be rented with this membership plan.\n");
                menu();
            }
            //parsing all the objects for rent record
            Customer cm = customerList.get(customerID - 1);
            Titles title = titlesList.get(titleID - 1);


            rentedItems.add(new Rent(cm, title, new Date(), "rented")); //new rent record
            titlesList.get(titleID - 1).setRented(true); //changing status of the item

            //now loyalty points
            //if customer has 100 points the rent will be free
            if (isEnoughLoyaltyPoints(customerID - 1)) {
                prntMe("Yay free rent! Don't forget to tell it to customer");
                customerList.get(customerID - 1).getMembershipCard().setLoyalty_points(0); //getting 100 from account
            } else {
                customerList.get(customerID - 1).getMembershipCard().add_10_points();
                prntMe("Item rent record was created, customer must return item in 72 hours"); //giving 10 points for rent
            }
        }catch (Exception e){
                prntMe("This ID doesn't exist");
                menu();
            }

        menu();

    }

    @Override
    public void returnRent() {
        //just small validation from crush because of empty lists

        if(titlesList.isEmpty() || customerList.isEmpty()){
            prntMe("This system doesn't have registered users or items\n" +
                    "Please upload database first");
            menu();
        }

        List<String> rentedItem = allRentedItems(); //collecting all items that were rented by customer
        if(rentedItem.isEmpty()){
            prntMe("No rents registered in the system\n");
            menu();
        }

        Integer customerID = Integer.parseInt(readInput("[0-9]+", "Please insert customer ID"));
        if(searchCustomerID(customerID).isEmpty()){
            prntMe("Customer doesn't exist, check input!");
            menu();
        }

        //TODO: print only last 15 if have time

        for ( Rent itemsRented : rentedItems
        ) {
            System.out.println(itemsRented);
        }
        Integer rentID = Integer.parseInt(readInput("[0-9]+", "Please insert rent ID"));
        try{
        rentedItems.get(rentID-1).setStatus("returned"); //set up status of rent to returned

        int titleID = rentedItems.get(rentID-1).getRentedItemID(); //getting
        titlesList.get(titleID-1).setRented(false);
        rentedItems.get(rentID-1).setDateOfReturn(new Date());

        prntMe("Rented item was successfully returned");
        }catch (Exception e){
            prntMe("Wrong ID!");
            menu();
        }

        int numOfDays = isOverDue(rentedItems.get(rentID-1).getDateOfRent(), rentedItems.get(rentID-1).getDateOfReturn());

        //discarding loyalty points from customer if rent is overdue
        if(numOfDays>3){
            customerList.get(customerID-1).getMembershipCard().discardPoints(numOfDays);
            prntMe("Rent is overdue! Calculating penalty points..."+
            "\n"+numOfDays + " * 2 = "+numOfDays*2+ " loyalty points discarded!");
        }

        menu();
    }

    /**
     * Method to check difference between two dates
     * @param dateRented - start date
     * @param dateReturned - end date
     * @return - difference between them
     */

    public Integer isOverDue(Date dateRented, Date dateReturned){

        long diff = dateReturned.getTime() - dateRented.getTime();

        return Math.toIntExact(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
    }

    /**
     * method to check if current item is rented or not
     * @param ID - id of item
     * @return - true or false
     */

    public Boolean isRented(int ID){
        return titlesList.get(ID-1).getRented();
    }

    /** TODO: research how to do it with class injection as planned originally
     * Method that compares customer membership plan with the type of item he/she tries to rent
     * @param titleID id of chosen title
     * @param customerID id of the customer
     * @return boolean value
     */

    public Boolean eligibleToRent(int titleID, int customerID){
        String customerType = customerList.get(customerID-1).getCustomerType();
        String titleType = titlesList.get(titleID-1).getClass().getSimpleName();

        if(customerType.equals("PremiumC")){
            return true;
        }else if((customerType.equals("TVL") && titleType.equals("BoxSet")) || (customerType.equals("MovieL") && titleType.equals("Movies"))
                || (customerType.equals("MusicL") && (titleType.equals("Music")) || titleType.equals("LiveConcert"))){
            return true;
        }
         return false;
    }

    /**
     * Method to check if customer has enough points
     * @param customerID id of customer
     * @return boolean value
     */

    public Boolean isEnoughLoyaltyPoints(int customerID){
        return (customerList.get(customerID).getMembershipCard().getLoyalty_points().equals(100));
    }


}





