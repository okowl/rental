package models.customers;

import models.titles.Music;

import java.util.List;

public class MusicL extends Customer <Music>{

    public MusicL(Integer ID, String name, String address, String customer_type, List<Music> rent_history) {
        super(ID, name, address, customer_type, rent_history);
    }
}
