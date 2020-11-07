package project.tour.management_DTO;

public class Tour_Statistical {
    private String name;
    private int tourArrival;
    private double tourCancel;

    public Tour_Statistical() {
    }

    public Tour_Statistical(String name, int tourArrival, double tourCancel) {
        this.name = name;
        this.tourArrival = tourArrival;
        this.tourCancel = tourCancel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTourArrival() {
        return tourArrival;
    }

    public void setTourArrival(int tourArrival) {
        this.tourArrival = tourArrival;
    }

    public double getTourCancel() {
        return tourCancel;
    }

    public void setTourCancel(double tourCancel) {
        this.tourCancel = tourCancel;
    }
}
