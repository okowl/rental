package models.titles;

import models.Registry;

import java.util.Map;

public abstract class Titles extends Registry {

    /**
     * A high level abstraction for all titles
     */

    public static Integer counter_id = 1;
    public String Year_Release;
    protected MediaType mediaType;
    protected Boolean rented = false;

    //different constructors to create a new object

    public Titles(Integer ID, String name, String year_Release) {
        super(ID, name);
        Year_Release = year_Release;

    }

    public Titles( String name, String year_Release) {
        super(counter_id+1, name);
        Year_Release = year_Release;
    }

    public Titles() {
        super();
    }

    public Titles(Integer counter_id) {
        super(counter_id);
        counter_id +=1;

    }

    public Titles(Integer id, String name) {
        super(id, name);
    }

    public static Integer getCounter_id() {
        return counter_id;
    }

    public static void setCounter_id(Integer counter_id) {
        Titles.counter_id = counter_id;
    }

    /**
     * This method is used to create multiple new objects of the selected type
     * such as boxset/movie and so on
     * just incrementing id each iteration and saving the rest of input from the staff member
     *
     * @param title information that was inserted and validated form staff member
     * @param optionChosen title type that was chosen by staff member
     * @return new object of chosen type with incremented ID
     */

    public static Titles factory(Titles title, String optionChosen) {
        switch (optionChosen){
            case "1":
                return new Music((Music) title, counter_id);
            case "2":
                return new LiveConcert((LiveConcert) title, counter_id);
            case "3":
                return new BoxSet((BoxSet) title, counter_id);
            case "4":
                return new Movies((Movies)title, counter_id);
            default:
                return null;
        }

    }


    public String getYear_Release() {
        return Year_Release;
    }

    public void setYearRelease(String year_Release) {
        Year_Release = year_Release;
    }

    public static void incrementCounter(){
        counter_id +=1;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", rented=" + rented +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
