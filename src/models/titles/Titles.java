package models.titles;

public abstract class Titles {

    public static Integer counter_id = 0;
    public Integer ID;
    public String Title;
    public String Year_Release;

    //id comes from outside
    public Titles(Integer ID, String title, String year_Release) {
        this.ID = ID;
        Title = title;
        Year_Release = year_Release;
    }

    //id comes from this class
    public Titles(String title, String year_Release) {
        ID = counter_id + 1;
        Title = title;
        Year_Release = year_Release;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
