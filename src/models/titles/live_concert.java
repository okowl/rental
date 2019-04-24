package models.titles;

public class live_concert extends Titles{

    private String Band_name;
    private String Event_name;

    public live_concert(Integer ID, String title, String year_Release, String band_name, String event_name) {
        super(ID, title, year_Release);
        Band_name = band_name;
        Event_name = event_name;
    }

    public live_concert(String title, String year_Release, String band_name, String event_name) {
        super(title, year_Release);
        Band_name = band_name;
        Event_name = event_name;
    }

    public String getBand_name() {
        return Band_name;
    }

    public void setBand_name(String band_name) {
        Band_name = band_name;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String event_name) {
        Event_name = event_name;
    }

    @Override
    public String toString() {
        return "live_concert{" +
                "Band_name='" + Band_name + '\'' +
                ", Event_name='" + Event_name + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
