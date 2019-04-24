package models.customers;

import models.titles.Titles;

import java.util.List;

public class PremiumC extends Customer<Titles> {

    public PremiumC(Integer ID, String name, String address, String customer_type, List<Titles> rent_history) {
        super(ID, name, address, customer_type, rent_history);
    }
}
