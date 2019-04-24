package models.titles;

public class BoxSet extends Viseo {

    private Integer num_seasons;


    public BoxSet(Integer ID, String title, String year_Release, String director, String genre, Integer num_seasons) {
        super(ID, title, year_Release, director, genre);
        this.num_seasons = num_seasons;
    }

    public BoxSet(String title, String year_Release, String director, String genre, Integer num_seasons) {
        super(title, year_Release, director, genre);
        this.num_seasons = num_seasons;
    }

    public Integer getNum_seasons() {
        return num_seasons;
    }

    public void setNum_seasons(Integer num_seasons) {
        this.num_seasons = num_seasons;
    }

    @Override
    public String toString() {
        return "BoxSet{" +
                "num_seasons=" + num_seasons +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
