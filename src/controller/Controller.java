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
import java.util.stream.IntStream;

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

    /**
     * Lambda method to search for a title name
     * it runs through array list of titles and streams all objects that maches to the input into the separate stream
     * This stream will be printed to the stuff
     */

    @Override
    public void serach4Title() {

        String input = readInput("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$",
                "Please insert title name, ID or customer address");
        List<Titles> filteredCustomers = titlesList.stream().filter(title->{
            //if title belongs to the live concert or music we also checking band name
            if(title.getClass().getSimpleName().equals(Music.class.getSimpleName())){
                return ((Music)title).getBand_name().toLowerCase().contains(input.toLowerCase());
            }
            if(title.getClass().getSimpleName().equals(LiveConcert.class.getSimpleName())){
                return ((LiveConcert)title).getBand_name().toLowerCase().contains(input.toLowerCase());
            }
            return title.getName().toLowerCase().contains(input.toLowerCase());
        }).collect(Collectors.toList());

        for (Titles titles :filteredCustomers
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

    /**
     * Method that adds new titles to the titles list
     * After stuff chose which title in particular they want to add it will redirect it to the specefic method
     * which will feel all the parameters for a new title and add it then to the Title list
     */

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

        /**
         * this part still not working as expected
         * problem: all of the object has same IDs
         * TODO: troubleshooting if have time left
         */

//        //adding many boxes of the same title if shop will get more than one
//        Integer copiesOfTitle = Integer.parseInt(readInput
//                ("[0-9]+", "Hom many copies you want to add? (please use just numbers)"));
//
//        //for loop that adds title to the list with a new ID

//        for(int i = 0; i < copiesOfTitle; i++){
//            titlesList.add(title);
//            Titles.incrementCounter();
//        }
//

        titlesList.add(title);
        menu();

    }

    /**
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





