package project.tour.management_DTO;

public class Tour_Group_DTO {
    private static String groupId;
    private static String groupName;
    private static String price;
    private static String startDate;
    private static String endDate;
    private static String createdAt;
    private static String lastModifiedAt;

    public Tour_Group_DTO() {
    }

    public Tour_Group_DTO(String groupId, String groupName, String startDate,
                          String endDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(String lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }
}
