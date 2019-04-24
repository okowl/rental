package models.customers;

import models.titles.Music;

import java.util.List;

public class MusicL extends Customer <Music>{

    public MusicL(Integer ID, String name, String address) {
        super(ID, name, address);
        customer_type = this.getClass().getSimpleName();
    }

    public MusicL(String name, String address) {
        super(name, address);
        customer_type = this.getClass().getSimpleName();
    }
}
