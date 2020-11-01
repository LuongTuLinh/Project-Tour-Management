package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.tour.management_GUI.GUI_Group_Tour_Details.*;

public class GUI_List_Employee extends JFrame {

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
        listEmployee.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listEmployee.setFixedCellHeight(30);
        listEmployee.setFixedCellWidth(350);
        listEmployee.setBorder(new EmptyBorder(10,10, 10, 10));


        listEmployee.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
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


        btnAddEmployeeToGroup.addMouseListener(new MouseAdapter() {
            User_DTO user_dto = new User_DTO();
            @Override
            public void mouseClicked(MouseEvent e) {
                String paramterIds = "";

                if(listEmployee.getSelectedValuesList() == null){
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn nhân viên");
                }
                else {
                    ArrayList<String> arrayListNameSelected = (ArrayList<String>) listEmployee.getSelectedValuesList();
                    for(Object x : dataListEmployee.keySet()){
                        for (String nameSelected : arrayListNameSelected) {

                            System.out.println(x +" và "+nameSelected);

                            if(nameSelected.equals(x)==true){
                                String idCustomer = dataListEmployee.get(x);
                                System.out.println("id customer:"+idCustomer);

                                paramterIds+="\""+idCustomer+"\",";
                                System.out.println(paramterIds);

                            }
                        }
                    }
                }

                String parameterCustomersId="{\"groupId\":"+id+",\"userIds\":["+paramterIds+"]}";
                StringBuilder stringBuilderIds = new StringBuilder(parameterCustomersId);
                System.out.println(stringBuilderIds.deleteCharAt(stringBuilderIds.length()-3));
                String parameter = stringBuilderIds.toString();
                String response = Handle_API_Tour_Group.send_POST_Add_Customer_To_Group(parameter, "groupDetails", user_dto.getToken());
                if(response.equals("success") == true){
                    dispose();
                    LoadDataTableCustomerInGroup(id);
                }
            }
        });
    }
    public static HashMap<String, String> hashMapEmployeeGroup(){
        if(idCustomersInGroup.isEmpty()){
            User_DTO user = new User_DTO();
            dataListEmployee = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Tour_Group.Fetch_API_List_All_Customers("users/staffs?Page=1&Limit=100", user.getToken()));
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
            String idCustomer = "";
            for (String idCustomerNotIn : idCustomersInGroup
            ) {
                idCustomer += idCustomerNotIn+",";
            }
            StringBuilder customerNotIn = new StringBuilder(idCustomer);
            System.out.println(customerNotIn.deleteCharAt(customerNotIn.length()-1));
            User_DTO user = new User_DTO();
            dataListEmployee = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Tour_Group.Fetch_API_List_All_Customers("users/staffs?Page=1&Limit=100&Filters[Id]="+customerNotIn+"&FilterConditions[Id]=notin", user.getToken()));
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


