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

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI_BarChart_Tour_PriceStatistic extends JFrame {
    public static ArrayList<Tour_Statistical> statisticalPriceArrayList;
    public GUI_BarChart_Tour_PriceStatistic(String startDate, String endDate) {
        GUI(startDate, endDate);
    }
    public void GUI(String startDate, String endDate){
        setLocation(300,180);
        statisticalPriceTour(startDate, endDate);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu Đồ Doanh Thu Của Tour",
                "Tên Tour",
                "Doanh Thu (VND)",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 600 , 367 ) );
        setContentPane( chartPanel );
        setTitle("Biểu đồ JFreeChart trong Java Swing");
        pack( );
        setVisible( true );
    }

    private CategoryDataset createDataset( ) {
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
        for(Tour_Statistical tour_statistical : statisticalPriceArrayList){
            if(tour_statistical.getTotalPrice()>0){
                dataset.addValue( tour_statistical.getTotalPrice() , tour_statistical.getName() , tour_statistical.getName() );
            }
        }

        return dataset;
    }
    public static ArrayList<Tour_Statistical> statisticalPriceTour(String startDate, String endDate){
        User_DTO user = new User_DTO();
        statisticalPriceArrayList = new ArrayList<>();
        JSONArray json = new JSONArray(Handle_API_Statistical.API_Statistical_Price_Tour("tours/tourPriceStatistic?FromDate="+startDate+"&ToDate="+endDate+"", user.getToken()));
        for (int i = 0; i < json.length(); i++) {

            JSONObject jsonObj;
            try {
                jsonObj = json.getJSONObject(i);
                String name = jsonObj.get("name").toString();
                double price  = Double.parseDouble(jsonObj.get("totalPrice").toString());
                Tour_Statistical tour_statistical = new Tour_Statistical(name, price);
                statisticalPriceArrayList.add(tour_statistical);
            } catch (JSONException ex) {
                Logger.getLogger(GUI_Table_Tour_Management.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return statisticalPriceArrayList;

    }

}