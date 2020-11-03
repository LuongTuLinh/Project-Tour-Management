package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Employee_And_Role;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.Timer;

import static project.tour.management_GUI.GUI_List_Employee.arrayListIdRole;


public class GUI_List_Roles {

    public static JFrame myFrame;

    private JPanel panelListCustomers;

    private JLabel labelTitle;

    public static HashMap<String, String> dataListRoles ;
    public static DefaultListModel<String> modelListRoles;
    public static JList<String> listRoles;
    private JScrollPane scrollPaneAllRoles;

    public GUI_List_Roles(){
        GUI();
    }
    public void GUI(){

        myFrame = new JFrame();

        myFrame.setSize(350, 380);
        myFrame.setLocationRelativeTo(null);
        myFrame.setLayout(null);
        myFrame.getContentPane().setBackground(Color.BLACK);
        myFrame.setUndecorated(true);


        panelListCustomers =new JPanel();
        panelListCustomers.setLayout(null);
        panelListCustomers.setBackground(Color.white);
        panelListCustomers.setBounds(0,0, 350, 380);

        labelTitle = new JLabel("- - - DANH SÁCH NHIỆM VỤ - - - ",JLabel.CENTER);
        labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
        labelTitle.setBounds(0,10,350,30);

        scrollPaneAllRoles= new JScrollPane();

        scrollPaneAllRoles.setBounds(2, 40, 348, 330);
        scrollPaneAllRoles.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });

        UpdateListRolesGroup();
        listRoles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listRoles.setFixedCellHeight(30);
        listRoles.setFixedCellWidth(300);
        listRoles.setBorder(new EmptyBorder(10,10, 10, 10));


        //listCustomers.setSelectedIndex(0);
        //listCustomers.setVisibleRowCount(10);
        listRoles.setSelectionModel(new DefaultListSelectionModel() {
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
        scrollPaneAllRoles.setViewportView(listRoles);


        panelListCustomers.add(labelTitle);
        panelListCustomers.add(scrollPaneAllRoles);
        myFrame.add(panelListCustomers);
        myFrame.setVisible(true);


    }
    public static void getIdRoles(){
        User_DTO user_dto = new User_DTO();
        String paramterIds = "";
        arrayListIdRole = new ArrayList<>();

        if(listRoles.getSelectedValuesList() == null){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn khách hàng");
        }
        else {
            ArrayList<String> arrayListNameSelected = (ArrayList<String>) listRoles.getSelectedValuesList();
            for(Object x : dataListRoles.keySet()){
                for (String nameSelected : arrayListNameSelected) {

                    System.out.println(x +" và "+nameSelected);

                    if(nameSelected.equals(x)==true){
                        String idCustomer = dataListRoles.get(x);
                        System.out.println("id Role:"+idCustomer);

                        paramterIds+="\""+idCustomer+"\",";
                        System.out.println(paramterIds);
                        arrayListIdRole.add(idCustomer);

                    }
                }
            }
        }
    }
    public static HashMap<String, String> hashMapRolesGroup(){
            User_DTO user = new User_DTO();
            dataListRoles = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Role("groupRoles?Page=1&Limit=100", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("name").toString();
                    String id = jsonObj.get("id").toString();

                    dataListRoles.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataListRoles;

        }
    public void UpdateListRolesGroup(){
        hashMapRolesGroup();
        modelListRoles = new  DefaultListModel<String>();
        listRoles = new JList<String>(modelListRoles);
        listRoles.setCellRenderer(new CheckboxListCellRenderer());
        for(Object object : dataListRoles.keySet()){
            modelListRoles.addElement(String.valueOf(object));
        }
        listRoles.setModel(modelListRoles);
        listRoles.setFont(new Font("Arial",Font.ITALIC,14));


    }
    public static void disConnectJFrame(){
        myFrame.setVisible(false);
        myFrame.dispose();
    }
    public void createAndStartDownwardTimer(final JFrame frame) {
        new Timer(25, new AbstractAction() {
            int screenWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width - 110;
            int x = frame.getX();

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (frame.getX() + frame.getWidth() < screenWidth ) {
                    x += 10;
                    frame.setLocation(x, frame.getY());
                }
                else {

                    ((Timer) ae.getSource()).stop();
                }
            }
        }).start();
    }
    public void createAndStartUpwardTimer() {
        Timer t = new Timer(25, new AbstractAction() {
            int x = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width - myFrame.getWidth()-110;

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (myFrame.getX() > 480) {
                    x -= 10;
                    myFrame.setLocation(x, myFrame.getY());
                }
                else {
                    ((Timer) ae.getSource()).stop();
                }
            }
        });
        t.setInitialDelay(50);
        t.start();
    }
}

