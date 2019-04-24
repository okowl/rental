package models.customers;

import models.titles.Movies;

import java.util.List;

public class MovieL extends Customer<Movies> {



    public MovieL(Integer ID, String name, String address) {
        super(ID, name, address);
        customer_type = this.getClass().getSimpleName();
    }

    public MovieL(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }
}
