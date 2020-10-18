package project.tour.management_DTO;

public class Tour_Price_DTO {
    private static String priceId;
    private static String price;
    private static String startDate;
    private static String endDate;
    private static String createAt;
    private static String lastModifiedAt;

    public Tour_Price_DTO() {
    }
    public Tour_Price_DTO(String priceId, String price, String startDate, String endDate){
        Tour_Price_DTO.priceId = priceId;
        Tour_Price_DTO.price = price;
        Tour_Price_DTO.startDate = startDate;
        Tour_Price_DTO.endDate = endDate;
    }

    public static String getPriceId() {
        return priceId;
    }

    public static void setPriceId(String priceId) {
        Tour_Price_DTO.priceId = priceId;
    }

    public static String getPrice() {
        return price;
    }

    public static void setPrice(String price) {
        Tour_Price_DTO.price = price;
    }

    public static String getStartDate() {
        return startDate;
    }

    public static void setStartDate(String startDate) {
        Tour_Price_DTO.startDate = startDate;
    }

    public static String getEndDate() {
        return endDate;
    }

    public static void setEndDate(String endDate) {
        Tour_Price_DTO.endDate = endDate;
    }

    public static String getCreateAt() {
        return createAt;
    }

    public static void setCreateAt(String createAt) {
        Tour_Price_DTO.createAt = createAt;
    }

    public static String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public static void setLastModifiedAt(String lastModifiedAt) {
        Tour_Price_DTO.lastModifiedAt = lastModifiedAt;
    }
}
