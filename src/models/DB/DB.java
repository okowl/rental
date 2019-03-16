package models.DB;

public class DB {
    private static DB ourInstance = new DB();

    public static DB getInstance() {
        return ourInstance;
    }

    private DB() {
    }
}
