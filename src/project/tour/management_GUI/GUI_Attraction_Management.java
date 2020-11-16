/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_Attraction_DTO;
import project.tour.management_DTO.Tour_Category_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Get_Tour;
import project.tour.management_Handle_API.Handle_API_Tour_Attractions;
import project.tour.management_Handle_API.Handle_API_Tour_Category;

/**
 *
 * @author DELL
 */
public class GUI_Attraction_Management extends JPanel{
    Tour_Category_DTO category_dto ;
    Tour_Attraction_DTO tour_attraction_dto;
    private JTabbedPane tabbedPane;
    /*************************DECLARE OF TABBED PANEL*********************************/
        /*-----------------DECLARE PANEL ATTRACTION TOUR-------------------------*/
            private JPanel panelAttractionTour;
            private JPanel panelField;
            private JPanel panelTable;
            
                private JLabel labelNameAttraction;
                private JTextField txtNameAttraction;
                private JSeparator sptNameAttraction;
                
                private JLabel labelDescriptionAttraction;
                private JTextArea textAreaDescription;
                private JScrollPane scrollPaneDescription;
                
                private JButton buttonAddAttraction;
                private JButton buttonClearFieldAttraction;
                
                private JButton buttonSaveAttraction;
                private JButton buttonCancelAttraction;
                
                public JTable tableAttractionTour;
                public DefaultTableModel modelTableAttractionTour;
                private JScrollPane scrollPane;
                
                private JLabel labelSearch;
                private JTextField txtSearch;
                private JLabel labelIconSearch;
                private JLabel labelIconRefreshAttraction;
                
                private JButton buttonEditAttraction;
                private JButton buttonDeleteAttraction;
        /*---------------END DECLARE PANEL ATTRACTION TOUR----------------------*/
    /************************END DECLARE OF TABBED PANEL******************************/
    
    public GUI_Attraction_Management(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
        /*========================================= TABBED PANL ====================================================*/
            tabbedPane = new JTabbedPane();
            tabbedPane.setBounds(5, 5, 980, 580);
            tabbedPane.setBackground(new Color(0,77,64));
            tabbedPane.setForeground(Color.white);
                /*===========================PANEL ATTRACTION TOUR====================================*/
                    panelAttractionTour = new JPanel();
                    panelAttractionTour.setLayout(null);
                    panelAttractionTour.setBounds(5,5,970,570);
                    panelAttractionTour.setBackground(Color.white);
                    /*===================PANEL FIELD ATTRACTION TOUR========================*/
                        panelField = new JPanel();
                        panelField.setLayout(null);
                        panelField.setBackground(Color.white);
                        panelField.setBounds(0,0,400,580);
                            //**************TEXTFIELD NAME ATTRACTION*******************//
                            labelNameAttraction = new JLabel("TÊN ĐỊA ĐIỂM :",JLabel.CENTER);
                            labelNameAttraction.setFont(new Font("Segoe",Font.BOLD,12));
                            labelNameAttraction.setBounds(0,80,120,30);

                            txtNameAttraction = new JTextField();
                            txtNameAttraction.setBounds(105,78,200,30);
                            txtNameAttraction.setBorder(null);
                            txtNameAttraction.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                            sptNameAttraction = new JSeparator();
                            sptNameAttraction.setBounds(105,108,200,10);
                            sptNameAttraction.setBackground(new Color(0,0,0));
                           //**************END TEXTFIELD NAME ATTRACTION*******************//
                        
                           //**************TEXTFIELD TEXTFIELD DESCRIPTION ATTRACTION*******************//
                            labelDescriptionAttraction = new JLabel("MÔ TẢ ĐỊA ĐIỂM :",JLabel.CENTER);
                            labelDescriptionAttraction.setFont(new Font("Segoe",Font.BOLD,12));
                            labelDescriptionAttraction.setBounds(5,160,120,30);

                            textAreaDescription = new JTextArea(10, 10);
                            textAreaDescription.setLineWrap(true);
                            textAreaDescription.setWrapStyleWord(true);
                            textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            textAreaDescription.setFont(new Font("Arial, Helvetica, sans-serif", Font.PLAIN, 14));

                            scrollPane = new JScrollPane(textAreaDescription);
                            scrollPane.setBounds(40,190,330,200);
                           //**************END TEXTFIELD TEXTFIELD DESCRIPTION ATTRACTION*******************//
                           
                            buttonAddAttraction = new JButton("Thêm Địa Điểm");
                            buttonAddAttraction.setBackground(new Color(41, 149, 85));
                            buttonAddAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonAddAttraction.setForeground(Color.WHITE);
                            buttonAddAttraction.setBounds(50,405,150,30); 
                            buttonAddAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonClearFieldAttraction = new JButton("Làm Mới");
                            buttonClearFieldAttraction.setBackground(new Color(255, 255, 255));
                            buttonClearFieldAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonClearFieldAttraction.setForeground(Color.BLACK);
                            buttonClearFieldAttraction.setBounds(250,405,105,30);
                            buttonClearFieldAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                            buttonSaveAttraction = new JButton("Lưu");
                            buttonSaveAttraction.setBackground(new Color(32, 171, 214));
                            buttonSaveAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonSaveAttraction.setForeground(Color.WHITE);
                            buttonSaveAttraction.setBounds(50,405,105,30); 
                            buttonSaveAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonCancelAttraction = new JButton("Huỷ Bỏ");
                            buttonCancelAttraction.setBackground(new Color(219, 50, 54));
                            buttonCancelAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonCancelAttraction.setForeground(Color.WHITE);
                            buttonCancelAttraction.setBounds(250,405,105,30);
                            buttonCancelAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        /**************ADD ELEMENT FOR PANEL FIELD ATTRACTION TOUR*********************/
                        panelField.add(labelNameAttraction);
                        panelField.add(txtNameAttraction);
                        panelField.add(sptNameAttraction);
                        
                        panelField.add(labelDescriptionAttraction);
                        panelField.add(scrollPane);

                        
                        panelField.add(buttonAddAttraction);
                        panelField.add(buttonClearFieldAttraction);

                        panelField.add(buttonSaveAttraction);
                        panelField.add(buttonCancelAttraction);
                        buttonSaveAttraction.setVisible(false);
                        buttonCancelAttraction.setVisible(false);
                        /**************END ADD ELEMENT FOR PANEL FIELD ATTRACTION TOUR*******************/
                    /*===================END PANEL FIELD ATTRACTION TOUR========================*/
                    
                    /*===================PANEL TABLE ATTRACTION TOUR========================*/
                        panelTable = new JPanel();
                        panelTable.setLayout(null);
                        panelTable.setBounds(400,0,580,570);
                        panelTable.setBackground(Color.white);
                        
                            labelSearch = new JLabel("Tìm kiếm:");
                            labelSearch.setBounds(80,21,80,25);

                            txtSearch = new JTextField();
                            txtSearch.setBounds(145,21,250,25);

                            labelIconSearch = new JLabel();
                            labelIconSearch.setBounds(410,20,25,25);
                            labelIconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            labelIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));

                            labelIconRefreshAttraction = new JLabel();
                            labelIconRefreshAttraction.setBounds(443,20,25,25);
                            labelIconRefreshAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            labelIconRefreshAttraction.setIcon(new ImageIcon(getClass().getResource("/image/icons8_repeat_25px_1.png")));

                            Vector<String> columnNames = new Vector<>();
                            columnNames.add("Mã ĐĐ");
                            columnNames.add("Tên Địa Điểm");
                            columnNames.add("Mô Tả");
                            modelTableAttractionTour = new DefaultTableModel(columnNames, 0);

                            tableAttractionTour = new JTable(modelTableAttractionTour);
                            LoadDataTableAttraction();
            
                            tableAttractionTour.setRowHeight(25);
                            tableAttractionTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                            tableAttractionTour.getTableHeader().setReorderingAllowed(false);
                            tableAttractionTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                            tableAttractionTour.getTableHeader().setOpaque(false);
                            tableAttractionTour.getTableHeader().setBackground(new Color(0,77,64));
                            tableAttractionTour.getTableHeader().setForeground(new Color(255,255,255));
                            tableAttractionTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            tableAttractionTour.setDefaultEditor(Object.class, null);

//                            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//                            rightRenderer.setHorizontalAlignment(JLabel.CENTER);

                            /****************SET SIZE COLUMN OF TABLE***********************/
                            tableAttractionTour.getColumnModel().getColumn(0).setPreferredWidth(60);
                            tableAttractionTour.getColumnModel().getColumn(1).setPreferredWidth(120);
                            tableAttractionTour.getColumnModel().getColumn(2).setPreferredWidth(380);
                            /****************SET SIZE COLUMN OF TABLE***********************/
                            

                            tableAttractionTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

                            scrollPane = new JScrollPane(tableAttractionTour);
                            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            scrollPane.setBounds(10,60,560,400);
                            
                            
                            buttonEditAttraction = new JButton("Sửa Địa Điểm");
                            buttonEditAttraction.setBackground(new Color(194, 98, 14));
                            buttonEditAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonEditAttraction.setForeground(Color.WHITE);
                            buttonEditAttraction.setBounds(100,485,150,30); 
                            buttonEditAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonDeleteAttraction = new JButton("Xoá Địa Điểm");
                            buttonDeleteAttraction.setBackground(new Color(219, 50, 54));
                            buttonDeleteAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonDeleteAttraction.setForeground(Color.WHITE);
                            buttonDeleteAttraction.setBounds(300,485,150,30); 
                            buttonDeleteAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                        /**************ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
                        panelTable.add(scrollPane);
                        panelTable.add(buttonEditAttraction);
                        panelTable.add(buttonDeleteAttraction);
                        panelTable.add(labelSearch);
                        panelTable.add(txtSearch);
                        panelTable.add(labelIconSearch);
                        panelTable.add(labelIconRefreshAttraction);
                        /**************END ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
                    /*===================END PANEL TABLE ATTRACTION TOUR========================*/
                    
                    /**************ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                    panelAttractionTour.add(panelField);
                    panelAttractionTour.add(panelTable);
                    /**************END ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                /*========================END PANEL ATTRACTION TOUR====================================*/

                
            /**************ADD PANEL FOR TABBED PANEL*********************/
                tabbedPane.addTab("Địa Điểm Tour", panelAttractionTour);
            /**************END ADD PANEL FOR TABBED PANEL*********************/
        /*======================================== END TABBED PANEL =================================================*/
        add(tabbedPane);
        
        /*========================HANDLE CLICK BUTTON OF ATTRACTION====================================*/
            labelIconSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String nameAttraction = txtSearch.getText();
                    if(!empty(nameAttraction)){
                        nameAttraction = encodeValue(nameAttraction);
                    }
                    String parameter = "&Filters[Name]=\""+nameAttraction+"\"&FilterConditions[Name]=like";
                    LoadDataTableAttractionAfterSearch(parameter);
                }
            });
            labelIconRefreshAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    LoadDataTableAttraction();
                }
            });

            buttonClearFieldAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clearTextFieldAttraction();
                }
            });
            
            buttonAddAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String nameAttraction = txtNameAttraction.getText();
                    String description = textAreaDescription.getText();
                    if(!empty( nameAttraction ) && !empty( description )) {

                            User_DTO user = new User_DTO();
                            String parameter = "{\"name\":\""+nameAttraction+"\",\"description\":\""+description+"\"}";
                            //APIRequester.sendPOST(parameter, "touristAttractions", user.getToken());
                            String response = Handle_API_Tour_Attractions.sendPost_Add_AttractionTour(parameter, "touristAttractions", user.getToken());
                            if(response.equals("success")==true){
                                LoadDataTableAttraction();
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                                clearTextFieldAttraction();
                            }

                    }else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                    }

                }
            });
            
            buttonDeleteAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tableAttractionTour.getSelectedRow();
                    if( row == -1 ){
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn địa điểm cần xoá");
                    } else {
                        int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá địa điểm này này?", "Thông báo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                            User_DTO user = new User_DTO();
                            String tourId = (tableAttractionTour.getModel().getValueAt(row, 0).toString());
                            //APIRequester.sendDelete("","touristAttractions/"+tourId, user.getToken());
                            String response = Handle_API_Tour_Attractions.sendDeleteAttractionTour("","touristAttractions/"+tourId, user.getToken());

                            if(response.equals("success")==true){
                                LoadDataTableAttraction();
                                JOptionPane.showMessageDialog(null, "Xoá địa điểm thành công");
                            }
                        }else if (result == JOptionPane.NO_OPTION){

                        }else {

                        }

                    }
                    
                }
            });
            
            buttonEditAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tableAttractionTour.getSelectedRow();
                    if( row == -1 ){
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn địa điểm cần sửa");
                    }else {
                        String tourId = (tableAttractionTour.getModel().getValueAt(row, 0).toString());
                        String name = (tableAttractionTour.getModel().getValueAt(row, 1).toString());
                        String description = (tableAttractionTour.getModel().getValueAt(row, 2).toString());
                        buttonAddAttraction.setVisible(false);
                        buttonClearFieldAttraction.setVisible(false);
                        buttonSaveAttraction.setVisible(true);
                        buttonCancelAttraction.setVisible(true);
                        txtNameAttraction.setText(name);
                        textAreaDescription.setText(description);
                        tour_attraction_dto = new Tour_Attraction_DTO(tourId, name, description);
                    }
                }
            });
            buttonCancelAttraction.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clearTextFieldAttraction();
                        buttonSaveAttraction.setVisible(false);
                        buttonCancelAttraction.setVisible(false);
                        buttonAddAttraction.setVisible(true);
                        buttonClearFieldAttraction.setVisible(true);
                    }
                });
            buttonSaveAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String name = txtNameAttraction.getText();
                    String description = textAreaDescription.getText();
                    if(checkDifferent(name, description, tour_attraction_dto)==false){
                        User_DTO user = new User_DTO();
                        String parameter = "{\"id\":"+tour_attraction_dto.getAttractionsId()+",\"name\":\""+name+"\",\"description\":\""+description+"\"}";
                        System.out.println(parameter);
                        APIRequester.sendPUT(parameter, "touristAttractions/"+tour_attraction_dto.getAttractionsId(), user.getToken());
                        clearTextFieldAttraction();
                        LoadDataTableAttraction();
                        buttonSaveAttraction.setVisible(false);
                        buttonCancelAttraction.setVisible(false);
                        buttonAddAttraction.setVisible(true);
                        buttonClearFieldAttraction.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }else {
                        JOptionPane.showMessageDialog(null, "Địa điểm không có thay đổi");
                    }
                }
            });
        /*========================END HANDLE CLICK BUTTON OF ATTRACTION====================================*/


    }
    public void LoadDataTableAttraction(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();
        modelTableAttractionTour.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("name").toString());
                data.add(jsonObj.get("description").toString());

                modelTableAttractionTour.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        tableAttractionTour.setModel(modelTableAttractionTour);
    }

    public void LoadDataTableAttractionAfterSearch(String parameter){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100"+parameter, user.getToken()));
        if(json.length()>=1){
            modelTableAttractionTour.setRowCount(0);
            for (int i = 0; i < json.length(); i++) {

                JSONObject jsonObj;
                try {
                    jsonObj = json.getJSONObject(i);
                    Vector<String> data = new Vector<>();

                    data.add(jsonObj.get("id").toString());
                    data.add(jsonObj.get("name").toString());
                    data.add(jsonObj.get("description").toString());

                    modelTableAttractionTour.addRow(data);
                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            tableAttractionTour.setModel(modelTableAttractionTour);
        }else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy địa điểm cần tìm");
        }
    }

    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferent(String name, String description, Tour_Attraction_DTO tour_attraction_dto){
        if(name.equals(tour_attraction_dto.getAttractionsName())== true && description.equals(tour_attraction_dto.getDescription())== true){
            return true;
        }
        return false;
    }


    public void clearTextFieldAttraction(){
        txtNameAttraction.setText("");
        textAreaDescription.setText("");
    }
    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
