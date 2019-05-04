package models.rent;

import models.Registry;
import models.customers.Customer;
import models.titles.Titles;

import java.util.Date;

public class Rent extends Registry {

    private Customer customer;
    private Titles title;
    private Date dateOfRent;
    private String status;

    public static Integer rent_counter = 1;

    //more constructors for the god of constructors

    public Rent(Integer ID, Customer customer, Titles title) {
        super(ID, customer.getName());
        rent_counter += 1;
        dateOfRent = new Date();
        this.title = title;
        this.customer = customer;
        this.status = status;

    }

    public Rent(Integer ID, String name, Customer customer, Titles title, Date dateOfRent, String status) {
        super(ID, name);
        this.customer = customer;
        this.title = title;
        this.dateOfRent = dateOfRent;
        this.status = status;
        rent_counter += 1;
    }

    //getters and setters
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

    public static Integer getRent_counter() {
        return rent_counter;
    }

    public static void setRent_counter(Integer rent_counter) {
        Rent.rent_counter = rent_counter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "customer=" + customer +
                ", title=" + title +
                ", dateOfRent=" + dateOfRent +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
