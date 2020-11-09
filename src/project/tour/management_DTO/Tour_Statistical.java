package project.tour.management_DTO;

public class Tour_Statistical {
    private String nameTour;
    private int tourArrival;
    private double tourCancel;
    private double totalPrice;
    private String staffFirstName;
    private String staffLastName;
    private int totalStaffArrival;
    private String nameCategory;
    private int totalArrivalCategoroy;

    public Tour_Statistical() {
    }

    public Tour_Statistical(String nameTour, int tourArrival, double tourCancel) {
        this.nameTour = nameTour;
        this.tourArrival = tourArrival;
        this.tourCancel = tourCancel;
    }

    public Tour_Statistical(String nameTour, double totalPrice) {
        this.nameTour = nameTour;
        this.totalPrice = totalPrice;
    }
    public Tour_Statistical(String staffFirstName, String staffLastName, int totalStaffArrival) {
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        this.totalStaffArrival = totalStaffArrival;
    }
    public Tour_Statistical(String nameCategory, int totalArrivalCategoroy){
        this.nameCategory = nameCategory;
        this.totalArrivalCategoroy = totalArrivalCategoroy;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = staffLastName;
    }

    public int getTotalStaffArrival() {
        return totalStaffArrival;
    }

    public void setTotalStaffArrival(int totalStaffArrival) {
        this.totalStaffArrival = totalStaffArrival;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String name) {
        this.nameTour = name;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getTotalArrivalCategoroy() {
        return totalArrivalCategoroy;
    }

    public void setTotalArrivalCategoroy(int totalArrivalCategoroy) {
        this.totalArrivalCategoroy = totalArrivalCategoroy;
    }
}
