package models.titles;

public class music extends Titles {

    private String Band_name;
    private String Genre;

    public music(Integer ID, String title, String year_Release, String band_name, String genre) {
        super(ID, title, year_Release);
        Band_name = band_name;
        Genre = genre;
    }

    public music(String title, String year_Release, String band_name, String genre) {
        super(title, year_Release);
        Band_name = band_name;
        Genre = genre;
    }

    public String getBand_name() {
        return Band_name;
    }

    public void setBand_name(String band_name) {
        Band_name = band_name;
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
                "Band_name='" + Band_name + '\'' +
                ", Genre='" + Genre + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
