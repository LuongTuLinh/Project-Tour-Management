package project.tour.management_DTO;

public class Tour_Group_Role {
    private String roleId;
    private String roleName;

    public Tour_Group_Role() {
    }

    public Tour_Group_Role(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
