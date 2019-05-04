package models.titles;

public class Music extends Audio {

    /**
     * Model for the Music titles
     */

    private String genre;

    //different constructors to create a new object of this type

    public Music(Integer ID, String title, String year_Release, String band_name, String genre) {
        super(ID, title, year_Release, band_name);
        this.genre = genre;
        mediaType = MediaType.CD;
    }

    public Music(String title, String year_Release, String band_name, String genre) {
        super(title, year_Release, band_name);
        this.genre = genre;
        mediaType = MediaType.CD;
    }
    //constructor for the single new item

    public Music() {
        super(counter_id);
        mediaType = MediaType.CD;
    }

    //constructor that uses for the Title factory

    public Music(Music title, Integer id) {
        super(id, title.getName());
        setBandName(title.getBand_name());
        setYearRelease(title.getYear_Release());
        genre = title.getGenre();
        mediaType = MediaType.CD;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Music{" +
                "genre='" + genre + '\'' +
                ", Band_name='" + Band_name + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", rented=" + rented +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
