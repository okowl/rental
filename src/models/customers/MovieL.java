package models.customers;

import models.titles.Movies;
import models.titles.Titles;

public class MovieL extends Customer<Movies> {

    //just different constructors

    //with all the parameters needed
    public MovieL(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customerType = this.getClass().getSimpleName();
    }

    //and just another constructor to add more flexibility to the code and have more options
    public MovieL(String name, String address) {
        super(name, address);
        customerType = this.getClass().getSimpleName();
    }

    //and this one is used to create a new customer
    public MovieL(Customer cm) {
        super(cm.getID(), cm.getName(), cm.getAddress(), cm.getMembershipCard());
        customerType = this.getClass().getSimpleName();
    }


}
