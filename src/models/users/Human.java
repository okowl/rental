package models.users;

public abstract class Human {


    public enum humans{
        Customer, Crew
    }

    protected String  name, email, ID, type;


    public Human(String name, String email, String ID, String type) {

        this.name = name;
        this.email = email;
        this.type = type;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "ID='" + ID + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", type='" + type + '\'' +
//                '}';
//    }



}
