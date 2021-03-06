package models.titles;

public class LiveConcert extends Audio {

    /**
     * Model for the Live Concert titles
     */

    private String Event_name;

    //different constructors to create a new object of this type

    public LiveConcert(Integer ID, String title, String year_Release, String band_name, String event_name) {
        super(ID, title, year_Release, band_name);
        Event_name = event_name;
        mediaType = MediaType.Blue_Ray;
    }

    public LiveConcert(String title, String year_Release, String band_name, String event_name) {
        super(title, year_Release, band_name);
        Event_name = event_name;
        mediaType = MediaType.Blue_Ray;
    }

    public LiveConcert(){
        super(counter_id);
        mediaType = MediaType.Blue_Ray;
    }


    //constructor that uses for the Title factory

    public LiveConcert(LiveConcert title, Integer id) {
            super(id, title.getName());
            setBandName(title.getBand_name());
            setYearRelease(title.getYear_Release());
            setEventName(title.getEvent_name());
            mediaType = MediaType.Blue_Ray;

    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEventName(String event_name) {
        Event_name = event_name;
    }

    @Override
    public String toString() {
        return "LiveConcert{" +
                "Event_name='" + Event_name + '\'' +
                ", Band_name='" + Band_name + '\'' +
                ", Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", rented=" + rented +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
