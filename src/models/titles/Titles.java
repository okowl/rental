package models.titles;

import models.Registry;

public abstract class Titles extends Registry {

    public static Integer counter_id = 0;
    public String Year_Release;

    public Titles(Integer ID, String name, String year_Release) {
        super(ID, name);
        Year_Release = year_Release;
    }

    public Titles( String name, String year_Release) {
        super(counter_id+1, name);
        Year_Release = year_Release;
    }

    public static Integer getCounter_id() {
        return counter_id;
    }

    public static void setCounter_id(Integer counter_id) {
        Titles.counter_id = counter_id;
    }

    public String getYear_Release() {
        return Year_Release;
    }

    public void setYear_Release(String year_Release) {
        Year_Release = year_Release;
    }

    @Override
    public String toString() {
        return "Titles{" +
                "Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
