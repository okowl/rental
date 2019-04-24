package models.titles;

public class music extends audio {

    private String Genre;

    public music(Integer ID, String title, String year_Release, String band_name, String genre) {
        super(ID, title, year_Release, band_name);
        Genre = genre;
    }

    public music(String title, String year_Release, String band_name, String genre) {
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
        return "music{" +
                "Genre='" + Genre + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
