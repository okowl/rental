package models.titles;

public class movies extends visual {

    private String Rewards;

    public movies(Integer ID, String title, String year_Release, String director, String genre, String rewards) {
        super(ID, title, year_Release, director, genre);
        Rewards = rewards;
    }

    public movies(String title, String year_Release, String director, String genre, String rewards) {
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
        return "movies{" +
                "Rewards='" + Rewards + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
