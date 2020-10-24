package project.tour.management_DTO;

public class Tour_Price_DTO {
    private String priceId;
    private String price;
    private String startDate;
    private String endDate;
    private String createAt;
    private String lastModifiedAt;

    public Tour_Price_DTO() {
    }
    public Tour_Price_DTO(String priceId, String price, String startDate, String endDate){
        this.priceId = priceId;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
}
