package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.Tour_Attraction_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Cost_Type;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import static project.tour.management_GUI.GUI_Group_Tour_Details.*;

public class GUI_List_Cost_Type extends JFrame {

    private JPanel panelListCostType;

    private JLabel labelTitle;

    public static HashMap<String, String> dataListCostType ;
    public static DefaultListModel<String> modelListCostType;
    public JList<String> listCostType;
    private JScrollPane scrollPaneAllCostType;
    private JButton btnAddCostTypeToGroup;

    private JLabel labelPriceCostType;
    private JTextField txtPriceCostType;
    private JSeparator sptPriceCostType;

    private JLabel labelDescriptionCostType;
    private JTextArea textAreaDescription;
    private JScrollPane scrollPaneCostType;

    public GUI_List_Cost_Type(String id){
        GUI(id);
    }
    public void GUI(String id){
        setSize(450, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setTitle("Danh Sách Chi Phí");

        panelListCostType =new JPanel();
        panelListCostType.setLayout(null);
        panelListCostType.setBackground(Color.white);
        panelListCostType.setBounds(0,1, 450, 549);

        labelTitle = new JLabel("- - - DANH SÁCH CHI PHÍ - - - ",JLabel.CENTER);
        labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
        labelTitle.setBounds(0,10,450,30);

        scrollPaneAllCostType = new JScrollPane();

        scrollPaneAllCostType.setBounds(20, 50, 400, 230);
        scrollPaneAllCostType.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });

        ListCostTypeGroup();
        listCostType.setSelectedIndex(0);
        listCostType.setVisibleRowCount(10);
        listCostType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCostType.setFixedCellHeight(30);
        listCostType.setFixedCellWidth(350);
        listCostType.setBorder(new EmptyBorder(10,10, 10, 10));


        scrollPaneAllCostType.setViewportView(listCostType);


        //**************TEXTFIELD PRICE COST TYPE*******************//
        labelPriceCostType = new JLabel("Giá Chi Phí :",JLabel.CENTER);
        labelPriceCostType.setFont(new Font("Segoe",Font.BOLD,12));
        labelPriceCostType.setBounds(0,287,120,30);

        txtPriceCostType = new JTextField();
        txtPriceCostType.setBounds(105,285,150,30);
        txtPriceCostType.setBorder(null);
        txtPriceCostType.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptPriceCostType = new JSeparator();
        sptPriceCostType.setBounds(105,315,150,10);
        sptPriceCostType.setBackground(new Color(0,0,0));
        //**************END TEXTFIELD PRICE COST TYPE*******************//

        //**************TEXTFIELD TEXTFIELD DESCRIPTION COST TYPE *******************//
        labelDescriptionCostType = new JLabel("Ghi Chú :",JLabel.CENTER);
        labelDescriptionCostType.setFont(new Font("Segoe",Font.BOLD,12));
        labelDescriptionCostType.setBounds(5,330,120,30);

        textAreaDescription = new JTextArea(10, 10);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));

        scrollPaneCostType = new JScrollPane(textAreaDescription);
        scrollPaneCostType.setBounds(40,365,370,100);
        //**************END TEXTFIELD TEXTFIELD DESCRIPTION COST TYPE*******************//


        btnAddCostTypeToGroup = new JButton("Lưu");
        btnAddCostTypeToGroup.setBackground(new Color(6, 32, 160));
        btnAddCostTypeToGroup.setFont(new Font("Segoe",Font.BOLD,13));
        btnAddCostTypeToGroup.setForeground(Color.WHITE);
        btnAddCostTypeToGroup.setBounds(170,475,115,30);
        btnAddCostTypeToGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelListCostType.add(labelTitle);
        panelListCostType.add(btnAddCostTypeToGroup);
        panelListCostType.add(scrollPaneAllCostType);

        panelListCostType.add(labelPriceCostType);
        panelListCostType.add(txtPriceCostType);
        panelListCostType.add(sptPriceCostType);

        panelListCostType.add(labelDescriptionCostType);
        panelListCostType.add(scrollPaneCostType);

        add(panelListCostType);
        setVisible(true);


        btnAddCostTypeToGroup.addMouseListener(new MouseAdapter() {
            User_DTO user_dto = new User_DTO();
            @Override
            public void mouseClicked(MouseEvent e) {

                if(listCostType.getSelectedValuesList().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Vui lòng chọn chi phí");
                }
                else {
                    String idCostType ="";
                    for(Object x : dataListCostType.keySet()){
                        if(listCostType.getSelectedValue().equals(x)){
                            idCostType = dataListCostType.get(x);
                        }
                    }
                    String price = txtPriceCostType.getText();
                    String note = textAreaDescription.getText();
                    String price_PATTERN = "^[0-9]+$";
                    if(Pattern.matches(price_PATTERN, price) == false) {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm giá tour");
                    }else {
                        String parameter="{\"id\":0,\"groupId\":"+id+",\"costTypeId\":"+idCostType+",\"price\":"+price+",\"note\":\""+note+"\"}";

                        String response = Handle_API_Cost_Type.sendPost_Add_Cost_Type(parameter, "groupCosts", user_dto.getToken());
                        if(response.equals("success") == true){
                            JOptionPane.showMessageDialog(null, "Thêm thành công");
                            dispose();
                            LoadDataTableCostTypeInGroup(id);
                        }
                    }

                }

            }
        });
    }
    public static HashMap<String, String> hashMapCostTypeInGroup(){
        if(idCostTypeInGroup.isEmpty()){
            User_DTO user = new User_DTO();
            dataListCostType = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Cost_Type.Fetch_API_All_Cost_Type("costTypes?Page=1&Limit=100", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("name").toString();
                    String id = jsonObj.get("id").toString();

                    dataListCostType.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataListCostType;
        }else {
            String idCostType = "";
            for (String idCostTypeNotIn : idCostTypeInGroup
                 ) {
                idCostType += idCostTypeNotIn+",";
            }

            StringBuilder costTypeNotIn = new StringBuilder(idCostType);
            System.out.println(costTypeNotIn.deleteCharAt(costTypeNotIn.length()-1));
            User_DTO user = new User_DTO();
            dataListCostType = new HashMap<String, String>();
            JSONArray result = new JSONArray(Handle_API_Cost_Type.Fetch_API_All_Cost_Type("costTypes?Page=1&Limit=100&Filters[Id]="+costTypeNotIn+"&FilterConditions[Id]=notin", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("name").toString();
                    String id = jsonObj.get("id").toString();

                    dataListCostType.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataListCostType;
        }
    }
    public void ListCostTypeGroup(){
        hashMapCostTypeInGroup();
        modelListCostType = new  DefaultListModel<String>();
        listCostType = new JList<String>(modelListCostType);
        for(Object object : dataListCostType.keySet()){
            modelListCostType.addElement(String.valueOf(object));
        }
        listCostType.setModel(modelListCostType);
        listCostType.setFont(new Font("Arial",Font.ITALIC,14));


    }
}