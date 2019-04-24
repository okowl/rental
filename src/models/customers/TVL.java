package models.customers;

import models.titles.BoxSet;

import java.util.List;

public class TVL extends Customer<BoxSet> {

    public TVL(Integer ID, String name, String address, String customer_type, List<BoxSet> rent_history) {
        super(ID, name, address, customer_type, rent_history);
    }
}
