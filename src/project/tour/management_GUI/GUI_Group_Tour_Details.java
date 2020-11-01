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
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class GUI_Group_Tour_Details extends JPanel{
    public static ArrayList<String> idCustomersInGroup = new ArrayList<String>();
    public static ArrayList<String> idEmployeeInGroup = new ArrayList<String>();
    public static ArrayList<String> idCostTypeInGroup = new ArrayList<String>();
    /***************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JTabbedPane tabbedPaneContent;
    /***************END DECLARE JPANEL********************/

    /***************DECLARE COMPONENT FOR PANEL HEADER********************/
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

        private JLabel labelGroupPrice;
        private JTextField txtGroupPrice;
        private JSeparator sptGroupPrice;

        private JLabel labelStartDate;
        private JDateChooser dateChooserStartDate;
        private JSeparator sptStartDate;

        private JLabel labelEndDate;
        private JDateChooser dateChooserEndDate;
        private JSeparator sptEndDate;

        private JButton btnSaveTour;
        private JButton btnBack;

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
        System.out.println(startDateFormat);
        System.out.println(endDateFormat);
        init(id, name, price, startDateFormat, endDateFormat);
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

            labelTitle = new JLabel("Chi Tiết Đoàn:",JLabel.CENTER);
            labelTitle.setFont(new Font("Segoe",Font.BOLD,14));
            labelTitle.setBounds(-5,0,150,30);

            sptTitle = new JSeparator();
            sptTitle.setBounds(10,28,120,10);
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
            labelGroupName.setBounds(505,45,80,30);

            txtGroupName = new JTextField();
            txtGroupName.setBounds(585,43,200,30);
            txtGroupName.setBorder(null);
            txtGroupName.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            txtGroupName.setEditable(false);
            txtGroupName.setText(name);

            sptGroupName = new JSeparator();
            sptGroupName.setBounds(585,73,200,10);
            sptGroupName.setBackground(new Color(0,0,0));
            //**************END TEXTFIELD GROUP NAME*******************//

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

            sptStartDate = new JSeparator();
            sptStartDate.setBounds(362,128,130,10);
            sptStartDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD START DATE*******************//

            //**************TEXTFIELD END DATE*******************//
            labelEndDate = new JLabel("NGÀY KẾT THÚC :",JLabel.CENTER);
            labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelEndDate.setBounds(550,100,120,30);

            dateChooserEndDate = new JDateChooser();
            dateChooserEndDate.setBounds(657, 98, 129, 30);
            dateChooserEndDate.setBorder(null);
            dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserEndDate.setDateFormatString("yyyy-MM-dd");
            dateChooserEndDate.setDate(endDateFormat);

            sptEndDate = new JSeparator();
            sptEndDate.setBounds(657,128,130,10);
            sptEndDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD END DATE*******************//

            btnSaveTour = new JButton("Lưu");
            btnSaveTour.setBackground(new Color(32, 171, 214));
            btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
            btnSaveTour.setForeground(Color.WHITE);
            btnSaveTour.setBounds(850,35,115,30);
            btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btnBack = new JButton("Trờ lại");
            btnBack.setBackground(new Color(239, 198, 74));
            btnBack.setFont(new Font("Segoe",Font.BOLD,13));
            btnBack.setForeground(Color.WHITE);
            btnBack.setBounds(850,105,115,30);
            btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

            /********************** ADD ELEMENT FOR HEADER *******************/
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

                panelHeader.add(labelGroupPrice);
                panelHeader.add(txtGroupPrice);
                panelHeader.add(sptGroupPrice);

                panelHeader.add(labelStartDate);
                panelHeader.add(dateChooserStartDate);
                panelHeader.add(sptStartDate);

                panelHeader.add(labelEndDate);
                panelHeader.add(dateChooserEndDate);
                panelHeader.add(sptEndDate);

                panelHeader.add(btnSaveTour);
                panelHeader.add(btnBack);
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
                    columnNames.add("Email");
                    modelTableCustomerGroup = new DefaultTableModel(columnNames,0);
                    tableGroupCustomer = new JTable(modelTableCustomerGroup);
                    LoadDataTableCustomerInGroup(id);
                    tableGroupCustomer.setRowHeight(25);
                    tableGroupCustomer.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                    tableGroupCustomer.getTableHeader().setReorderingAllowed(false);
                    tableGroupCustomer.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                    tableGroupCustomer.getTableHeader().setOpaque(false);
                    tableGroupCustomer.getTableHeader().setBackground(new Color(0,77,64));
                    tableGroupCustomer.getTableHeader().setForeground(new Color(255,255,255));
                    tableGroupCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                    /****************SET SIZE COLUMN OF TABLE***********************/

                    /****************SET SIZE COLUMN OF TABLE***********************/


                    tableGroupCustomer.setFont(new Font("Times New Roman",Font.PLAIN,15));

                    scrollPaneTableCustomer = new JScrollPane(tableGroupCustomer);
                    scrollPaneTableCustomer.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                        @Override
                        protected void configureScrollBarColors() {
                            this.thumbColor = new Color(19, 113, 106);
                        }
                    });
                    scrollPaneTableCustomer.setBounds(100,20,650,340);


                    btnAddCustomer = new JButton("Thêm khách hàng");
                    btnAddCustomer.setBackground(new Color(39, 113, 4));
                    btnAddCustomer.setFont(new Font("Segoe",Font.BOLD,13));
                    btnAddCustomer.setForeground(Color.WHITE);
                    btnAddCustomer.setBounds(235,375,165,30);
                    btnAddCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnRemoveCustomer = new JButton("Xoá");
                    btnRemoveCustomer.setBackground(new Color(149, 4, 4));
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
                    tableGroupCostType.setSelectionBackground(new java.awt.Color(0,105,92, 180));
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
                    btnAddCostType.setBackground(new Color(39, 113, 4));
                    btnAddCostType.setFont(new Font("Segoe",Font.BOLD,13));
                    btnAddCostType.setForeground(Color.WHITE);
                    btnAddCostType.setBounds(235,375,165,30);
                    btnAddCostType.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnRemoveCostType = new JButton("Xoá");
                    btnRemoveCostType.setBackground(new Color(149, 4, 4));
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

                labelTitleEmployeeInGroup = new JLabel("Nhân Viên Đoàn Tour");
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
                tableEmployeeGroup.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                tableEmployeeGroup.getTableHeader().setReorderingAllowed(false);
                tableEmployeeGroup.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableEmployeeGroup.getTableHeader().setOpaque(false);
                tableEmployeeGroup.getTableHeader().setBackground(new Color(0,77,64));
                tableEmployeeGroup.getTableHeader().setForeground(new Color(255,255,255));
                tableEmployeeGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                /****************SET SIZE COLUMN OF TABLE***********************/
                tableEmployeeGroup.getColumnModel().getColumn(0).setPreferredWidth(25);
                tableEmployeeGroup.getColumnModel().getColumn(1).setPreferredWidth(50);
                tableEmployeeGroup.getColumnModel().getColumn(2).setPreferredWidth(40);
                /****************SET SIZE COLUMN OF TABLE***********************/


                tableEmployeeGroup.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPaneTableEmployeeGroup = new JScrollPane(tableEmployeeGroup);
                scrollPaneTableEmployeeGroup.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                    scrollPaneTableEmployeeGroup.setBounds(10,35,500,330);


                btnAddEmployeeGroup = new JButton("Thêm nhân viên");
                btnAddEmployeeGroup.setBackground(new Color(39, 113, 4));
                btnAddEmployeeGroup.setFont(new Font("Segoe",Font.BOLD,13));
                btnAddEmployeeGroup.setForeground(Color.WHITE);
                btnAddEmployeeGroup.setBounds(100,377,165,30);
                btnAddEmployeeGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

                btnRemoveEmployeeGroup = new JButton("Xoá");
                btnRemoveEmployeeGroup.setBackground(new Color(149, 4, 4));
                btnRemoveEmployeeGroup.setFont(new Font("Segoe",Font.BOLD,13));
                btnRemoveEmployeeGroup.setForeground(Color.WHITE);
                btnRemoveEmployeeGroup.setBounds(400,377,115,30);
                btnRemoveEmployeeGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

            /**==================================================================================**/

                labelTitleRoleEmployee = new JLabel("Vai Trò Nhân Viên Trong Đoàn");
                labelTitleRoleEmployee.setBounds(660,7,250,20);
                labelTitleRoleEmployee.setForeground(new Color(0,0,0));
                labelTitleRoleEmployee.setFont(new Font("Times New Roman",1,18));

//                Vector<String> columnNamesRoleEmployee = new Vector<>();
//                columnNamesRoleEmployee.add("Họ");
//                columnNamesRoleEmployee.add("Tên");
//                columnNamesRoleEmployee.add("Công Việc");
//                modelTableRoleEmployee = new DefaultTableModel(columnNamesRoleEmployee,0);
//                tableRoleEmployee = new JTable(modelTableRoleEmployee);
                LoadDataRoleEmployee(id);
                tableRoleEmployee.setRowHeight(25);
                tableRoleEmployee.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                tableRoleEmployee.getTableHeader().setReorderingAllowed(false);
                tableRoleEmployee.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableRoleEmployee.getTableHeader().setOpaque(false);
                tableRoleEmployee.getTableHeader().setBackground(new Color(0,77,64));
                tableRoleEmployee.getTableHeader().setForeground(new Color(255,255,255));
                tableRoleEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


                /****************SET SIZE COLUMN OF TABLE***********************/
                tableRoleEmployee.getColumnModel().getColumn(0).setPreferredWidth(50);
                tableRoleEmployee.getColumnModel().getColumn(1).setPreferredWidth(40);
                /****************SET SIZE COLUMN OF TABLE***********************/


                tableRoleEmployee.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPaneTableRoleEmployee = new JScrollPane(tableRoleEmployee);
                scrollPaneTableRoleEmployee.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                scrollPaneTableRoleEmployee.setBounds(600,35,380,330);

                btnRemoveRoleEmployee = new JButton("Xoá nhiệm vụ");
                btnRemoveRoleEmployee.setBackground(new Color(149, 4, 4));
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
                GUI_List_Employee gui_list_employee = new GUI_List_Employee(id);

            }
        });
        btnRemoveEmployeeGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableGroupCustomer.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xoá");
                }else {
                    User_DTO user_dto = new User_DTO();
                    String idCustomer = (tableGroupCustomer.getModel().getValueAt(row, 0).toString());
                    String response = Handle_API_Tour_Group.send_Delete_Customer_In_Group("", "groupDetails/"+idCustomer, user_dto.getToken());
                    if(response.equals("success") == true){
                        LoadDataTableCustomerInGroup(id);
                    }
                }
            }
        });
        /**=================*END HANDLE EVENT TABLE EMPLOYEE*============*/

        /**======================* HANDLE EVENT TABLE CUSTOMER *==============*/
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

                        LoadDataTableCostTypeInGroup(id);
                    }
                }
            }
        });
        /**=================*END HANDLE EVENT TABLE CUSTOMER*============*/
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
                System.out.println(idCustomersInGroup);
                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(my.get("lastName").toString());
                data.add(my.get("firstName").toString());
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
        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Customer_In_Group("groupDetails?Page=1&Limit=100&Filters[groupId]="+groupId+"&FilterConditions[groupId]==", user.getToken()));

        idEmployeeInGroup.clear();

        modelTableEmployeeGroup.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idEmployeeInGroup += jsonObj.get("userId")+",";
                idEmployeeInGroup.add(jsonObj.get("userId").toString());
                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(my.get("lastName").toString());
                data.add(my.get("firstName").toString());
                data.add(my.get("email").toString());

                modelTableEmployeeGroup.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableEmployeeGroup.setModel(modelTableEmployeeGroup);
    }

    public static void LoadDataRoleEmployee(String groupId){
//        User_DTO user = new User_DTO();
//        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Customer_In_Group("groupDetails?Page=1&Limit=100&Filters[groupId]="+groupId+"&FilterConditions[groupId]==", user.getToken()));

//        modelTableEmployeeGroup.setRowCount(0);
//        for (int i = 0; i < json.length(); i++) {
//
//            JSONObject jsonObj;
//            try {
//                jsonObj = json.getJSONObject(i);
//                idEmployeeInGroup += jsonObj.get("userId")+",";
//                JSONObject my = (JSONObject) jsonObj.get("applicationUser");
//                Vector<String> data = new Vector<>();

//                data.add(jsonObj.get("id").toString());
//                data.add(my.get("lastName").toString());
//                data.add(my.get("firstName").toString());
//                data.add(my.get("email").toString());

//                modelTableEmployeeGroup.addRow(data);
//            } catch (JSONException ex) {
//                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
//            }

//        }
        String data[][]={ {"Cao Bá","Quát","Hướng dẫn viên"},
                {"Cao Thị Vân","Anh","Massage cho khách"},
                {"Cao Bá","Quát","Massage cho Linh"},
                {"Nguyễn ","Huệ","Lái xe"}};
        String column[]={"Họ","Tên","Công Việc"};
        tableRoleEmployee=new JTable(data,column);

//        tableEmployeeGroup.setModel(modelTableEmployeeGroup);
    }

    public static void LoadDataTableCostTypeInGroup(String groupId){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Customer_In_Group("groupCosts?Page=1&Limit=100&Filters[groupId]="+groupId+"&FilterConditions[groupId]==", user.getToken()));

        idCostTypeInGroup.clear();

        modelTableCostType.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
//                idCostTypeInGroup += jsonObj.get("costTypeId")+",";
                idCostTypeInGroup.add(jsonObj.get("costTypeId").toString());
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
}