package controller;

import models.customers.*;
import models.rent.Rent;
import models.titles.*;

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


    private List <Customer> customerList;
    private List <Titles> titlesList;
    private List <Rent> rentedItems;

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
        menu();

    }

    public void menu(){

        String chosenOption = readInput("[1-7]", "Please chose one of the menu item:" +
                "\n1. Search for title\n2. Search for customer\n3. Add new customer \n4. Add new title\n" +
                "5. Update customer profile\n6. Record a new rent\n7. Return a rented item");
        switch (chosenOption){

            case "1":
                serach4Title();
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
                updCutomer();
                break;
            case "6":
                recordRent();
                break;
            case "7":
                returnRent();
                break;

        }

    }


    @Override
    public void serach4Title() {

        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert title name, ID or customer address");
        List<Titles> filteredCustomers = titlesList.stream().filter(title->{
            if(title.getClass().getSimpleName().equals(Music.class.getSimpleName())){
                return ((Music)title).getBand_name().toLowerCase().contains(input.toLowerCase());
            }
            return title.getName().toLowerCase().contains(input.toLowerCase());
        }).collect(Collectors.toList());

        for (Titles titles :filteredCustomers
        ) {
            System.out.println(titles);
        }

        menu();
    }

    @Override
    public void search4Customers() {
        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert Name, ID or customer address");
        List<Customer> filteredCustomers = customerList.stream().filter(cm->cm.getName()
                .toLowerCase().contains(input.toLowerCase()) ||
                cm.getAddress().toLowerCase().contains(input.toLowerCase())).collect(Collectors.toList());

        for (Customer customer :filteredCustomers
             ) {
            System.out.println(customer);
        }

        menu();

    }

    @Override
    public void addNewTitle() {

        prnt("Please chose one of the following options:" +
                "\n1 - new Music Album\n2 - new Live Concert\n3 - new TV-show\n4 - new Movie");

       Map <String, Titles> titleMapper = new HashMap<>();
        titleMapper.put("1", new Music());
        titleMapper.put("2", new LiveConcert());
        titleMapper.put("3", new BoxSet());
        titleMapper.put("4", new Movies());

        String optionChosen = readInput("[1-4]", "Please use just numbers");
        Titles title = null;

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

        titlesList.add(title);

        menu();

    }

    private Titles createMovie(Movies movies) {

        movies.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a movie name"));
        movies.setDirector(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a director name"));
        movies.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a movie genre"));
        movies.setRewards(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter any rewards that movie won"));
        movies.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));

        return movies;
    }


    private Titles createBoxSet(BoxSet boxSet) {

        boxSet.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a TV-show name"));
        boxSet.setDirector(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a director name"));
        boxSet.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a TV-Show genre"));
        boxSet.setNumSeasons(Integer.parseInt(readInput("[0-9]+","Please enter number of seasons")));
        boxSet.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));

        return boxSet;
    }

    private Titles createLiveConcert(LiveConcert liveConcert) {

        liveConcert.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a Live concert name"));
        liveConcert.setBandName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a band name"));
        liveConcert.setEventName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an Event name"));
        liveConcert.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));


        return liveConcert;
    }

    private Titles createMusic(Music music) {

        music.setName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an album name"));
        music.setBandName(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter a band name"));
        music.setGenre(readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$","Please enter an album genre"));
        music.setYearRelease(readInput("[0-9]{4}","Please enter year of release"));


        return music;
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
        //customerList.add(cm);

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
                customerList
                        .add(options
                                .get("1"));
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

        menu();
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





