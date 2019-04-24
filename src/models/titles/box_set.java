package models.titles;

public class box_set extends Titles{

    private String Director;
    private Integer num_seasons;
    private String Genre;

    public box_set(Integer ID, String title, String year_Release, String director, Integer num_seasons, String genre) {
        super(ID, title, year_Release);
        Director = director;
        this.num_seasons = num_seasons;
        Genre = genre;
    }

    public box_set(String title, String year_Release, String director, Integer num_seasons, String genre) {
        super(title, year_Release);
        Director = director;
        this.num_seasons = num_seasons;
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public Integer getNum_seasons() {
        return num_seasons;
    }

    public void setNum_seasons(Integer num_seasons) {
        this.num_seasons = num_seasons;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "box_set{" +
                "Director='" + Director + '\'' +
                ", num_seasons=" + num_seasons +
                ", Genre='" + Genre + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
