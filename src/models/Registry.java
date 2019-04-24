package models;

public abstract class Registry {

    /***
     * High level abstraction that will be really handy if
     * I would use database, as on the high level I would use just a set range of ids for customers
     * and just items like club cards in Tesco
     */


    protected Integer ID;
    protected String Name;

    public Registry(Integer ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Registry{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}

