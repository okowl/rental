package models.customers;

import models.titles.Titles;

import java.util.List;

public class PremiumC extends Customer<Titles> {

    public PremiumC(Integer ID, String name, String address) {
        super(ID, name, address);
        customer_type = this.getClass().getSimpleName();
    }

    public PremiumC(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }
}
