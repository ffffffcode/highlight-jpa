package ex.aaronfae.spring.highlightjpa.entity;

public class MongoLocation {

    private String place;
    private String year;

    public MongoLocation(String place, String year) {
        super();
        this.place = place;
        this.year = year;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
