package models.rent;

import models.Registry;
import models.customers.Customer;
import models.titles.Titles;

import java.util.Date;

public class Rent extends Registry {

    private Customer customer;
    private Titles title;
    private Date dateOfRent;
    private Boolean rented;
    public static Integer rent_counter = 1;


    public Rent(Integer ID, Customer customer, Titles title) {
        super(ID, customer.getName());
        rent_counter += 1;
        dateOfRent = new Date();
        this.title = title;
        this.customer = customer;
        rented = true;

    }

    public Rent(Integer ID, String name, Customer customer, Titles title, Date dateOfRent, Boolean rented) {
        super(ID, name);
        this.customer = customer;
        this.title = title;
        this.dateOfRent = dateOfRent;
        this.rented = rented;
        rent_counter += 1;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Titles getTitle() {
        return title;
    }

    public void setTitle(Titles title) {
        this.title = title;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    public static Integer getRent_counter() {
        return rent_counter;
    }

    public static void setRent_counter(Integer rent_counter) {
        Rent.rent_counter = rent_counter;
    }

    @Override
    public String toString() {
        return "Rent{" +
                ", title=" + title.getName() +
                ", dateOfRent=" + dateOfRent +
                ", rented=" + rented +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
