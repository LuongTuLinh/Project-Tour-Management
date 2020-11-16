package project.tour.management_GUI;

import com.toedter.calendar.JDateChooser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import project.tour.management_API.APIRequester;
import project.tour.management_DTO.Tour_DTO;
import project.tour.management_DTO.Tour_Group_DTO;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Get_Tour;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import static project.tour.management_GUI.GUI_Tour_Management.removeAllAndAddNewPanel;

public class GUI_Table_Group extends JPanel {
    Tour_DTO tour_dto;
    User_DTO user_dto;
    Tour_Group_DTO tour_group_dto;
    /*==================DECLARE ELEMENT OF JPANEL=========================*/

        private JLabel labelNameGroup;
        private JTextField txtNameGroup;
        private JSeparator sptNameGroup;

        private JLabel labelStartDate;
        private JDateChooser dateChooserStartDate;
        private JSeparator sptStartDate;

        private JLabel labelEndDate;
        private JDateChooser dateChooserEndDate;
        private JSeparator sptEndDate;

        private JButton buttonAddGroup;
        private JButton buttonClearFieldGroup;
        private JButton buttonSaveGroup;
        private JButton buttonCancelGroup;
        private JButton buttonEditGroup;
        private JButton buttonDeleteGroup;
        private JButton buttonDetailGroup;

        private JScrollPane scrollPaneTableGroup;
        public JTable tableGroup;
        public DefaultTableModel modelTableGroup;

    /*==================END DECLARE ELEMENT OF JPANEL=========================*/

    public GUI_Table_Group(){
        GUI();
    }
    public void GUI(){
        setLayout(null);
        setBackground(Color.white);
        setBounds(0,0,980,430);



        //**************TEXTFIELD NAME GROUP*******************//
        labelNameGroup = new JLabel("TÊN ĐOÀN :",JLabel.CENTER);
        labelNameGroup.setFont(new Font("Segoe",Font.BOLD,12));
        labelNameGroup.setBounds(0,45,80,30);

        txtNameGroup = new JTextField();
        txtNameGroup.setBounds(100,43,180,30);
        txtNameGroup.setBorder(null);
        txtNameGroup.setFont(new Font(Font.SERIF, Font.PLAIN, 15));

        sptNameGroup = new JSeparator();
        sptNameGroup.setBounds(100,73,180,10);
        sptNameGroup.setBackground(new Color(0,0,0));
        //**************END TEXTFIELD NAME GROUP*******************//



        //**************TEXTFIELD START DATE*******************//
        labelStartDate = new JLabel("NGÀY BẮT ĐẦU :",JLabel.CENTER);
        labelStartDate.setFont(new Font("Segoe",Font.BOLD,12));
        labelStartDate.setBounds(15,110,120,30);

        dateChooserStartDate = new JDateChooser();
        dateChooserStartDate.setBounds(122, 108, 130, 30);
        dateChooserStartDate.setBorder(null);
        dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        dateChooserStartDate.setDateFormatString("yyyy-MM-dd");

        sptStartDate = new JSeparator();
        sptStartDate.setBounds(122,138,130,10);
        sptStartDate.setBackground(new Color(0,0,0));

        //**************END TEXTFIELD START DATE*******************//

        //**************TEXTFIELD END DATE*******************//
        labelEndDate = new JLabel("NGÀY KẾT THÚC :",JLabel.CENTER);
        labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
        labelEndDate.setBounds(15,200,120,30);

        dateChooserEndDate = new JDateChooser();
        dateChooserEndDate.setBounds(123, 198, 129, 30);
        dateChooserEndDate.setBorder(null);
        dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        dateChooserEndDate.setDateFormatString("yyyy-MM-dd");

        sptEndDate = new JSeparator();
        sptEndDate.setBounds(122,228,130,10);
        sptEndDate.setBackground(new Color(0,0,0));

        //**************END TEXTFIELD END DATE*******************//


        buttonAddGroup = new JButton("Thêm Đoàn");
        buttonAddGroup.setBackground(new Color(41, 149, 85));
        buttonAddGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonAddGroup.setForeground(Color.WHITE);
        buttonAddGroup.setBounds(10,280,145,30);
        buttonAddGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonClearFieldGroup = new JButton("Làm mới");
        buttonClearFieldGroup.setBackground(new Color(255, 255, 255));
        buttonClearFieldGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonClearFieldGroup.setForeground(Color.BLACK);
        buttonClearFieldGroup.setBounds(190,280,105,30);
        buttonClearFieldGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonSaveGroup = new JButton("Lưu");
        buttonSaveGroup.setBackground(new Color(32, 171, 214));
        buttonSaveGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSaveGroup.setForeground(Color.WHITE);
        buttonSaveGroup.setBounds(10,280,105,30);
        buttonSaveGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonCancelGroup = new JButton("Huỷ Bỏ");
        buttonCancelGroup.setBackground(new Color(219, 50, 54));
        buttonCancelGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonCancelGroup.setForeground(Color.WHITE);
        buttonCancelGroup.setBounds(190,280,105,30);
        buttonCancelGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /*===================END PANEL FIELD GROUP TOUR========================*/

        /*===================PANEL TABLE GROUP TOUR========================*/

        Vector<String> columnNames = new Vector<>();

        columnNames.add("Mã Đoàn");
        columnNames.add("Tên Đoàn");
//        columnNames.add("Mã Tour");
        columnNames.add("Giá(VND)");
        columnNames.add("Trạng Thái");
        columnNames.add("Ngày Bắt Đầu");
        columnNames.add("Ngày Kết Thúc");

        modelTableGroup = new DefaultTableModel(columnNames, 0);
        tableGroup = new JTable(modelTableGroup);

        LoadDataTableTourGroup();
        tableGroup.setRowHeight(25);
        tableGroup.setSelectionBackground(new java.awt.Color(0,105,92, 180));
        tableGroup.getTableHeader().setReorderingAllowed(false);
        tableGroup.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
        tableGroup.getTableHeader().setOpaque(false);
        tableGroup.getTableHeader().setBackground(new Color(0,77,64));
        tableGroup.getTableHeader().setForeground(new Color(255,255,255));
        tableGroup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableGroup.setDefaultEditor(Object.class, null);
        DefaultTableCellRenderer rightRendererPrice = new DefaultTableCellRenderer();
        rightRendererPrice.setHorizontalAlignment(JLabel.CENTER);
        tableGroup.getColumnModel().getColumn(2).setCellRenderer(rightRendererPrice);

        /****************SET SIZE COLUMN OF TABLE***********************/
        tableGroup.getColumnModel().getColumn(0).setPreferredWidth(40);
//        tableGroup.getColumnModel().getColumn(2).setPreferredWidth(40);
        /****************SET SIZE COLUMN OF TABLE***********************/


        tableGroup.setFont(new Font("Times New Roman",Font.PLAIN,15));

        scrollPaneTableGroup = new JScrollPane(tableGroup);
        scrollPaneTableGroup.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(19, 113, 106);
            }
        });
        scrollPaneTableGroup.setBounds(305,10,660,340);


        buttonEditGroup = new JButton("Sửa Đoàn");
        buttonEditGroup.setBackground(new Color(194, 98, 14));
        buttonEditGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonEditGroup.setForeground(Color.WHITE);
        buttonEditGroup.setBounds(415,360,140,30);
        buttonEditGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonDetailGroup = new JButton("Chi Tiết Đoàn ");
        buttonDetailGroup.setBackground(new Color(38, 210, 159));
        buttonDetailGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonDetailGroup.setForeground(Color.WHITE);
        buttonDetailGroup.setBounds(585,360,140,30);
        buttonDetailGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        buttonDeleteGroup = new JButton("Xoá Đoàn");
        buttonDeleteGroup.setBackground(new Color(219, 50, 54));
        buttonDeleteGroup.setFont(new Font("Segoe",Font.BOLD,13));
        buttonDeleteGroup.setForeground(Color.WHITE);
        buttonDeleteGroup.setBounds(755,360,140,30);
        buttonDeleteGroup.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /*------------------------END PANEL TABLE GROUP TOUR------------------------------*/


        /**********ADD COMPONENT FOR PANEL GROUP TOUR*****************/

        add(labelNameGroup);
        add(txtNameGroup);
        add(sptNameGroup);

        add(labelStartDate);
        add(dateChooserStartDate);
        add(sptStartDate);

        add(labelEndDate);
        add(dateChooserEndDate);
        add(sptEndDate);

        add(buttonAddGroup);
        add(buttonClearFieldGroup);
        add(buttonSaveGroup);
        add(buttonCancelGroup);

        add(scrollPaneTableGroup);
        add(buttonEditGroup);
        add(buttonDeleteGroup);
        add(buttonDetailGroup);

        /**********END ADD COMPONENT FOR PANEL GROUP TOUR***************/

        /*========================HANDLE CLICK BUTTON OF GROUP====================================*/
        buttonDetailGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đoàn cần xem");
                }else {
                    String id = (tableGroup.getModel().getValueAt(row, 0).toString());
                    System.out.println("id group:"+id);
                    String name = (tableGroup.getModel().getValueAt(row, 1).toString());
                    String price = (tableGroup.getModel().getValueAt(row, 2).toString());
                    String status = (tableGroup.getModel().getValueAt(row, 3).toString());
                    String statusGroup = "";
                    if(status.equals("Mới")==true){
                        statusGroup +=1;
                    }
//                    if(status.equals("Đang Xử Lý")==true){
//                        statusGroup +=2;
//                    }
                    if(status.equals("Hoàn Thành")==true){
                        statusGroup +=2;
                    }
                    if(status.equals("Đã Huỷ")==true){
                        statusGroup +=3;
                    }
                    String startDate = (tableGroup.getModel().getValueAt(row, 4).toString());
                    String endDate = (tableGroup.getModel().getValueAt(row, 5).toString());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String substringStartDate = startDate.substring(0,10);
                    String substringEndtDate = endDate.substring(0,10);

                    tour_group_dto = new Tour_Group_DTO(id, name, price, substringStartDate, substringEndtDate, statusGroup);
                    Tour_Group_DTO.setStatus(statusGroup);
                    removeAllAndAddNewPanel(new GUI_Group_Tour_Details(id, name, price, substringStartDate, substringEndtDate));
                }
            }
        });
        buttonClearFieldGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldGroup();
            }
        });

        buttonAddGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nameGroup = txtNameGroup.getText();

                String startDate = formatDateTime(dateChooserStartDate.getDate());
                String  endDate = formatDateTime(dateChooserEndDate.getDate());

                String  idTour = tour_dto.getTourId();
                if( !empty( nameGroup ) && !empty( startDate ) && !empty(endDate)) {

                            User_DTO user = new User_DTO();

                            String parameter = "{\"tourId\":"+idTour+",\"name\":\""+nameGroup+"\",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                            System.out.println(parameter);
//                            APIRequester.sendPOST(parameter, "groups", user.getToken());
                            String response = Handle_API_Tour_Group.send_POST_Tour_Group(parameter, "groups", user.getToken());
                            if(response.equals("success") == true){
                                LoadDataTableTourGroup();
                                clearTextFieldGroup();
                            }
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }

            }
        });
        buttonDeleteGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đoàn cần xoá");
                } else {
                    int result = JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn xoá đoàn này?", "Thông báo",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        User_DTO user = new User_DTO();
                        String id = (tableGroup.getModel().getValueAt(row, 0).toString());
                        //APIRequester.sendDelete("","groups/"+id, user.getToken());
                        String response = Handle_API_Tour_Group.send_Delete_Group_In_Tour("","groups/"+id, user.getToken());
                        if(response.equals("success")==true){
                            LoadDataTableTourGroup();
                            JOptionPane.showMessageDialog(null, "Xoá đoàn thành công");
                        }
                    }else if (result == JOptionPane.NO_OPTION){

                    }else {

                    }

                }

            }
        });

        buttonEditGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableGroup.getSelectedRow();
                if( row == -1 ){
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn đoàn cần sửa");
                }else {
                    String id = (tableGroup.getModel().getValueAt(row, 0).toString());
                    String name = (tableGroup.getModel().getValueAt(row, 1).toString());
                    String price = (tableGroup.getModel().getValueAt(row, 2).toString().replace(",",""));
                    String startDate = (tableGroup.getModel().getValueAt(row, 4).toString());
                    String endDate = (tableGroup.getModel().getValueAt(row, 5).toString());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String substringStartDate = startDate.substring(0,10);
                    String substringEndtDate = endDate.substring(0,10);
                    try {
                        Date startDateFormat = dateFormat.parse(substringStartDate);
                        Date endDateFormat = dateFormat.parse(substringEndtDate);

                        buttonAddGroup.setVisible(false);
                        buttonClearFieldGroup.setVisible(false);
                        buttonSaveGroup.setVisible(true);
                        buttonCancelGroup.setVisible(true);
                        txtNameGroup.setText(name);
                        dateChooserStartDate.setDate(startDateFormat);
                        dateChooserEndDate.setDate(endDateFormat);
                        String status = (tableGroup.getModel().getValueAt(row, 3).toString());
                        String statusGroup = "";
                        if(status.equals("Mới")==true){
                            statusGroup +=1;
                        }
//                        if(status.equals("Đang Xử Lý")==true){
//                            statusGroup +=2;
//                        }
                        if(status.equals("Hoàn Thành")==true){
                            statusGroup +=2;
                        }
                        if(status.equals("Đã Huỷ")==true){
                            statusGroup +=3;
                        }
                        tour_group_dto = new Tour_Group_DTO(id, name,price, substringStartDate, substringEndtDate, statusGroup);

                    } catch (java.text.ParseException parseException) {
                        parseException.printStackTrace();
                    }
                }
            }
        });
        buttonCancelGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearTextFieldGroup();
                buttonSaveGroup.setVisible(false);
                buttonCancelGroup.setVisible(false);
                buttonAddGroup.setVisible(true);
                buttonClearFieldGroup.setVisible(true);
            }
        });

        buttonSaveGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String name = txtNameGroup.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String startDate = dateFormat.format(dateChooserStartDate.getDate());
                String  endDate = dateFormat.format(dateChooserEndDate.getDate());
                if( !empty( name ) && !empty( startDate ) && !empty(endDate)) {
                    if(checkDifferentGroup(name, startDate, endDate, tour_group_dto)==false){
                        User_DTO user = new User_DTO();
                        String parameter = "{\"id\":"+tour_group_dto.getGroupId()+",\"name\":\""+name+"\",\"price\":"+tour_group_dto.getPrice()+",\"status\":"+Tour_Group_DTO.getStatus()+",\"startDate\":\""+startDate+"\",\"endDate\":\""+endDate+"\"}";
                        System.out.println(parameter);
                        String response = Handle_API_Tour_Group.sendPut_Tour_Group(parameter, "groups/"+tour_group_dto.getGroupId(), user.getToken());
                        if(response.equals("success")){
                                clearTextFieldGroup();
                                LoadDataTableTourGroup();
                                buttonSaveGroup.setVisible(false);
                                buttonCancelGroup.setVisible(false);
                                buttonAddGroup.setVisible(true);
                                buttonClearFieldGroup.setVisible(true);
                            }


                    }else {
                        JOptionPane.showMessageDialog(null, "Đoàn không có thay đổi");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Vui lòng nhập đầy đủ thông tin");
                }
            }
        });
        /*========================END HANDLE CLICK BUTTON OF GROUP====================================*/
    }
    public void LoadDataTableTourGroup(){
        User_DTO user = new User_DTO();
        JSONArray json = new JSONArray(Handle_API_Tour_Group.Fetch_API_Tour_Group("tours/"+tour_dto.getTourId()+"/groups?TourId="+tour_dto.getTourId()+"&Page=1&Limit=100", user.getToken()));
//        Vector<Vector<String>> dataList = new Vector<>();
        modelTableGroup.setRowCount(0);
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                Vector<String> data = new Vector<>();

                data.add(jsonObj.get("id").toString());
                data.add(jsonObj.get("name").toString());
//                data.add(jsonObj.get("tourId").toString());
                int price = Integer.parseInt(jsonObj.get("price").toString());
                String priceTour = java.text.NumberFormat.getIntegerInstance().format(price);
                data.add(priceTour);
                int status = Integer.parseInt(jsonObj.get("status").toString());
                String statusGroup="";
                if(status == 1){
                    statusGroup += "Mới";
                }
//                if(status == 2){
//                    statusGroup += "Đang Xử Lý";
//                }
                if(status == 2){
                    statusGroup += "Hoàn Thành";
                }
                if(status == 3){
                    statusGroup += "Đã Huỷ";
                }
                data.add(statusGroup);
//                String startDate =
                String substringStartDate = jsonObj.get("startDate").toString().substring(0,10);
                String substringEndtDate = jsonObj.get("endDate").toString().substring(0,10);
                data.add(substringStartDate);
                data.add(substringEndtDate);

                modelTableGroup.addRow(data);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        tableGroup.setModel(modelTableGroup);

    }
    public void clearTextFieldGroup(){
        txtNameGroup.setText("");
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
    public static boolean checkDifferentGroup(String name, String startDate, String endDate, Tour_Group_DTO group_dto){
        if(name.equals(group_dto.getGroupName())== true &&
                startDate.equals(group_dto.getStartDate())== true &&
                endDate.equals(group_dto.getEndDate())== true){
            return true;
        }
        return false;
    }
}
