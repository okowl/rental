package models.plans;

public enum Membership_type {

    ML("ML: Music Lovers - Rental of music CDs and live conccert videos"),
    VL("VL: Video Lovers - Rental of movies (excluding live concert videos)"),
    TV("TV: TV Lovers - Rental of Box Sets"),
    PR("PR : Premium - any title included");

    private final String subscription;


    Membership_type(String subscription) {
        this.subscription = subscription;
    }
}
