package controller;

import models.customers.Customer;
import models.customers.MusicL;
import models.customers.TVL;
import models.rent.Rent;
import models.titles.Titles;

import java.util.List;

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


        MusicL musicL = new MusicL("Felipe","foo");
        MusicL musicL1= new MusicL("Olga","Bar");
        TVL foo = new TVL("example", "exampleAddress");

        System.out.println(musicL);
        System.out.println(musicL1);
        System.out.println(foo);



    }





    @Override
    public void serach4title() {

    }

    @Override
    public void search4customers() {

    }

    @Override
    public void add_new_title() {

    }

    @Override
    public void add_new_customers() {

    }

    @Override
    public void upd_cutomer() {

    }

    @Override
    public void record_rent() {

    }

    @Override
    public void return_rent() {

    }
}
