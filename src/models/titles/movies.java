package models.titles;

public class movies extends Titles {

    private String Director;
    private String Rewards;
    private String Genre;

    public movies(Integer ID, String title, String year_Release, String director, String rewards, String genre) {
        super(ID, title, year_Release);
        Director = director;
        Rewards = rewards;
        Genre = genre;
    }

    public movies(String title, String year_Release, String director, String rewards, String genre) {
        super(title, year_Release);
        Director = director;
        Rewards = rewards;
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getRewards() {
        return Rewards;
    }

    public void setRewards(String rewards) {
        Rewards = rewards;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "movies{" +
                "Director='" + Director + '\'' +
                ", Rewards='" + Rewards + '\'' +
                ", Genre='" + Genre + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
