package models.customers;

import models.titles.Titles;


/**
 * because premium can rent everything the best way to include everything
 * it make sense to do an injection of Titles class
 */
public class PremiumC extends Customer<Titles> {

    //just different constructors

    //with all the parameters needed
    public PremiumC(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customer_type = this.getClass().getSimpleName();
    }

    public PremiumC(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }

    //this one is actually used in constructor to create a new customer
    public PremiumC(Customer cm) {
        super(cm.getID(), cm.getName(), cm.getAddress(), cm.getMembership_card());
        customer_type = this.getClass().getSimpleName();
    }
}
