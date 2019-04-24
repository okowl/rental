package models;

public abstract class Registry {

    private Integer ID;
    private String Name;

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

