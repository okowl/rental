package models.titles;

public class live_concert extends audio{


    private String Event_name;

    public live_concert(Integer ID, String title, String year_Release, String band_name, String event_name) {
        super(ID, title, year_Release, band_name);
        Event_name = event_name;
    }

    public live_concert(String title, String year_Release, String band_name, String event_name) {
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
        return "live_concert{" +
                "Event_name='" + Event_name + '\'' +
                ", ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                '}';
    }
}
