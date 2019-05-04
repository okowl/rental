package models.customers;

import models.titles.BoxSet;


public class TVL extends Customer<BoxSet> {

    //just different constructors

    //with all the parameters needed
    public TVL(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customerType = this.getClass().getSimpleName();
    }
    //and more flexible one
    public TVL(String name, String address) {
        super(name, address);
        customerType = this.getClass().getSimpleName();
    }

    //this one is actually used in constructor to create a new customer
    public TVL(Customer cm) {
        super(cm.getID(), cm.getName(), cm.getAddress(), cm.getMembershipCard());
        customerType = this.getClass().getSimpleName();
    }
}
