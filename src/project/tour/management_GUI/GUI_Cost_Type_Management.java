package project.tour.management_GUI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import project.tour.management_DTO.Tour_Group_CostType;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Cost_Type;
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

public class GUI_Cost_Type_Management extends JPanel {
    public Tour_Group_CostType tour_group_costType;

    private JTabbedPane tabbedPane;
    private JPanel panelCostType;
    /*---------------DECLARE PANEL CostType TOUR--------------------*/
    private JPanel panelFieldCostType;
    private JPanel panelTableCostType;

    private JLabel labelNameCostType;
    private JTextField txtNameCostType;
    private JSeparator sptNameCostType;

    private JButton buttonAddCostType;
    private JButton buttonClearFieldCostType;

    private JButton buttonSaveCostType;
    private JButton buttonCancelCostType;

    public JTable tableCostType;
    public DefaultTableModel modeltableCostType;
    private JScrollPane scrollPaneCostType;

    private JLabel labelSearchCostType;
    private JTextField txtSearchCostType;
    private JLabel labelIconSearchCostType;
    private JLabel labelIconRefreshCostType;

    private JButton buttonEditCostType;
    private JButton buttonDeleteCostType;
    /*--------------END DECLARE PANEL CostType TOUR-----------------------*/
    public GUI_Cost_Type_Management(){
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
                panelCostType = new JPanel();
                panelCostType.setLayout(null);
                panelCostType.setBounds(5,5,970,570);
                panelCostType.setBackground(Color.white);
            /*===================PANEL FIELD CostType TOUR========================*/
            panelFieldCostType = new JPanel();
            panelFieldCostType.setLayout(null);
            panelFieldCostType.setBackground(Color.white);
            panelFieldCostType.setBounds(0,0,400,570);
            //**************TEXTFIELD NAME CostType*******************//
            labelNameCostType = new JLabel("TÊN LOẠI CHI PHÍ :",JLabel.CENTER);
            labelNameCostType.setFont(new Font("Segoe",Font.BOLD,12));
            labelNameCostType.setBounds(30,165,120,30);

            txtNameCostType = new JTextField();
            txtNameCostType.setBounds(145,163,200,30);
            txtNameCostType.setBorder(null);
            txtNameCostType.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

            sptNameCostType = new JSeparator();
            sptNameCostType.setBounds(145,193,200,10);
            sptNameCostType.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD NAME CostType*******************//


            buttonAddCostType = new JButton("Thêm Loại Chi Phí");
            buttonAddCostType.setBackground(new Color(41, 149, 85));
            buttonAddCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonAddCostType.setForeground(Color.WHITE);
            buttonAddCostType.setBounds(50,305,170,30);
            buttonAddCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

            buttonClearFieldCostType = new JButton("Làm Mới");
            buttonClearFieldCostType.setBackground(new Color(255, 255, 255));
            buttonClearFieldCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonClearFieldCostType.setForeground(Color.BLACK);
            buttonClearFieldCostType.setBounds(250,305,105,30);
            buttonClearFieldCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

            buttonSaveCostType = new JButton("Lưu");
            buttonSaveCostType.setBackground(new Color(32, 171, 214));
            buttonSaveCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonSaveCostType.setForeground(Color.WHITE);
            buttonSaveCostType.setBounds(50,305,105,30);
            buttonSaveCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

            buttonCancelCostType = new JButton("Huỷ Bỏ");
            buttonCancelCostType.setBackground(new Color(219, 50, 54));
            buttonCancelCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonCancelCostType.setForeground(Color.WHITE);
            buttonCancelCostType.setBounds(250,305,105,30);
            buttonCancelCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));
            /**************ADD ELEMENT FOR PANEL FIELD CostType TOUR*********************/
            panelFieldCostType.add(labelNameCostType);
            panelFieldCostType.add(txtNameCostType);
            panelFieldCostType.add(sptNameCostType);

            panelFieldCostType.add(buttonAddCostType);
            panelFieldCostType.add(buttonClearFieldCostType);

            panelFieldCostType.add(buttonSaveCostType);
            panelFieldCostType.add(buttonCancelCostType);
            buttonSaveCostType.setVisible(false);
            buttonCancelCostType.setVisible(false);
            /**************END ADD ELEMENT FOR PANEL FIELD CostType TOUR*******************/
            /*===================END PANEL FIELD CostType TOUR========================*/

            /*===================PANEL TABLE CostType TOUR========================*/
            panelTableCostType = new JPanel();
            panelTableCostType.setLayout(null);
            panelTableCostType.setBounds(400,0,580,570);
            panelTableCostType.setBackground(Color.white);

            labelSearchCostType = new JLabel("Tìm kiếm:");
            labelSearchCostType.setBounds(80,21,80,25);

            txtSearchCostType = new JTextField();
            txtSearchCostType.setBounds(145,21,250,25);

            labelIconSearchCostType = new JLabel();
            labelIconSearchCostType.setBounds(410,20,25,25);
            labelIconSearchCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));
            labelIconSearchCostType.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));

            labelIconRefreshCostType = new JLabel();
            labelIconRefreshCostType.setBounds(443,20,25,25);
            labelIconRefreshCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));
            labelIconRefreshCostType.setIcon(new ImageIcon(getClass().getResource("/image/icons8_repeat_25px_1.png")));

            Vector<String> columnName = new Vector<>();
            columnName.add("Mã Loại");
            columnName.add("Tên Loại Chi Phí");
            modeltableCostType = new DefaultTableModel(columnName, 0);

            tableCostType = new JTable(modeltableCostType);
            LoadDataTableCostType();

            tableCostType.setRowHeight(25);
            tableCostType.setSelectionBackground(new java.awt.Color(0,105,92, 180));
            tableCostType.getTableHeader().setReorderingAllowed(false);
            tableCostType.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
            tableCostType.getTableHeader().setOpaque(false);
            tableCostType.getTableHeader().setBackground(new Color(0,77,64));
            tableCostType.getTableHeader().setForeground(new Color(255,255,255));
            tableCostType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tableCostType.setDefaultEditor(Object.class, null);

    //                            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    //                            rightRenderer.setHorizontalAlignment(JLabel.CENTER);

            /****************SET SIZE COLUMN OF TABLE***********************/
            tableCostType.getColumnModel().getColumn(0).setPreferredWidth(100);
            tableCostType.getColumnModel().getColumn(1).setPreferredWidth(460);
            /****************SET SIZE COLUMN OF TABLE***********************/


            tableCostType.setFont(new Font("Times New Roman",Font.PLAIN,15));

            scrollPaneCostType = new JScrollPane(tableCostType);
            scrollPaneCostType.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = new Color(19, 113, 106);
                }
            });
            scrollPaneCostType.setBounds(10,60,560,400);


            buttonEditCostType = new JButton("Sửa Loại Chi Phí");
            buttonEditCostType.setBackground(new Color(194, 98, 14));
            buttonEditCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonEditCostType.setForeground(Color.WHITE);
            buttonEditCostType.setBounds(100,485,150,30);
            buttonEditCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

            buttonDeleteCostType = new JButton("Xoá Loại Chi Phí");
            buttonDeleteCostType.setBackground(new Color(219, 50, 54));
            buttonDeleteCostType.setFont(new Font("Segoe",Font.BOLD,13));
            buttonDeleteCostType.setForeground(Color.WHITE);
            buttonDeleteCostType.setBounds(300,485,150,30);
            buttonDeleteCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

            /**************ADD ELEMENT FOR PANEL TABLE CostType TOUR*******************/
            panelTableCostType.add(scrollPaneCostType);
            panelTableCostType.add(buttonEditCostType);
            panelTableCostType.add(buttonDeleteCostType);
            panelTableCostType.add(labelSearchCostType);
            panelTableCostType.add(txtSearchCostType);
            panelTableCostType.add(labelIconSearchCostType);
            panelTableCostType.add(labelIconRefreshCostType);
            /**************END ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
            /*===================END PANEL TABLE COST TYPE========================*/

            /**************ADD PANEL FOR PANEL COST TYPE*********************/
            panelCostType.add(panelFieldCostType);
            panelCostType.add(panelTableCostType);
            /**************END ADD PANEL FOR PANEL COST TYPE*********************/
            /*========================END PANEL CostType TOUR====================================*/
        /**************ADD PANEL FOR TABBED PANEL*********************/
        tabbedPane.addTab("Loại Chi Phí", panelCostType);
        add(tabbedPane);
        /**************END ADD PANEL FOR TABBED PANEL*********************/
        /*========================END HANDLE CLICK BUTTON OF COST TYPE====================================*/

        labelIconRefreshCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoadDataTableCostType();
            }
        });

        labelIconSearchCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameCostType = txtSearchCostType.getText();
                nameCostType = encodeValue(nameCostType);
                String parameter = "&Filters[Name]=\""+nameCostType+"\"&FilterConditions[Name]=like";
                LoadDataTableCostTypeAfterSearch(parameter);
            }
        });

        buttonClearFieldCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldCostType();
            }
        });

        buttonAddCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameCostType = txtNameCostType.getText();
                if(!empty( nameCostType ) ) {

                    User_DTO user = new User_DTO();

                    String parameter = "{\"name\":\""+nameCostType+"\"}";
                    //APIRequester.sendPOST(parameter, "tourCategories", user.getToken());
                    String response =  Handle_API_Cost_Type.sendPost_Add_Cost_Type(parameter, "costTypes", user.getToken());
                    if (response.equals("success")==true){
                        LoadDataTableCostType();
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                        clearTextFieldCostType();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }

            }
        });
        buttonDeleteCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCostType.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại chi phí cần xoá");
                } else {
                    int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá loại chi phí này?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        User_DTO user = new User_DTO();
                        String idCostType = (tableCostType.getModel().getValueAt(row, 0).toString());
                        //APIRequester.sendDelete("","tourCategories/"+tourId, user.getToken());
                        String response = Handle_API_Cost_Type.sendDeleteCostType("","costTypes/"+idCostType, user.getToken());
                        if(response.equals("success") == true){
                            LoadDataTableCostType();
                            JOptionPane.showMessageDialog(null, "Xoá chi phí thành công");
                        }
                    }else if (result == JOptionPane.NO_OPTION){

                    }else {

                    }

                }

            }
        });

        buttonEditCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableCostType.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn loại chi phí cần sửa");
                }else {
                    String idCostType = (tableCostType.getModel().getValueAt(row, 0).toString());
                    String name = (tableCostType.getModel().getValueAt(row, 1).toString());
                    buttonAddCostType.setVisible(false);
                    buttonClearFieldCostType.setVisible(false);
                    buttonSaveCostType.setVisible(true);
                    buttonCancelCostType.setVisible(true);
                    txtNameCostType.setText(name);
//                    NameCostType = name;
//                    IdCostType = idCostType;
//                    category_dto = new Tour_Category_DTO(tourId, name);
                    tour_group_costType = new Tour_Group_CostType(idCostType, name);
                }
            }
        });
        buttonCancelCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldCostType();
                buttonSaveCostType.setVisible(false);
                buttonCancelCostType.setVisible(false);
                buttonAddCostType.setVisible(true);
                buttonClearFieldCostType.setVisible(true);
            }
        });

        buttonSaveCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = txtNameCostType.getText();
                if(checkDifferent(name, tour_group_costType)==false){
                    User_DTO user = new User_DTO();
                    String parameter = "{\"id\":"+tour_group_costType.getCostTypeId()+",\"name\":\""+name+"\"}";
                    System.out.println(parameter);
                    //APIRequester.sendPUT(parameter, "costTypes/"+IdCostType, user.getToken());
                    String response = Handle_API_Cost_Type.send_PUT_Edit_Cost_Type(parameter, "costTypes/"+tour_group_costType.getCostTypeId(), user.getToken());
                    if(response.equals("success")){
                        clearTextFieldCostType();
                        LoadDataTableCostType();
                        buttonSaveCostType.setVisible(false);
                        buttonCancelCostType.setVisible(false);
                        buttonAddCostType.setVisible(true);
                        buttonClearFieldCostType.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Loại chi phí không có thay đổi");
                }
            }
        });
        /*========================END HANDLE CLICK BUTTON OF COST TYPE====================================*/
    }
    public void LoadDataTableCostType(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Cost_Type.Fetch_API_All_Cost_Type("costTypes?Page=1&Limit=100", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();
        modeltableCostType.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("name").toString());

                modeltableCostType.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        tableCostType.setModel(modeltableCostType);


    }
    public void LoadDataTableCostTypeAfterSearch(String parameter){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Cost_Type.Fetch_API_All_Cost_Type("costTypes?Page=1&Limit=100"+parameter, user.getToken()));
        if(json.length() >= 1) {
            modeltableCostType.setRowCount(0);
            for (int i = 0; i < json.length(); i++) {

                JSONObject jsonObj;
                try {
                    jsonObj = json.getJSONObject(i);
                    Vector<String> data = new Vector<>();

                    data.add(jsonObj.get("id").toString());
                    data.add(jsonObj.get("name").toString());

                    modeltableCostType.addRow(data);
                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            tableCostType.setModel(modeltableCostType);
        }else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy chi phí cần tìm");
        }
    }
    public void clearTextFieldCostType(){
        txtNameCostType.setText("");
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferent(String name, Tour_Group_CostType costType){
        if(name.equals(costType.getCostTypeName())== true ){
            return true;
        }
        return false;
    }
}
