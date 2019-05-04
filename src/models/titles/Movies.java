package models.titles;

public class Movies extends Viseo {

    /**
     * Model for the Movies titles
     */

    protected String Rewards;

    //different constructors to create a new object of this type

    public Movies(Integer ID, String title, String year_Release, String director, String genre, String rewards) {
        super(ID, title, year_Release, director, genre);
        Rewards = rewards;
    }

    public Movies(String title, String year_Release, String director, String genre, String rewards) {
        super(title, year_Release, director, genre);
        Rewards = rewards;
    }

    public Movies() {
        super(counter_id);
    }


    //constructor that uses for the Title factory

    public Movies(Movies title, Integer id) {

        super(id, title.getName());
        setDirector(title.getDirector());
        setYearRelease(title.getYear_Release());
        setGenre(title.getGenre());
        setRewards(title.getRewards());
        mediaType = MediaType.DVD;

    }

    public String getRewards() {
        return Rewards;
    }

    public void setRewards(String rewards) {
        Rewards = rewards;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "Rewards='" + Rewards + '\'' +
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
