package models.customers;

import models.titles.Audio;

public class MusicL extends Customer <Audio>{

    //just different constructors

    //with all the parameters needed
    public MusicL(Integer ID, String name, String address, Membership_card membership_card) {
        super(ID, name, address, membership_card);
        customerType = this.getClass().getSimpleName();
    }

    //and for more flexibility - another one
    public MusicL(String name, String address) {
        super(name, address);
        customerType = this.getClass().getSimpleName();
    }
    //this one is actually used in constructor to create a new customer
    public MusicL(Customer cm) {
        super(cm.getID(), cm.getName(), cm.getAddress(), cm.getMembershipCard());
        customerType = this.getClass().getSimpleName();
    }
}
