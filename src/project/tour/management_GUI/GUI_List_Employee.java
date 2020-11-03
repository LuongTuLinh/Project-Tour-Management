package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Employee_And_Role;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.tour.management_GUI.GUI_Group_Tour_Details.*;
import static project.tour.management_GUI.GUI_List_Roles.*;

public class GUI_List_Employee extends JFrame {

    public GUI_List_Roles gui_list_roles =  new GUI_List_Roles();;
    public static ArrayList<String> arrayListIdRole;

    private JPanel panelListEmployee;

    private JLabel labelTitle;

    public static HashMap<String, String> dataListEmployee ;
    public static DefaultListModel<String> modelListEmployee;
    public JList<String> listEmployee;
    private JScrollPane scrollPaneAllEmployee;
    private JButton btnAddEmployeeToGroup;

    public GUI_List_Employee(String id){
        GUI(id);
    }
    public void GUI(String id){
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Danh Sách Nhân Viên");

        panelListEmployee =new JPanel();
        panelListEmployee.setLayout(null);
        panelListEmployee.setBackground(Color.white);
        panelListEmployee.setBounds(0,1, 450, 499);

        labelTitle = new JLabel("- - - DANH SÁCH Nhân Viên - - - ",JLabel.CENTER);
        labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
        labelTitle.setBounds(0,10,450,30);

        scrollPaneAllEmployee = new JScrollPane();

        scrollPaneAllEmployee.setBounds(20, 70, 400, 330);
        scrollPaneAllEmployee.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });

        UpdateListEmployee();
        listEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listEmployee.setFixedCellHeight(30);
        listEmployee.setFixedCellWidth(350);
        listEmployee.setBorder(new EmptyBorder(10,10, 10, 10));

        scrollPaneAllEmployee.setViewportView(listEmployee);

        btnAddEmployeeToGroup = new JButton("Lưu");
        btnAddEmployeeToGroup.setBackground(new Color(6, 32, 160));
        btnAddEmployeeToGroup.setFont(new Font("Segoe",Font.BOLD,13));
        btnAddEmployeeToGroup.setForeground(Color.WHITE);
        btnAddEmployeeToGroup.setBounds(170,415,115,30);
        btnAddEmployeeToGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelListEmployee.add(labelTitle);
        panelListEmployee.add(btnAddEmployeeToGroup);
        panelListEmployee.add(scrollPaneAllEmployee);
        add(panelListEmployee);
        setVisible(true);

        listEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    gui_list_roles.createAndStartDownwardTimer(myFrame);
                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    listEmployee.clearSelection();
                    listRoles.clearSelection();
                    gui_list_roles.createAndStartUpwardTimer();
                }
            }
        });
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();

                GUI_List_Roles.disConnectJFrame();
                LoadDataEmployeeInGroup(id);
                LoadDataRoleEmployee(id);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


        btnAddEmployeeToGroup.addMouseListener(new MouseAdapter() {
            User_DTO user_dto = new User_DTO();
            @Override
            public void mouseClicked(MouseEvent e) {
                getIdRoles();
                String idEmployee ="";
                String idRoles = "";

                if(listEmployee.getSelectedValuesList() == null){
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn nhân viên");
                }
                else {

                    for(Object x : dataListEmployee.keySet()){
                        if(listEmployee.getSelectedValue().equals(x)){
                            idEmployee = dataListEmployee.get(x);
                        }
                    }
                }
                System.out.println(arrayListIdRole);
                for(String idrole : arrayListIdRole){
                    idRoles+=idrole+",";
                }
                System.out.println("id: "+idEmployee);
                StringBuilder idR = new StringBuilder(idRoles);
                System.out.println("list id roles: "+idR.deleteCharAt(idR.length()-1));

                String parameter = "{\"groupId\":"+id+",\"staffId\":\""+idEmployee+"\",\"groupRoles\":["+idR.toString()+"]}";

                String response = Handle_API_Tour_Group.send_POST_Add_Customer_To_Group(parameter, "staffGroupRoles", user_dto.getToken());
                if(response.equals("success") == true){
                    dispose();

                    GUI_List_Roles.disConnectJFrame();
                    LoadDataEmployeeInGroup(id);
                    LoadDataRoleEmployee(id);
                }
            }
        });
    }
    public static HashMap<String, String> hashMapEmployeeGroup(){
        if(idEmployeeInGroup.isEmpty()){
            User_DTO user = new User_DTO();
            dataListEmployee = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Employee("users/staffs?Page=1&Limit=100", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("lastName").toString()+" "+jsonObj.get("firstName").toString();
                    String id = jsonObj.get("id").toString();

                    dataListEmployee.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataListEmployee;
        }else {
            String idEmployee = "";
            for (String idEmployeeNotIn : idEmployeeInGroup
            ) {
                idEmployee += idEmployeeNotIn+",";
            }
            StringBuilder EmployeeNotIn = new StringBuilder(idEmployee);
            System.out.println(EmployeeNotIn.deleteCharAt(EmployeeNotIn.length()-1));
            User_DTO user = new User_DTO();
            dataListEmployee = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Employee("users/staffs?Page=1&Limit=100&Filters[Id]="+EmployeeNotIn+"&FilterConditions[Id]=notin", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("lastName").toString()+" "+jsonObj.get("firstName").toString();
                    String id = jsonObj.get("id").toString();

                    dataListEmployee.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataListEmployee;
        }
    }
    public void UpdateListEmployee(){
        hashMapEmployeeGroup();
        modelListEmployee = new  DefaultListModel<String>();
        listEmployee = new JList<String>(modelListEmployee);
        listEmployee.setCellRenderer(new CheckboxListCellRenderer());
        for(Object object : dataListEmployee.keySet()){
            modelListEmployee.addElement(String.valueOf(object));
        }
        listEmployee.setModel(modelListEmployee);
        listEmployee.setFont(new Font("Arial",Font.ITALIC,14));


    }
}


