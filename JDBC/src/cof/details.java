package cof;

public class details {
    private int id;
    private String name;
    private String location;
    private double rating;
    private int openingTime;
    private int closingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nLocation: " + location +
               "\nRating: " + rating + "\nOpening Time: " + openingTime +
               "\nClosing Time: " + closingTime;
    }
}


