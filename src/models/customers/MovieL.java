package models.customers;

import models.titles.Movies;

import java.util.List;

public class MovieL extends Customer<Movies> {

    //just two different constructors

    //with all the parameters needed
    public MovieL(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customer_type = this.getClass().getSimpleName();
    }

    //and just another constructor to add more flexibility to the code and have more options
    public MovieL(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }



}
