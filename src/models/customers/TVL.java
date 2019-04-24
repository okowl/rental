package models.customers;

import models.titles.BoxSet;


public class TVL extends Customer<BoxSet> {

    //just two different constructors

    //with all the parameters needed
    public TVL(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customer_type = this.getClass().getSimpleName();
    }
    //and more flexible one
    public TVL(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }
}
