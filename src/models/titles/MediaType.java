package models.titles;

/**
 * enum that holds all media types and they capacity
 * in the future could be used to check if the title can be saved on one of them based on the size of the item
 */

public enum MediaType {
    CD(720), DVD(4600), Blue_Ray(27000);

    Integer storage;

    MediaType(Integer storage){
        this.storage = storage;
    }


}
