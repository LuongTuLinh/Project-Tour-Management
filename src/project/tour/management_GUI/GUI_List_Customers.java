package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.Tour_Attraction_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour_Attractions;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.tour.management_GUI.GUI_Group_Tour_Details.LoadDataTableCustomerInGroup;
import static project.tour.management_GUI.GUI_Group_Tour_Details.idCustomersInGroup;

public class GUI_List_Customers extends JFrame {

    private JPanel panelListCustomers;

    private JLabel labelTitle;

    public static HashMap<String, String> dataListCustomers ;
    public static DefaultListModel<String> modelListCustomers;
    public JList<String> listCustomers;
    private JScrollPane scrollPaneAllCustomer;
    private JButton btnAddCustomerToGroup;

    public GUI_List_Customers(String id){
        GUI(id);
    }
    public void GUI(String id){
        setSize(450, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Danh Sách Khách Hàng");

            panelListCustomers =new JPanel();
            panelListCustomers.setLayout(null);
            panelListCustomers.setBackground(Color.white);
            panelListCustomers.setBounds(0,1, 450, 499);

                labelTitle = new JLabel("- - - DANH SÁCH KHÁCH HÀNG - - - ",JLabel.CENTER);
                labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
                labelTitle.setBounds(0,10,450,30);

                scrollPaneAllCustomer = new JScrollPane();

                scrollPaneAllCustomer.setBounds(20, 70, 400, 330);
                scrollPaneAllCustomer.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });

                UpdateListAttractionTour();
                listCustomers.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                listCustomers.setFixedCellHeight(30);
                listCustomers.setFixedCellWidth(350);
                listCustomers.setBorder(new EmptyBorder(10,10, 10, 10));


                //listCustomers.setSelectedIndex(0);
                //listCustomers.setVisibleRowCount(10);
                listCustomers.setSelectionModel(new DefaultListSelectionModel() {
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
                scrollPaneAllCustomer.setViewportView(listCustomers);

                btnAddCustomerToGroup = new JButton("Lưu");
                btnAddCustomerToGroup.setBackground(new Color(6, 32, 160));
                btnAddCustomerToGroup.setFont(new Font("Segoe",Font.BOLD,13));
                btnAddCustomerToGroup.setForeground(Color.WHITE);
                btnAddCustomerToGroup.setBounds(170,415,115,30);
                btnAddCustomerToGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

            panelListCustomers.add(labelTitle);
            panelListCustomers.add(btnAddCustomerToGroup);
            panelListCustomers.add(scrollPaneAllCustomer);
        add(panelListCustomers);
        setVisible(true);


        btnAddCustomerToGroup.addMouseListener(new MouseAdapter() {
            User_DTO user_dto = new User_DTO();
            @Override
            public void mouseClicked(MouseEvent e) {
                String paramterIds = "";

                ArrayList<String> arrayListNameSelected = (ArrayList<String>) listCustomers.getSelectedValuesList();
                if(arrayListNameSelected.isEmpty()){
                    System.out.println(arrayListNameSelected);
                } else {
                    for(Object x : dataListCustomers.keySet()){
                        for (String nameSelected : arrayListNameSelected) {

                            System.out.println(x +" và "+nameSelected);

                            if(nameSelected.equals(x)==true){
                                String idCustomer = dataListCustomers.get(x);
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
    public static HashMap<String, String> hashMapTourAttraction(){
        StringBuilder customerNotIn = new StringBuilder(idCustomersInGroup);
        System.out.println(customerNotIn.deleteCharAt(customerNotIn.length()-1));

        User_DTO user = new User_DTO();
        dataListCustomers = new HashMap<String, String>();
        JSONArray result = new JSONArray(Handle_API_Tour_Group.Fetch_API_List_All_Customers("users/customers?Page=1&Limit=100&Filters[Id]="+customerNotIn+"&FilterConditions[Id]=notin", user.getToken()));
        for(int i = 0; i < result.length(); i++){
            JSONObject jsonObj;
            try {
                jsonObj = result.getJSONObject(i);
                String name = jsonObj.get("lastName").toString()+" "+jsonObj.get("firstName").toString();
                String id = jsonObj.get("id").toString();

                dataListCustomers.put(name,id);

            } catch (JSONException ex) {
                Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataListCustomers;
    }
    public void UpdateListAttractionTour(){
        hashMapTourAttraction();
        modelListCustomers = new  DefaultListModel<String>();
        listCustomers = new JList<String>(modelListCustomers);
        listCustomers.setCellRenderer(new CheckboxListCellRenderer());
        for(Object object : dataListCustomers.keySet()){
            modelListCustomers.addElement(String.valueOf(object));
        }
        listCustomers.setModel(modelListCustomers);
        listCustomers.setFont(new Font("Arial",Font.ITALIC,14));


    }
}
class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {

        setComponentOrientation(list.getComponentOrientation());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setSelected(isSelected);
        setEnabled(list.isEnabled());

        setText(value == null ? "" : value.toString());

        return this;
    }
}

