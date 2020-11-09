package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import project.tour.management_DTO.Tour_Group_Role;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Employee_And_Role;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.tour.management_GUI.GUI_Attraction_Management.encodeValue;

public class GUI_RoleGroup_Management extends JPanel {
    public Tour_Group_Role tour_group_role;
    private JTabbedPane tabbedPane;
    private JPanel panelRoleManagement;
    /*---------------DECLARE PANEL ROLE TOUR--------------------*/
    private JPanel panelFieldRoleGroup;
    private JPanel panelTableRoleGroup;

    private JLabel labelNameRole;
    private JTextField txtNameRole;
    private JSeparator sptNameRole;

    private JButton buttonAddRole;
    private JButton buttonClearFieldRole;

    private JButton buttonSaveRole;
    private JButton buttonCancelRole;

    public JTable tableRoleGroup;
    public DefaultTableModel modeltableRoleGroup;
    private JScrollPane scrollPaneRoleGroup;

    private JLabel labelSearchRole;
    private JTextField txtSearchRole;
    private JLabel labelIconSearchRole;
    private JLabel labelIconRefreshRole;

    private JButton buttonEditRole;
    private JButton buttonDeleteRole;
    /*--------------END DECLARE PANEL ROLE TOUR-----------------------*/
    public GUI_RoleGroup_Management(){
        GUI();
    }
    public void GUI(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
            tabbedPane = new JTabbedPane();
            tabbedPane.setBounds(5, 5, 980, 580);
            tabbedPane.setBackground(new Color(0,77,64));
            tabbedPane.setForeground(Color.white);
            panelRoleManagement = new JPanel();
            panelRoleManagement.setLayout(null);
            panelRoleManagement.setBounds(5,5,970,570);
            panelRoleManagement.setBackground(Color.white);
        /*===================PANEL FIELD ROLE TOUR========================*/
        panelFieldRoleGroup = new JPanel();
        panelFieldRoleGroup.setLayout(null);
        panelFieldRoleGroup.setBackground(Color.white);
        panelFieldRoleGroup.setBounds(0,0,400,570);

        //**************TEXTFIELD NAME ROLE*******************//
        labelNameRole = new JLabel("TÊN NHIỆM VỤ :",JLabel.CENTER);
        labelNameRole.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameRole.setBounds(30,165,120,30);

        txtNameRole = new JTextField();
        txtNameRole.setBounds(145,163,200,30);
        txtNameRole.setBorder(null);
        txtNameRole.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptNameRole = new JSeparator();
        sptNameRole.setBounds(145,193,200,10);
        sptNameRole.setBackground(new Color(0,0,0));
        //**************END TEXTFIELD NAME ROLE*******************//


        buttonAddRole = new JButton("Thêm nhiệm vụ");
        buttonAddRole.setBackground(new Color(41, 149, 85));
        buttonAddRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonAddRole.setForeground(Color.WHITE);
        buttonAddRole.setBounds(50,305,170,30);
        buttonAddRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearFieldRole = new JButton("Làm Mới");
        buttonClearFieldRole.setBackground(new Color(255, 255, 255));
        buttonClearFieldRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearFieldRole.setForeground(Color.BLACK);
        buttonClearFieldRole.setBounds(250,305,105,30);
        buttonClearFieldRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonSaveRole = new JButton("Lưu");
        buttonSaveRole.setBackground(new Color(32, 171, 214));
        buttonSaveRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveRole.setForeground(Color.WHITE);
        buttonSaveRole.setBounds(50,305,105,30);
        buttonSaveRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCancelRole = new JButton("Huỷ Bỏ");
        buttonCancelRole.setBackground(new Color(219, 50, 54));
        buttonCancelRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonCancelRole.setForeground(Color.WHITE);
        buttonCancelRole.setBounds(250,305,105,30);
        buttonCancelRole.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /**************ADD ELEMENT FOR PANEL FIELD ROLE TOUR*********************/
        panelFieldRoleGroup.add(labelNameRole);
        panelFieldRoleGroup.add(txtNameRole);
        panelFieldRoleGroup.add(sptNameRole);

        panelFieldRoleGroup.add(buttonAddRole);
        panelFieldRoleGroup.add(buttonClearFieldRole);

        panelFieldRoleGroup.add(buttonSaveRole);
        panelFieldRoleGroup.add(buttonCancelRole);
        buttonSaveRole.setVisible(false);
        buttonCancelRole.setVisible(false);
        /**************END ADD ELEMENT FOR PANEL FIELD ROLE TOUR*******************/
        /*===================END PANEL FIELD ROLE TOUR========================*/

        /*===================PANEL TABLE ROLE TOUR========================*/
        panelTableRoleGroup = new JPanel();
        panelTableRoleGroup.setLayout(null);
        panelTableRoleGroup.setBounds(400,0,580,570);
        panelTableRoleGroup.setBackground(Color.white);

        labelSearchRole = new JLabel("Tìm kiếm:");
        labelSearchRole.setBounds(80,21,80,25);

        txtSearchRole = new JTextField();
        txtSearchRole.setBounds(145,21,250,25);

        labelIconSearchRole = new JLabel();
        labelIconSearchRole.setBounds(410,20,25,25);
        labelIconSearchRole.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelIconSearchRole.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));

        labelIconRefreshRole = new JLabel();
        labelIconRefreshRole.setBounds(443,20,25,25);
        labelIconRefreshRole.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelIconRefreshRole.setIcon(new ImageIcon(getClass().getResource("/image/icons8_repeat_25px_1.png")));

        Vector<String> columnName = new Vector<>();
        columnName.add("Mã Nhiệm Vụ");
        columnName.add("Tên Nhiệm Vụ");
        modeltableRoleGroup = new DefaultTableModel(columnName, 0);

        tableRoleGroup = new JTable(modeltableRoleGroup);
        LoadDataTableRole();

        tableRoleGroup.setRowHeight(25);
        tableRoleGroup.setSelectionBackground(new java.awt.Color(0,105,92, 180));
        tableRoleGroup.getTableHeader().setReorderingAllowed(false);
        tableRoleGroup.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        tableRoleGroup.getTableHeader().setOpaque(false);
        tableRoleGroup.getTableHeader().setBackground(new Color(0,77,64));
        tableRoleGroup.getTableHeader().setForeground(new Color(255,255,255));
        tableRoleGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableRoleGroup.setDefaultEditor(Object.class, null);

        //                            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        //                            rightRenderer.setHorizontalAlignment(JLabel.CENTER);

        /****************SET SIZE COLUMN OF TABLE***********************/
        tableRoleGroup.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableRoleGroup.getColumnModel().getColumn(1).setPreferredWidth(460);
        /****************SET SIZE COLUMN OF TABLE***********************/


        tableRoleGroup.setFont(new Font("Times New Roman",Font.PLAIN,15));

        scrollPaneRoleGroup = new JScrollPane(tableRoleGroup);
        scrollPaneRoleGroup.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });
        scrollPaneRoleGroup.setBounds(10,60,560,400);


        buttonEditRole = new JButton("Sửa Nhiệm Vụ");
        buttonEditRole.setBackground(new Color(194, 98, 14));
        buttonEditRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonEditRole.setForeground(Color.WHITE);
        buttonEditRole.setBounds(100,485,150,30);
        buttonEditRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonDeleteRole = new JButton("Xoá Nhiệm Vụ");
        buttonDeleteRole.setBackground(new Color(219, 50, 54));
        buttonDeleteRole.setFont(new Font("Segoe",Font.BOLD,13));
        buttonDeleteRole.setForeground(Color.WHITE);
        buttonDeleteRole.setBounds(300,485,150,30);
        buttonDeleteRole.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /**************ADD ELEMENT FOR PANEL TABLE ROLE TOUR*******************/
        panelTableRoleGroup.add(scrollPaneRoleGroup);
        panelTableRoleGroup.add(buttonEditRole);
        panelTableRoleGroup.add(buttonDeleteRole);
        panelTableRoleGroup.add(labelSearchRole);
        panelTableRoleGroup.add(txtSearchRole);
        panelTableRoleGroup.add(labelIconSearchRole);
        panelTableRoleGroup.add(labelIconRefreshRole);
        /**************END ADD ELEMENT FOR PANEL TABLE ROLE TOUR*******************/
        /*===================END PANEL TABLE ROLE========================*/

        /**************ADD PANEL FOR PANEL COST TYPE*********************/
        panelRoleManagement.add(panelFieldRoleGroup);
        panelRoleManagement.add(panelTableRoleGroup);
        /**************END ADD PANEL FOR PANEL COST TYPE*********************/
        /*========================END PANEL CostType TOUR====================================*/
        /**************ADD PANEL FOR TABBED PANEL*********************/
        tabbedPane.addTab("--Nhiệm Vụ Tour--", panelRoleManagement);
        add(tabbedPane);
        /**************END ADD PANEL FOR TABBED PANEL*********************/
        /*========================END HANDLE CLICK BUTTON OF COST TYPE====================================*/

        labelIconRefreshRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoadDataTableRole();
            }
        });

        labelIconSearchRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameRole = txtSearchRole.getText();
                nameRole = encodeValue(nameRole);
                String parameter = "&Filters[Name]=\""+nameRole+"\"&FilterConditions[Name]=like";
                LoadDataTableRoleAfterSearch(parameter);
            }
        });

        buttonClearFieldRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldRole();
            }
        });

        buttonAddRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameRole = txtNameRole.getText();
                if(!empty( nameRole ) ) {

                    User_DTO user = new User_DTO();

                    String parameter = "{\"name\":\""+nameRole+"\"}";
                    //APIRequester.sendPOST(parameter, "tourCategories", user.getToken());
                    String response = Handle_API_Employee_And_Role.sendPost_Add_Role_Group(parameter, "groupRoles", user.getToken());
                    if (response.equals("success")==true){
                        LoadDataTableRole();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        clearTextFieldRole();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }

            }
        });
        buttonDeleteRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableRoleGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhiệm vụ cần xoá");
                } else {
                    User_DTO user = new User_DTO();
                    String idRole = (tableRoleGroup.getModel().getValueAt(row, 0).toString());
                    //APIRequester.sendDelete("","tourCategories/"+tourId, user.getToken());
                    String response = Handle_API_Employee_And_Role.sendDeleteRole("","groupRoles/"+idRole, user.getToken());
                    if(response.equals("success") == true){
                        LoadDataTableRole();
                        JOptionPane.showMessageDialog(null, "Xoá nhiệm vụ thành công");
                    }
                }

            }
        });

        buttonEditRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableRoleGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại chi phí cần sửa");
                }else {
                    String id = (tableRoleGroup.getModel().getValueAt(row, 0).toString());
                    String name = (tableRoleGroup.getModel().getValueAt(row, 1).toString());
                    buttonAddRole.setVisible(false);
                    buttonClearFieldRole.setVisible(false);
                    buttonSaveRole.setVisible(true);
                    buttonCancelRole.setVisible(true);
                    txtNameRole.setText(name);
                    tour_group_role = new Tour_Group_Role(id, name);
                }
            }
        });
        buttonCancelRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldRole();
                buttonSaveRole.setVisible(false);
                buttonCancelRole.setVisible(false);
                buttonAddRole.setVisible(true);
                buttonClearFieldRole.setVisible(true);
            }
        });

        buttonSaveRole.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = txtNameRole.getText();
                if(checkDifferent(name, tour_group_role)==false){
                    User_DTO user = new User_DTO();
                    String parameter = "{\"id\":"+tour_group_role.getRoleId()+",\"name\":\""+name+"\"}";
                    System.out.println(parameter);
                    //APIRequester.sendPUT(parameter, "costTypes/"+IdCostType, user.getToken());
                    String response = Handle_API_Employee_And_Role.send_PUT_Edit_Role(parameter, "groupRoles/"+tour_group_role.getRoleId(), user.getToken());
                    if(response.equals("success")){
                        clearTextFieldRole();
                        LoadDataTableRole();
                        buttonSaveRole.setVisible(false);
                        buttonCancelRole.setVisible(false);
                        buttonAddRole.setVisible(true);
                        buttonClearFieldRole.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Nhiệm vụ không có thay đổi");
                }
            }
        });
        /*========================END HANDLE CLICK BUTTON OF COST TYPE====================================*/
    }
    public void LoadDataTableRole(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Role("groupRoles?Page=1&Limit=100", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();
        modeltableRoleGroup.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("name").toString());

                modeltableRoleGroup.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        tableRoleGroup.setModel(modeltableRoleGroup);


    }
    public void LoadDataTableRoleAfterSearch(String parameter){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Role("groupRoles?Page=1&Limit=100"+parameter, user.getToken()));
        if(json.length() >= 1) {
            modeltableRoleGroup.setRowCount(0);
            for (int i = 0; i < json.length(); i++) {

                JSONObject jsonObj;
                try {
                    jsonObj = json.getJSONObject(i);
                    Vector<String> data = new Vector<>();

                    data.add(jsonObj.get("id").toString());
                    data.add(jsonObj.get("name").toString());

                    modeltableRoleGroup.addRow(data);
                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tableRoleGroup.setModel(modeltableRoleGroup);
        }else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nhiệm vụ cần tìm");
        }
    }
    public void clearTextFieldRole(){
        txtNameRole.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferent(String name, Tour_Group_Role role){
        if(name.equals(role.getRoleId())== true ){
            return true;
        }
        return false;
    }
}
