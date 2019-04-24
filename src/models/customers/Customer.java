package models.customers;

import models.Registry;
import models.titles.Titles;

import java.util.List;

public class Customer <T extends Titles> extends Registry {


    protected String address;
    protected String customer_type;
    protected List <T> Rent_history;
    protected Membership_card membership_card;
    public static Integer customers_counter = 0;



    public Customer(Integer ID, String name, String address) {
        super(ID, name);
        this.address = address;
    }

    public Customer(String name, String address) {
        super(customers_counter+1, name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public List<T> getRent_history() {
        return Rent_history;
    }

    public void setRent_history(List<T> rent_history) {
        Rent_history = rent_history;
    }

    public Membership_card getMembership_card() {
        return membership_card;
    }

    public void setMembership_card(Membership_card membership_card) {
        this.membership_card = membership_card;
    }

    public static Integer getCustomers_counter() {
        return customers_counter;
    }

    public static void setCustomers_counter(Integer customers_counter) {
        Customer.customers_counter = customers_counter;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", customer_type='" + customer_type + '\'' +
                ", Rent_history=" + Rent_history +
                ", membership_card=" + membership_card +
                '}';
    }

    private class Membership_card{

        CardType card;
        private Integer loyalty_pointd;

        public Membership_card(CardType card, Integer loyalty_pointd) {
            this.card = card;
            this.loyalty_pointd = loyalty_pointd;
        }

        //initial loyalty points methods
        public void add_10_points(){

            loyalty_pointd+=10;

        }

        public CardType getCard() {
            return card;
        }

        public void setCard(CardType card) {
            this.card = card;
        }

        @Override
        public String toString() {
            return "Membership_card{" +
                    "card=" + card +
                    ", loyalty_pointd=" + loyalty_pointd +
                    '}';
        }

        public Integer getLoyalty_pointd() {
            return loyalty_pointd;
        }

        public void setLoyalty_pointd(Integer loyalty_pointd) {
            this.loyalty_pointd = loyalty_pointd;
        }
    }

}
