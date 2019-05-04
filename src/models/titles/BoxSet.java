package models.titles;

public class BoxSet extends Viseo {

    protected Integer num_seasons;

    /**
     * Model for TW-shows titles
     */

    //different constructors to create a new object of this type

    public BoxSet(Integer ID, String title, String year_Release, String director, String genre, Integer num_seasons) {
        super(ID, title, year_Release, director, genre);
        this.num_seasons = num_seasons;
    }

    public BoxSet(String title, String year_Release, String director, String genre, Integer num_seasons) {
        super(title, year_Release, director, genre);
        this.num_seasons = num_seasons;
    }

    public BoxSet() {
        super(counter_id);

    }


    //constructor that uses for the Title factory

    public BoxSet(BoxSet title, Integer id) {

            super(id, title.getName());
            setDirector(title.getDirector());
            setYearRelease(title.getYear_Release());
            setGenre(title.getGenre());
            setNumSeasons(title.getNum_seasons());
            mediaType = MediaType.DVD;

    }

    public Integer getNum_seasons() {
        return num_seasons;
    }

    public void setNumSeasons(Integer num_seasons) {
        this.num_seasons = num_seasons;
    }

    @Override
    public String toString() {
        return "BoxSet{" +
                "num_seasons=" + num_seasons +
                ", Director='" + Director + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", rented=" + rented +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
