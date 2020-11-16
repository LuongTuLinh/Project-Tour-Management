package project.tour.management_GUI;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUI_Statistical_Tour extends JPanel {
    /***********************************************/
    private JPanel panelTourArrivalStatistic;

    private JLabel labelStartDate;
    private JDateChooser dateChooserStartDate;
    private JSeparator sptStartDate;

    private JLabel labelEndDate;
    private JDateChooser dateChooserEndDate;
    private JSeparator sptEndDate;

    private JButton buttonSearchTour;
    /***********************************************/

    /***********************************************/
    private JPanel panelTourPriceStatistic;

    private JLabel labelStartDatePrice;
    private JDateChooser dateChooserStartDatePrice;
    private JSeparator sptStartDatePrice;

    private JLabel labelEndDatePrice;
    private JDateChooser dateChooserEndDatePrice;
    private JSeparator sptEndDatePrice;

    private JButton buttonSearchTourPrice;
    /***********************************************/

    /***********************************************/
    private JPanel panelTourStaffStatistic;

    private JLabel labelTitleStaffStatistic;

    private JButton buttonSearchStaffStatistic;
    /***********************************************/

    /***********************************************/
    private JPanel panelTourArrivalStatistic1;

    private JLabel labelStartDate1;
    private JDateChooser dateChooserStartDate1;
    private JSeparator sptStartDate1;

    private JLabel labelEndDate1;
    private JDateChooser dateChooserEndDate1;
    private JSeparator sptEndDate1;

    private JButton buttonSearchTour1;
    /***********************************************/
    public GUI_Statistical_Tour(){
        GUI();
    }
    public void GUI(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);

        /*****************************************************************************************/
            panelTourArrivalStatistic = new JPanel();
            panelTourArrivalStatistic.setLayout(null);
            panelTourArrivalStatistic.setBounds(25, 30, 940, 100);
            panelTourArrivalStatistic.setBackground(Color.white);
            Border borderOfPanelSearchPrice = BorderFactory.createTitledBorder("Thống Kê Số Đoàn Hoàn Thành và Bị Huỷ");
            panelTourArrivalStatistic.setBorder(borderOfPanelSearchPrice);


            //**************TEXTFIELD START DATE*******************//
            labelStartDate = new JLabel("Ngày bắt đầu :",JLabel.CENTER);
            labelStartDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelStartDate.setBounds(105,32,120,30);

            dateChooserStartDate = new JDateChooser();
            dateChooserStartDate.setBounds(212, 30, 130, 30);
            dateChooserStartDate.setBorder(null);
            dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserStartDate.setDateFormatString("yyyy-MM-dd");

            sptStartDate = new JSeparator();
            sptStartDate.setBounds(212,60,130,10);
            sptStartDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD START DATE*******************//

            //**************TEXTFIELD END DATE*******************//
            labelEndDate = new JLabel("Ngày kết thúc :",JLabel.CENTER);
            labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelEndDate.setBounds(400,32,120,30);

            dateChooserEndDate = new JDateChooser();
            dateChooserEndDate.setBounds(508, 30, 129, 30);
            dateChooserEndDate.setBorder(null);
            dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserEndDate.setDateFormatString("yyyy-MM-dd");

            sptEndDate = new JSeparator();
            sptEndDate.setBounds(507,60,130,10);
            sptEndDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD END DATE*******************//

            buttonSearchTour = new JButton("Thống kê");
            buttonSearchTour.setBackground(new Color(32, 171, 214));
            buttonSearchTour.setFont(new Font("Segoe",Font.BOLD,13));
            buttonSearchTour.setForeground(Color.WHITE);
            buttonSearchTour.setBounds(700,28,130,30);
            buttonSearchTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

            panelTourArrivalStatistic.add(labelStartDate);
            panelTourArrivalStatistic.add(dateChooserStartDate);
            panelTourArrivalStatistic.add(sptStartDate);

            panelTourArrivalStatistic.add(labelEndDate);
            panelTourArrivalStatistic.add(dateChooserEndDate);
            panelTourArrivalStatistic.add(sptEndDate);
            panelTourArrivalStatistic.add(buttonSearchTour);

        /*****************************************************************************************/
        /*****************************************************************************************/
            panelTourPriceStatistic = new JPanel();
            panelTourPriceStatistic.setLayout(null);
            panelTourPriceStatistic.setBounds(25, 180, 940, 100);
            panelTourPriceStatistic.setBackground(Color.white);
            Border borderOfPanelPrice = BorderFactory.createTitledBorder("Thống Kê Lợi Nhuận Từ Ngày đến Ngày Của Tour");
            panelTourPriceStatistic.setBorder(borderOfPanelPrice);


            //**************TEXTFIELD START DATE*******************//
            labelStartDatePrice = new JLabel("Ngày bắt đầu :",JLabel.CENTER);
            labelStartDatePrice.setFont(new Font("Segoe",Font.BOLD,12));
            labelStartDatePrice.setBounds(105,32,120,30);

            dateChooserStartDatePrice = new JDateChooser();
            dateChooserStartDatePrice.setBounds(212, 30, 130, 30);
            dateChooserStartDatePrice.setBorder(null);
            dateChooserStartDatePrice.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserStartDatePrice.setDateFormatString("yyyy-MM-dd");

            sptStartDatePrice = new JSeparator();
            sptStartDatePrice.setBounds(212,60,130,10);
            sptStartDatePrice.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD START DATE*******************//

            //**************TEXTFIELD END DATE*******************//
            labelEndDatePrice = new JLabel("Ngày kết thúc :",JLabel.CENTER);
            labelEndDatePrice.setFont(new Font("Segoe",Font.BOLD,12));
            labelEndDatePrice.setBounds(400,32,120,30);

            dateChooserEndDatePrice = new JDateChooser();
            dateChooserEndDatePrice.setBounds(508, 30, 129, 30);
            dateChooserEndDatePrice.setBorder(null);
            dateChooserEndDatePrice.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserEndDatePrice.setDateFormatString("yyyy-MM-dd");

            sptEndDatePrice = new JSeparator();
            sptEndDatePrice.setBounds(507,60,130,10);
            sptEndDatePrice.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD END DATE*******************//

            buttonSearchTourPrice = new JButton("Thống kê");
            buttonSearchTourPrice.setBackground(new Color(32, 171, 214));
            buttonSearchTourPrice.setFont(new Font("Segoe",Font.BOLD,13));
            buttonSearchTourPrice.setForeground(Color.WHITE);
            buttonSearchTourPrice.setBounds(700,28,130,30);
            buttonSearchTourPrice.setCursor(new Cursor(Cursor.HAND_CURSOR));

            panelTourPriceStatistic.add(labelStartDatePrice);
            panelTourPriceStatistic.add(dateChooserStartDatePrice);
            panelTourPriceStatistic.add(sptStartDatePrice);

            //panelStatisticalTour.add(labelPriceToPrice);

            panelTourPriceStatistic.add(labelEndDatePrice);
            panelTourPriceStatistic.add(dateChooserEndDatePrice);
            panelTourPriceStatistic.add(sptEndDatePrice);
            panelTourPriceStatistic.add(buttonSearchTourPrice);

    /*****************************************************************************************/
        /*****************************************************************************************/
        panelTourStaffStatistic = new JPanel();
        panelTourStaffStatistic.setLayout(null);
        panelTourStaffStatistic.setBounds(25, 330, 940, 100);
        panelTourStaffStatistic.setBackground(Color.white);
        Border borderOfPanel = BorderFactory.createTitledBorder("Thống Kê Nhân Viên");
        panelTourStaffStatistic.setBorder(borderOfPanel);

        labelTitleStaffStatistic = new JLabel("Thống Kê Nhân Viên Có Nhiều Công Việc Nhất ",JLabel.CENTER);
        labelTitleStaffStatistic.setFont(new Font("Segoe",Font.BOLD,12));
        labelTitleStaffStatistic.setBounds(190,32,270,30);


        buttonSearchStaffStatistic = new JButton("Thống kê");
        buttonSearchStaffStatistic.setBackground(new Color(32, 171, 214));
        buttonSearchStaffStatistic.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSearchStaffStatistic.setForeground(Color.WHITE);
        buttonSearchStaffStatistic.setBounds(700,28,130,30);
        buttonSearchStaffStatistic.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelTourStaffStatistic.add(labelTitleStaffStatistic);

        panelTourStaffStatistic.add(buttonSearchStaffStatistic);

        /*****************************************************************************************/

        /*****************************************************************************************/
        panelTourArrivalStatistic1 = new JPanel();
        panelTourArrivalStatistic1.setLayout(null);
        panelTourArrivalStatistic1.setBounds(25, 470, 940, 100);
        panelTourArrivalStatistic1.setBackground(Color.white);
        Border border = BorderFactory.createTitledBorder("Thống Kê Thể Loại Được Sử Dụng Nhiều Nhất");
        panelTourArrivalStatistic1.setBorder(border);


        //**************TEXTFIELD START DATE*******************//
        labelStartDate1 = new JLabel("Ngày bắt đầu :",JLabel.CENTER);
        labelStartDate1.setFont(new Font("Segoe",Font.BOLD,12));
        labelStartDate1.setBounds(105,32,120,30);

        dateChooserStartDate1 = new JDateChooser();
        dateChooserStartDate1.setBounds(212, 30, 130, 30);
        dateChooserStartDate1.setBorder(null);
        dateChooserStartDate1.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        dateChooserStartDate1.setDateFormatString("yyyy-MM-dd");

        sptStartDate1 = new JSeparator();
        sptStartDate1.setBounds(212,60,130,10);
        sptStartDate1.setBackground(new Color(0,0,0));

        //**************END TEXTFIELD START DATE*******************//

        //**************TEXTFIELD END DATE*******************//
        labelEndDate1 = new JLabel("Ngày kết thúc :",JLabel.CENTER);
        labelEndDate1.setFont(new Font("Segoe",Font.BOLD,12));
        labelEndDate1.setBounds(400,32,120,30);

        dateChooserEndDate1 = new JDateChooser();
        dateChooserEndDate1.setBounds(508, 30, 129, 30);
        dateChooserEndDate1.setBorder(null);
        dateChooserEndDate1.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
        dateChooserEndDate1.setDateFormatString("yyyy-MM-dd");

        sptEndDate1 = new JSeparator();
        sptEndDate1.setBounds(507,60,130,10);
        sptEndDate1.setBackground(new Color(0,0,0));

        //**************END TEXTFIELD END DATE*******************//

        buttonSearchTour1 = new JButton("Thống kê");
        buttonSearchTour1.setBackground(new Color(32, 171, 214));
        buttonSearchTour1.setFont(new Font("Segoe",Font.BOLD,13));
        buttonSearchTour1.setForeground(Color.WHITE);
        buttonSearchTour1.setBounds(700,28,130,30);
        buttonSearchTour1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panelTourArrivalStatistic1.add(labelStartDate1);
        panelTourArrivalStatistic1.add(dateChooserStartDate1);
        panelTourArrivalStatistic1.add(sptStartDate1);

        panelTourArrivalStatistic1.add(labelEndDate1);
        panelTourArrivalStatistic1.add(dateChooserEndDate1);
        panelTourArrivalStatistic1.add(sptEndDate1);
        panelTourArrivalStatistic1.add(buttonSearchTour1);

        /*****************************************************************************************/


        add(panelTourArrivalStatistic);
        add(panelTourPriceStatistic);
        add(panelTourStaffStatistic);
        add(panelTourArrivalStatistic1);

        /*****************************************************************************************/
        buttonSearchTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String startDate = formatDateTime(dateChooserStartDate.getDate());
                String  endDate = formatDateTime(dateChooserEndDate.getDate());
                if(!empty(startDate)&&!empty(endDate)){

                    if(checkStartDateToEndDate(dateChooserStartDate.getDate(), dateChooserEndDate.getDate())==true){

                        GUI_PieChart_Tour_ArrivalStatistic a = new GUI_PieChart_Tour_ArrivalStatistic(startDate, endDate);
                        GUI_BarChart_Tour_ArrivalStatistic b = new GUI_BarChart_Tour_ArrivalStatistic(startDate, endDate);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Ngày bắt đầu phải nhỏ hơn Ngày kết thúc");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                }

            }
        });
        /*****************************************************************************************/
        /*****************************************************************************************/
        buttonSearchTourPrice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String startDate = formatDateTime(dateChooserStartDatePrice.getDate());
                String  endDate = formatDateTime(dateChooserEndDatePrice.getDate());
                if(!empty(startDate)&&!empty(endDate)){

                    if(checkStartDateToEndDate(dateChooserStartDatePrice.getDate(), dateChooserEndDatePrice.getDate())==true){

                        GUI_BarChart_Tour_PriceStatistic gui_barChart_tour_arrivalStatistic = new GUI_BarChart_Tour_PriceStatistic(startDate, endDate);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Ngày bắt đầu phải nhỏ hơn Ngày kết thúc");
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                }

            }
        });
        /*****************************************************************************************/
        /*****************************************************************************************/
        buttonSearchStaffStatistic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GUI_PieChart_Tour_StaffStatistic gui_pieChart_tour_staffStatistic = new GUI_PieChart_Tour_StaffStatistic();
            }
        });
        /*****************************************************************************************/
        /*****************************************************************************************/
        buttonSearchTour1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String startDate = formatDateTime(dateChooserStartDate1.getDate());
                String  endDate = formatDateTime(dateChooserEndDate1.getDate());
                if(!empty(startDate)&&!empty(endDate)){

                    if(checkStartDateToEndDate(dateChooserStartDate1.getDate(), dateChooserEndDate1.getDate())==true){

                        GUI_BarChart_Tour_Category_Statistic gui_barChart_tour_category_statistic = new GUI_BarChart_Tour_Category_Statistic(startDate, endDate);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Lỗi! Ngày bắt đầu phải nhỏ hơn Ngày kết thúc");
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                }

            }
        });
        /*****************************************************************************************/
    }
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static String formatDateTime(Date dateOrNull) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return (dateOrNull == null ? null : dateFormat.format(dateOrNull));
    }
    public boolean checkStartDateToEndDate(Date start, Date end){
        if(start.before(end)){
            return true;
        }
        else {
            return false;
        }
    }
}
