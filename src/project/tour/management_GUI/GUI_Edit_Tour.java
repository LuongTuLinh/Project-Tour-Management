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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
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
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_Category_DTO;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.Tour_Price_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour_Attractions;
import project.tour.management_Handle_API.Handle_API_Tour_Category;
import project.tour.management_Handle_API.Handle_API_Tour_Id;
import project.tour.management_Handle_API.Handle_API_Tour_Price;

/**
 *
 * @author DELL
 */
public class GUI_Edit_Tour extends JPanel{
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

        private JLabel labelStatusTour;
        private JTextField txtStatusTour;
        private JSeparator sptStatusTour;

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

            private JLabel labelTourID;
            private JTextField txtTourID;
            private JSeparator sptTourID;

            private JLabel labelPrice;
            private JTextField txtPrice;
            private JSeparator sptPrice;

            private JLabel labelStartDate;
//            private JTextField txtStartDate;
            private JDateChooser dateChooserStartDate;
            private JSeparator sptStartDate;

            private JLabel labelEndDate;
//            private JTextField txtEndDate;
            private JDateChooser dateChooserEndDate;
            private JSeparator sptEndDate;

            private JButton buttonAddPrice;
            private JButton buttonClearFieldPrice;
            private JButton buttonEditPrice;
            private JButton buttonDeletePrice;
            private JButton buttonSavePrice;
            private JButton buttonCancelPrice;

            private JScrollPane scrollPaneTablePrice;
            private JTable tableTourPrice;

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
                    txtTourId.setText(Tour_DTO.getTourId());
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
                    txtNameTour.setText(Tour_DTO.getTourName());

                    sptNameTour = new JSeparator();
                    sptNameTour.setBounds(115,84,408,10);
                    sptNameTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR NAME*******************//

                   //**************TEXTFIELD TOUR STATUS*******************//
                    labelStatusTour = new JLabel("TRẠNG THÁI:",JLabel.CENTER);
                    labelStatusTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelStatusTour.setBounds(365,10,80,30);

                    txtStatusTour = new JTextField();
                    txtStatusTour.setBounds(445,8,80,30);
                    txtStatusTour.setBorder(null);
                    txtStatusTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    txtStatusTour.setText(Tour_DTO.getStatus());

                    sptStatusTour = new JSeparator();
                    sptStatusTour.setBounds(445,38,80,10);
                    sptStatusTour.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR STATUS*******************//

                   //**************TEXTFIELD TOUR PRICE*******************//
                    labelPriceTour = new JLabel("GIÁ TOUR:",JLabel.CENTER);
                    labelPriceTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelPriceTour.setBounds(600,56,80,30);

                    txtPriceTour = new JTextField();
                    txtPriceTour.setBounds(680,54,125,30);
                    txtPriceTour.setBorder(null);
                    txtPriceTour.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                    txtPriceTour.setText(Tour_DTO.getPrice());

                    sptPriceTour = new JSeparator();
                    sptPriceTour.setBounds(680,84,125,10);
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
                    txtSpecification.setText(Tour_DTO.getSpecification());

                    sptSpecification = new JSeparator();
                    sptSpecification.setBounds(115,128,690,10);
                    sptSpecification.setBackground(new Color(0,0,0));
                   //**************END TEXTFIELD TOUR Specification*******************//

                   //**************COMBOBOX CATEGORY TOUR*******************//
                    labelCategoryTour = new JLabel("THỂ LOẠI:",JLabel.CENTER);
                    labelCategoryTour.setFont(new Font("Segoe",Font.BOLD,12));
                    labelCategoryTour.setBounds(600,20,80,30);

                    comboBoxCategoryTour = new JComboBox<>();
                    comboBoxCategoryTour.setModel(new DefaultComboBoxModel<>(new String [] {
                        "Du lịch văn hóa", "Du lịch MICE", "Teambuilding", "Du lịch xanh", "Du lịch ẩm thực", "Du lịch tham quan"}));
                    comboBoxCategoryTour.setBounds(680,13,130,30);
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
                    btnBack.setBounds(850,100,115,30);
                    btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

                /************ADD COMPONENT FOR PANEL HEADER*****************/
                    panelHeader.add(labelTourId);
                    panelHeader.add(txtTourId);
                    panelHeader.add(sptTourId);
                    panelHeader.add(labelNameTour);
                    panelHeader.add(txtNameTour);
                    panelHeader.add(sptNameTour);

                    panelHeader.add(labelPriceTour);
                    panelHeader.add(txtPriceTour);
                    panelHeader.add(sptPriceTour);
                    panelHeader.add(labelStatusTour);
                    panelHeader.add(txtStatusTour);
                    panelHeader.add(sptStatusTour);
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
                            /*===================PANEL FIELD CATEGORY TOUR========================*/
                                labelTourID = new JLabel("MÃ TOUR :",JLabel.CENTER);
                                labelTourID.setFont(new Font("Segoe",Font.BOLD,12));
                                labelTourID.setBounds(0,50,80,30);

                                txtTourID = new JTextField();
                                txtTourID.setBounds(85,48,80,30);
                                txtTourID.setBorder(null);
                                txtTourID.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                txtTourID.setText(Tour_DTO.getTourId());
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

//                                txtStartDate = new JTextField();
//                                txtStartDate.setBounds(292,48,160,30);
//                                txtStartDate.setBorder(null);
//                                txtStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserStartDate = new JDateChooser();
                                dateChooserStartDate.setBounds(292, 48, 160, 30);
                                dateChooserStartDate.setBorder(null);
                                dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserStartDate.setDateFormatString("yyyy-MM-dd");

                                sptStartDate = new JSeparator();
                                sptStartDate.setBounds(292,78,160,10);
                                sptStartDate.setBackground(new Color(0,0,0));

                                //**************END TEXTFIELD START DATE*******************//

                                //**************TEXTFIELD END DATE*******************//
                                labelEndDate = new JLabel("NGÀY KẾT THÚC :",JLabel.CENTER);
                                labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
                                labelEndDate.setBounds(185,150,120,30);

//                                txtEndDate = new JTextField();
//                                txtEndDate.setBounds(292,148,160,30);
//                                txtEndDate.setBorder(null);
//                                txtEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserEndDate = new JDateChooser();
                                dateChooserEndDate.setBounds(293, 148, 159, 30);
                                dateChooserEndDate.setBorder(null);
                                dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
                                dateChooserEndDate.setDateFormatString("yyyy-MM-dd");

                                sptEndDate = new JSeparator();
                                sptEndDate.setBounds(292,178,165,10);
                                sptEndDate.setBackground(new Color(0,0,0));


                                //**************END TEXTFIELD END DATE*******************//


                                buttonAddPrice = new JButton("Thêm Giá Tour");
                                buttonAddPrice.setBackground(new Color(41, 149, 85));
                                buttonAddPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonAddPrice.setForeground(Color.WHITE);
                                buttonAddPrice.setBounds(50,230,150,30);
                                buttonAddPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonClearFieldPrice = new JButton("Xoá");
                                buttonClearFieldPrice.setBackground(new Color(239, 198, 74));
                                buttonClearFieldPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonClearFieldPrice.setForeground(Color.WHITE);
                                buttonClearFieldPrice.setBounds(250,230,105,30);
                                buttonClearFieldPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonSavePrice = new JButton("Lưu");
                                buttonSavePrice.setBackground(new Color(41, 149, 85));
                                buttonSavePrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonSavePrice.setForeground(Color.WHITE);
                                buttonSavePrice.setBounds(50,230,105,30);
                                buttonSavePrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonCancelPrice = new JButton("Huỷ Bỏ");
                                buttonCancelPrice.setBackground(new Color(239, 198, 74));
                                buttonCancelPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonCancelPrice.setForeground(Color.WHITE);
                                buttonCancelPrice.setBounds(250,230,105,30);
                                buttonCancelPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));
                                /**************ADD ELEMENT FOR PANEL FIELD PRICE TOUR*********************/

                                /**************END ADD ELEMENT FOR PANEL FIELD PRICE TOUR*******************/
                            /*===================END PANEL FIELD PRICE TOUR========================*/

                            /*===================PANEL TABLE PRICE TOUR========================*/

                                LoadDataTableTourPrice();
                                tableTourPrice.setRowHeight(25);
                                tableTourPrice.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                                tableTourPrice.getTableHeader().setReorderingAllowed(false);
                                tableTourPrice.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                                tableTourPrice.getTableHeader().setOpaque(false);
                                tableTourPrice.getTableHeader().setBackground(new Color(0,77,64));
                                tableTourPrice.getTableHeader().setForeground(new Color(255,255,255));
                                tableTourPrice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


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
                                scrollPaneTablePrice.setBounds(480,10,490,340);


                                buttonEditPrice = new JButton("Sửa Giá Tour");
                                buttonEditPrice.setBackground(new Color(255,165, 0));
                                buttonEditPrice.setFont(new Font("Segoe",Font.BOLD,13));
                                buttonEditPrice.setForeground(Color.WHITE);
                                buttonEditPrice.setBounds(550,360,150,30);
                                buttonEditPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

                                buttonDeletePrice = new JButton("Xoá Giá Tour");
                                buttonDeletePrice.setBackground(new Color(214, 38, 53));
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
//                        panelPriceTour.add(txtStartDate);
                        panelPriceTour.add(dateChooserStartDate);
                        panelPriceTour.add(sptStartDate);

                        panelPriceTour.add(labelEndDate);
//                        panelPriceTour.add(txtEndDate);
                        panelPriceTour.add(dateChooserEndDate);
                        panelPriceTour.add(sptEndDate);

                        panelPriceTour.add(buttonAddPrice);
                        panelPriceTour.add(buttonClearFieldPrice);
                        panelPriceTour.add(buttonSavePrice);
                        panelPriceTour.add(buttonCancelPrice);

                        panelPriceTour.add(scrollPaneTablePrice);
                        panelPriceTour.add(buttonEditPrice);
                        panelPriceTour.add(buttonDeletePrice);

//                        txtEndDate.setVisible(false);
//                        txtStartDate.setVisible(false);

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
                            /*********************END ALL COMPONENT PLACE TOUR*****************/

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
                            UpdateJListSelected();

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
                    String name = txtNameTour.getText();
                    String specification = txtSpecification.getText();
                    String price = txtPriceTour.getText();
                    String price_PATTERN = "^[0-9]+$";
                    if(checkDifferentTour(name, specification, price)==false){
                        if(Pattern.matches(price_PATTERN, price)==false){
                        JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm giá tour");
                        } else {
                            if(price.equals(Tour_DTO.getPrice())) {
                                price = Tour_DTO.getPrice();
                            }
                            String parameter = "{\"id\":\""+Tour_DTO.getTourId()+"\",\"name\":\""+name+"\",\"specification\":\""+specification+"\",\"tourCategoryId\":\"b079a901-ee32-4fce-8777-72cd55317931\",\"price\":"+price+",\"status\":1}";
                            APIRequester.sendPUT(parameter, "tours/"+Tour_DTO.getTourId(), user.getToken());
                            JOptionPane.showMessageDialog(null, "Sửa thành công");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Tour không có thay đổi");
                    }

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
                    String price = txtPrice.getText();
//                    String startDate = txtStartDate.getText();
//                    String endDate = txtEndDate.getText();

                    String startDate = formatDateTime(dateChooserStartDate.getDate());
                    String  endDate = formatDateTime(dateChooserEndDate.getDate());

                    String  idTour = txtTourID.getText();
                    if( !empty( price ) && !empty( startDate ) && !empty(endDate)) {
                        String price_PATTERN = "^[0-9]+$";
                        if(Pattern.matches(price_PATTERN, price) == false) {
                            JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng kiểm giá tour");
                        }else {
                            try {
                                User_DTO user = new User_DTO();

                                String parameter = "{\"tourId\":"+idTour+",\"price\":"+price+",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                                System.out.println(parameter);
                                APIRequester.sendPOST(parameter, "tourPrices", user.getToken());
                                LoadDataTableTourPrice();
                                JOptionPane.showMessageDialog(null, "Thêm thành công");
                                clearTextFieldPrice();
                            } catch (IOException | ParseException ex) {
                                Logger.getLogger(GUI_Add_Attraction_and_Category_Tour.class.getName()).log(Level.SEVERE, null, ex);
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
                        User_DTO user = new User_DTO();
                        String id = (tableTourPrice.getModel().getValueAt(row, 0).toString());
                        APIRequester.sendDelete("tourPrices/"+id, user.getToken());
                        LoadDataTableTourPrice();
                        JOptionPane.showMessageDialog(null, "Xoá giá tour thành công");
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
//                            txtStartDate.setText(startDate);
//                            txtEndDate.setText(endDate);
                            Tour_Price_DTO price_dto = new Tour_Price_DTO(id, price, substringStartDate, substringEndtDate);
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
                    String price = txtPrice.getText();
//                    String startDate = txtStartDate.getText();
//                    String endDate = txtEndDate.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String startDate = dateFormat.format(dateChooserStartDate.getDate());
                    String  endDate = dateFormat.format(dateChooserEndDate.getDate());
                    if(checkDifferentPrice(price, startDate, endDate)==false){
                        User_DTO user = new User_DTO();
                        String parameter = "{\"id\":"+Tour_Price_DTO.getPriceId()+",\"price\":"+price+",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                        System.out.println(parameter);
                        APIRequester.sendPUT(parameter, "tourPrices/"+Tour_Price_DTO.getPriceId(), user.getToken());
                        clearTextFieldPrice();
                        buttonSavePrice.setVisible(false);
                        buttonCancelPrice.setVisible(false);
                        buttonAddPrice.setVisible(true);
                        buttonClearFieldPrice.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    }else {
                        JOptionPane.showMessageDialog(null, "Giá tour không có thay đổi");
                    }
                }
            });
            /*========================END HANDLE CLICK BUTTON OF PRICE====================================*/

    }

    public static ArrayList<String> TourAttractionsList()
    {
        ArrayList<String> arrayTourAttractions = new ArrayList<>();
        User_DTO user = new User_DTO();
        Handle_API_Tour_Attractions tourAttractions = new Handle_API_Tour_Attractions();
        JSONArray result = new JSONArray(Handle_API_Tour_Attractions.Fetch_API_Tour_Attraction("touristAttractions?Page=1&Limit=100", user.getToken()));
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

    public static ArrayList<String> TourAttractionsListisSelected(){
        User_DTO user = new User_DTO();
        ArrayList<String> arrayTourAttractions = new ArrayList<>();
        JSONArray json = new JSONArray(Handle_API_Tour_Id.Fetch_API_Tour_Id_Detail("tours/"+Tour_DTO.getTourId(), user.getToken()));
            for(int i = 0 ; i < json.length(); i++){
                try {
                    JSONObject obj = (JSONObject) json.get(i);
                    JSONObject my = (JSONObject) obj.get("touristAttraction");

                    String name = my.get("name").toString();

                    arrayTourAttractions.add(name);
                } catch (JSONException ex) {
                    Logger.getLogger(ProjectTourManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return arrayTourAttractions;
    }

        private void UpdateJListSelected(){
        model = new DefaultListModel<String>();
        for(String p : TourAttractionsListisSelected()){
             model.addElement(p);
        }
        listPlaceSeleted.setModel(model);
        listPlaceSeleted.setSelectedIndex(0);
        listPlaceSeleted.setFont(new Font("Arial",Font.ITALIC,14));
    }
    public static boolean checkDifferentTour(String name, String specification, String price){
        if(name.equals(Tour_DTO.getTourName())== true && specification.equals(Tour_DTO.getSpecification())== true && price.equals(Tour_DTO.getPrice())== true){
            return true;
        }
        return false;
    }

    public static boolean checkDifferentPrice(String price, String startDate, String endDate){
        if(price.equals(Tour_Price_DTO.getPrice())== true && startDate.equals(Tour_Price_DTO.getStartDate())== true && endDate.equals(Tour_Price_DTO.getEndDate())== true){
            return true;
        }
        return false;
    }

    public void LoadDataTableTourPrice(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Price.Fetch_API_Tour_Price("tourPrices?Page=1&Limit=100", user.getToken()));
        Vector<Vector<String>> dataList = new Vector<>();
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("tourId").toString());
                data.add(jsonObj.get("price").toString());
                data.add(jsonObj.get("startDate").toString());
                data.add(jsonObj.get("endDate").toString());

                dataList.add(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        Vector<String> columnNames = new Vector<>();

        columnNames.add("Mã Giá");
        columnNames.add("Mã Tour");
        columnNames.add("Giá");
        columnNames.add("Ngày Bắt Đầu");
        columnNames.add("Ngày Kết Thúc");
        tableTourPrice = new JTable(dataList, columnNames);

    }
    public void clearTextFieldPrice(){
        txtPrice.setText("");
//        txtStartDate.setText("");
//        txtEndDate.setText("");
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
}
