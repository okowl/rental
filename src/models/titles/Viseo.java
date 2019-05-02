package models.titles;

public abstract class Viseo extends Titles {

    /**
     * A high level abstraction for all the video content
     */


    protected String Director;
    protected String Genre;

    //different constructors to create a new object of this type


    public Viseo(Integer ID, String title, String year_Release, String director, String genre) {
        super(ID, title, year_Release);
        Director = director;
        Genre = genre;
        mediaType = MediaType.DVD;

    }

    public Viseo(String title, String year_Release, String director, String genre) {
        super(title, year_Release);
        Director = director;
        Genre = genre;
        mediaType = MediaType.DVD;
    }

    public Viseo() {
        mediaType = MediaType.DVD;
    }

    public Viseo(Integer counter_id) {

        super(counter_id);
    }

    public Viseo(Integer id, String name) {
        super(id, name);
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
                ", Year_Release='" + Year_Release + '\'' +
                ", mediaType=" + mediaType +
                ", ID=" + ID +
                ", Name='" + Name + '\'' +
                '}';
    }
}
