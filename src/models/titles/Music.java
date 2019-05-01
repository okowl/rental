package models.titles;

public class Music extends Audio {

    /**
     * Model for the Music titles
     */

    private String Genre;

    public Music(Integer ID, String title, String year_Release, String band_name, String genre) {
        super(ID, title, year_Release, band_name);
        Genre = genre;
        mediaType = MediaType.CD;
    }

    public Music(String title, String year_Release, String band_name, String genre) {
        super(title, year_Release, band_name);
        Genre = genre;
        mediaType = MediaType.CD;
    }

    public Music() {
        super(counter_id);
        mediaType = MediaType.CD;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "Music{" +
                "Genre='" + Genre + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
