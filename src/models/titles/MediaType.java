package models.titles;

public enum MediaType {
    CD(720), DVD(4600), Blue_Ray(27000);

    Integer storage;

    MediaType(Integer storage){
        this.storage = storage;
    }


}
