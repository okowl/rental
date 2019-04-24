package controller;

import models.customers.Customer;
import models.rent.Rent;
import models.titles.Titles;

import java.util.List;

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
