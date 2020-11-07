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
    private JPanel panelStatisticalTour;
    private JLabel labelPriceToPrice;

    private JLabel labelStartDate;
    private JDateChooser dateChooserStartDate;
    private JSeparator sptStartDate;

    private JLabel labelEndDate;
    private JDateChooser dateChooserEndDate;
    private JSeparator sptEndDate;

    private JButton buttonSearchTour;
    public GUI_Statistical_Tour(){
        GUI();
    }
    public void GUI(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);

            panelStatisticalTour = new JPanel();
            panelStatisticalTour.setLayout(null);
            panelStatisticalTour.setBounds(25, 60, 940, 100);
            panelStatisticalTour.setBackground(Color.white);
            Border borderOfPanelSearchPrice = BorderFactory.createTitledBorder("Thống kê tour abc xyz cccc");
            panelStatisticalTour.setBorder(borderOfPanelSearchPrice);


//            labelPriceToPrice = new JLabel("đến");
//            labelPriceToPrice.setBounds(155,25,80,25);

            //**************TEXTFIELD START DATE*******************//
            labelStartDate = new JLabel("Ngày bắt đầu :",JLabel.CENTER);
            labelStartDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelStartDate.setBounds(105,30,120,30);

            dateChooserStartDate = new JDateChooser();
            dateChooserStartDate.setBounds(212, 28, 130, 30);
            dateChooserStartDate.setBorder(null);
            dateChooserStartDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserStartDate.setDateFormatString("yyyy-MM-dd");

            sptStartDate = new JSeparator();
            sptStartDate.setBounds(212,58,130,10);
            sptStartDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD START DATE*******************//

            //**************TEXTFIELD END DATE*******************//
            labelEndDate = new JLabel("Ngày kết thúc :",JLabel.CENTER);
            labelEndDate.setFont(new Font("Segoe",Font.BOLD,12));
            labelEndDate.setBounds(400,30,120,30);

            dateChooserEndDate = new JDateChooser();
            dateChooserEndDate.setBounds(508, 28, 129, 30);
            dateChooserEndDate.setBorder(null);
            dateChooserEndDate.setFont(new Font(Font.SERIF, Font.PLAIN, 15));
            dateChooserEndDate.setDateFormatString("yyyy-MM-dd");

            sptEndDate = new JSeparator();
            sptEndDate.setBounds(507,58,130,10);
            sptEndDate.setBackground(new Color(0,0,0));

            //**************END TEXTFIELD END DATE*******************//

            buttonSearchTour = new JButton("Thống kê");
            buttonSearchTour.setBackground(new Color(32, 171, 214));
            buttonSearchTour.setFont(new Font("Segoe",Font.BOLD,13));
            buttonSearchTour.setForeground(Color.WHITE);
            buttonSearchTour.setBounds(700,26,130,30);
            buttonSearchTour.setCursor(new Cursor(Cursor.HAND_CURSOR));

            panelStatisticalTour.add(labelStartDate);
            panelStatisticalTour.add(dateChooserStartDate);
            panelStatisticalTour.add(sptStartDate);

            //panelStatisticalTour.add(labelPriceToPrice);

            panelStatisticalTour.add(labelEndDate);
            panelStatisticalTour.add(dateChooserEndDate);
            panelStatisticalTour.add(sptEndDate);
            panelStatisticalTour.add(buttonSearchTour);

        add(panelStatisticalTour);

        buttonSearchTour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String startDate = formatDateTime(dateChooserStartDate.getDate());
                String  endDate = formatDateTime(dateChooserEndDate.getDate());
                if(!empty(startDate)&&!empty(endDate)){
                    GUI_Pie_Chart a = new GUI_Pie_Chart(startDate, endDate);
                    GUI_Bar_Chart b = new GUI_Bar_Chart(startDate, endDate);
                }else {
                    JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc");
                }

            }
        });
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
