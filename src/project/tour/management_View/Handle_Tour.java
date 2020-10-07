/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.image.ImageObserver.ABORT;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Handle_Tour extends JPanel{
    /***************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JTabbedPane tabbedPaneContent;
    /***************END DECLARE JPANEL********************/
    
    /***************DECLARE COMPONENT FOR PANEL HEADER********************/
        private JLabel labelTourId;
        private JTextField txtTourId;
        private JSeparator sptTourId;
        private JLabel labelNameTour;
        private JTextField txtNameTour;
        private JSeparator sptNameTour;
        
        private JLabel labelTest1;
        private JTextField txtTest1;
        private JSeparator sptTest1;
        private JLabel labelTest2;
        private JTextField txtTest2;
        private JSeparator sptTest2;
        private JLabel labelTest3;
        private JTextField txtTest3;
        private JSeparator sptTest3;
        
        private JLabel labelCategoryTour;
        private JComboBox<String> comboBoxCategoryTour;
        
        private JButton btnSaveTour;
        private JButton btnBack;
    /***************END DECLARE COMPONENT FOR PANEL HEADER********************/
    
    /***************DECLARE COMPONENT FOR PANEL CONTENT********************/
        private JPanel panelPriceTour;
        private JPanel panelPlaceTour;
        private JPanel panelCategoryTour;
        
        /*---------DECLARE PANEL PLACE TOUR-----------*/
            private JLabel labelSearch;
            private JTextField txtSearch;
            private JLabel labelIconSearch;
            private JScrollPane scrollPaneAllPlace;
            private JList listPlaceTour;
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
            
        /*---------DECLARE PANEL CATEGORY TOUR-----------*/
            private JTable tableCategoryTour;
            private JLabel labelCategoryId;
            private JTextField txtCategoryId;
            private JSeparator sptCategoryId;
            private JLabel labelCategoryName;
            private JTextField txtCategoryName;
            private JSeparator sptCategoryName;
        /*---------END DECLARE PANEL CATEGORY TOUR-----------*/
    /***************END DECLARE COMPONENT FOR PANEL CONTENT********************/
    
    public Handle_Tour(){
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
                panelHeader.setBounds(0,0,990,110);
                
                  //**************TEXTFIELD TOUR ID*******************//
                    labelTourId = new JLabel("MÃ TOUR:",JLabel.CENTER);
                    labelTourId.setFont(new Font("Segoe",Font.BOLD,12));
                    labelTourId.setBounds(35,25,80,30);

                    txtTourId = new JTextField();
                    txtTourId.setBounds(115,23,120,30);
                    txtTourId.setBorder(null);
                    txtTourId.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                    sptTourId = new JSeparator();
                    sptTourId.setBounds(115,53,120,10);
                    sptTourId.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR ID*******************//
                   
                   //**************TEXTFIELD TOUR NAME*******************//
                    labelNameTour = new JLabel("TÊN TOUR:",JLabel.CENTER);
                    labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelNameTour.setBounds(35,73,80,30);

                    txtNameTour = new JTextField();
                    txtNameTour.setBounds(115,71,120,30);
                    txtNameTour.setBorder(null);
                    txtNameTour.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                    sptNameTour = new JSeparator();
                    sptNameTour.setBounds(115,101,120,10);
                    sptNameTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR NAME*******************//
                   
                   //**************TEXTFIELD TOUR TEST 1*******************//
                    labelTest1 = new JLabel("ABC DEFG:",JLabel.CENTER);
                    labelTest1.setFont(new Font("Segoe",Font.BOLD,12));
                    labelTest1.setBounds(320,25,80,30);

                    txtTest1 = new JTextField();
                    txtTest1.setBounds(400,23,120,30);
                    txtTest1.setBorder(null);
                    txtTest1.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                    sptTest1 = new JSeparator();
                    sptTest1.setBounds(400,53,120,10);
                    sptTest1.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR TEST 1*******************//
                   
                   //**************TEXTFIELD TOUR TEST 2*******************//
                    labelTest2 = new JLabel("NOW ABCD:",JLabel.CENTER);
                    labelTest2.setFont(new Font("Segoe",Font.BOLD,12));
                    labelTest2.setBounds(320,73,80,30);

                    txtTest2 = new JTextField();
                    txtTest2.setBounds(400,71,120,30);
                    txtTest2.setBorder(null);
                    txtTest2.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                    sptTest2 = new JSeparator();
                    sptTest2.setBounds(400,101,120,10);
                    sptTest2.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR TEST 2*******************//
                   
                   //**************TEXTFIELD TOUR TEST 3*******************//
                    labelTest3 = new JLabel("ABC DEFG:",JLabel.CENTER);
                    labelTest3.setFont(new Font("Segoe",Font.BOLD,12));
                    labelTest3.setBounds(600,25,80,30);

                    txtTest3 = new JTextField();
                    txtTest3.setBounds(680,23,120,30);
                    txtTest3.setBorder(null);
                    txtTest3.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                    sptTest3 = new JSeparator();
                    sptTest3.setBounds(680,53,120,10);
                    sptTest3.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR TEST 3*******************//
                   
                   //**************COMBOBOX CATEGORY TOUR*******************//
                    labelCategoryTour = new JLabel("THỂ LOẠI:",JLabel.CENTER);
                    labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelCategoryTour.setBounds(600,87,80,30);
                   
                    comboBoxCategoryTour = new JComboBox<>();
                    comboBoxCategoryTour.setModel(new DefaultComboBoxModel<>(new String [] {
                        "Tour trong nước","Tour nước ngoài"}));
                    comboBoxCategoryTour.setBounds(680,80,130,30);
                    comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));
                   //**************END COMBOBOX CATEGORY TOUR*******************//
                   
                    btnSaveTour = new JButton("Lưu");
                    btnSaveTour.setBackground(new Color(32, 171, 214));
                    btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
                    btnSaveTour.setForeground(Color.WHITE);
                    btnSaveTour.setBounds(850,30,115,30); 
                    btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                   
                    btnBack = new JButton("Trờ lại");
                    btnBack.setBackground(new Color(239, 198, 74));
                    btnBack.setFont(new Font("Segoe",Font.BOLD,13));
                    btnBack.setForeground(Color.WHITE);
                    btnBack.setBounds(850,80,115,30); 
                    btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                /************ADD COMPONENT FOR PANEL HEADER*****************/
                    panelHeader.add(labelTourId);
                    panelHeader.add(txtTourId);
                    panelHeader.add(sptTourId);
                    panelHeader.add(labelNameTour);
                    panelHeader.add(txtNameTour);
                    panelHeader.add(sptNameTour);
                    
                    panelHeader.add(labelTest1);
                    panelHeader.add(txtTest1);
                    panelHeader.add(sptTest1);
                    panelHeader.add(labelTest2);
                    panelHeader.add(txtTest2);
                    panelHeader.add(sptTest2);
                    panelHeader.add(labelTest3);
                    panelHeader.add(txtTest3);
                    panelHeader.add(sptTest3);
                    
                    panelHeader.add(comboBoxCategoryTour);
                    panelHeader.add(labelCategoryTour);
                    
                    panelHeader.add(btnSaveTour);
                    panelHeader.add(btnBack);
                /**********END ADD COMPONENT FOR PANEL HEADER*****************/
            /*------------------------END PANEL HEADER------------------------------*/
            
            /*------------------------PANEL CONTENT------------------------------*/
                tabbedPaneContent = new JTabbedPane();
                tabbedPaneContent.setBounds(0,110,990,480);
                tabbedPaneContent.setBackground(new Color(0,77,64));
                tabbedPaneContent.setForeground(Color.white);
                    
                    /*------------------------PANEL PRICE TOUR------------------------------*/
                        panelPriceTour = new JPanel();
                        panelPriceTour.setLayout(null);
                        panelPriceTour.setBackground(Color.white);
                        panelPriceTour.setBounds(5,5,980,470);
                            Vector header = new Vector();
                            header.add("Banana Team");
                            header.add("Team Banana");
                            header.add("Banana Team");
                            header.add("Team Banana");
                            header.add("Banana Team");
                            tableModelPriceTour = new DefaultTableModel(header, ABORT);

                            tablePriceTour = new JTable(tableModelPriceTour);
                            tablePriceTour.setRowHeight(25);
                            tablePriceTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                            tablePriceTour.getTableHeader().setReorderingAllowed(false);
                            tablePriceTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                            tablePriceTour.getTableHeader().setOpaque(false);
                            tablePriceTour.getTableHeader().setBackground(new Color(0,77,64));
                            tablePriceTour.getTableHeader().setForeground(new Color(255,255,255));

                            tablePriceTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

                            scrollPanePriceTour = new JScrollPane(tablePriceTour);
                            scrollPanePriceTour.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            scrollPanePriceTour.setBounds(45,10,900,420);
                        
                        /**********ADD COMPONENT FOR PANEL PRICE TOUR*****************/
                        panelPriceTour.add(scrollPanePriceTour);
                        /**********END ADD COMPONENT FOR PANEL PRICE TOUR***************/
                    /*------------------------END PANEL PRICE TOUR------------------------------*/
                    
                    
                    /*------------------------PANEL PLACE TOUR------------------------------*/
                        panelPlaceTour = new JPanel();
                        panelPlaceTour.setLayout(null);
                        panelPlaceTour.setBounds(5,5,980,470);
                        panelPlaceTour.setBackground(Color.white);
                            
                        /**********COMPONENT ALL PLACE TOUR*****************/
                            labelSearch = new JLabel("Tìm kiếm:");
                            labelSearch.setBounds(30,24,80,25);

                            txtSearch = new JTextField();
                            txtSearch.setBounds(95,24,250,25);

                            labelIconSearch = new JLabel();
                            labelIconSearch.setBounds(360,23,25,25);
                            labelIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));
                        
                            labelAllPlaceTour = new JLabel("Tất Cả Địa Điểm Tour");
                            labelAllPlaceTour.setBounds(110,65,250,25);
                            labelAllPlaceTour.setForeground(new Color(0,0,0));
                            labelAllPlaceTour.setFont(new Font("Times New Roman",1,18));
                            
                            scrollPaneAllPlace = new JScrollPane();
                            listPlaceTour = new JList<>();
                            scrollPaneAllPlace.setBounds(39, 110, 343, 320);
                            scrollPaneAllPlace.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            
                            listPlaceTour.setModel(new javax.swing.AbstractListModel<String>() {
                            String[] strings = {
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            "Biệt thự Hằng Nga “Crazy House”","Nông trại Sunny Farm","Hoa Sơn Điền Trang",
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            "Biệt thự Hằng Nga “Crazy House”","Nông trại Sunny Farm","Hoa Sơn Điền Trang",
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            "Biệt thự Hằng Nga “Crazy House”","Nông trại Sunny Farm","Hoa Sơn Điền Trang",
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            
                            };
                            @Override
                            public int getSize() { return strings.length; }
                            @Override
                            public String getElementAt(int i) { return strings[i]; }
                            });
                            
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
                            labelPlaceSeleted.setBounds(660,65,250,25);
                            labelPlaceSeleted.setForeground(new Color(0,0,0));
                            labelPlaceSeleted.setFont(new Font("Times New Roman",1,18));
                            
                            scrollPanePlaceSeleted = new JScrollPane();
                            listPlaceSeleted = new JList<>();
                            scrollPanePlaceSeleted.setBounds(600, 110, 343, 320);
                            scrollPanePlaceSeleted.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            
                            listPlaceSeleted.setModel(new javax.swing.AbstractListModel<String>() {
                            String[] strings = { 
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            "Biệt thự Hằng Nga “Crazy House”","Nông trại Sunny Farm","Hoa Sơn Điền Trang",
                            "Hoa Sơn Điền Trang","Nông trại Sunny Farm","Biệt thự Hằng Nga “Crazy House”",
                            "Biệt thự Hằng Nga “Crazy House”","Hoa Sơn Điền Trang","Nông trại Sunny Farm",
                            
                            };
                            @Override
                            public int getSize() { return strings.length; }
                            @Override
                            public String getElementAt(int i) { return strings[i]; }
                            });
                            
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
                    
                    /*------------------------PANEL CATEGORY TOUR------------------------------*/
                        panelCategoryTour = new JPanel();
                        panelCategoryTour.setLayout(null);
                        panelCategoryTour.setBackground(Color.white);
                        panelCategoryTour.setBounds(5,5,980,470);
                            
                            //**************TEXTFIELD CATEGORY ID*******************//
                            labelCategoryId = new JLabel("MÃ THỂ LOẠI:",JLabel.CENTER);
                            labelCategoryId.setFont(new Font("Segoe",Font.BOLD,12));
                            labelCategoryId.setBounds(35,25,80,30);

                            txtCategoryId = new JTextField();
                            txtCategoryId.setBounds(115,23,120,30);
                            txtCategoryId.setBorder(null);
                            txtCategoryId.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                            sptCategoryId = new JSeparator();
                            sptCategoryId.setBounds(115,53,120,10);
                            sptCategoryId.setBackground(new Color(0,0,0));
                           //**************END TEXTFIELD CATEGORY ID*******************//

                           //**************TEXTFIELD CATEGORY NAME*******************//
                            labelCategoryName = new JLabel("TÊN THỂ LOẠI:",JLabel.CENTER);
                            labelCategoryName.setFont(new Font("Segoe",Font.BOLD,12));
                            labelCategoryName.setBounds(400,25,80,30);

                            txtCategoryName = new JTextField();
                            txtCategoryName.setBounds(480,23,120,30);
                            txtCategoryName.setBorder(null);
                            txtCategoryName.setFont(new Font(Font.SERIF, Font.BOLD, 14));

                            sptCategoryName = new JSeparator();
                            sptCategoryName.setBounds(480,53,120,10);
                            sptCategoryName.setBackground(new Color(0,0,0));
                           //**************END TEXTFIELD CATEGORY NAME*******************//

                        /**********ADD COMPONENT FOR PANEL CATEGORY TOUR***************/
                            panelCategoryTour.add(labelCategoryId);
                            panelCategoryTour.add(txtCategoryId);
                            panelCategoryTour.add(sptCategoryId);
                            panelCategoryTour.add(labelCategoryName);
                            panelCategoryTour.add(txtCategoryName);
                            panelCategoryTour.add(sptCategoryName);
                        /**********END ADD COMPONENT FOR PANEL CATEGORY TOUR***************/
                    /*------------------------PANEL CATEGORY TOUR------------------------------*/
                    
                /**********ADD COMPONENT FOR PANEL CONTENT*****************/
                    tabbedPaneContent.addTab("--Địa Điểm Tour--", panelPlaceTour);
                    tabbedPaneContent.addTab("--Giá Tour--", panelPriceTour);
                    tabbedPaneContent.addTab("--Thể Loại Tour--", panelCategoryTour);
                /**********END ADD COMPONENT FOR PANEL CONTENT*****************/
            /*------------------------END PANEL CONTENT------------------------------*/
        
        /***************ADD COMPONENT FOR PANEL MAIN********************/
            add(panelHeader);
            add(tabbedPaneContent);
        /***************END ADD COMPONENT FOR PANEL MAIN********************/
    }
}
