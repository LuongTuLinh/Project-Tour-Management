package project.tour.management_GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import project.tour.management_DTO.Tour_Statistical;
import project.tour.management_DTO.User_DTO;
import project.tour.management_Handle_API.Handle_API_Statistical;


import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI_BarChart_Tour_Category_Statistic extends JFrame {
    public static ArrayList<Tour_Statistical> statisticalCategoryArrayList;
    public GUI_BarChart_Tour_Category_Statistic(String startDate, String endDate) {
        GUI(startDate, endDate);
    }
    public void GUI(String startDate, String endDate){
        setLocation(300,180);
        statisticalCategoryTour(startDate, endDate);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu Đồ Thể Loại Được Sử Dụng Nhiều Nhất",
                "Tên Thể Loại",
                "Số Lần Chọn",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new Dimension( 600 , 367 ) );
        setContentPane( chartPanel );
        setTitle("Biểu đồ thống kê");

        pack( );
        setVisible( true );
    }

    private CategoryDataset createDataset( ) {
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
        for(Tour_Statistical tour_statistical : statisticalCategoryArrayList){
            System.out.println(tour_statistical.getTotalArrivalCategoroy());
                dataset.addValue( tour_statistical.getTotalArrivalCategoroy() , tour_statistical.getNameCategory() , tour_statistical.getNameCategory() );
        }

        return dataset;
    }

    public static ArrayList<Tour_Statistical> statisticalCategoryTour(String startDate, String endDate){
        User_DTO user = new User_DTO();
        statisticalCategoryArrayList = new ArrayList<>();
        JSONArray json = new JSONArray(Handle_API_Statistical.API_Category_Tour_Statistical("tours/tourCategoryArrivalStatistic?FromDate="+startDate+"&ToDate="+endDate+"", user.getToken()));
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                String name = jsonObj.get("name").toString();
                int totalArrival  = Integer.parseInt(jsonObj.get("totalArrival").toString());
                Tour_Statistical tour_statistical = new Tour_Statistical(name, totalArrival);
                statisticalCategoryArrayList.add(tour_statistical);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return statisticalCategoryArrayList;

    }

}