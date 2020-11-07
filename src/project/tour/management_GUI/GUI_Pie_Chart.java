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
public class GUI_Pie_Chart extends JFrame{
    public static ArrayList<Tour_Statistical> statisticalArrayList;
    public GUI_Pie_Chart(String startDate, String endDate){
        GUI(startDate, endDate);
    }
    public void GUI(String startDate, String endDate){
        statisticalTour(startDate, endDate);
        JFreeChart pieChart = createChart(createDataset());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        add(chartPanel);
        setTitle("Biểu đồ JFreeChart trong Java Swing");
        setSize(600, 400);
        //setLocationRelativeTo(null);
        setLocation(700,295);
        setResizable(false);
        setVisible(true);
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu Đồ Số Đoàn Bị Huỷ Của Tour", dataset, true, true, true);
        return chart;
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        System.out.println(statisticalArrayList);
        for(Tour_Statistical tour_statistical : statisticalArrayList){
            if(tour_statistical.getTourCancel() > 0){
                dataset.setValue(tour_statistical.getName(), new Double(tour_statistical.getTourCancel()));
            }
        }
//        dataset.setValue("Nhóm 0 - 14", new Double(25.0));
        return dataset;
    }

    public static ArrayList<Tour_Statistical> statisticalTour(String startDate, String endDate){
        User_DTO user = new User_DTO();
        statisticalArrayList = new ArrayList<>();
        JSONArray json = new JSONArray(Handle_API_Statistical.API_Statistical_Tour("tours/tourArrival?FromDate="+startDate+"&ToDate="+endDate+"", user.getToken()));
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                String name = jsonObj.get("name").toString();
                double tourCancel  = Double.parseDouble(jsonObj.get("tourCancel").toString());
                int tourArrival = Integer.parseInt(jsonObj.get("tourArrival").toString());
                Tour_Statistical tour_statistical = new Tour_Statistical(name, tourArrival, tourCancel);
                statisticalArrayList.add(tour_statistical);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return statisticalArrayList;

    }

}
