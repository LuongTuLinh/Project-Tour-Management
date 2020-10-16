/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_Attraction_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour;
import project.tour.management_Handle_API.Handle_API_Tour_Attractions;

/**
 *
 * @author DELL
 */
public class Handle_Add_Attraction_and_Category_Tour extends JPanel{
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
                
                private JButton buttonAddAttraction;
                private JButton buttonClear;
                
                private JButton buttonSaveAttraction;
                private JButton buttonCancel;
                
                private JTable tableAttractionTour;
                private JScrollPane scrollPane;
                
                private JLabel labelSearch;
                private JTextField txtSearch;
                private JLabel labelIconSearch;
                
                private JButton buttonEditAttraction;
                private JButton buttonDeleteAttraction;
        /*---------------END DECLARE PANEL ATTRACTION TOUR----------------------*/
  
        /*---------------DECLARE PANEL CATEGORY TOUR--------------------*/
            private JPanel panelCategoryTour;
            private JPanel panelFieldCategory;
            private JPanel panelTableCategory;
            
                private JLabel labelNameCategory;
                private JTextField txtNameCategory;
                private JSeparator sptNameCategory;
                
                private JButton buttonAddCategory;
                private JButton buttonClearFieldCategory;
                
                private JButton buttonSaveCategory;
                private JButton buttonCancelCategory;
                
                private JTable tableCategoryTour;
                private JScrollPane scrollPaneCategory;
                
                private JLabel labelSearchCategory;
                private JTextField txtSearchCategory;
                private JLabel labelIconSearchCategory;
                
                private JButton buttonEditCategory;
                private JButton buttonDeleteCategory;
        /*--------------END DECLARE PANEL CATEGORY TOUR-----------------------*/
    /************************END DECLARE OF TABBED PANEL******************************/
    
    public Handle_Add_Attraction_and_Category_Tour(){
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
                            textAreaDescription.setBounds(40,190,330,200);
                            textAreaDescription.setLineWrap(true);
                            textAreaDescription.setWrapStyleWord(true);
                            textAreaDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                            txtDescriptionAttraction = new JTextField();
//                            txtDescriptionAttraction.setBounds(105,178,290,30);
//                            txtDescriptionAttraction.setBorder(null);
//                            txtDescriptionAttraction.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
//
//                            sptDescriptionAttraction = new JSeparator();
//                            sptDescriptionAttraction.setBounds(105,208,290,10);
//                            sptDescriptionAttraction.setBackground(new Color(0,0,0));
                           //**************END TEXTFIELD TEXTFIELD DESCRIPTION ATTRACTION*******************//
                           
                            buttonAddAttraction = new JButton("Thêm Địa Điểm");
                            buttonAddAttraction.setBackground(new Color(41, 149, 85));
                            buttonAddAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonAddAttraction.setForeground(Color.WHITE);
                            buttonAddAttraction.setBounds(50,405,150,30); 
                            buttonAddAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonClear = new JButton("Xoá");
                            buttonClear.setBackground(new Color(239, 198, 74));
                            buttonClear.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonClear.setForeground(Color.WHITE);
                            buttonClear.setBounds(250,405,105,30); 
                            buttonClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                            buttonSaveAttraction = new JButton("Lưu");
                            buttonSaveAttraction.setBackground(new Color(41, 149, 85));
                            buttonSaveAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonSaveAttraction.setForeground(Color.WHITE);
                            buttonSaveAttraction.setBounds(50,405,105,30); 
                            buttonSaveAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonCancel = new JButton("Huỷ Bỏ");
                            buttonCancel.setBackground(new Color(239, 198, 74));
                            buttonCancel.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonCancel.setForeground(Color.WHITE);
                            buttonCancel.setBounds(250,405,105,30); 
                            buttonCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        /**************ADD ELEMENT FOR PANEL FIELD ATTRACTION TOUR*********************/
                        panelField.add(labelNameAttraction);
                        panelField.add(txtNameAttraction);
                        panelField.add(sptNameAttraction);
                        
                        panelField.add(labelDescriptionAttraction);
                        panelField.add(textAreaDescription);
//                        panelField.add(txtDescriptionAttraction);
//                        panelField.add(sptDescriptionAttraction);
                        
                        panelField.add(buttonAddAttraction);
                        panelField.add(buttonClear);
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
                            labelIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));
                        
                            LoadDataTableAttraction();
            
                            tableAttractionTour.setRowHeight(25);
                            tableAttractionTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                            tableAttractionTour.getTableHeader().setReorderingAllowed(false);
                            tableAttractionTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                            tableAttractionTour.getTableHeader().setOpaque(false);
                            tableAttractionTour.getTableHeader().setBackground(new Color(0,77,64));
                            tableAttractionTour.getTableHeader().setForeground(new Color(255,255,255));
                            tableAttractionTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
                            buttonEditAttraction.setBackground(new Color(255,165, 0));
                            buttonEditAttraction.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonEditAttraction.setForeground(Color.WHITE);
                            buttonEditAttraction.setBounds(100,485,150,30); 
                            buttonEditAttraction.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonDeleteAttraction = new JButton("Xoá Địa Điểm");
                            buttonDeleteAttraction.setBackground(new Color(214, 38, 53));
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
                        /**************END ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
                    /*===================END PANEL TABLE ATTRACTION TOUR========================*/
                    
                    /**************ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                    panelAttractionTour.add(panelField);
                    panelAttractionTour.add(panelTable);
                    /**************END ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                /*========================END PANEL ATTRACTION TOUR====================================*/
                
                
                /*========================PANEL CATEGORY TOUR====================================*/
                    panelCategoryTour = new JPanel();
                    panelCategoryTour.setLayout(null);
                    panelCategoryTour.setBounds(5,5,970,570);
                    panelCategoryTour.setBackground(Color.white);
                    /*===================PANEL FIELD CATEGORY TOUR========================*/
                        panelFieldCategory = new JPanel();
                        panelFieldCategory.setLayout(null);
                        panelFieldCategory.setBackground(Color.white);
                        panelFieldCategory.setBounds(0,0,400,580);
                            //**************TEXTFIELD NAME CATEGORY*******************//
                            labelNameCategory = new JLabel("TÊN THỂ LOẠI :",JLabel.CENTER);
                            labelNameCategory.setFont(new Font("Segoe",Font.BOLD,12));
                            labelNameCategory.setBounds(0,80,120,30);

                            txtNameCategory = new JTextField();
                            txtNameCategory.setBounds(105,78,200,30);
                            txtNameCategory.setBorder(null);
                            txtNameCategory.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                            sptNameCategory = new JSeparator();
                            sptNameCategory.setBounds(105,108,200,10);
                            sptNameCategory.setBackground(new Color(0,0,0));
                           //**************END TEXTFIELD NAME CATEGORY*******************//
                        

                            buttonAddCategory = new JButton("Thêm Thể Loại");
                            buttonAddCategory.setBackground(new Color(41, 149, 85));
                            buttonAddCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonAddCategory.setForeground(Color.WHITE);
                            buttonAddCategory.setBounds(50,405,150,30); 
                            buttonAddCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonClearFieldCategory = new JButton("Xoá");
                            buttonClearFieldCategory.setBackground(new Color(239, 198, 74));
                            buttonClearFieldCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonClearFieldCategory.setForeground(Color.WHITE);
                            buttonClearFieldCategory.setBounds(250,405,105,30); 
                            buttonClearFieldCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                            buttonSaveCategory = new JButton("Lưu");
                            buttonSaveCategory.setBackground(new Color(41, 149, 85));
                            buttonSaveCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonSaveCategory.setForeground(Color.WHITE);
                            buttonSaveCategory.setBounds(50,405,105,30); 
                            buttonSaveCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonCancelCategory = new JButton("Huỷ Bỏ");
                            buttonCancelCategory.setBackground(new Color(239, 198, 74));
                            buttonCancelCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonCancelCategory.setForeground(Color.WHITE);
                            buttonCancelCategory.setBounds(250,405,105,30); 
                            buttonCancelCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        /**************ADD ELEMENT FOR PANEL FIELD CATEGORY TOUR*********************/
                        panelFieldCategory.add(labelNameCategory);
                        panelFieldCategory.add(txtNameCategory);
                        panelFieldCategory.add(sptNameCategory);
                        
                        panelFieldCategory.add(buttonAddCategory);
                        panelFieldCategory.add(buttonClearFieldCategory);
                        /**************END ADD ELEMENT FOR PANEL FIELD CATEGORY TOUR*******************/
                    /*===================END PANEL FIELD CATEGORY TOUR========================*/
                    
                    /*===================PANEL TABLE CATEGORY TOUR========================*/
                        panelTableCategory = new JPanel();
                        panelTableCategory.setLayout(null);
                        panelTableCategory.setBounds(400,0,580,570);
                        panelTableCategory.setBackground(Color.white);
                        
                            labelSearchCategory = new JLabel("Tìm kiếm:");
                            labelSearchCategory.setBounds(80,21,80,25);

                            txtSearchCategory = new JTextField();
                            txtSearchCategory.setBounds(145,21,250,25);

                            labelIconSearchCategory = new JLabel();
                            labelIconSearchCategory.setBounds(410,20,25,25);
                            labelIconSearchCategory.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));
                        
                            LoadDataTableAttraction();
            
                            tableCategoryTour.setRowHeight(25);
                            tableCategoryTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                            tableCategoryTour.getTableHeader().setReorderingAllowed(false);
                            tableCategoryTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                            tableCategoryTour.getTableHeader().setOpaque(false);
                            tableCategoryTour.getTableHeader().setBackground(new Color(0,77,64));
                            tableCategoryTour.getTableHeader().setForeground(new Color(255,255,255));
                            tableCategoryTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//                            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//                            rightRenderer.setHorizontalAlignment(JLabel.CENTER);

                            /****************SET SIZE COLUMN OF TABLE***********************/
                            tableCategoryTour.getColumnModel().getColumn(0).setPreferredWidth(60);
                            tableCategoryTour.getColumnModel().getColumn(1).setPreferredWidth(120);
                            tableCategoryTour.getColumnModel().getColumn(2).setPreferredWidth(380);
                            /****************SET SIZE COLUMN OF TABLE***********************/
                            

                            tableCategoryTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

                            scrollPaneCategory = new JScrollPane(tableCategoryTour);
                            scrollPaneCategory.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            scrollPaneCategory.setBounds(10,60,560,400);
                            
                            
                            buttonEditCategory = new JButton("Sửa Thể Loại");
                            buttonEditCategory.setBackground(new Color(255,165, 0));
                            buttonEditCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonEditCategory.setForeground(Color.WHITE);
                            buttonEditCategory.setBounds(100,485,150,30); 
                            buttonEditCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            buttonDeleteCategory = new JButton("Xoá Địa Điểm");
                            buttonDeleteCategory.setBackground(new Color(214, 38, 53));
                            buttonDeleteCategory.setFont(new Font("Segoe",Font.BOLD,13));
                            buttonDeleteCategory.setForeground(Color.WHITE);
                            buttonDeleteCategory.setBounds(300,485,150,30); 
                            buttonDeleteCategory.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                        /**************ADD ELEMENT FOR PANEL TABLE CATEGORY TOUR*******************/
                        panelTableCategory.add(scrollPaneCategory);
                        panelTableCategory.add(buttonEditCategory);
                        panelTableCategory.add(buttonDeleteCategory);
                        panelTableCategory.add(labelSearchCategory);
                        panelTableCategory.add(txtSearchCategory);
                        panelTableCategory.add(labelIconSearchCategory);
                        /**************END ADD ELEMENT FOR PANEL TABLE ATTRACTION TOUR*******************/
                    /*===================END PANEL TABLE ATTRACTION TOUR========================*/
                    
                    /**************ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                    panelCategoryTour.add(panelFieldCategory);
                    panelCategoryTour.add(panelTableCategory);
                    /**************END ADD PANEL FOR PANEL ATTRACTION TOUR*********************/
                /*========================END PANEL CATEGORY TOUR====================================*/
                
            /**************ADD PANEL FOR TABBED PANEL*********************/
                tabbedPane.addTab("--Địa Điểm Tour--", panelAttractionTour);
                tabbedPane.addTab("--Thể Loại Tour--", panelCategoryTour);
            /**************END ADD PANEL FOR TABBED PANEL*********************/
        /*======================================== END TABBED PANEL =================================================*/
        add(tabbedPane);
        
        /*========================HANDLE CLICK BUTTON====================================*/
            buttonClear.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textAreaDescription.setText("");
                    txtNameAttraction.setText("");
                }
            });
            
            buttonAddAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String nameAttraction = txtNameAttraction.getText();
                    String description = textAreaDescription.getText();
                    if(!empty( nameAttraction ) && !empty( description )) {
                        try {
                            User_DTO user = new User_DTO();
                            String parameter = "{\"name\":\""+nameAttraction+"\",\"description\":\""+description+"\"}";
                            APIRequester.sendPOST(parameter, "touristAttractions", user.getToken());
                            LoadDataTableAttraction();
                            JOptionPane.showMessageDialog(null, "Thêm thành công");
                            textAreaDescription.setText("");
                            txtNameAttraction.setText("");
                        } catch (IOException | ParseException ex) {
                            Logger.getLogger(Handle_Add_Attraction_and_Category_Tour.class.getName()).log(Level.SEVERE, null, ex);
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
                        User_DTO user = new User_DTO();
                        String tourId = (tableAttractionTour.getModel().getValueAt(row, 0).toString());
                        APIRequester.sendDelete("touristAttractions/"+tourId, user.getToken());
                        LoadDataTableAttraction();
                        JOptionPane.showMessageDialog(null, "Xoá địa điểm thành công");
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
                        buttonClear.setVisible(false);
                        panelField.add(buttonSaveAttraction);
                        panelField.add(buttonCancel);
                        txtNameAttraction.setText(name);
                        textAreaDescription.setText(description);
                        Tour_Attraction_DTO attraction = new Tour_Attraction_DTO(tourId, name, description);
                    }
                }
            });
            buttonCancel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    textAreaDescription.setText("");
                    txtNameAttraction.setText("");
                    buttonSaveAttraction.setVisible(false);
                    buttonCancel.setVisible(false);
                    panelField.add(buttonAddAttraction);
                    panelField.add(buttonClear);
                }
            });
            buttonSaveAttraction.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String name = txtNameAttraction.getText();
                    String description = textAreaDescription.getText();
                    if(checkDifferent(name, description)==false){
                        User_DTO user = new User_DTO();
                        String parameter = "{\"id\":\""+Tour_Attraction_DTO.getAttractionsId()+"\",\"name\":\""+name+"\",\"description\":\""+description+"\"}";
                        APIRequester.sendPUT(parameter, "touristAttractions/"+Tour_Attraction_DTO.getAttractionsId(), user.getToken());
                        textAreaDescription.setText("");
                        txtNameAttraction.setText("");
                        buttonSaveAttraction.setVisible(false);
                        buttonCancel.setVisible(false);
                        panelField.add(buttonAddAttraction);
                        panelField.add(buttonClear);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }else {
                        JOptionPane.showMessageDialog(null, "Địa điểm không có thay đổi");
                    }
                }
            });
        /*========================END HANDLE CLICK BUTTON====================================*/
    }
    public void LoadDataTableAttraction(){
        Handle_API_Tour api_tour = new Handle_API_Tour();
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100", user.getToken()));
        Vector<Vector<String>> dataList = new Vector<>();
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.getString("id"));
                data.add(jsonObj.getString("name"));
                data.add(jsonObj.getString("description"));

                dataList.add(data);
            } catch (JSONException ex) {
                Logger.getLogger(Handle_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Mã ĐĐ");
        columnNames.add("Tên Địa Điểm");
        columnNames.add("Mô Tả");

         tableAttractionTour = new JTable(dataList, columnNames);
    }
    public void LoadDataTableCategory(){
        Handle_API_Tour api_tour = new Handle_API_Tour();
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("tourCategories?Page=1&Limit=100", user.getToken()));
        Vector<Vector<String>> dataList = new Vector<>();
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.getString("id"));
                data.add(jsonObj.getString("name"));

                dataList.add(data);
            } catch (JSONException ex) {
                Logger.getLogger(Handle_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Mã Thể Loại");
        columnNames.add("Tên Thể Loại");

         tableAttractionTour = new JTable(dataList, columnNames);
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferent(String name, String description){
        if(name.equals(Tour_Attraction_DTO.getAttractionsName())== true && description.equals(Tour_Attraction_DTO.getDescription())== true){
            return true;
        }
        return false;
    }
}
