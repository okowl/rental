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

    public static Titles fatory(Titles title, String optionChosen) {
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

    @Override
    public String toString() {
        return "Titles{" +
                "Year_Release='" + Year_Release + '\'' +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
