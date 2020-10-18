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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour_Attractions;

/**
 *
 * @author DELL
 */
public class GUI_Add_Tour extends JPanel{
    private Tour_DTO tour = new Tour_DTO();
    /***************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JTabbedPane tabbedPaneContent;
    /***************END DECLARE JPANEL********************/
    
    /***************DECLARE COMPONENT FOR PANEL HEADER********************/
        private JLabel labelNameTour;
        private JTextField txtNameTour;
        private JSeparator sptNameTour;
        
        private JLabel labelPriceTour;
        private JTextField txtPriceTour;
        private JSeparator sptPriceTour;
        
        private JLabel labelSpecification;
        private JTextField txtSpecification;
        private JSeparator sptSpecification;
        
        private JLabel labelCategoryTour;
        private JComboBox<String> comboBoxCategoryTour;
        
        private JButton btnSaveTour;
        private JButton btnBack;
    /***************END DECLARE COMPONENT FOR PANEL HEADER********************/
    
    /***************DECLARE COMPONENT FOR PANEL CONTENT********************/
        private JPanel panelPriceTour;
        private JPanel panelPlaceTour;
        
        /*---------DECLARE PANEL PLACE TOUR-----------*/
            private JLabel labelSearch;
            private JTextField txtSearch;
            private JLabel labelIconSearch;
            private JScrollPane scrollPaneAllPlace;
            private JList<String> listPlaceTour;
            DefaultListModel<String> model;
            private JLabel labelAllPlaceTour;
            private JScrollPane scrollPanePlaceSeleted;
            private JList listPlaceSeleted;
            private JLabel labelPlaceSeleted;
            private JButton btnAddPlaceTour;
            private JButton btnRemovePlaceTour;
            
        /*---------END DECLARE PANEL PLACE TOUR-----------*/
            
        /*---------DECLARE PANEL PRICE TOUR-----------*/
            private JTable tablePriceTour;
            private DefaultTableModel tableModelPriceTour;
            private JScrollPane scrollPanePriceTour;
        /*---------END DECLARE PANEL PRICE TOUR-----------*/
            
    /***************END DECLARE COMPONENT FOR PANEL CONTENT********************/
    
    public GUI_Add_Tour(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
            /*---------------------PANEL HEADER------------------------*/
                panelHeader = new JPanel();
                panelHeader.setLayout(null);
                panelHeader.setBackground(Color.white);
                panelHeader.setBounds(0,0,990,150);
                   
                   //**************TEXTFIELD TOUR NAME*******************//
                    labelNameTour = new JLabel("TÊN TOUR:",JLabel.CENTER);
                    labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelNameTour.setBounds(35,10,80,30);

                    txtNameTour = new JTextField();
                    txtNameTour.setBounds(115,8,500,30);
                    txtNameTour.setBorder(null);
                    txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    sptNameTour = new JSeparator();
                    sptNameTour.setBounds(115,38,500,10);
                    sptNameTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR NAME*******************//
                   
                   //**************TEXTFIELD TOUR PRICE*******************//
                    labelPriceTour = new JLabel("GIÁ TOUR:",JLabel.CENTER);
                    labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelPriceTour.setBounds(35,56,80,30);

                    txtPriceTour = new JTextField();
                    txtPriceTour.setBounds(115,54,125,30);
                    txtPriceTour.setBorder(null);
                    txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    sptPriceTour = new JSeparator();
                    sptPriceTour.setBounds(115,84,125,10);
                    sptPriceTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR PRICE*******************//
                   
                   //**************TEXTFIELD TOUR Specification*******************//
                    labelSpecification = new JLabel("ĐẶC ĐIỂM:",JLabel.CENTER);
                    labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
                    labelSpecification.setBounds(35,100,80,30);

                    txtSpecification = new JTextField();
                    txtSpecification.setBounds(115,98,690,30);
                    txtSpecification.setBorder(null);
                    txtSpecification.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    sptSpecification = new JSeparator();
                    sptSpecification.setBounds(115,128,690,10);
                    sptSpecification.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR Specification*******************//
                   
                   //**************COMBOBOX CATEGORY TOUR*******************//
                    labelCategoryTour = new JLabel("THỂ LOẠI:",JLabel.CENTER);
                    labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelCategoryTour.setBounds(595,60,80,30);
                   
                    comboBoxCategoryTour = new JComboBox<>();
                    comboBoxCategoryTour.setModel(new DefaultComboBoxModel<>(new String [] {
                        "Du lịch văn hóa", "Du lịch MICE", "Teambuilding", "Du lịch xanh", "Du lịch ẩm thực", "Du lịch tham quan"}));
                    comboBoxCategoryTour.setBounds(675,53,130,30);
                    comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));
                   //**************END COMBOBOX CATEGORY TOUR*******************//
                   
                    btnSaveTour = new JButton("Thêm Tour");
                    btnSaveTour.setBackground(new Color(32, 171, 214));
                    btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
                    btnSaveTour.setForeground(Color.WHITE);
                    btnSaveTour.setBounds(850,30,115,30); 
                    btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                   
                    btnBack = new JButton("Trờ lại");
                    btnBack.setBackground(new Color(239, 198, 74));
                    btnBack.setFont(new Font("Segoe",Font.BOLD,13));
                    btnBack.setForeground(Color.WHITE);
                    btnBack.setBounds(850,100,115,30); 
                    btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                /************ADD COMPONENT FOR PANEL HEADER*****************/
                    panelHeader.add(labelNameTour);
                    panelHeader.add(txtNameTour);
                    panelHeader.add(sptNameTour);
                    
                    panelHeader.add(labelPriceTour);
                    panelHeader.add(txtPriceTour);
                    panelHeader.add(sptPriceTour);

                    panelHeader.add(labelSpecification);
                    panelHeader.add(txtSpecification);
                    panelHeader.add(sptSpecification);
                    
                    panelHeader.add(comboBoxCategoryTour);
                    panelHeader.add(labelCategoryTour);
                    
                    panelHeader.add(btnSaveTour);
                    panelHeader.add(btnBack);
                /**********END ADD COMPONENT FOR PANEL HEADER*****************/
            /*------------------------END PANEL HEADER------------------------------*/
            
            /*------------------------PANEL CONTENT------------------------------*/
                tabbedPaneContent = new JTabbedPane();
                tabbedPaneContent.setBounds(0,150,990,440);
                tabbedPaneContent.setBackground(new Color(0,77,64));
                tabbedPaneContent.setForeground(Color.white);
                    
                    /*------------------------PANEL PRICE TOUR------------------------------*/
                        panelPriceTour = new JPanel();
                        panelPriceTour.setLayout(null);
                        panelPriceTour.setBackground(Color.white);
                        panelPriceTour.setBounds(5,5,980,470);
                        
                        /**********ADD COMPONENT FOR PANEL PRICE TOUR*****************/

                        /**********END ADD COMPONENT FOR PANEL PRICE TOUR***************/
                    /*------------------------END PANEL PRICE TOUR------------------------------*/
                    
                    
                    /*------------------------PANEL PLACE TOUR------------------------------*/
                        panelPlaceTour = new JPanel();
                        panelPlaceTour.setLayout(null);
                        panelPlaceTour.setBounds(5,5,980,430);
                        panelPlaceTour.setBackground(Color.white);
                            
                        /**********COMPONENT ALL PLACE TOUR*****************/
                            labelSearch = new JLabel("Tìm kiếm:");
                            labelSearch.setBounds(30,21,80,25);

                            txtSearch = new JTextField();
                            txtSearch.setBounds(95,21,250,25);

                            labelIconSearch = new JLabel();
                            labelIconSearch.setBounds(360,20,25,25);
                            labelIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));
                        
                            labelAllPlaceTour = new JLabel("Tất Cả Địa Điểm Tour");
                            labelAllPlaceTour.setBounds(110,60,250,25);
                            labelAllPlaceTour.setForeground(new Color(0,0,0));
                            labelAllPlaceTour.setFont(new Font("Times New Roman",1,18));
                            
                            scrollPaneAllPlace = new JScrollPane();
                            
                            scrollPaneAllPlace.setBounds(39, 100, 343, 310);
                            scrollPaneAllPlace.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            
                            listPlaceTour = new JList<>();
                            UpdateJList();
//                            DefaultListCellRenderer renderer = (DefaultListCellRenderer) listPlaceTour.getCellRenderer();
//                            renderer.setHorizontalAlignment(SwingConstants.CENTER);
                            listPlaceTour.setFixedCellHeight(27);
                            listPlaceTour.setFixedCellWidth(100);
                            listPlaceTour.setBorder(new EmptyBorder(10,10, 10, 10));
                            
                            
                            listPlaceTour.setSelectedIndex(0);
                            listPlaceTour.setVisibleRowCount(10);
                            listPlaceTour.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            scrollPaneAllPlace.setViewportView(listPlaceTour);
                            /*********************END COMPONENT ALL PLACE TOUR*****************/
                            
                            btnAddPlaceTour = new JButton("Thêm >>>");
                            btnAddPlaceTour.setBackground(new Color(41, 149, 85));
                            btnAddPlaceTour.setFont(new Font("Segoe",Font.BOLD,13));
                            btnAddPlaceTour.setForeground(Color.WHITE);
                            btnAddPlaceTour.setBounds(435,200,115,30); 
                            btnAddPlaceTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                            btnRemovePlaceTour = new JButton("<<< Loại Bỏ");
                            btnRemovePlaceTour.setBackground(new Color(239, 198, 74));
                            btnRemovePlaceTour.setFont(new Font("Segoe",Font.BOLD,13));
                            btnRemovePlaceTour.setForeground(Color.WHITE);
                            btnRemovePlaceTour.setBounds(435,300,115,30); 
                            btnRemovePlaceTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            
                            /******************COMPONENT PLACE TOUR IS SELECTED*****************/
                            labelPlaceSeleted = new JLabel("Địa Điểm Đã Được Chọn");
                            labelPlaceSeleted.setBounds(660,60,250,25);
                            labelPlaceSeleted.setForeground(new Color(0,0,0));
                            labelPlaceSeleted.setFont(new Font("Times New Roman",1,18));
                            
                            scrollPanePlaceSeleted = new JScrollPane();
                            
                            scrollPanePlaceSeleted.setBounds(600, 100, 343, 310);
                            scrollPanePlaceSeleted.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            
                            listPlaceSeleted = new JList<>();
                            
                            listPlaceSeleted.setFixedCellHeight(27);
                            listPlaceSeleted.setFixedCellWidth(100);
                            listPlaceSeleted.setBorder(new EmptyBorder(10,10, 10, 10));
                            
                            listPlaceSeleted.setSelectedIndex(0);
                            listPlaceSeleted.setVisibleRowCount(10);
                            listPlaceSeleted.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            scrollPanePlaceSeleted.setViewportView(listPlaceSeleted);
                            /******************END COMPONENT PLACE TOUR IS SELECTED*****************/
                            
                        /**********ADD COMPONENT FOR PANEL PLACE TOUR*****************/
                        panelPlaceTour.add(labelSearch);
                        panelPlaceTour.add(txtSearch);
                        panelPlaceTour.add(labelIconSearch);
                        panelPlaceTour.add(scrollPaneAllPlace);
                        panelPlaceTour.add(labelAllPlaceTour);
                        panelPlaceTour.add(scrollPanePlaceSeleted);
                        panelPlaceTour.add(labelPlaceSeleted);
                        panelPlaceTour.add(btnAddPlaceTour);
                        panelPlaceTour.add(btnRemovePlaceTour);
                        /**********END ADD COMPONENT FOR PANEL PLACE TOUR***************/
                    /*------------------------END PANEL PLACE TOUR------------------------------*/
                    
                /**********ADD COMPONENT FOR PANEL CONTENT*****************/
                    tabbedPaneContent.addTab("--Địa Điểm Tour--", panelPlaceTour);
                    tabbedPaneContent.addTab("--Giá Tour--", panelPriceTour);
                /**********END ADD COMPONENT FOR PANEL CONTENT*****************/
            /*------------------------END PANEL CONTENT------------------------------*/
        
        /***************ADD COMPONENT FOR PANEL MAIN********************/
            add(panelHeader);
            add(tabbedPaneContent);
        /***************END ADD COMPONENT FOR PANEL MAIN********************/
        
        
        /*------------------------HANDLE CLICK BUTTON------------------------------*/
            btnSaveTour.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    User_DTO user = new User_DTO();
                     String tourName = txtNameTour.getText();
                     String tourPrice = txtPriceTour.getText();
                     String specification = txtSpecification.getText();
                     String tourCategoryId = String.valueOf(comboBoxCategoryTour.getSelectedItem());
                     String price_PATTERN = "^[0-9]+$";
                     if(tourCategoryId.equals("Du lịch văn hóa")){
                         tourCategoryId = "b079a901-ee32-4fce-8777-72cd55317931";
                         System.out.println(tourCategoryId);
                     }
                     
                     if( !empty( tourName ) && !empty( tourPrice ) && !empty( specification ) ) {
                        if(Pattern.matches(price_PATTERN, tourPrice)==false){
                            JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm giá tour");
                        } else {
                            String input = "{\"name\":\"" + tourName + "\",\"specification\":\""+specification+"\",\"tourCategoryId\":\""+tourCategoryId+"\",\"price\":"+tourPrice+"}";
                            try {
                                APIRequester.sendPOST(input, "tours", user.getToken());
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                            } catch (IOException | ParseException ex) {
                                Logger.getLogger(GUI_Add_Tour.class.getName()).log(Level.SEVERE, null, ex);
                            }
                         }
                     } else {
                         JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                     }
                }
            });
        /*------------------------END HANDLE CLICK BUTTON------------------------------*/
        
    }
    
    public static ArrayList<String> TourAttractionsList() {
        ArrayList<String> arrayTourAttractions = new ArrayList<>();
        User_DTO user = new User_DTO();
        Handle_API_Tour_Attractions tourAttractions = new Handle_API_Tour_Attractions();
        JSONArray result = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=30", user.getToken()));
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("name").toString();

                    arrayTourAttractions.add(name);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }

        return arrayTourAttractions;
    }
    private void UpdateJList(){
        model = new DefaultListModel<String>();
        for(String p : TourAttractionsList()){
             model.addElement(p);
        }
        listPlaceTour.setModel(model);     
        listPlaceTour.setSelectedIndex(0);
        listPlaceTour.setFont(new Font("Arial",Font.ITALIC,14));
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
      }
}
