package project.tour.management_GUI;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.Tour_Attraction_DTO;
import project.tour.management_DTO.Tour_Statistical;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Statistical;
import project.tour.management_Handle_API.Handle_API_Tour_Group;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TVD
 */
public class GUI_PieChart_Tour_StaffStatistic extends JFrame{
    public static ArrayList<Tour_Statistical> staffStatisticalArrayList;
    public GUI_PieChart_Tour_StaffStatistic(){
        GUI();
    }
    public void GUI(){
        staffStatisticalTour();
        JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        add(chartPanel);
        setTitle("Biểu đồ JFreeChart trong Java Swing");
        setSize(600, 400);
        //setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Thống Kê Nhân Viên Có Nhiều Công Việc Nhất", dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        System.out.println(staffStatisticalArrayList);
        for(Tour_Statistical tour_statistical : staffStatisticalArrayList){
            if(tour_statistical.getTotalStaffArrival() > 10){
                dataset.setValue(tour_statistical.getStaffFirstName()+" "+tour_statistical.getStaffLastName(),
                        new Double(tour_statistical.getTotalStaffArrival()));
            }
        }
//        dataset.setValue("Nhóm 0 - 14", new Double(25.0));
        return dataset;
    }

    public static ArrayList<Tour_Statistical> staffStatisticalTour(){
        User_DTO user = new User_DTO();
        staffStatisticalArrayList = new ArrayList<>();
        JSONArray json = new JSONArray(Handle_API_Statistical.API_Staff_Statistical("tours/staffStatistic", user.getToken()));
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                String firstName = jsonObj.get("firstName").toString();
                String lastName = jsonObj.get("lastName").toString();
                int totalArrival = Integer.parseInt(jsonObj.get("totalArrival").toString());
                Tour_Statistical tour_statistical = new Tour_Statistical(firstName, lastName, totalArrival);
                staffStatisticalArrayList.add(tour_statistical);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return staffStatisticalArrayList;

    }

}
