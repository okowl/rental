package models.titles;

public abstract class Audio extends Titles {
    /**
     * A high level abstraction for Music and Live concert class
     */

    private String Band_name;

    public Audio(Integer ID, String title, String year_Release, String band_name) {
        super(ID, title, year_Release);
        Band_name = band_name;
    }

    public Audio(String title, String year_Release, String band_name) {
        super(title, year_Release);
        Band_name = band_name;
    }

    public Audio(Integer counter_id) {
        super(counter_id);
    }

    public String getBand_name() {
        return Band_name;
    }

    public void setBandName(String band_name) {
        Band_name = band_name;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "Band_name='" + Band_name + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
