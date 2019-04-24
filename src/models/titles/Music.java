package models.titles;

public class Music extends Audio {

    private String Genre;

    public Music(Integer ID, String title, String year_Release, String band_name, String genre) {
        super(ID, title, year_Release, band_name);
        Genre = genre;
    }

    public Music(String title, String year_Release, String band_name, String genre) {
        super(title, year_Release, band_name);
        Genre = genre;
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
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}