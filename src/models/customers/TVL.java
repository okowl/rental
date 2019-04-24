package models.customers;

import models.titles.BoxSet;

import java.util.List;

public class TVL extends Customer<BoxSet> {


    public TVL(Integer ID, String name, String address) {
        super(ID, name, address);
        customer_type = this.getClass().getSimpleName();
    }

    public TVL(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }
}
