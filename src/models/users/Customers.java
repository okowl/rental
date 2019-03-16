package models.users;

import models.plans.Membership_type;

public class Customers extends Human {

    private String address;
    private Membership_type membership_Card;

    public Customers(String name, String email, String ID, String type, String address, Membership_type
                     membership_Card) {
        super(name, email, ID, type);
    }
}
