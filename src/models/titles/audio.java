package models.titles;

public abstract class audio extends Titles {

    private String Band_name;

    public audio(Integer ID, String title, String year_Release, String band_name) {
        super(ID, title, year_Release);
        Band_name = band_name;
    }

    public audio(String title, String year_Release, String band_name) {
        super(title, year_Release);
        Band_name = band_name;
    }

    public String getBand_name() {
        return Band_name;
    }

    public void setBand_name(String band_name) {
        Band_name = band_name;
    }

    @Override
    public String toString() {
        return "audio{" +
                "Band_name='" + Band_name + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
