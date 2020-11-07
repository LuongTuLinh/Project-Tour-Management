/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_GUI;

import com.toedter.calendar.JDateChooser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.Tour_Group_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Employee_And_Role;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

import static project.tour.management_GUI.GUI_Tour_Management.removeAllAndAddNewPanel;

/**
 *
 * @author DELL
 */
public class GUI_Group_Tour_Details extends JPanel{
    private static Tour_Group_DTO tour_group_dto;
    Tour_DTO tour_dto;
    public static String statusGroup="";

    public static ArrayList<String> idCustomersInGroup = new ArrayList<String>();
    public static ArrayList<String> idEmployeeInGroup = new ArrayList<String>();
    /***************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JTabbedPane tabbedPaneContent;
    /***************END DECLARE JPANEL********************/

    /***************DECLARE COMPONENT FOR PANEL HEADER********************/
        private JLabel labelBack;

        private JLabel labelTitle;
        private JSeparator sptTitle;

        private JLabel labelGroupId;
        private JTextField txtGroupId;
        private JSeparator sptGroupId;

        private JLabel labelTourId;
        private JTextField txtTourId;
        private JSeparator sptTourId;

        private JLabel labelGroupName;
        private JTextField txtGroupName;
        private JSeparator sptGroupName;

        private JLabel labelStatusGroup;
        private JComboBox<String> comboBoxStatusGroup;

        private JButton btnSaveGroup;

        private JLabel labelGroupPrice;
        private JTextField txtGroupPrice;
        private JSeparator sptGroupPrice;

        private JLabel labelStartDate;
        private JDateChooser dateChooserStartDate;
        private JSeparator sptStartDate;

        private JLabel labelEndDate;
        private JDateChooser dateChooserEndDate;
        private JSeparator sptEndDate;


    /***************END DECLARE COMPONENT FOR PANEL HEADER********************/

    /***************DECLARE COMPONENT FOR PANEL CONTENT********************/
        private JPanel panelCustomerGroup;
        private JPanel panelEmployeeGroup;
        private JPanel panelCostTypeGroup;
        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/

            private JScrollPane scrollPaneTableCustomer;
            public static JTable tableGroupCustomer;
            public static DefaultTableModel modelTableCustomerGroup;

            private JButton btnAddCustomer;
            private JButton btnRemoveCustomer;
        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/

        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/

        private JScrollPane scrollPaneTableCostType;
        public static JTable tableGroupCostType;
        public static DefaultTableModel modelTableCostType;

        private JButton btnAddCostType;
        private JButton btnRemoveCostType;
        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/

        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/

        private JLabel labelTitleEmployeeInGroup;
        private JLabel labelTitleRoleEmployee;

        private JScrollPane scrollPaneTableEmployeeGroup;
        public static JTable tableEmployeeGroup;
        public static DefaultTableModel modelTableEmployeeGroup;

        private JButton btnAddEmployeeGroup;
        private JButton btnRemoveEmployeeGroup;

        private JScrollPane scrollPaneTableRoleEmployee;
        public static JTable tableRoleEmployee;
        public static DefaultTableModel modelTableRoleEmployee;

        private JButton btnRemoveRoleEmployee;
        /***************DECLARE ELEMENT FOR PANEL CUSTOMER********************/


    /***************END DECLARE COMPONENT FOR PANEL CONTENT********************/

    public GUI_Group_Tour_Details(String id, String name, String price, String substringStartDate, String substringEndtDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateFormat = null;
        Date endDateFormat = null;
        try {
             startDateFormat = dateFormat.parse(substringStartDate);
             endDateFormat = dateFormat.parse(substringEndtDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        init(id, name, price, startDateFormat, endDateFormat);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startDateG = sdf.format(startDateFormat);
        String endDateG = sdf.format(endDateFormat);
        tour_group_dto = new Tour_Group_DTO(id, name, startDateG, endDateG);
    }
    public void init(String id, String name, String price, Date startDateFormat, Date endDateFormat){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
        /**=================================*PANEL HEADER*===================================*/
        panelHeader = new JPanel();
        panelHeader.setLayout(null);
        panelHeader.setBackground(Color.white);
        panelHeader.setBounds(0,0,990,150);

        labelBack = new JLabel(" << Trở lại",JLabel.CENTER);
        labelBack.setFont(new Font("Segoe",Font.BOLD,14));
        labelBack.setBounds(-5,0,80,30);

            labelTitle = new JLabel("Chi Tiết Đoàn:",JLabel.CENTER);
            labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
            labelTitle.setBounds(95,0,150,30);

            sptTitle = new JSeparator();
            sptTitle.setBounds(110,28,120,10);
            sptTitle.setBackground(new Color(0,0,0));

            //**************TEXTFIELD TOUR ID*******************//
            labelTourId = new JLabel("MÃ TOUR:",JLabel.CENTER);
            labelTourId.setFont(new Font("Segoe",Font.BOLD,12));
            labelTourId.setBounds(35,45,80,30);

            txtTourId = new JTextField();
            txtTourId.setBounds(115,43,100,30);
            txtTourId.setBorder(null);
            txtTourId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            txtTourId.setEditable(false);
            txtTourId.setText(Tour_DTO.getTourId());

            sptTourId = new JSeparator();
            sptTourId.setBounds(115,73,100,10);
            sptTourId.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD TOUR ID*******************//

            //**************TEXTFIELD GROUP ID*******************//
            labelGroupId = new JLabel("MÃ ĐOÀN:",JLabel.CENTER);
            labelGroupId.setFont(new Font("Segoe",Font.BOLD,12));
            labelGroupId.setBounds(250,45,80,30);

            txtGroupId = new JTextField();
            txtGroupId.setBounds(330,43,100,30);
            txtGroupId.setBorder(null);
            txtGroupId.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            txtGroupId.setEditable(false);
            txtGroupId.setText(id);

            sptGroupId = new JSeparator();
            sptGroupId.setBounds(330,73,100,10);
            sptGroupId.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD GROUP ID*******************//

            //**************TEXTFIELD GROUP NAME*******************//
            labelGroupName = new JLabel("TÊN ĐOÀN:",JLabel.CENTER);
            labelGroupName.setFont(new Font("Segoe",Font.BOLD,12));
            labelGroupName.setBounds(465,45,80,30);

            txtGroupName = new JTextField();
            txtGroupName.setBounds(545,43,200,30);
            txtGroupName.setBorder(null);
            txtGroupName.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            txtGroupName.setText(name);

            sptGroupName = new JSeparator();
            sptGroupName.setBounds(545,73,200,10);
            sptGroupName.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD GROUP NAME*******************//

            labelStatusGroup = new JLabel("TRẠNG THÁI:",JLabel.CENTER);
            labelStatusGroup.setFont(new Font("Segoe",Font.BOLD,12));
            labelStatusGroup.setBounds(775,45,80,30);

            comboBoxStatusGroup = new JComboBox<>();

            comboBoxStatusGroup.setBounds(860,44,110,30);
            comboBoxStatusGroup.setFont(new Font("Segoe",Font.BOLD,13));
            selectedComboBoxStatusGroup();

            btnSaveGroup = new JButton("Lưu");
            btnSaveGroup.setBackground(new Color(32, 171, 214));
            btnSaveGroup.setFont(new Font("Segoe",Font.BOLD,13));
            btnSaveGroup.setForeground(Color.WHITE);
            btnSaveGroup.setBounds(855,100,115,30);
            btnSaveGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

            //**************TEXTFIELD GROUP PRICE*******************//
            labelGroupPrice = new JLabel("GIÁ :",JLabel.CENTER);
            labelGroupPrice.setFont(new Font("Segoe",Font.BOLD,12));
            labelGroupPrice.setBounds(35,100,80,30);

            txtGroupPrice = new JTextField();
            txtGroupPrice.setBounds(115,98,120,30);
            txtGroupPrice.setBorder(null);
            txtGroupPrice.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            txtGroupPrice.setEditable(false);
            txtGroupPrice.setText(price);

            sptGroupPrice = new JSeparator();
            sptGroupPrice.setBounds(115,128,120,10);
            sptGroupPrice.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD GROUP PRICE*******************//


            //**************TEXTFIELD START DATE*******************//
            labelStartDate = new JLabel("NGÀY BẮT ĐẦU :",JLabel.CENTER);
            labelStartDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelStartDate.setBounds(255,100,120,30);

            dateChooserStartDate = new JDateChooser();
            dateChooserStartDate.setBounds(362, 98, 130, 30);
            dateChooserStartDate.setBorder(null);
            dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserStartDate.setDateFormatString("yyyy-MM-dd");
            dateChooserStartDate.setDate(startDateFormat);
            dateChooserStartDate.setEnabled(true);

            sptStartDate = new JSeparator();
            sptStartDate.setBounds(362,128,130,10);
            sptStartDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD START DATE*******************//

            //**************TEXTFIELD END DATE*******************//
            labelEndDate = new JLabel("NGÀY KẾT THÚC :",JLabel.CENTER);
            labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelEndDate.setBounds(550,100,120,30);

            dateChooserEndDate = new JDateChooser();
            dateChooserEndDate.setBounds(658, 98, 129, 30);
            dateChooserEndDate.setBorder(null);
            dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserEndDate.setDateFormatString("yyyy-MM-dd");
            dateChooserEndDate.setDate(endDateFormat);
            dateChooserEndDate.setEnabled(true);

            sptEndDate = new JSeparator();
            sptEndDate.setBounds(657,128,130,10);
            sptEndDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD END DATE*******************//



            /********************** ADD ELEMENT FOR HEADER *******************/
                panelHeader.add(labelBack);
                panelHeader.add(labelTitle);
                panelHeader.add(sptTitle);

                panelHeader.add(labelTourId);
                panelHeader.add(txtTourId);
                panelHeader.add(sptTourId);

                panelHeader.add(labelGroupId);
                panelHeader.add(txtGroupId);
                panelHeader.add(sptGroupId);

                panelHeader.add(labelGroupName);
                panelHeader.add(txtGroupName);
                panelHeader.add(sptGroupName);

                panelHeader.add(labelStatusGroup);
                panelHeader.add(comboBoxStatusGroup);
                panelHeader.add(btnSaveGroup);

                panelHeader.add(labelGroupPrice);
                panelHeader.add(txtGroupPrice);
                panelHeader.add(sptGroupPrice);

                panelHeader.add(labelStartDate);
                panelHeader.add(dateChooserStartDate);
                panelHeader.add(sptStartDate);

                panelHeader.add(labelEndDate);
                panelHeader.add(dateChooserEndDate);
                panelHeader.add(sptEndDate);

            /********************** END ADD ELEMENT FOR HEADER *********************/
        /**==================================*END PANEL HEADER*===================================*/

        /**==================================* PANEL CONTENT*===================================*/
        tabbedPaneContent = new JTabbedPane();
        tabbedPaneContent.setBounds(0,150,990,440);
        tabbedPaneContent.setBackground(new Color(0,77,64));
        tabbedPaneContent.setForeground(Color.white);

            /**==================================*PANEL CUSTOMER*===================================*/
                panelCustomerGroup = new JPanel();
                panelCustomerGroup.setLayout(null);
                panelCustomerGroup.setBackground(Color.white);
                panelCustomerGroup.setBounds(5,5,980,430);

                    Vector<String> columnNames = new Vector<>();
                    columnNames.add("Mã khách hàng");
                    columnNames.add("Họ");
                    columnNames.add("Tên");
                    columnNames.add("Số điện thoại");
                    columnNames.add("Email");
                    modelTableCustomerGroup = new DefaultTableModel(columnNames,0);
                    tableGroupCustomer = new JTable(modelTableCustomerGroup);
                    LoadDataTableCustomerInGroup(id);

                    tableGroupCustomer.setSelectionBackground(new Color(0,105,92, 180));
                    tableGroupCustomer.getTableHeader().setReorderingAllowed(false);
                    tableGroupCustomer.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                    tableGroupCustomer.getTableHeader().setOpaque(false);
                    tableGroupCustomer.getTableHeader().setBackground(new Color(0,77,64));
                    tableGroupCustomer.getTableHeader().setForeground(new Color(255,255,255));
                    tableGroupCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                    /****************SET SIZE COLUMN OF TABLE***********************/
                        tableGroupCustomer.getColumnModel().getColumn(0).setPreferredWidth(50);
                        tableGroupCustomer.getColumnModel().getColumn(2).setPreferredWidth(50);
                        tableGroupCustomer.getColumnModel().getColumn(3).setPreferredWidth(50);
                    /****************SET SIZE COLUMN OF TABLE***********************/


                    tableGroupCustomer.setFont(new Font("Times New Roman",Font.PLAIN,15));

                    scrollPaneTableCustomer = new JScrollPane(tableGroupCustomer);
                    scrollPaneTableCustomer.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                        @Override
                        protected void configureScrollBarColors() {
                            this.thumbColor = new Color(19, 113, 106);
                        }
                    });
                    scrollPaneTableCustomer.setBounds(80,20,815,340);


                    btnAddCustomer = new JButton("Thêm khách hàng");
                    btnAddCustomer.setBackground(new Color(41, 149, 85));
                    btnAddCustomer.setFont(new Font("Segoe",Font.BOLD,13));
                    btnAddCustomer.setForeground(Color.WHITE);
                    btnAddCustomer.setBounds(235,375,165,30);
                    btnAddCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnRemoveCustomer = new JButton("Xoá");
                    btnRemoveCustomer.setBackground(new Color(219, 50, 54));
                    btnRemoveCustomer.setFont(new Font("Segoe",Font.BOLD,13));
                    btnRemoveCustomer.setForeground(Color.WHITE);
                    btnRemoveCustomer.setBounds(535,375,115,30);
                    btnRemoveCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));

                /********************** ADD ELEMENT FOR PANEL CUSTOMER *********************/
                    panelCustomerGroup.add(scrollPaneTableCustomer);
                    panelCustomerGroup.add(btnAddCustomer);
                    panelCustomerGroup.add(btnRemoveCustomer);
                /********************** END ADD ELEMENT FOR PANEL CUSTOMER *********************/
        /**==================================*END PANEL CUSTOMER*===================================*/

        /**==================================*PANEL COST TYPE**===================================*/
                panelCostTypeGroup = new JPanel();
                panelCostTypeGroup.setLayout(null);
                panelCostTypeGroup.setBackground(Color.white);
                panelCostTypeGroup.setBounds(5,5,980,430);

                    Vector<String> columnNamesCostType = new Vector<>();
                    columnNamesCostType.add("Mã Thể Loại");
                    columnNamesCostType.add("Tên Loại Chi Phí");
                    columnNamesCostType.add("Giá Chí Phí");
                    columnNamesCostType.add("Ngày Tạo");
                    columnNamesCostType.add("Ghi Chú");
                    modelTableCostType = new DefaultTableModel(columnNamesCostType,0);
                    tableGroupCostType = new JTable(modelTableCustomerGroup);
                    LoadDataTableCostTypeInGroup(id);
                    tableGroupCostType.setRowHeight(25);
                    tableGroupCostType.setSelectionBackground(new Color(0,105,92, 180));
                    tableGroupCostType.getTableHeader().setReorderingAllowed(false);
                    tableGroupCostType.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                    tableGroupCostType.getTableHeader().setOpaque(false);
                    tableGroupCostType.getTableHeader().setBackground(new Color(0,77,64));
                    tableGroupCostType.getTableHeader().setForeground(new Color(255,255,255));
                    tableGroupCostType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                    /****************SET SIZE COLUMN OF TABLE***********************/
                    tableGroupCostType.getColumnModel().getColumn(0).setPreferredWidth(50);
                    tableGroupCostType.getColumnModel().getColumn(2).setPreferredWidth(50);
                    tableGroupCostType.getColumnModel().getColumn(3).setPreferredWidth(50);
                    /****************SET SIZE COLUMN OF TABLE***********************/


                    tableGroupCostType.setFont(new Font("Times New Roman",Font.PLAIN,15));

                    scrollPaneTableCostType = new JScrollPane(tableGroupCostType);
                    scrollPaneTableCostType.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                        @Override
                        protected void configureScrollBarColors() {
                            this.thumbColor = new Color(19, 113, 106);
                        }
                    });
                    scrollPaneTableCostType.setBounds(150,20,700,340);


                    btnAddCostType = new JButton("Thêm Chi Phí");
                    btnAddCostType.setBackground(new Color(41, 149, 85));
                    btnAddCostType.setFont(new Font("Segoe",Font.BOLD,13));
                    btnAddCostType.setForeground(Color.WHITE);
                    btnAddCostType.setBounds(235,375,165,30);
                    btnAddCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnRemoveCostType = new JButton("Xoá");
                    btnRemoveCostType.setBackground(new Color(219, 50, 54));
                    btnRemoveCostType.setFont(new Font("Segoe",Font.BOLD,13));
                    btnRemoveCostType.setForeground(Color.WHITE);
                    btnRemoveCostType.setBounds(535,375,115,30);
                    btnRemoveCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

                /********************** ADD ELEMENT FOR PANEL COST TYPE* *********************/
                panelCostTypeGroup.add(scrollPaneTableCostType);
                panelCostTypeGroup.add(btnAddCostType);
                panelCostTypeGroup.add(btnRemoveCostType);
                /********************** END ADD ELEMENT FOR PANEL COST TYPE* *********************/
        /**==================================*END PANEL COST TYPE*===================================*/

        /**==================================*PANEL EMPLOYEE*===================================*/
            panelEmployeeGroup = new JPanel();
            panelEmployeeGroup.setLayout(null);
            panelEmployeeGroup.setBounds(5,5,980,430);
            panelEmployeeGroup.setBackground(Color.white);

                labelTitleEmployeeInGroup = new JLabel("Các Nhân Viên Trong Đoàn ");
                labelTitleEmployeeInGroup.setBounds(110,7,250,20);
                labelTitleEmployeeInGroup.setForeground(new Color(0,0,0));
                labelTitleEmployeeInGroup.setFont(new Font("Times New Roman",1,18));

                Vector<String> columnNamesEmployeeGroup = new Vector<>();
                columnNamesEmployeeGroup.add("Mã NV");
                columnNamesEmployeeGroup.add("Họ");
                columnNamesEmployeeGroup.add("Tên");
                columnNamesEmployeeGroup.add("Email");
                modelTableEmployeeGroup = new DefaultTableModel(columnNamesEmployeeGroup,0);
                tableEmployeeGroup = new JTable(modelTableEmployeeGroup);
                LoadDataEmployeeInGroup(id);
                tableEmployeeGroup.setRowHeight(25);
                tableEmployeeGroup.setSelectionBackground(new Color(0,105,92, 180));
                tableEmployeeGroup.getTableHeader().setReorderingAllowed(false);
                tableEmployeeGroup.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableEmployeeGroup.getTableHeader().setOpaque(false);
                tableEmployeeGroup.getTableHeader().setBackground(new Color(0,77,64));
                tableEmployeeGroup.getTableHeader().setForeground(new Color(255,255,255));
                tableEmployeeGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                /****************SET SIZE COLUMN OF TABLE***********************/
                tableEmployeeGroup.getColumnModel().getColumn(0).setPreferredWidth(15);
                tableEmployeeGroup.getColumnModel().getColumn(1).setPreferredWidth(50);
                tableEmployeeGroup.getColumnModel().getColumn(2).setPreferredWidth(20);
                /****************SET SIZE COLUMN OF TABLE***********************/


                tableEmployeeGroup.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPaneTableEmployeeGroup = new JScrollPane(tableEmployeeGroup);
                scrollPaneTableEmployeeGroup.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                    scrollPaneTableEmployeeGroup.setBounds(10,35,530,330);


                btnAddEmployeeGroup = new JButton("Thêm nhân viên");
                btnAddEmployeeGroup.setBackground(new Color(41, 149, 85));
                btnAddEmployeeGroup.setFont(new Font("Segoe",Font.BOLD,13));
                btnAddEmployeeGroup.setForeground(Color.WHITE);
                btnAddEmployeeGroup.setBounds(80,377,165,30);
                btnAddEmployeeGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnRemoveEmployeeGroup = new JButton("Xoá");
                btnRemoveEmployeeGroup.setBackground(new Color(219, 50, 54));
                btnRemoveEmployeeGroup.setFont(new Font("Segoe",Font.BOLD,13));
                btnRemoveEmployeeGroup.setForeground(Color.WHITE);
                btnRemoveEmployeeGroup.setBounds(380,377,115,30);
                btnRemoveEmployeeGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

            /**==================================================================================**/

                labelTitleRoleEmployee = new JLabel("Vai Trò Nhân Viên Trong Đoàn");
                labelTitleRoleEmployee.setBounds(660,7,250,20);
                labelTitleRoleEmployee.setForeground(new Color(0,0,0));
                labelTitleRoleEmployee.setFont(new Font("Times New Roman",1,18));

                Vector<String> columnNamesRoleEmployee = new Vector<>();
                columnNamesRoleEmployee.add("Họ");
                columnNamesRoleEmployee.add("Tên");
                columnNamesRoleEmployee.add("Mã CV");
                columnNamesRoleEmployee.add("Công Việc");
                modelTableRoleEmployee = new DefaultTableModel(columnNamesRoleEmployee,0);
                tableRoleEmployee = new JTable(modelTableRoleEmployee);
                LoadDataRoleEmployee(id);
                tableRoleEmployee.setRowHeight(25);
                tableRoleEmployee.setSelectionBackground(new Color(0,105,92, 180));
                tableRoleEmployee.getTableHeader().setReorderingAllowed(false);
                tableRoleEmployee.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableRoleEmployee.getTableHeader().setOpaque(false);
                tableRoleEmployee.getTableHeader().setBackground(new Color(0,77,64));
                tableRoleEmployee.getTableHeader().setForeground(new Color(255,255,255));
                tableRoleEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                /****************SET SIZE COLUMN OF TABLE***********************/
                tableRoleEmployee.getColumnModel().getColumn(0).setPreferredWidth(50);
                tableRoleEmployee.getColumnModel().getColumn(1).setPreferredWidth(40);
                tableRoleEmployee.getColumnModel().getColumn(2).setPreferredWidth(30);
                /****************SET SIZE COLUMN OF TABLE***********************/


                tableRoleEmployee.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPaneTableRoleEmployee = new JScrollPane(tableRoleEmployee);
                scrollPaneTableRoleEmployee.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                scrollPaneTableRoleEmployee.setBounds(600,35,400,330);

                btnRemoveRoleEmployee = new JButton("Xoá nhiệm vụ");
                btnRemoveRoleEmployee.setBackground(new Color(219, 50, 54));
                btnRemoveRoleEmployee.setFont(new Font("Segoe",Font.BOLD,13));
                btnRemoveRoleEmployee.setForeground(Color.WHITE);
                btnRemoveRoleEmployee.setBounds(740,377,135,30);
                btnRemoveRoleEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));

            /********************** ADD ELEMENT FOR PANEL EMPLOYEE *********************/
            panelEmployeeGroup.add(labelTitleEmployeeInGroup);
            panelEmployeeGroup.add(labelTitleRoleEmployee);
            panelEmployeeGroup.add(scrollPaneTableEmployeeGroup);
            panelEmployeeGroup.add(btnAddEmployeeGroup);
            panelEmployeeGroup.add(btnRemoveEmployeeGroup);
            panelEmployeeGroup.add(scrollPaneTableRoleEmployee);
            panelEmployeeGroup.add(btnRemoveRoleEmployee);
            /********************** END ADD ELEMENT FOR PANEL EMPLOYEE *********************/
        /**==================================*END PANEL EMPLOYEE*===================================*/

            /**********ADD COMPONENT FOR PANEL CONTENT*****************/
            tabbedPaneContent.addTab("--Khách Hàng Đoàn--", panelCustomerGroup);
            tabbedPaneContent.addTab("--Nhân Viên--", panelEmployeeGroup);
            tabbedPaneContent.addTab("--Loại Chi Phí--", panelCostTypeGroup);
            /**********END ADD COMPONENT FOR PANEL CONTENT*****************/

        /**==================================*END PANEL CONTENT*===================================*/

        /***************ADD COMPONENT FOR PANEL MAIN********************/
            add(panelHeader);
            add(tabbedPaneContent);
            //revalidate();
        /***************END ADD COMPONENT FOR PANEL MAIN********************/

        checkStatusGroup();

        comboBoxStatusGroup.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                System.out.println(comboBoxStatusGroup.getSelectedItem());
                if(comboBoxStatusGroup.getSelectedItem().equals("Mới")){
                    statusGroup = "1";
                }
                if(comboBoxStatusGroup.getSelectedItem().equals("Đang Xử Lý")){
                    statusGroup = "2";
                }
                if(comboBoxStatusGroup.getSelectedItem().equals("Hoàn Thành")){
                    statusGroup = "3";
                }
                if(comboBoxStatusGroup.getSelectedItem().equals("Huỷ Đoàn")){
                    statusGroup = "4";
                }
            }
        });

        labelBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAllAndAddNewPanel(new GUI_Edit_Tour());
            }
        });
        btnSaveGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameG = txtGroupName.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String startDateG = dateFormat.format(dateChooserStartDate.getDate());
                String  endDateG = dateFormat.format(dateChooserEndDate.getDate());
                String status = statusGroup != "" ? statusGroup : Tour_Group_DTO.getStatus();
                String price = txtGroupPrice.getText().replace(",","");
                if( !empty( name ) && !empty( startDateG ) && !empty(endDateG)) {
                    if(checkDifferentGroup(nameG, startDateG, endDateG, status)==false){
                        User_DTO user = new User_DTO();
                        String parameter = "{\"id\":"+tour_group_dto.getGroupId()+",\"name\":\""+name+"\",\"price\":"+price+",\"status\":"+status+",\"startDate\":\""+startDateG+"\",\"endDate\":\""+endDateG+"\"}";
                        System.out.println(parameter);
                        String response = Handle_API_Tour_Group.sendPut_Tour_Group(parameter, "groups/"+tour_group_dto.getGroupId(), user.getToken());
                        if(response.equals("success")){
                            //LoadDataTableTourGroup();
                            getGroupTourId(id);
                            checkStatusGroup();
                        }


                    }else {
                        JOptionPane.showMessageDialog(null, "Đoàn tour không có thay đổi");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }
            }
        });

        /**======================* HANDLE EVENT TABLE CUSTOMER *==============*/
            btnAddCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    GUI_List_Customers gui_list_customers = new GUI_List_Customers(id);

                }
            });
            btnRemoveCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = tableGroupCustomer.getSelectedRow();
                    if( row == -1 ){
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng cần xoá");
                    }else {
                        User_DTO user_dto = new User_DTO();
                        String idCustomer = (tableGroupCustomer.getModel().getValueAt(row, 0).toString());
                        String response = Handle_API_Tour_Group.send_Delete_Customer_In_Group("", "groupDetails/"+idCustomer, user_dto.getToken());
                        if(response.equals("success") == true){
                            JOptionPane.showMessageDialog(null, "Xoá thành công");
                            LoadDataTableCustomerInGroup(id);
                        }
                    }
                }
            });
        /**=================*END HANDLE EVENT TABLE CUSTOMER*============*/

        /**======================* HANDLE EVENT TABLE EMPLOYEE *==============*/
        btnAddEmployeeGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //GUI_List_Roles gui_list_roles = new GUI_List_Roles();
                GUI_List_Employee gui_list_employee = new GUI_List_Employee(id);

            }
        });
        btnRemoveEmployeeGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableEmployeeGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xoá");
                }else {
                    User_DTO user_dto = new User_DTO();
                    String idEmp = (tableEmployeeGroup.getModel().getValueAt(row, 0).toString());
                    String parameter ="{\"groupId\":"+id+",\"staffId\":\""+idEmp+"\"}";
                    String response = Handle_API_Tour_Group.send_Delete_Customer_In_Group(parameter, "groups/staff", user_dto.getToken());
                    if(response.equals("success") == true){
                        LoadDataEmployeeInGroup(id);
                    }
                }
            }
        });
        btnRemoveRoleEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableRoleEmployee.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn công việc cần xoá");
                }else {
                    User_DTO user_dto = new User_DTO();
                    String idRole = (tableRoleEmployee.getModel().getValueAt(row, 2).toString());
                    String response = Handle_API_Employee_And_Role.sendDeleteRole("", "staffGroupRoles/"+idRole, user_dto.getToken());
                    if(response.equals("success") == true){
                        JOptionPane.showMessageDialog(null, "Xoá thành công");
                        LoadDataRoleEmployee(id);
                    }
                }
            }
        });
        /**=================*END HANDLE EVENT TABLE EMPLOYEE*============*/

        /**======================* HANDLE EVENT TABLE COST TYPE *==============*/
        btnAddCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GUI_List_Cost_Type gui_list_cost_type = new GUI_List_Cost_Type(id);

            }
        });
        btnRemoveCostType.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableGroupCostType.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn chi phí cần xoá");
                }else {
                    User_DTO user_dto = new User_DTO();
                    String idCostType = (tableGroupCostType.getModel().getValueAt(row, 0).toString());
                    String response = Handle_API_Tour_Group.send_Delete_Customer_In_Group("", "groupCosts/"+idCostType, user_dto.getToken());
                    if(response.equals("success") == true){
                        JOptionPane.showMessageDialog(null, "Xoá thành công");
                        LoadDataTableCostTypeInGroup(id);
                    }
                }
            }
        });
        /**=================*END HANDLE EVENT TABLE COST TYPE*============*/
    }

    public static void LoadDataTableCustomerInGroup(String groupId){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Customer_In_Group("groupDetails?Page=1&Limit=100&Filters[groupId]="+groupId+"&FilterConditions[groupId]==", user.getToken()));

        idCustomersInGroup.clear();

        modelTableCustomerGroup.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idCustomersInGroup += jsonObj.get("userId")+",";
                idCustomersInGroup.add(jsonObj.get("userId").toString());
                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(my.get("lastName").toString());
                data.add(my.get("firstName").toString());
                data.add(my.get("phoneNumber").toString());
                data.add(my.get("email").toString());


                modelTableCustomerGroup.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableGroupCustomer.setModel(modelTableCustomerGroup);
    }

    public static void LoadDataEmployeeInGroup(String groupId){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Employee("groups/"+groupId+"/staffsWithoutRole", user.getToken()));

        idEmployeeInGroup.clear();

        modelTableEmployeeGroup.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idEmployeeInGroup += jsonObj.get("userId")+",";
                idEmployeeInGroup.add(jsonObj.get("id").toString());
//                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("lastName").toString());
                data.add(jsonObj.get("firstName").toString());
                data.add(jsonObj.get("email").toString());

                modelTableEmployeeGroup.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableEmployeeGroup.setModel(modelTableEmployeeGroup);
    }

    public static void LoadDataRoleEmployee(String groupId){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Employee_And_Role.Fetch_API_All_Employee("groups/"+groupId+"/staffs?Page=1&Limit=100", user.getToken()));

        //idEmployeeInGroup.clear();

        modelTableRoleEmployee.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idEmployeeInGroup += jsonObj.get("userId")+",";
                //idEmployeeInGroup.add(jsonObj.get("staffId").toString());
                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
                JSONObject obj = (JSONObject) jsonObj.get("groupRole");
                Vector<String> data = new Vector<>();

                data.add(my.get("lastName").toString());
                data.add(my.get("firstName").toString());
                data.add(jsonObj.get("id").toString());
                data.add(obj.get("name").toString());


                modelTableRoleEmployee.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableRoleEmployee.setModel(modelTableRoleEmployee);
    }

    public static void LoadDataTableCostTypeInGroup(String groupId){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Customer_In_Group("groupCosts?Page=1&Limit=100&Filters[groupId]="+groupId+"&FilterConditions[groupId]==", user.getToken()));


        modelTableCostType.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idCostTypeInGroup += jsonObj.get("costTypeId")+",";
                JSONObject my = (JSONObject) jsonObj.get("costType");
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(my.get("name").toString());
                data.add(jsonObj.get("price").toString());
                data.add(jsonObj.get("createdAt").toString());
                data.add(jsonObj.get("note").toString());

                modelTableCostType.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableGroupCostType.setModel(modelTableCostType);
    }
    public void selectedComboBoxStatusGroup(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Mới");
        map.put(2, "Đang Xử Lý");
        map.put(3, "Hoàn Thành");
        map.put(4, "Huỷ Đoàn");
        Set<Integer> set = map.keySet();
        int i = 0;
        for (Integer key : set){
            comboBoxStatusGroup.addItem(map.get(key));
            System.out.println("aaa"+tour_group_dto.getStatus());
            int status = Integer.parseInt(tour_group_dto.getStatus());
            if(status == key){
                comboBoxStatusGroup.setSelectedIndex(i);
            }
            i++;
        }
    }
    public void getGroupTourId(String id){
        User_DTO user = new User_DTO();
        Handle_API_Tour_Group.API_Get_Tour_Group_Id("groups/"+id, user.getToken());
    }
    public static String formatDateTime(Date dateOrNull) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (dateOrNull == null ? null : dateFormat.format(dateOrNull));
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static boolean checkDifferentGroup(String name, String startDate, String endDate, String status){
        if(name.equals(tour_group_dto.getGroupName())== true &&
                startDate.equals(tour_group_dto.getStartDate())== true &&
                endDate.equals(tour_group_dto.getEndDate())== true&&
                status.equals(Tour_Group_DTO.getStatus())==true){
            return true;
        }
        return false;
    }

//    public void updateGroup(){
//        txtGroupName.setText(tour_group_dto.getGroupName());
//    }

    public void checkStatusGroup(){
        if(Tour_Group_DTO.getStatus().equals("3")==true||Tour_Group_DTO.getStatus().equals("4")==true){
            btnSaveGroup.setVisible(false);
            txtGroupName.setEditable(false);
            dateChooserEndDate.setEnabled(false);
            dateChooserStartDate.setEnabled(false);
            btnAddCustomer.setVisible(false);
            btnRemoveCustomer.setVisible(false);
            btnAddCostType.setVisible(false);
            btnRemoveCostType.setVisible(false);
            btnAddEmployeeGroup.setVisible(false);
            btnRemoveEmployeeGroup.setVisible(false);
            btnRemoveRoleEmployee.setVisible(false);

            txtGroupPrice.setBounds(155,98,120,30);
            labelGroupPrice.setBounds(75,100,80,30);
            sptGroupPrice.setBounds(155,128,120,10);

            dateChooserStartDate.setBounds(402, 98, 130, 30);
            labelStartDate.setBounds(295,100,120,30);
            sptStartDate.setBounds(402,128,130,10);

            dateChooserEndDate.setBounds(698, 98, 129, 30);
            labelEndDate.setBounds(590,100,120,30);
            sptEndDate.setBounds(698,128,130,10);
        }
    }
}
