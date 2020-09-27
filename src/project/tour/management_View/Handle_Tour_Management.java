/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.tour.management_View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.image.ImageObserver.ABORT;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Handle_Tour_Management extends JPanel{
    /*************DECLARE JPANEL********************/
        private JPanel panelHeader;
        private JPanel panelContent;
    /*************END DECLARE JPANEL********************/
        
    /*************DECLARE COMPONENT JPANEL HEADER********************/
        private JLabel labelSearch;
        private JLabel lbIconSearch;
        private JTextField txtSearch;
        private JButton btnEditTour;
        private JButton btnDeleteTour;
        private JButton btnAddTour;
        private JButton btnSaveTour;
    /*************END DECLARE COMPONENT JPANEL HEADER********************/
        
    /*************DECLARE COMPONENT JPANEL CONTENT********************/
        private JTable tableTour;
        private DefaultTableModel modelTable;
        private JScrollPane scrollPane;
    /*************DECLARE COMPONENT JPANEL CONTENT********************/
    public Handle_Tour_Management(){
        init();
    }
    public void init(){
        setLayout(null);
        setBounds(0, 0, 990, 590);
        setBackground(Color.white);
        
          /*------------------------PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/
            panelHeader = new JPanel();
            panelHeader.setLayout(null);
            panelHeader.setBounds(0, 0, 990, 80);
            panelHeader.setBackground(Color.white);
            
                labelSearch = new JLabel("Tìm kiếm:");
                labelSearch.setBounds(30,19,80,25);

                txtSearch = new JTextField();
                txtSearch.setBounds(95,19,250,25);

                lbIconSearch = new JLabel();
                lbIconSearch.setBounds(360,18,25,25);
                lbIconSearch.setIcon(new ImageIcon(getClass().getResource("/image/icons8_Search_in_Browser_25px.png")));
                
                btnEditTour = new JButton("Sửa Tour");
                btnEditTour.setBackground(new Color(239, 198, 74));
                btnEditTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnEditTour.setForeground(Color.WHITE);
                btnEditTour.setBounds(420,16,115,30); 
                btnEditTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnDeleteTour = new JButton("Xoá Tour");
                btnDeleteTour.setBackground(new Color(219, 50, 54));
                btnDeleteTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnDeleteTour.setForeground(Color.WHITE);
                btnDeleteTour.setBounds(550,16,115,30); 
                btnDeleteTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnAddTour = new JButton("Thêm Tour");
                btnAddTour.setBackground(new Color(41, 149, 85));
                btnAddTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnAddTour.setForeground(Color.WHITE);
                btnAddTour.setBounds(720,16,115,30); 
                btnAddTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                btnSaveTour = new JButton("Lưu");
                btnSaveTour.setBackground(new Color(32, 171, 214));
                btnSaveTour.setFont(new Font("Segoe",Font.BOLD,13));
                btnSaveTour.setForeground(Color.WHITE);
                btnSaveTour.setBounds(850,16,115,30); 
                btnSaveTour.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
            /****************ADD COMPONENT FOR PANEL HEADER***********************/
                panelHeader.add(labelSearch);
                panelHeader.add(txtSearch);
                panelHeader.add(lbIconSearch);
                panelHeader.add(btnEditTour);
                panelHeader.add(btnDeleteTour);
                panelHeader.add(btnAddTour);
                panelHeader.add(btnSaveTour);
            /***************END ADD COMPONENT FOR PANEL HEADER**********************/
          
          /*------------------------END PANEL HEADER INCLUDE BUTTON AND SEARCH-----------------------------*/
          
          
          /*------------------------PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/
            panelContent = new JPanel();
            panelContent.setLayout(null);
            panelContent.setBackground(Color.white);
            panelContent.setBounds(0, 80, 990, 510);
                
                Vector header = new Vector();
                header.add("Banana Team");
                header.add("Team Banana");
                header.add("Banana Team");
                header.add("Team Banana");
                header.add("Banana Team");
                header.add("Team Banana");
                header.add("Banana Team");
                header.add("Team Banana");
                modelTable = new DefaultTableModel(header, ABORT);

                tableTour = new JTable(modelTable);
                tableTour.setRowHeight(25);
                tableTour.setSelectionBackground(new java.awt.Color(0,105,92, 180));
                tableTour.getTableHeader().setReorderingAllowed(false);
                tableTour.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,15));
                tableTour.getTableHeader().setOpaque(false);
                tableTour.getTableHeader().setBackground(new Color(0,77,64));
                tableTour.getTableHeader().setForeground(new Color(255,255,255));

                tableTour.setFont(new Font("Times New Roman",Font.PLAIN,15));

                scrollPane = new JScrollPane(tableTour);
                scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        this.thumbColor = new Color(19, 113, 106);
                    }
                });
                scrollPane.setBounds(35,0,930,500);
            /****************ADD COMPONENT FOR PANEL CONTENT**************************/
                panelContent.add(scrollPane);
            /***************END ADD COMPONENT FOR PANEL CONTENT*************************/
          /*------------------------END PANEL CONTENT INCLUDE TABLE TOURS MANAGEMENT-----------------------------*/
          
          
          
          
        /*******************ADD COMPONENT FOR PANEL MAIN***********************/
        add(panelHeader);
        add(panelContent);
        /******************END ADD COMPONENT FOR PANEL MAIN************************/
    }
}
