package project.tour.management_DTO;

public class Tour_Group_CostType {
    private  String costTypeId;
    private String costTypeName;

    public Tour_Group_CostType() {
    }

    public Tour_Group_CostType(String costTypeId, String costTypeName) {
        this.costTypeId = costTypeId;
        this.costTypeName = costTypeName;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }
}
