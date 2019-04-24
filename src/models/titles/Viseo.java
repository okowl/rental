package models.titles;

public abstract class Viseo extends Titles {


    private String Director;
    private String Genre;

    public Viseo(Integer ID, String title, String year_Release, String director, String genre) {
        super(ID, title, year_Release);
        Director = director;
        Genre = genre;
    }

    public Viseo(String title, String year_Release, String director, String genre) {
        super(title, year_Release);
        Director = director;
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "Viseo{" +
                "Director='" + Director + '\'' +
                ", Genre='" + Genre + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}