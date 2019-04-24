package models.titles;

public class LiveConcert extends Audio {

    /**
     * Model for the Live Concert titles
     */

    private String Event_name;

    public LiveConcert(Integer ID, String title, String year_Release, String band_name, String event_name) {
        super(ID, title, year_Release, band_name);
        Event_name = event_name;
    }

    public LiveConcert(String title, String year_Release, String band_name, String event_name) {
        super(title, year_Release, band_name);
        Event_name = event_name;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String event_name) {
        Event_name = event_name;
    }

    @Override
    public String toString() {
        return "LiveConcert{" +
                "Event_name='" + Event_name + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
