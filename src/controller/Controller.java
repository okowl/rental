package controller;

import models.customers.*;
import models.rent.Rent;
import models.titles.Titles;
import static controller.utility.Utility.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/***
 * This is singleton controller
 * because it's best practice
 */

public class Controller implements Options4Menu {


    private List <Customer> Customer_list;
    private List <Titles> Titles_list;
    private List <Rent> Rented_items;

    private static Controller controller;


    public static Controller getInstance() {
        if(controller == null){
            controller = new Controller();
        }
        return controller;
    }



    private Controller() {

        Customer_list = new ArrayList<>();

        addNewCustomers();

        search4Customers();

//        MusicL musicL = new MusicL("Felipe","foo");
//        MusicL musicL1= new MusicL("Olga","Bar");
//        TVL foo = new TVL("example", "exampleAddress");
//
//        System.out.println(musicL);
//        System.out.println(musicL1);
//        System.out.println(foo);
//


    }

    public void menu(){

    }


    @Override
    public void serach4Title() {

    }

    @Override
    public void search4Customers() {
        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert Name, ID or customer address");
        List<Customer> filteredCustomers = Customer_list.stream().filter(cm->cm.getName()
                .toLowerCase().contains(input) ||
                cm.getAddress().toLowerCase().contains(input)).collect(Collectors.toList());

        for (Customer customer :filteredCustomers
             ) {
            System.out.println(customer);
        }

    }

    @Override
    public void addNewTitle() {

    }

    /**
     *
     */

    @Override
    public void addNewCustomers() {

        Customer cm = new Customer(
                readInput("^[A-Za-z _]*[A-Za-z][A-Za-z _]*$","Please enter customer full name"),
                readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter customer full address")
        );
        //Customer_list.add(cm);

        Map<String, Customer> options = new HashMap<>();
        options.put("1", new MusicL(cm));
        options.put("2", new TVL(cm));
        options.put("3", new MovieL(cm));
        options.put("4", new PremiumC(cm));

        prnt("Ask the customer what subscription type they want buy");
        prntMe("Choose one of options above:");
        prntMe("1 - for Music Lovers, 2 - TV Lovers, 3 - Movie Lovers,4 - for Premium");

        String chosenOption = readInput("[1-4]", "Please just use numbers");



        switch (chosenOption){
            case "1":
                Customer_list
                        .add(options
                                .get("1"));
                break;
            case "2":
                Customer_list.add(options.get("2"));
                break;
            case "3":
                Customer_list.add(options.get("3"));
                break;
            case "4":
                Customer_list.add(options.get("4"));
                break;

        }


    }

    @Override
    public void updCutomer() {

    }

    @Override
    public void recordRent() {

    }

    @Override
    public void returnRent() {

    }
}





