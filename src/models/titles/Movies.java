package models.titles;

public class Movies extends Viseo {

    private String Rewards;

    public Movies(Integer ID, String title, String year_Release, String director, String genre, String rewards) {
        super(ID, title, year_Release, director, genre);
        Rewards = rewards;
    }

    public Movies(String title, String year_Release, String director, String genre, String rewards) {
        super(title, year_Release, director, genre);
        Rewards = rewards;
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
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}