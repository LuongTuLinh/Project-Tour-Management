package project.tour.management_GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import project.tour.management_DTO.Tour_Statistical;


import javax.swing.*;

import static project.tour.management_GUI.GUI_PieChart_Tour_ArrivalStatistic.statisticalArrayList;
import static project.tour.management_GUI.GUI_PieChart_Tour_ArrivalStatistic.statisticalTour;

public class GUI_BarChart_Tour_ArrivalStatistic extends JFrame {

    public GUI_BarChart_Tour_ArrivalStatistic(String startDate, String endDate) {
        GUI(startDate, endDate);
    }
    public void GUI(String startDate, String endDate){
        statisticalTour(startDate, endDate);
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu Đồ Số Đoàn Đã Hoàn Thành Của Tour",
                "Tên Tour",
                "Số Lượng",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);


        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 600 , 367 ) );
        setContentPane( chartPanel );
        setTitle("Biểu đồ thống kê");
        setLocation(70,245);
        pack( );
        setVisible( true );
    }

    private CategoryDataset createDataset( ) {
//        final String fiat = "FIAT";
//        final String audi = "AUDI";
//        final String ford = "FORD";
//        final String speed = "Speed";
//        final String millage = "Millage";
//        final String userrating = "User Rating";
//        final String safety = "safety";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );
//
//        dataset.addValue( 1.0 , fiat , speed );
//        dataset.addValue( 3.0 , fiat , userrating );
//        dataset.addValue( 5.0 , fiat , millage );
//        dataset.addValue( 5.0 , fiat , safety );
//
//        dataset.addValue( 5.0 , audi , speed );
//        dataset.addValue( 6.0 , audi , userrating );
//        dataset.addValue( 10.0 , audi , millage );
//        dataset.addValue( 4.0 , audi , safety );
//
//        dataset.addValue( 4.0 , ford , speed );
//        dataset.addValue( 2.0 , ford , userrating );
//        dataset.addValue( 3.0 , ford , millage );
//        dataset.addValue( 6.0 , ford , safety );
        for(Tour_Statistical tour_statistical : statisticalArrayList){
            if(tour_statistical.getTourArrival()>0){
                dataset.addValue( tour_statistical.getTourArrival() , tour_statistical.getNameTour() , tour_statistical.getNameTour() );
            }
        }

        return dataset;
    }

}