package models.customers;

import models.titles.Movies;

import java.util.List;

public class MovieL extends Customer<Movies> {


    public MovieL(Integer ID, String name, String address, String customer_type, List<Movies> rent_history) {
        super(ID, name, address, customer_type, rent_history);
    }
}
