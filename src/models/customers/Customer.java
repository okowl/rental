package models.customers;

import models.Registry;
import models.titles.Titles;

import java.util.List;

public class Customer <T extends Titles> extends Registry {


    protected String address;
    protected String customerType;
    protected List <T> rentHistory;
    protected Membership_card membershipCard;
    public static Integer customers_counter = 1;



    public Customer(Integer ID, String name, String address, Membership_card membershipCard) {
        super(ID, name);
        this.address = address;
        this.membershipCard = membershipCard;
        customers_counter += 1;
    }

    public Customer(String name, String address) {
        super(customers_counter, name);
        this.address = address;
        this.membershipCard = initMembershipCard();
        customers_counter += 1;
    }

//    public abstract Boolean isEligibleToRent(Titles title){
//        try{
//            rentHistory.add(title);
//            rentHistory.removeAll();
//            return true;
//        }catch(Exception e){
//            return false;
//        }
//    }

    //TODO to implement new membershipCard Instantiation
    private Membership_card initMembershipCard() {
        return new Membership_card(CardType.CREDIT, 0);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<T> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<T> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public Membership_card getMembershipCard() {
        return membershipCard;
    }

    public void setMembershipCard(Membership_card membershipCard) {
        this.membershipCard = membershipCard;
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
                ", customerType='" + customerType + '\'' +
                ", rentHistory=" + rentHistory +
                ", membershipCard=" + membershipCard +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }

    /**
     * There are no membership card without a member
     * So here goes inner class that hold functionality for the membreship card
     * */

    public class Membership_card{

        CardType card;
        private Integer loyalty_points;

        public Membership_card(CardType card, Integer loyalty_pointd) {
            this.card = card;
            this.loyalty_points = loyalty_pointd;
        }

        //initial loyalty points methods
        public void add_10_points(){

            loyalty_points +=10;

        }

        //getters and setters

        public CardType getCard() {
            return card;
        }

        public void setCard(CardType card) {
            this.card = card;
        }


        public Integer getLoyalty_points() {
            return loyalty_points;
        }

        public void setLoyalty_points(Integer loyalty_points) {
            this.loyalty_points = loyalty_points;
        }

        @Override
        public String toString() {
            return "Membership_card{" +
                    "card=" + card +
                    ", loyalty_points=" + loyalty_points +
                    '}';
        }
    }

}
