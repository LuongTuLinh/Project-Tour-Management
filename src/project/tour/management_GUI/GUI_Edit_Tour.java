/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import com.toedter.calendar.JDateChooser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.*;
import project.tour.management_Handle_API.*;

import static project.tour.management_GUI.GUI_Tour_Management.removeAllAndAddNewPanel;

/**
 *
 * @author DELL
 */
public class GUI_Edit_Tour extends JPanel{
    Tour_DTO tour_dto;
    Tour_Price_DTO tour_price_dto;
    Tour_Attraction_DTO tour_attraction_dto;
    Tour_Category_DTO category_dto;
    public static String statusTour="";

    public static HashMap<String, String> dataAttraction ;
    public static DefaultListModel<String> modelAttractionTour;
    public JList<String> listPlaceTour;

    public static HashMap<String, String> dataAttractionSearch ;

    //public static HashMap<String, String> dataAttractionisSelected ;
    public static ArrayList<Tour_Attraction_DTO> dataAttractionisSelected;
    public static DefaultListModel<Tour_Attraction_DTO> modelAttractionTourisSelected;
    public JList<Tour_Attraction_DTO> listPlaceTourisSelected  ;

    private Tour_DTO tour = new Tour_DTO();
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

        private JLabel labelPriceTour;
        private JTextField txtPriceTour;
        private JSeparator sptPriceTour;
        private JLabel labelVND;

        private JLabel labelStatusTour;
        private JComboBox<String> comboBoxStatusTour;

        private JLabel labelSpecification;
        private JTextField txtSpecification;
        private JSeparator sptSpecification;

        private JLabel labelCategoryTour;
        private static JComboBox<Tour_Category_DTO> comboBoxCategoryTour;

        private JButton btnSaveTour;
        private JButton btnBack;
    /***************END DECLARE COMPONENT FOR PANEL HEADER********************/

    /***************DECLARE COMPONENT FOR PANEL CONTENT********************/
        private JPanel panelPriceTour;
        private JPanel panelPlaceTour;
        private JPanel panelGroupTour;

        /*---------DECLARE PANEL PLACE TOUR-----------*/
            private JLabel labelSearch;
            private JTextField txtSearch;
            private JLabel labelIconSearch;
            private JScrollPane scrollPaneAllPlace;
            private JLabel labelAllPlaceTour;
            private JScrollPane scrollPanePlaceSeleted;
            private JLabel labelPlaceSeleted;
            private JButton btnAddPlaceTour;
            private JButton btnRemovePlaceTour;
            private JButton btnSavePlaceTour;

        /*---------END DECLARE PANEL PLACE TOUR-----------*/

        /*---------DECLARE PANEL PRICE TOUR-----------*/

            private JLabel labelTourID;
            private JTextField txtTourID;
            private JSeparator sptTourID;

            private JLabel labelPrice;
            private JTextField txtPrice;
            private JSeparator sptPrice;

            private JLabel labelStartDate;
            private JDateChooser dateChooserStartDate;
            private JSeparator sptStartDate;

            private JLabel labelEndDate;
            private JDateChooser dateChooserEndDate;
            private JSeparator sptEndDate;

            private JButton buttonAddPrice;
            private JButton buttonClearFieldPrice;
            private JButton buttonEditPrice;
            private JButton buttonDeletePrice;
            private JButton buttonSavePrice;
            private JButton buttonCancelPrice;

            private JScrollPane scrollPaneTablePrice;
            public JTable tableTourPrice;
            public DefaultTableModel modelTablePriceTour;

        /*---------END DECLARE PANEL PRICE TOUR-----------*/

    /***************END DECLARE COMPONENT FOR PANEL CONTENT********************/

    public GUI_Edit_Tour(){
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

                  //**************TEXTFIELD TOUR ID*******************//
                    labelTourId = new JLabel("MÃ TOUR:",JLabel.CENTER);
                    labelTourId.setFont(new Font("Segoe",Font.BOLD,12));
                    labelTourId.setBounds(35,10,80,30);

                    txtTourId = new JTextField();
                    txtTourId.setBounds(115,8,200,30);
                    txtTourId.setBorder(null);
                    txtTourId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    txtTourId.setText(tour_dto.getTourId());
                    txtTourId.setEditable(false);

                    sptTourId = new JSeparator();
                    sptTourId.setBounds(115,38,200,10);
                    sptTourId.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR ID*******************//

                   //**************TEXTFIELD TOUR NAME*******************//
                    labelNameTour = new JLabel("TÊN TOUR:",JLabel.CENTER);
                    labelNameTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelNameTour.setBounds(35,56,80,30);

                    txtNameTour = new JTextField();
                    txtNameTour.setBounds(115,54,408,30);
                    txtNameTour.setBorder(null);
                    txtNameTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    txtNameTour.setText(tour_dto.getTourName());

                    sptNameTour = new JSeparator();
                    sptNameTour.setBounds(115,84,408,10);
                    sptNameTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR NAME*******************//

                   //**************TEXTFIELD TOUR STATUS*******************//
                    labelStatusTour = new JLabel("TRẠNG THÁI:",JLabel.CENTER);
                    labelStatusTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelStatusTour.setBounds(365,10,80,30);

                    comboBoxStatusTour = new JComboBox<>();

                    comboBoxStatusTour.setBounds(445,9,110,30);
                    comboBoxStatusTour.setFont(new Font("Segoe",Font.BOLD,13));
                    selectedComboBoxStatusTour();
                   //**************END TEXTFIELD TOUR STATUS*******************//

                   //**************TEXTFIELD TOUR PRICE*******************//
                    labelPriceTour = new JLabel("GIÁ TOUR:",JLabel.CENTER);
                    labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelPriceTour.setBounds(600,56,80,30);

                    txtPriceTour = new JTextField();
                    txtPriceTour.setBounds(680,54,90,30);
                    txtPriceTour.setBorder(null);
                    txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                    long price = Long.parseLong(tour_dto.getPrice());
                    String priceTour = java.text.NumberFormat.getIntegerInstance().format(price);
                    txtPriceTour.setText(priceTour);

                    labelVND = new JLabel("VND",JLabel.CENTER);
                    labelVND.setFont(new Font("Segoe",Font.BOLD,12));
                    labelVND.setBounds(770,54,30,30);

                    sptPriceTour = new JSeparator();
                    sptPriceTour.setBounds(680,84,125,10);
                    sptPriceTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR PRICE*******************//

                   //**************TEXTFIELD TOUR Specification*******************//
                    labelSpecification = new JLabel("ĐẶC ĐIỂM:",JLabel.CENTER);
                    labelSpecification.setFont(new Font("Segoe",Font.BOLD,12));
                    labelSpecification.setBounds(35,100,80,30);

                    txtSpecification = new JTextField();
                    txtSpecification.setBounds(115,98,700,30);
                    txtSpecification.setBorder(null);
                    txtSpecification.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    txtSpecification.setText(tour_dto.getSpecification());

                    sptSpecification = new JSeparator();
                    sptSpecification.setBounds(115,128,700,10);
                    sptSpecification.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR Specification*******************//

                   //**************COMBOBOX CATEGORY TOUR*******************//
                    labelCategoryTour = new JLabel("THỂ LOẠI:",JLabel.CENTER);
                    labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelCategoryTour.setBounds(600,20,80,30);

                    comboBoxCategoryTour = new JComboBox<>();
                        loadCategoryTourComboBox(tour_dto);

                    comboBoxCategoryTour.setBounds(680,13,150,30);
                    comboBoxCategoryTour.setFont(new Font("Segoe",Font.BOLD,13));


                   //**************END COMBOBOX CATEGORY TOUR*******************//

                    btnSaveTour = new JButton("Lưu");
                    btnSaveTour.setBackground(new Color(32, 171, 214));
                    btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
                    btnSaveTour.setForeground(Color.WHITE);
                    btnSaveTour.setBounds(850,30,115,30);
                    btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnBack = new JButton("Trờ lại");
                    btnBack.setBackground(new Color(149, 148, 142));
                    btnBack.setFont(new Font("Segoe",Font.BOLD,13));
                    btnBack.setForeground(Color.WHITE);
                    btnBack.setBounds(850,100,115,30);
                    btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

                /************ADD COMPONENT FOR PANEL HEADER*****************/
                    panelHeader.add(labelTourId);
                    panelHeader.add(txtTourId);
                    panelHeader.add(sptTourId);
                    panelHeader.add(labelNameTour);
                    panelHeader.add(txtNameTour);
                    panelHeader.add(sptNameTour);
                    panelHeader.add(labelVND);

                    panelHeader.add(labelPriceTour);
                    panelHeader.add(txtPriceTour);
                    panelHeader.add(sptPriceTour);
                    panelHeader.add(labelStatusTour);
                    panelHeader.add(comboBoxStatusTour);
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
                        panelPriceTour.setBounds(5,5,980,430);
                                //**************TEXTFIELD TOUR ID*******************//
                                labelTourID = new JLabel("MÃ TOUR :",JLabel.CENTER);
                                labelTourID.setFont(new Font("Segoe",Font.BOLD,12));
                                labelTourID.setBounds(0,50,80,30);

                                txtTourID = new JTextField();
                                txtTourID.setBounds(85,48,80,30);
                                txtTourID.setBorder(null);
                                txtTourID.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                txtTourID.setText(tour_dto.getTourId());
                                txtTourID.setEditable(false);

                                sptTourID = new JSeparator();
                                sptTourID.setBounds(85,78,80,10);
                                sptTourID.setBackground(new Color(0,0,0));
                                //**************END TEXTFIELD TOUR ID*******************//

                                //**************TEXTFIELD TOUR PRICE*******************//
                                labelPrice = new JLabel("GIÁ TOUR :",JLabel.CENTER);
                                labelPrice.setFont(new Font("Segoe",Font.BOLD,12));
                                labelPrice.setBounds(0,150,80,30);

                                txtPrice = new JTextField();
                                txtPrice.setBounds(85,148,80,30);
                                txtPrice.setBorder(null);
                                txtPrice.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

                                sptPrice= new JSeparator();
                                sptPrice.setBounds(85,178,80,10);
                                sptPrice.setBackground(new Color(0,0,0));
                                //**************END TEXTFIELD TOUR PRICE*******************//

                                //**************TEXTFIELD START DATE*******************//
                                labelStartDate = new JLabel("NGÀY BẮT ĐẦU :",JLabel.CENTER);
                                labelStartDate.setFont(new Font("Segoe",Font.BOLD,12));
                                labelStartDate.setBounds(185,50,120,30);

                                dateChooserStartDate = new JDateChooser();
                                dateChooserStartDate.setBounds(292, 48, 140, 30);
                                dateChooserStartDate.setBorder(null);
                                dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserStartDate.setDateFormatString("yyyy-MM-dd");

                                sptStartDate = new JSeparator();
                                sptStartDate.setBounds(292,78,140,10);
                                sptStartDate.setBackground(new Color(0,0,0));

                                //**************END TEXTFIELD START DATE*******************//

                                //**************TEXTFIELD END DATE*******************//
                                labelEndDate = new JLabel("NGÀY KẾT THÚC :",JLabel.CENTER);
                                labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
                                labelEndDate.setBounds(185,150,120,30);

                                dateChooserEndDate = new JDateChooser();
                                dateChooserEndDate.setBounds(293, 148, 139, 30);
                                dateChooserEndDate.setBorder(null);
                                dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserEndDate.setDateFormatString("yyyy-MM-dd");

                                sptEndDate = new JSeparator();
                                sptEndDate.setBounds(292,178,140,10);
                                sptEndDate.setBackground(new Color(0,0,0));

                                //**************END TEXTFIELD END DATE*******************//


                                buttonAddPrice = new JButton("Thêm Giá Tour");
                                buttonAddPrice.setBackground(new Color(41, 149, 85));
                                buttonAddPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonAddPrice.setForeground(Color.WHITE);
                                buttonAddPrice.setBounds(50,230,150,30);
                                buttonAddPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonClearFieldPrice = new JButton("Làm Mới");
                                buttonClearFieldPrice.setBackground(new Color(255, 255, 255));
                                buttonClearFieldPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonClearFieldPrice.setForeground(Color.BLACK);
                                buttonClearFieldPrice.setBounds(250,230,105,30);
                                buttonClearFieldPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonSavePrice = new JButton("Lưu");
                                buttonSavePrice.setBackground(new Color(32, 171, 214));
                                buttonSavePrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonSavePrice.setForeground(Color.WHITE);
                                buttonSavePrice.setBounds(50,230,105,30);
                                buttonSavePrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonCancelPrice = new JButton("Huỷ Bỏ");
                                buttonCancelPrice.setBackground(new Color(219, 50, 54));
                                buttonCancelPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonCancelPrice.setForeground(Color.WHITE);
                                buttonCancelPrice.setBounds(250,230,105,30);
                                buttonCancelPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                /**************ADD ELEMENT FOR PANEL FIELD PRICE TOUR*********************/

                                /**************END ADD ELEMENT FOR PANEL FIELD PRICE TOUR*******************/
                            /*===================END PANEL FIELD PRICE TOUR========================*/

                            /*===================PANEL TABLE PRICE TOUR========================*/
                                Vector<String> columnNames = new Vector<>();
                                columnNames.add("Mã Giá");
                                columnNames.add("Mã Tour");
                                columnNames.add("Giá(VND)");
                                columnNames.add("Ngày Bắt Đầu");
                                columnNames.add("Ngày Kết Thúc");
                                modelTablePriceTour = new DefaultTableModel(columnNames,0);
                                tableTourPrice = new JTable(modelTablePriceTour);
                                LoadDataTableTourPrice();
                                tableTourPrice.setRowHeight(25);
                                tableTourPrice.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                                tableTourPrice.getTableHeader().setReorderingAllowed(false);
                                tableTourPrice.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                                tableTourPrice.getTableHeader().setOpaque(false);
                                tableTourPrice.getTableHeader().setBackground(new Color(0,77,64));
                                tableTourPrice.getTableHeader().setForeground(new Color(255,255,255));
                                tableTourPrice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                                tableTourPrice.setDefaultEditor(Object.class, null);
                                DefaultTableCellRenderer rightRendererPrice = new DefaultTableCellRenderer();
                                rightRendererPrice.setHorizontalAlignment(JLabel.CENTER);
                                tableTourPrice.getColumnModel().getColumn(2).setCellRenderer(rightRendererPrice);



                                /****************SET SIZE COLUMN OF TABLE***********************/
                                tableTourPrice.getColumnModel().getColumn(0).setPreferredWidth(50);
                                tableTourPrice.getColumnModel().getColumn(1).setPreferredWidth(50);
                                /****************SET SIZE COLUMN OF TABLE***********************/


                                tableTourPrice.setFont(new Font("Times New Roman",Font.PLAIN,15));

                                scrollPaneTablePrice = new JScrollPane(tableTourPrice);
                                scrollPaneTablePrice.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                    @Override
                                    protected void configureScrollBarColors() {
                                        this.thumbColor = new Color(19, 113, 106);
                                    }
                                });
                                scrollPaneTablePrice.setBounds(460,10,510,340);


                                buttonEditPrice = new JButton("Sửa Giá Tour");
                                buttonEditPrice.setBackground(new Color(194, 98, 14));
                                buttonEditPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonEditPrice.setForeground(Color.WHITE);
                                buttonEditPrice.setBounds(550,360,150,30);
                                buttonEditPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonDeletePrice = new JButton("Xoá Giá Tour");
                                buttonDeletePrice.setBackground(new Color(219, 50, 54));
                                buttonDeletePrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonDeletePrice.setForeground(Color.WHITE);
                                buttonDeletePrice.setBounds(750,360,150,30);
                                buttonDeletePrice.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            /**************ADD ELEMENT FOR PANEL TABLE CATEGORY TOUR*******************/

                            /**************ADD ELEMENT FOR PANEL TABLE CATEGORY TOUR*******************/
                            /*------------------------END PANEL TABLE PRICE TOUR------------------------------*/


                        /**********ADD COMPONENT FOR PANEL PRICE TOUR*****************/
                        panelPriceTour.add(labelTourID);
                        panelPriceTour.add(txtTourID);
                        panelPriceTour.add(sptTourID);

                        panelPriceTour.add(labelPrice);
                        panelPriceTour.add(txtPrice);
                        panelPriceTour.add(sptPrice);

                        panelPriceTour.add(labelStartDate);
                        panelPriceTour.add(dateChooserStartDate);
                        panelPriceTour.add(sptStartDate);

                        panelPriceTour.add(labelEndDate);
                        panelPriceTour.add(dateChooserEndDate);
                        panelPriceTour.add(sptEndDate);

                        panelPriceTour.add(buttonAddPrice);
                        panelPriceTour.add(buttonClearFieldPrice);
                        panelPriceTour.add(buttonSavePrice);
                        panelPriceTour.add(buttonCancelPrice);

                        panelPriceTour.add(scrollPaneTablePrice);
                        panelPriceTour.add(buttonEditPrice);
                        panelPriceTour.add(buttonDeletePrice);

                        /**********END ADD COMPONENT FOR PANEL PRICE TOUR***************/
                    /*------------------------END PANEL PRICE TOUR------------------------------*/


                    /*------------------------PANEL PLACE TOUR------------------------------*/
                        panelPlaceTour = new JPanel();
                        panelPlaceTour.setLayout(null);
                        panelPlaceTour.setBounds(5,5,980,430);
                        panelPlaceTour.setBackground(Color.white);

                        /**********ALL COMPONENT PLACE TOUR*****************/
                            labelSearch = new JLabel("Tìm kiếm:");
                            labelSearch.setBounds(30,21,80,25);

                            txtSearch = new JTextField();
                            txtSearch.setBounds(95,21,250,25);

                            labelIconSearch = new JLabel();
                            labelIconSearch.setBounds(360,20,25,25);
                            labelIconSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
                            labelIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_search_property_25px.png")));

                            labelAllPlaceTour = new JLabel("Tất Cả Địa Điểm Tour");
                            labelAllPlaceTour.setBounds(110,60,250,25);
                            labelAllPlaceTour.setForeground(new Color(0,0,0));
                            labelAllPlaceTour.setFont(new Font("Times New Roman",1,18));

                            scrollPaneAllPlace = new JScrollPane();

                            scrollPaneAllPlace.setBounds(39, 100, 343, 305);
                            scrollPaneAllPlace.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });


                            UpdateListAttractionTour();
                            listPlaceTour.setFixedCellHeight(27);
                            listPlaceTour.setFixedCellWidth(100);
                            listPlaceTour.setBorder(new EmptyBorder(10,10, 10, 10));


                            listPlaceTour.setSelectedIndex(0);
                            listPlaceTour.setVisibleRowCount(10);
                            listPlaceTour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            scrollPaneAllPlace.setViewportView(listPlaceTour);
                            /*********************END ALL COMPONENT PLACE TOUR*****************/

                            btnAddPlaceTour = new JButton("Thêm >>>");
                            btnAddPlaceTour.setBackground(new Color(41, 149, 85));
                            btnAddPlaceTour.setFont(new Font("Segoe",Font.BOLD,13));
                            btnAddPlaceTour.setForeground(Color.WHITE);
                            btnAddPlaceTour.setBounds(435,220,115,30);
                            btnAddPlaceTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            btnSavePlaceTour = new JButton("Lưu Địa Điểm");
                            btnSavePlaceTour.setBackground(new Color(32, 171, 214));
                            btnSavePlaceTour.setFont(new Font("Segoe",Font.BOLD,13));
                            btnSavePlaceTour.setForeground(Color.WHITE);
                            btnSavePlaceTour.setBounds(630,373,130,30);
                            btnSavePlaceTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            btnRemovePlaceTour = new JButton(" Loại Bỏ");
                            btnRemovePlaceTour.setBackground(new Color(219, 50, 54));
                            btnRemovePlaceTour.setFont(new Font("Segoe",Font.BOLD,13));
                            btnRemovePlaceTour.setForeground(Color.WHITE);
                            btnRemovePlaceTour.setBounds(800,373,115,30);
                            btnRemovePlaceTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

                            /******************COMPONENT PLACE TOUR IS SELECTED*****************/
                            labelPlaceSeleted = new JLabel("Địa Điểm Đã Được Chọn");
                            labelPlaceSeleted.setBounds(660,60,250,25);
                            labelPlaceSeleted.setForeground(new Color(0,0,0));
                            labelPlaceSeleted.setFont(new Font("Times New Roman",1,18));

                            scrollPanePlaceSeleted = new JScrollPane();

                            scrollPanePlaceSeleted.setBounds(600, 100, 343, 258);
                            scrollPanePlaceSeleted.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                                @Override
                                protected void configureScrollBarColors() {
                                    this.thumbColor = new Color(19, 113, 106);
                                }
                            });
                            
                            modelAttractionTourisSelected = new  DefaultListModel<Tour_Attraction_DTO>();
                            listPlaceTourisSelected = new JList<Tour_Attraction_DTO>(modelAttractionTourisSelected);
                            UpdateJListSelected();


                            listPlaceTourisSelected.setFixedCellHeight(27);
                            listPlaceTourisSelected.setFixedCellWidth(100);
                            listPlaceTourisSelected.setBorder(new EmptyBorder(10,10, 10, 10));

                            listPlaceTourisSelected.setSelectedIndex(0);
                            listPlaceTourisSelected.setVisibleRowCount(10);
                            listPlaceTourisSelected.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            scrollPanePlaceSeleted.setViewportView(listPlaceTourisSelected);
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
                        panelPlaceTour.add(btnSavePlaceTour);
                        /**********END ADD COMPONENT FOR PANEL PLACE TOUR***************/
                    /*------------------------END PANEL PLACE TOUR------------------------------*/

                    /*------------------------PANEL GROUP TOUR------------------------------*/
                        panelGroupTour = new JPanel();
                        panelGroupTour.setLayout(null);
                        panelGroupTour.setBackground(Color.white);
                        panelGroupTour.setBounds(5,5,980,430);
                    /*------------------------END PANEL GROUP TOUR------------------------------*/
                /**********ADD COMPONENT FOR PANEL CONTENT*****************/
                    tabbedPaneContent.addTab("Địa Điểm Tour", panelPlaceTour);
                    tabbedPaneContent.addTab("Giá Tour", panelPriceTour);
                    tabbedPaneContent.addTab("Đoàn", panelGroupTour);
                /**********END ADD COMPONENT FOR PANEL CONTENT*****************/
            /*------------------------END PANEL CONTENT------------------------------*/

        /***************ADD COMPONENT FOR PANEL MAIN********************/
            add(panelHeader);
            add(tabbedPaneContent);
        /***************END ADD COMPONENT FOR PANEL MAIN********************/

        /*------------------------HANDLE CLICK BUTTON------------------------------*/
            txtPriceTour.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    String price = txtPriceTour.getText();
                    long priceTour = Long.parseLong(price.replace(",",""));
                    String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                    txtPriceTour.setText(priceNewTour);
                }
            });

            txtPrice.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent e) {
                    String price = txtPrice.getText();
                    long priceTour = Long.parseLong(price.replace(",",""));
                    String priceNewTour = java.text.NumberFormat.getIntegerInstance().format(priceTour);
                    txtPrice.setText(priceNewTour);
                }
            });

            btnSaveTour.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    User_DTO user = new User_DTO();
                    String name = txtNameTour.getText();
                    String specification = txtSpecification.getText();
                    String price = txtPriceTour.getText().replace(",","");
                    String price_PATTERN = "^[1-9]([0-9])*$";
                    String staus = statusTour != "" ? statusTour : Tour_DTO.getStatus();
                    Tour_Category_DTO category_dto = (Tour_Category_DTO) (comboBoxCategoryTour.getSelectedItem());
                    String category = category_dto.getCategoryId();
                    if(checkDifferentTour(name, specification, price, staus, category)==false){
                        if(Pattern.matches(price_PATTERN, price)==false){
                        JOptionPane.showMessageDialog(null, "Lỗi! Giá tour không hợp lệ, và giá tour phải lớn hơn 0.");
                        } else {
                            String parameter = "{\"id\":"+Tour_DTO.getTourId()+",\"name\":\""+name+"\",\"specification\":\""+specification+"\",\"tourCategoryId\":"+category+",\"price\":"+price+",\"status\":"+staus+"}";
                            System.out.println(parameter);
                            APIRequester.sendPUT(parameter, "tours/"+tour_dto.getTourId(), user.getToken());
                            JOptionPane.showMessageDialog(null, "Sửa thành công");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Tour không có thay đổi");
                    }

                }
            });
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAllAndAddNewPanel(new GUI_Table_Tour_Management());
            }
        });
        /*------------------------END HANDLE CLICK BUTTON------------------------------*/

        /*========================HANDLE CLICK BUTTON OF PRICE====================================*/
            buttonClearFieldPrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clearTextFieldPrice();
                }
            });

            buttonAddPrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String price = txtPrice.getText().replace(",","");

                    String startDate = formatDateTime(dateChooserStartDate.getDate());
                    String  endDate = formatDateTime(dateChooserEndDate.getDate());

                    String  idTour = txtTourID.getText();
                    if( !empty( price ) && !empty( startDate ) && !empty(endDate)) {
                        String price_PATTERN = "^[1-9]([0-9])*$";
                        if(Pattern.matches(price_PATTERN, price) == false) {
                            JOptionPane.showMessageDialog(null, "Lỗi! Giá tour không hợp lệ, và giá tour phải lớn hơn 0.");
                        }else {

                                User_DTO user = new User_DTO();

                                String parameter = "{\"tourId\":"+idTour+",\"price\":"+price+",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                                System.out.println(parameter);
//                                APIRequester.sendPOST(parameter, "tourPrices", user.getToken());
                                String response = Handle_API_Tour_Price.send_POST_Tour_Price(parameter, "tourPrices", user.getToken());
                                if(response.equals("success") == true){
                                    LoadDataTableTourPrice();
                                    clearTextFieldPrice();
                                }
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                    }

                }
            });
            buttonDeletePrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tableTourPrice.getSelectedRow();
                    if( row == -1 ){
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn giá tour cần xoá");
                    } else {
                        int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá giá tour này?", "Thông báo",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if(result == JOptionPane.YES_OPTION){
                            User_DTO user = new User_DTO();
                            String id = (tableTourPrice.getModel().getValueAt(row, 0).toString());
                            APIRequester.sendDelete("","tourPrices/"+id, user.getToken());
                            LoadDataTableTourPrice();
                            JOptionPane.showMessageDialog(null, "Xoá giá tour thành công");
                        }else if (result == JOptionPane.NO_OPTION){

                        }else {

                        }

                    }

                }
            });

            buttonEditPrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tableTourPrice.getSelectedRow();
                    if( row == -1 ){
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn giá tour cần sửa");
                    }else {
                        String id = (tableTourPrice.getModel().getValueAt(row, 0).toString());
                        String price = (tableTourPrice.getModel().getValueAt(row, 2).toString());
                        String startDate = (tableTourPrice.getModel().getValueAt(row, 3).toString());
                        String endDate = (tableTourPrice.getModel().getValueAt(row, 4).toString());

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String substringStartDate = startDate.substring(0,10);
                        String substringEndtDate = endDate.substring(0,10);
                        try {
                            Date startDateFormat = dateFormat.parse(substringStartDate);
                            Date endDateFormat = dateFormat.parse(substringEndtDate);

                            buttonAddPrice.setVisible(false);
                            buttonClearFieldPrice.setVisible(false);
                            buttonSavePrice.setVisible(true);
                            buttonCancelPrice.setVisible(true);
                            txtPrice.setText(price);
                            dateChooserStartDate.setDate(startDateFormat);
                            dateChooserEndDate.setDate(endDateFormat);
                            tour_price_dto = new Tour_Price_DTO(id, price, substringStartDate, substringEndtDate);
                        } catch (java.text.ParseException parseException) {
                            parseException.printStackTrace();
                        }
                    }
                }
            });
            buttonCancelPrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clearTextFieldPrice();
                    buttonSavePrice.setVisible(false);
                    buttonCancelPrice.setVisible(false);
                    buttonAddPrice.setVisible(true);
                    buttonClearFieldPrice.setVisible(true);
                }
            });

            buttonSavePrice.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String price = txtPrice.getText().replace(",","");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = dateFormat.format(dateChooserStartDate.getDate());
                    String  endDate = dateFormat.format(dateChooserEndDate.getDate());
                    if( !empty( price ) && !empty( startDate ) && !empty(endDate)) {
                        if(checkDifferentPrice(price, startDate, endDate, tour_price_dto)==false){
                            String price_PATTERN = "^[1-9]([0-9])*$";
                            if(Pattern.matches(price_PATTERN, price) == false) {
                                JOptionPane.showMessageDialog(null, "Lỗi! Giá tour không hợp lệ, và giá tour phải lớn hơn 0.");
                            }else {
                                User_DTO user = new User_DTO();
                                String parameter = "{\"id\":"+tour_price_dto.getPriceId()+",\"price\":"+price+",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                                //APIRequester.sendPUT(parameter, "tourPrices/"+Tour_Price_DTO.getPriceId(), user.getToken());
                                String response = Handle_API_Tour_Price.sendPut_Tour_Price(parameter,"tourPrices/"+tour_price_dto.getPriceId(), user.getToken());
                                if(response.equals("success")){
                                    clearTextFieldPrice();
                                    LoadDataTableTourPrice();
                                    buttonSavePrice.setVisible(false);
                                    buttonCancelPrice.setVisible(false);
                                    buttonAddPrice.setVisible(true);
                                    buttonClearFieldPrice.setVisible(true);
                                }
                            }

                        }else {
                            JOptionPane.showMessageDialog(null, "Giá tour không có thay đổi");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                    }
                }
            });
            /*========================END HANDLE CLICK BUTTON OF PRICE====================================*/

        tabbedPaneContent.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int i = tabbedPaneContent.getSelectedIndex();
                if(i == 2) {
                    panelGroupTour.removeAll();
                    panelGroupTour.add(new GUI_Table_Group());
                    repaint();
                }
            }
        });

        /*======================== HANDLE HANDLE EVENT JLIST ATTRACTION====================================*/
            listPlaceTour.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(e.getValueIsAdjusting()){
                        for(Object x : dataAttraction.keySet()){
                            if(listPlaceTour.getSelectedValue().equals(x)){
                                String idAttraction = dataAttraction.get(x);
                                tour_attraction_dto = new Tour_Attraction_DTO(idAttraction);
                            }
                        }
                    }
                }
            });

//        listPlaceTourisSelected.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if(e.getValueIsAdjusting()){
//                    for(Tour_Attraction_DTO attraction_dto : dataAttractionisSelected){
//                        if(listPlaceTourisSelected.getSelectedValue().equals(attraction_dto.getAttractionsName())==true){
//                            String idAttraction = attraction_dto.getAttractionsId();
//                            System.out.println(idAttraction);
//                            tour_attraction_dto = new Tour_Attraction_DTO(idAttraction);
//                        }
//                    }
//                }
//            }
//        });

        btnAddPlaceTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String idAttraction ="";
                for(Object x : dataAttraction.keySet()){
                    if(listPlaceTour.getSelectedValue().equals(x)){
                         idAttraction = dataAttraction.get(x);
                        tour_attraction_dto = new Tour_Attraction_DTO(idAttraction);
                    }
                }

                User_DTO user_dto = new User_DTO();
                System.out.println(listPlaceTour.getSelectedValue());
                String parameter = "{\"tourId\":"+Tour_DTO.getTourId()+",\"touristAttractionIds\":["+idAttraction+"]}";
                System.out.println(parameter);
                Handle_API_Tour_Attractions.sendPostTourDetail(parameter,"tourDetail", user_dto.getToken());
                modelAttractionTourisSelected.clear();
                UpdateJListSelected();
            }
        });

        btnRemovePlaceTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                User_DTO user_dto = new User_DTO();
                String idAttraction ="";
                for(Tour_Attraction_DTO attraction_dto : dataAttractionisSelected){
                    int index = listPlaceTourisSelected.getSelectedIndex();

                    System.out.println(index+1 +" va "+ attraction_dto.getIndex());
                    System.out.println(listPlaceTourisSelected.getSelectedValue().equals(attraction_dto.getAttractionsName()));
                    System.out.println(listPlaceTourisSelected.getSelectedValue()+" va "+ attraction_dto.getAttractionsName());

                    int indexAttraction = attraction_dto.getIndex();

                    String name = listPlaceTourisSelected.getSelectedValue().toString();
                    String nameAttraction = attraction_dto.getAttractionsName();

                    if(name.equals(nameAttraction)==true&&(index+1)==indexAttraction){
                        idAttraction += attraction_dto.getAttractionsId();

                    }
                }

                String parameter = "{\"tourId\":"+tour_dto.getTourId()+",\"ids\":["+idAttraction+"]}";
                System.out.println(parameter);
                Handle_API_Tour_Attractions.sendDeleteTourDetail(parameter,"tourDetail", user_dto.getToken());
                modelAttractionTourisSelected.clear();
                UpdateJListSelected();
                listPlaceTourisSelected.setSelectedIndex(0);
            }
        });

        btnSavePlaceTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                User_DTO user = new User_DTO();
                //String parameter = "{\"tourId\":"+Tour_DTO.getTourId()+",\"tourDetails\":[";

                // lay index of jlist so sanh voi

                String parameter = "{ \"tourId\": "+Tour_DTO.getTourId()+", \"tourDetails\": [ ";
                for (int i = 0; i < listPlaceTourisSelected.getModel().getSize(); i++) {
                    Tour_Attraction_DTO attraction = listPlaceTourisSelected.getModel().getElementAt(i);
                    System.out.println(attraction.getAttractionsId()+" va "+ attraction.getAttractionsName());

//                    for(Tour_Attraction_DTO attraction_dto : dataAttractionisSelected){
//                        if(item.equals(attraction_dto.getAttractionsName())==true){
//
//                                //parameter += "{ \"touristAttractionId\": "+dataAttractionisSelected.get(x)+", \"index\": "+(i+1)+" }, ";
//                        }
//                    }
                    parameter += "{\"id\":"+attraction.getAttractionsId()+",\"index\":"+(i+1)+"},";
                }
                parameter += "]}";
                StringBuilder parameterFormat = new StringBuilder(parameter);
                System.out.println(parameterFormat.deleteCharAt(parameterFormat.length()-3));
                String reponse = Handle_API_Tour_Detail.sendPUT_Attraction_Tour(parameterFormat.toString(),
                        "tourDetail", user.getToken());
                if(reponse.equals("success") == true){
                    JOptionPane.showMessageDialog(null, "Lưu địa điểm thành công");
                    modelAttractionTourisSelected.clear();
                    UpdateJListSelected();
                    listPlaceTourisSelected.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
                }
            }
        });
        /*======================== END HANDLE EVENT JLIST ATTRACTION====================================*/

        /*========================  HANDLE EVENT JCOMBOBOX CATEGORY AND STATUS====================================*/
//        comboBoxCategoryTour.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent arg0) {
//                Tour_Category_DTO category_dto = (Tour_Category_DTO) (comboBoxCategoryTour.getSelectedItem());
////                System.out.println(category_dto.getCategoryId() + category_dto. getCategoryName());
//                category_dto.setCategoryId(category_dto.getCategoryId());
//            }
//        });
        comboBoxStatusTour.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                System.out.println(comboBoxStatusTour.getSelectedItem());
                if(comboBoxStatusTour.getSelectedItem().equals("Đang Mở")){
                    statusTour = "1";
                }
                if(comboBoxStatusTour.getSelectedItem().equals("Đã Đóng")){
                    statusTour = "2";
                }
                if(comboBoxStatusTour.getSelectedItem().equals("Tạm Hoãn")){
                    statusTour = "3";
                }
            }
        });

        labelIconSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameAttraction = txtSearch.getText();
//                if(!empty(nameAttraction)){
                    nameAttraction = encodeValue(nameAttraction);
//                }
                String parameter = "&Filters[Name]=\""+nameAttraction+"\"&FilterConditions[Name]=like";
                modelAttractionTour.removeAllElements();
                UpdateListAttractionTourAfterSearch(parameter);
            }
        });
        labelPlaceSeleted.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UpdateListAttractionTour();
            }
        });
        /*======================== END  HANDLE EVENT JCOMBOBOX CATEGORY====================================*/

        /*========================  HANDLE EVENT JLIST ATTRACTION SELECTED====================================*/
        MyMouseAdaptor myMouseAdaptor = new MyMouseAdaptor();
        listPlaceTourisSelected.addMouseListener(myMouseAdaptor);
        listPlaceTourisSelected.addMouseMotionListener(myMouseAdaptor);
        /*======================== END HANDLE EVENT JLIST ATTRACTION SELECTED====================================*/

    }
    private class MyMouseAdaptor extends MouseInputAdapter {
        private boolean mouseDragging = false;
        private int dragSourceIndex;

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                dragSourceIndex = listPlaceTourisSelected.getSelectedIndex();
                mouseDragging = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseDragging = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (mouseDragging) {
                int currentIndex = listPlaceTourisSelected.locationToIndex(e.getPoint());
                if (currentIndex != dragSourceIndex) {
                    int dragTargetIndex = listPlaceTourisSelected.getSelectedIndex();
                    Tour_Attraction_DTO dragElement = modelAttractionTourisSelected.get(dragSourceIndex);
                    modelAttractionTourisSelected.remove(dragSourceIndex);
                    modelAttractionTourisSelected.add(dragTargetIndex, dragElement);
                    dragSourceIndex = currentIndex;
                }
            }
        }
    }

    public static HashMap<String, String> hashMapTourAttraction(){
        User_DTO user = new User_DTO();
        dataAttraction = new HashMap<String, String>();
        JSONArray result = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100", user.getToken()));
        for(int i = 0; i < result.length(); i++){
            JSONObject jsonObj;
            try {
                jsonObj = result.getJSONObject(i);
                String name = jsonObj.get("name").toString();
                String id = jsonObj.get("id").toString();

                dataAttraction.put(name,id);

            } catch (JSONException ex) {
                Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataAttraction;
    }
    public void UpdateListAttractionTour(){
        hashMapTourAttraction();
        modelAttractionTour = new  DefaultListModel<String>();
        listPlaceTour = new JList<String>(modelAttractionTour);
        for(Object object : dataAttraction.keySet()){
            modelAttractionTour.addElement(String.valueOf(object));
        }
        listPlaceTour.setModel(modelAttractionTour);
        System.out.println(listPlaceTour.getModel());
        listPlaceTour.setFont(new Font("Arial",Font.ITALIC,14));

    }

    public static HashMap<String, String> hashMapTourAttractionAfterSearch(String parameter){
        User_DTO user = new User_DTO();
        dataAttractionSearch = new HashMap<String, String>();
        JSONArray result = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100"+parameter, user.getToken()));
        if(result.length() >= 1){
            for(int i = 0; i < result.length(); i++){
                JSONObject jsonObj;
                try {
                    jsonObj = result.getJSONObject(i);
                    String name = jsonObj.get("name").toString();
                    String id = jsonObj.get("id").toString();

                    dataAttractionSearch.put(name,id);

                } catch (JSONException ex) {
                    Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dataAttractionSearch;
        }else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy địa điểm cần tìm");
        }
        return dataAttractionSearch;
    }
    public void UpdateListAttractionTourAfterSearch(String parameter){
        hashMapTourAttractionAfterSearch(parameter);
        modelAttractionTour = new  DefaultListModel<String>();
        for(Object object : dataAttractionSearch.keySet()){
            modelAttractionTour.addElement(String.valueOf(object));
        }
        listPlaceTour.setModel(modelAttractionTour);
        listPlaceTour.setFont(new Font("Arial",Font.ITALIC,14));

    }

    public static ArrayList<Tour_Attraction_DTO> TourAttractionsListisSelected(Tour_DTO tour_dto){
        User_DTO user = new User_DTO();
        dataAttractionisSelected = new ArrayList<>();
        JSONArray result = new JSONArray(Handle_API_Tour_Id.Fetch_API_Tour_Id_Detail("tours/"+tour_dto.getTourId(), user.getToken()));
        for(int i = 0; i < result.length(); i++){
            try {
                JSONObject obj = (JSONObject) result.get(i);
                JSONObject my = (JSONObject) obj.get("touristAttraction");

                    String name = my.get("name").toString();
                    String id = obj.get("id").toString();
                    int index = Integer.parseInt(obj.get("index").toString());

//                dataAttractionisSelected.put(id,name);
                    Tour_Attraction_DTO tour_attraction_dto = new Tour_Attraction_DTO(id, name, index);

                dataAttractionisSelected.add(tour_attraction_dto);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Edit_Tour.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dataAttractionisSelected;
    }
    public void UpdateJListSelected(){
        TourAttractionsListisSelected( tour_dto);
        for(Tour_Attraction_DTO attraction_dto : TourAttractionsListisSelected(tour_dto)){
            modelAttractionTourisSelected.addElement(attraction_dto);
        }
        listPlaceTourisSelected.setModel(modelAttractionTourisSelected);
        listPlaceTourisSelected.setFont(new Font("Arial",Font.ITALIC,14));
    }

    public static void loadCategoryTourComboBox( Tour_DTO tour_dto){
        User_DTO user = new User_DTO();
        JSONArray array = new JSONArray(Handle_API_Tour_Category.Fetch_API_Tour_Category("tourCategories?Page=1&Limit=100", user.getToken()));
        for(int i = 0; i < array.length(); i++){
            try {
                JSONObject jsonObject = (JSONObject) array.get(i);
                String id = jsonObject.get("id").toString();
                String name = jsonObject.get("name").toString();
                comboBoxCategoryTour.addItem(new Tour_Category_DTO(id, name));
                if(tour_dto.getTourCategoryId().equals(id) == true){
                    comboBoxCategoryTour.setSelectedIndex(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public void selectedComboBoxStatusTour(){
        Map<Integer, String> map = new  HashMap<>();
        map.put(1, "Đang Mở");
        map.put(2, "Đã Đóng");
        map.put(3, "Tạm Hoãn");
        Set<Integer> set = map.keySet();
        int i = 0;
        for (Integer key : set){
            comboBoxStatusTour.addItem(map.get(key));
            int status = Integer.parseInt(tour_dto.getStatus());
            if(status == key){
                comboBoxStatusTour.setSelectedIndex(i);
            }
            i++;
        }
    }

    public static boolean checkDifferentTour(String name, String specification,
                                             String price, String status, String category ){
        if(name.equals(Tour_DTO.getTourName())== true &&
                specification.equals(Tour_DTO.getSpecification())== true &&
                price.equals(Tour_DTO.getPrice())== true && status.equals(Tour_DTO.getStatus())== true
        && category.equals(Tour_DTO.getTourCategoryId()) == true){
            return true;
        }
        return false;
    }

    public static boolean checkDifferentPrice(String price, String startDate, String endDate, Tour_Price_DTO tour_price_dto){
        if(price.equals(tour_price_dto.getPrice())== true &&
                startDate.equals(tour_price_dto.getStartDate())== true &&
                endDate.equals(tour_price_dto.getEndDate())== true){
            return true;
        }
        return false;
    }

    public void LoadDataTableTourPrice(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Price.Fetch_API_Tour_Price("tours/"+tour_dto.getTourId()+"/tourPrices?Page=1&Limit=100", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();

        modelTablePriceTour.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("tourId").toString());
                int price = Integer.parseInt(jsonObj.get("price").toString());
                String priceTour = java.text.NumberFormat.getIntegerInstance().format(price);
                data.add(priceTour);
                String substringStartDate = jsonObj.get("startDate").toString().substring(0,10);
                String substringEndtDate = jsonObj.get("endDate").toString().substring(0,10);
                data.add(substringStartDate);
                data.add(substringEndtDate);
                data.add(substringStartDate);
                data.add(substringEndtDate);

                modelTablePriceTour.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }



        tableTourPrice.setModel(modelTablePriceTour);

    }
    public void clearTextFieldPrice(){
        txtPrice.setText("");
        dateChooserEndDate.setCalendar(null);
        dateChooserStartDate.setCalendar(null);
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static String formatDateTime(Date dateOrNull) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (dateOrNull == null ? null : dateFormat.format(dateOrNull));
    }
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
